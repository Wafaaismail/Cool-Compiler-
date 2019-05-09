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

        String getString(String space){

            return space + "Expression Type:" + type + "\n";
        }

        String getV() {
            return v;
        }
    }

    static class Assignment extends Expression {
	public String name;
        public expression e1;
        public Assignment(String n, expression v1, int l){
            name = n;
            e1 = v1;
            lineNo = l;
        }
        String getString(String space){
            return space+"#"+lineNo+"\n"+space+"_assign\n"+space+sp+name+"\n"+e1.getString(space+sp)+"\n"+space+": "+type;
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

    static class BlockOfExpressions extends Expression {
	ArrayList<AST.Expression> exprs;
        String v;

        public BlockOfExpr(ArrayList<Expression> exprs){
            type = "BlockOfExpr";
            this.exprs = exprs;
            v = "t" + tCounter++;
        }

        String getString(String space){

            String str = space + "Expression: type:" + type + "\n";

            for(Expression e: exprs){
                str += e.getString(space+sp);
            }

            return str;
        }

        void gen(){
            Expression last = new Expression();

            for(Expression e: exprs){
                e.gen();
                last = e;
            }

            prog3AdCode.add(v + " = " + last.getV());
        }

        @Override
        String getV(){
            return v;
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
        public expression predicate;
        public List<branch> branches;
        public Case(expression p, List<branch> b, int l){
            predicate = p;
            branches = b;
            lineNo = l;
        }
        String getString(String space){
            String str = space+"#"+lineNo+"\n"+space+"_typcase\n"+predicate.getString(space+sp)+"\n";
            for ( branch b1 : branches ) {
                str += b1.getString(space+sp)+"\n";
            }
            str += space+": "+type;
            return str;
        }
    }
    // Branch class for holding the cases of class Case
    public static class branch extends ASTNode {
		public String name;
		public String type;
		public expression value;
		public branch(String n, String t, expression v, int l){
			name = n;
			type = t;
			value = v;
			lineNo = l;
		}
		String getString(String space){
			return space+"#"+lineNo+"\n"+space+"_branch\n"+space+sp+name+"\n"+space+sp+type+"\n"+value.getString(space+sp);
		}
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

    static class Arithmetic extends Expression {
	Expression e1;
        Expression e2;
        String op;
        int res;
        public String v;

        public Arithmetic(Expression ee1, Expression ee2, String opp) {

            e1 = ee1;
            e2 = ee2;
            op = opp;
            res = this.eval();
            v = "t" + tCounter++;
            System.out.println(">>> " +v);

            switch (op) {
                case "+":
                    type = "Add";
                    break;
                case "-":
                    type = "Sub";
                    break;
                case "*":
                    type = "Mul";
                    break;
                case "/":
                    type = "Div";
                    break;
                default:
                    type = "un identified";
                    break;

            }
        }

        String getString(String space) {

            return space + "Expression: type:" + type + "\n"
                    + space + e1.getString(space + sp) + "\n"
                    + space + e2.getString(space + sp) + "\n"
                    + space + "result = " + res + "\n";
        }

        int eval() {
            switch (op) {
                case "+":
                    return e1.eval() + e2.eval();
                case "-":
                    return e1.eval() - e2.eval();
                case "*":
                    return e1.eval() * e2.eval();
                case "/":
                    return e1.eval() / e2.eval();
                default:
                    return -999999;
            }
        }

        void gen(){
            e1.gen();
            e2.gen();
            String command = v + " = " + e1.getV() + " " + op + " " + e2.getV();

            prog3AdCode.add(command);


        }
        @Override
        String getV(){
            return v;
        }
    }

    static class Relational extends Expression {
    }

    static class LogOP extends Expression {
        Expression e;
        String op;
        public String v;

        public LogOp(Expression ee, String opp) {
            e = ee;
            op = opp;
            if(op.equals("NOT"))    op = "!";
            v = "t" + tCounter++;
        }

        String getString(String space) {

            return space + "Expression: type: "+ op + "\n"
                    + space + e.getString(space + sp) + "\n";
        }

        void gen(){
            e.gen();
            String command = v + " = " + op + " " + e.getV();
            prog3AdCode.add(command);
        }
        @Override
        String getV(){
            return v;
        }
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
    // Class dispatch for calling methods
    public static class dispatch extends expression{
		public expression caller;
		public String name;
		public List<expression> actuals;
		public dispatch(expression v1, String n, List<expression> a, int l){
			caller = v1;
			name = n;
			actuals = a;
			lineNo = l;
		} 
		String getString(String space){
			String str;
			str = space+"#"+lineNo+"\n"+space+"_dispatch\n"+caller.getString(space+sp)+"\n"+space+sp+name+"\n"+space+sp+"(\n";
			for ( expression e1 : actuals ) {
				str += e1.getString(space+sp)+"\n";	
			}
			str+=space+sp+")\n"+space+": "+type;
			return str;
		}
	}
	
	public static class static_dispatch extends expression{
                public expression caller;
		public String typeid;
                public String name;
                public List<expression> actuals;
                public static_dispatch(expression v1, String t, String n, List<expression> a, int l){
                        caller = v1;
			typeid = t;
                        name = n;
                        actuals = a;
                        lineNo = l;
                }
                String getString(String space){
                        String str;
                        str = space+"#"+lineNo+"\n"+space+"_static_dispatch\n"+caller.getString(space+sp)+"\n"+space+sp+typeid+"\n"+space+sp+name+"\n"+space+sp+"(\n";
                        for ( expression e1 : actuals ) {
                                str += e1.getString(space+sp)+"\n";     
                        }
                        str+=space+sp+")\n"+space+": "+type;
                        return str;
                }
        }
}
