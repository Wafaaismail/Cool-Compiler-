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

        String type;
        public String v = "uninitialized";
        public Expression(){
            type = "no_type";
        }

        int calc(){
            return  -99999
        }

        String getString(String space){

            return space + "Expression Type:" + type + "\n";
        }

        String getV() {
            return v;
        }
    }

    static class Assignment extends Expression {
        Expression e;
        public String v;
        public Assignment(String v,Expression e){
            type = "ASSIGN_OPERATOR"
            this.e = e;
            this.v = v;
        }

        String getString(String space) {
            return space + "Expression Type :" +type + "Expression Value : " + v + "\n";
        }

        void generate(){
            e.generate();
            threeAddressCode.add(v + " = " +e.getV());
        }

        @java.lang.Override
        public String getV() {
            return v;
        }
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

     //TODO  complete class after check grammer return value
    static class BlockOfExpressions extends Expression {
        ArrayList <AST.Expression> blockOfexprs;
        String v;
        public BlockOfExpressions ( ArrayList <AST.Expression> blockOfexprs){
            this.blockOfexprs = blockOfexprs;
            //type = "";

        }
    }

    static class Let extends Expression {
        Expression expression;
        ArrayList<Expression> exprs;
        ArrayList<String> ids;
        ArrayList<Boolean> flags;
        String type;
        public String v;

        public Let(ArrayList<Boolean> flags, ArrayList<String> ids, ArrayList<Expression> exprs, Expression expression){
            this.exprs = exprs;
            this.flags = flags;
            this.ids = ids;
            this.expression = expression;
            type = "LET";
            v = "t" + tCounter++;
        }

        String getString(String space){
            return space + "Expression: type:" + type + "\n";
        }

        void generate(){
            int po = 0;
            for (AST.Expression it : exprs){
                if(flags.get(po)){
                    it.generate();
                    prog3AdCode.add(ids.get(po) + " = " + it.getV());
                }
                po++;
            }
            expression.generate();
            prog3AdCode.add(v + " = " + expression.getV());
        }

        @Override
        String getV(){
            return v;
        }
    }

    static class Case extends Expression {
    }

    static class NewType extends Expression {
        public String type;

        public NewType(String type){
            this.type = type;
        }

        String getString(String space){
            return space + "Expression: type: NEW " + type + "\n";
        }

        @Override
        String getV(){
            return "NULL";
        }
    }

    static class IsVoid extends Expression {
        Expression expression;
        public String v;
        public String type;

        public IsVoid(Expression expression){
            e = expression;
            type = "IsVoid";
            v = "t" + tCounter++;
        }

        String getString(String space){
            return space + "Expression: type:" + type + "\n";
        }

        void generate(){
            expression.generate();
            String command = v + " = " + expressione.getV() + " == NULL";
            prog3AdCode.add(command);
        }

        @Override
        String getV(){
            return v;
        }
    }


    static class Parentheses extends Expression{
        Expression e;
        String v;
        public Parentheses (Expression e){
            type = "Parentheses";
            this.e = e;
            v = e.getV();

        }

        @java.lang.Override
        String getString(String space) {
            return space + "Expression Type :" +type + "Expression Value : " + v + "\n"
                   +space +e.getString(space+sp) +"\n" ;
        }

        @java.lang.Override
        void generate() {
            e.generate();
        }

        @java.lang.Override
        public String getV() {
            return v;
        }

    }
    static class Arithmetic extends Expression {
        Expression e1;
        Expression e2;
        String op;
        int result;
        public String v;

        public Arithmetic(Expression e1, Expression e2, String op) {
            this.e1 = e1;
            this.e2 = e2;
            result = this.calc();
            v = "t" + tCounter++;
            System.out.println("-> " + v);

            switch (op) {
                case "+":
                    type = "PLUS";
                    break;
                case "-":
                    type = "MINUS";
                    break;
                case "*":
                    type = "MULTIPLY";
                    break;
                case "/":
                    type = "DIVIDE";
                    break;
                default:
                    type = "undefined type";
            }
        }

        @java.lang.Override
        String getString(String space) {
            return space + "Expression Type :" + type + "\n" +
                    +space + e1.getString(space + sp) + "\n"
                    + space + e2.getString(space + sp) + "\n"
                    + space + "result = " + result + "\n";
        }


        @java.lang.Override
        int calc() {
            switch (op) {
                case "+":
                    return e1.calc() + e2.calc();
                break;
                case "-":
                    return e1.calc() - e2.calc();
                break;
                case "*":
                    return e1.calc() * e2.calc();
                break;
                case "/":
                    return e1.calc() / e2.calc();
                break;
                default:
                    return -9999;
            }
        }

            @java.lang.Override
            void generate () {
                e1.calc();
                e2.calc();
                threeAddressCode.add(
                        v + " = " + e1.getV() + op + e2.getV()
                );
            }

            @java.lang.Override
            public String getV () {
                return v;
            }
        }

    static class Relational extends Expression {
    }

    static class Logic extends Expression {
    } //Not

    static class Id extends Expression {
        public String v;
        public String type;

        public Id(String v){
            type = "ObId";
            this.v = v;

        }
        String getString(String space){

            return space + "Expression: type:" + type + " value = " + v + "\n";
        }

        @Override
        String getV(){
            return v;
        }
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
        public String v;
        public String type;
        public Bool(String bool){
            type = "BOOL_CONST";
            v = bool;
        }

        String getString(String space){
            return space + "Expression: type:" + type + " value = " + v + "\n";
        }

        @Override
        String getV(){
            return v;
        }
    }
}
