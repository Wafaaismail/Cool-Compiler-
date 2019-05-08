import java.util.*;

public class AST {

    public static ArrayList<String> threeAddressCode = new ArrayList<>();
    public static int tCounter = 1; //counter for temp variables
    public static int lCounter = 1; // counter for labels

    public static abstract class ASTNode {
        int lineNo;

        abstract void generate();

    }

    static class Program extends ASTNode {
        @Override
        void generate() {

        }
    }

    static class Block extends ASTNode {
        @Override
        void generate() {

        }
    }

    static class Feature extends Block {
    }

    static class Method extends Feature {
    }

    static class Property extends Feature {
    }

    static class Formal extends ASTNode {
        @Override
        void generate() {

        }
    }


    //    Productions of expr
    static class Expression extends ASTNode {
        @Override
        void generate() {

        }
    }

    static class Assignment extends Expression {
    }

    static class If extends Expression {
    }

    static class While extends Expression {
    }

    static class BlockOfExpressions extends Expression {
    }

    static class Let extends Expression {
    }

    static class Case extends Expression {
    }

    static class NewType extends Expression {
    }

    static class IsVoid extends Expression {
    }

    static class Arithmetic extends Expression {
    }

    static class Relational extends Expression {
    }

    static class Logic extends Expression {
    } //Not

    static class Id extends Expression {
    }

    static class Int extends Expression {
    }

    static class Literal extends Expression {
    }

    static class Bool extends Expression {
        public Bool(Boolean value) {
        }
    }
}
