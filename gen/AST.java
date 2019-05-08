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
        String name;
        String type;
        Boolean flag = false;
        Expression e;

        // Construct with 2 string as a parameter & 1 integer
        public Property(String n, String t, int l){
            name = n;
            type = t;
            lineNo = l;
            System.out.println("111111" + flag);
        }

        // Construct with 2 string as a parameter & 1 integer & Expression
        public Property(String n, String t, int l, Expression e){
            name = n;
            type = t;
            lineNo = l;
            this.e = e;
            flag = true;
            System.out.println("222222" + flag);
        }

        String getString(String space){

            return space+ "#" + lineNo + " Property :" + name + " - Type:" + type + "\n";
        }

        // Generate The Three address code if an expression is passed in construct
        @Override
        void generate(){
            if(flag){
                e.generate();
                prog3AdCode.add(name + " = " + e.getV());
            }
        }

        String getV(){
            return name;
        }
    }

    static class Formal extends ASTNode {
        @Override
        void generate() {

        }
    }


    //    Productions of expr
    static class Expression extends ASTNode {

        String type;
        public String v = "uninitialized";
        public Expression(){
            type = "no_type";
        }

        String getString(String space){

            return space + "Expression Type:" + type + "\n";
        }

        String getV() {
            return v;
        }
    }

    static class Assignment extends Expression {
    }

    static class If extends Expression {
    }

    static class While extends Expression {
        Expression e1;
        Expression e2;
        String before, after;

        public String v;

        // While Loop Accepts 2 Expressions as Paramter
        public While(Expression e1, Expression e2){
            this.e1 = e1;
            this.e2 = e2;
            type = "While";
            before = "BEFORE" + lCounter;
            after = "AFTER" + lCounter++;
        }

        String getString(String space){
            return space + "Expression Type:" + type + "\n";
        }

        // Generate The Three address code
        @Override
        void gererate(){
            prog3AdCode.add(before + ": ");
            e1.gererate();
            prog3AdCode.add("ifFalse " + e1.getV() + " goto " + after);
            e2.gererate();
            prog3AdCode.add("goto " + before);
            prog3AdCode.add(after + ": ");
        }
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

    static class IntConst extends Expression {
        int value;
        public String v;

        // Accepts an integer value as a parameter

        public IntConst(int val){
            type = "IntConst";
            value = val;
            this.v = Integer.toString(value);
        }

        String getString(String space){

            return space + "Expression Type:" + type + " value = " + value + "\n";
        }

        String getV(){
            return v;
        }
    }

    static class Literal extends Expression {
    }

    static class Bool extends Expression {
        public Bool(Boolean value) {
        }
    }
}
