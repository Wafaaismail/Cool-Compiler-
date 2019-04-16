import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputFilePath = "testCases/bad.cl";
        String outputFileName = inputFilePath.substring(
                10, inputFilePath.lastIndexOf('.')
        );

        CharStream input = CharStreams.fromFileName(inputFilePath);
        CoolLexer lexer = new CoolLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        List<Token> allTokens = tokens.getTokens();

        //to detect if there is an error in lexems
        Boolean err = false ;
        for (int i = 0 ; i < allTokens.size() ; i++){
            if (allTokens.get(i).getType() == 48) {
                err = true ;
                System.out.println("Symbol "
                        +allTokens.get(i).getText()
                        + " isn't allowed in line "
                        +allTokens.get(i).getLine()
                        +"\n");
            }
        }
        if(!err)
            writeUsingBufferedWriter(outputFileName+"-lex",allTokens, allTokens.size());

    }

    private static void writeUsingBufferedWriter(String fileName, List<Token> tokens, int noOfLines) {
        File file = new File(fileName+".txt");
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