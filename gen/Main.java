import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        String inputFilePath = "gen/cool.cl";
        FileInputStream is = new FileInputStream(inputFilePath);
        //ANTLRInputStream input = new ANTLRInputStream(is);
        CharStream input = CharStreams.fromFileName(inputFilePath);
        CoolLexer lexer = new CoolLexer(input);
        Token token = lexer.nextToken();
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        while (token.getType() != CoolLexer.EOF) {
            System.out.println("\t" + token.getType() + "\t\t" + token.getText());
            token = lexer.nextToken();
        }
    }

    private static String getTokenType(int tokenType) {
        switch (tokenType) {
            case CoolLexer.ID:
                return "ID";
            case CoolLexer.CLASS:
                return "CLASS";
            case CoolLexer.OPEN_CARLY:
                return "OPEN_CURLY";
            case CoolLexer.CLOSE_CARLY:
                return "CLOSE_CURLY";
            case CoolLexer.COLUN:
                return "COLUN";
            case CoolLexer.SEMICOLUN:
                return "SEMICOLUN";

            default:
                return "OTHER";
        }
    }
}