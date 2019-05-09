import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        //boolean exists ;
        String inputFilePath = "", outputFilePath = "";

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter file path: ");
        inputFilePath = reader.nextLine();

        outputFilePath = inputFilePath.substring(inputFilePath.indexOf("/") + 1);
        outputFilePath = outputFilePath.substring(0, outputFilePath.indexOf("."));
        outputFilePath = "output/"+outputFilePath;

        CharStream input = CharStreams.fromFileName(inputFilePath);
        Cool_lexer lexer = new Cool_lexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        List<Token> allTokens = tokens.getTokens();

        //to detect if there is an error in lexems
        Boolean err = false ;
        for (int i = 0 ; i < allTokens.size() ; i++){
            if (allTokens.get(i).getType() == 52) {
                err = true ;
                System.out.println("Symbol "
                        +allTokens.get(i).getText()
                        + " isn't allowed in line "
                        +allTokens.get(i).getLine()
                        +"\n");
            }
        }
        if(!err){
            System.out.println("The file passes lexer test.");
            writeLexerOutput(outputFilePath+".cl-lex",allTokens, allTokens.size());
            try {
                Cool_parser parser = new Cool_parser(tokens);
                ParseTree tree = parser.program();
                Cool_parser.ProgramContext prog = parser.program();
                System.out.println(prog.obj.getString(""));
                prog.obj.generate();

                for(String s: AST.threeAddressCode){
                    System.out.println(s);
                }
                TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
                viewer.open();
                System.out.println(tree.toStringTree(parser));
            }catch (ParseCancellationException e){

            }

        }


    }

    private static void writeLexerOutput(String fileName, List<Token> tokens, int noOfLines) {
        File file = new File(fileName);
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine="" ;
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                dataWithNewLine+=
                        "Line : " + tokens.get(noOfLines-i).getLine() +
                                ", Type : " + tokens.get(noOfLines-i).getType() +
                                ", Value : " + tokens.get(noOfLines-i).getText() ;
                br.write(dataWithNewLine);
                br.newLine();
                dataWithNewLine = "" ;
            }
            System.out.println("Writing tokens file is done");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
