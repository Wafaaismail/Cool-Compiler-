import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean exists ;
        String inputFilePath = "", outputFileName = "";

        for(String str : args) {

            File tempFile = new File(args[0]);
            exists = tempFile.exists();

            if(exists)
            {
                inputFilePath = args[0];
                break;
            }else{
                System.out.println("The File Is Not Exist");
                return;
            }

        }



        outputFileName = inputFilePath.substring(inputFilePath.indexOf("/") + 1);
        outputFileName = outputFileName.substring(0, outputFileName.indexOf("."));


        CharStream input = CharStreams.fromFileName(inputFilePath);
        CoolLexer lexer = new CoolLexer(input);

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
            writeUsingBufferedWriter(outputFileName+".cl-lex",allTokens, allTokens.size());

            CoolParser parser = new CoolParser(tokens);
            ParseTree tree = parser.program();

            System.out.println(tree.toStringTree(parser));
        }


    }

    private static void writeUsingBufferedWriter(String fileName, List<Token> tokens, int noOfLines) {
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
