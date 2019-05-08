import java.util.*;

public class AST {

    public static ArrayList<String> threeAddressCode = new ArrayList<>();
    public static int tCounter = 1; //counter for temp variables
    public static int lCounter = 1; // counter for labels
    public static String sp = "  ";
    
    public static abstract class ASTNode {
        int lineNo;

        abstract void generate();

    }
    
    // Class Program
    static class Program extends ASTNode {
        public ArrayList<AST.Block> blocks_;

        public program(ArrayList<AST.Block> c, int l){
            blocks_ = c;
            lineNo = l;
        }

        String getString(String space){
            String str;
            str = space + "#" + lineNo + "\n" + space + "_program";
            for (Block c : blocks_){
                str += "\n" + c.getString(space + sp);
            }
            return str;
        }

        void generate() {
            for(AST.Block : blocks_){
                c.generate();
            }
        }
    }

    // Class Block
    static class Block extends ASTNode {
        public String name;
        public String parent;
        public List<Feature> featureList;

        public Block(String n, String p, List<Feature> fl, int l){
            name = n;
            parent = p;
            featureList = fl;
            lineNo = l;
        }

        String getString(String space){
            String str;
            str = space + "#" + lineNo + " class:" + name;
            for (Feature f : featureList){
                str += "\n" + f.getString(space + sp);
            }
            return str;
        }

        void generate() {
            for (Feature f : featureList){
                f.generate();
            }
        }
    }

    // Class Feature
    static class Feature extends Block {
        String getString(String space) {
            return space + "feature";
        }
    }

    // Class Method
    static class Method extends Feature {
        String name;
        String retType;
        public List<Formal> formalList;
        Expression expression;

        public Method(String n, String rt, List<Formal> fl, Expression ee, int l){
            name = n;
            retType = rt;
            formalList = fl;
            expression = ee;
            lineNo = l;
        }

        String getString(String space){
            String str;
            str = space + "#" + lineNo + " Method:" + name + " return type:" + retType + "\n";
            if (formalList.size() > 0)
                str += space + sp + "Formals:" + formalList.size() + "\n";
            else
                str += space + sp + "No formals" + "\n";
            for (Formal f : formalList){
                str += f.getString(space + sp) + "\n";
            }
            str += expression.getString(space + sp) + "\n";
            return str;
        }

        void generate(){
            expression.generate();
        }
    }

    // Class Property
    static class Property extends Feature {
        String name;
        String type;
        Bool flag = false;
        Expression expression;

        public Property(String n, String t, int l){
            name = n;
            type = t;
            lineNo = l;
            System.out.println("111111" + flag);
        }
        public Property(String n, String t, int l, Expression expression){
            name = n;
            type = t;
            lineNo = l;
            this.expression = expression;
            flag = true;
            System.out.println("222222" + flag);
        }

        String getString(String space){
            return space + "#" + lineNo + " Property:" + name + " type:" + type + "\n";
        }

        void generate(){
            if(flag){
                expression.generate();
                threeAddressCode.add(name + " = " + e.getV());
            }
        }

        String getV(){
            return name;
        }

    }

    // Class Formal
    static class Formal extends ASTNode {
        String name;
        String type;

        public Formal(String n, String t){
            name = n;
            type = t;
        }

        String getString(String space){
            return space + "Formal:" + name + " type:" + type + "\n";
        }
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
