import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        String inputFilePath = "gen/good.cl";
        String outputFileName = "";
        char [] temp = inputFilePath.toCharArray();
        for (int i = 4 ; i < inputFilePath.length() ; i++){
            if(temp[i]=='.') break;
            else outputFileName += temp[i];
        }


        CharStream input = CharStreams.fromFileName(inputFilePath);
        CoolLexer lexer = new CoolLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        List<Token> allTokens = tokens.getTokens();
        System.out.println(outputFileName);
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