
import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

// TODO: 27/05/19 fix results
// TODO: 27/05/19 change tval to array list better
// TODO: 27/05/19 implement new / case / let / block /methodCall
//  /ownMethodCall / classes /proprtey  >>> check productions again to avoid missing any production
// TODO: 27/05/19 Print in file insted of consol
// TODO: 27/05/19 update project readme
// TODO: 27/05/19 provide simple testCases
public class myVisitor extends CoolBaseVisitor<Value> {

    //id , val
    private Hashtable <String, Value> memory = new Hashtable <String, Value>();
    //id ,temp
    private Hashtable <String, String> tmemory = new Hashtable<String,String>();
    //temp ,val
    private Hashtable <Value, Value> tval = new Hashtable<Value,Value>();


    static public class Temp{
        static int count = 0;
        int number;
        public Temp() { number = ++count; }
        public String toString() { return "t" + number; }
    }
    static public class Label{
        static int count = 0;
        int number;
        public Label() { number = ++count; }
        public String toString() { return "L" + number; }
    }

    //    @Override
//    public Value visitProgram(CoolParser.ProgramContext ctx) {
//        Value progBlocks = visit(ctx.programBlocks());
//        System.out.println("program Blocks :" + progBlocks);
//
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Value visitClasses(CoolParser.ClassesContext ctx) {
//        Value classdef = visit(ctx.classDefine());
//        Value progBlocks = visit(ctx.programBlocks());
//        return visitChildren(ctx);
//    }
//
    @Override
    public Value visitAssignment(CoolParser.AssignmentContext ctx) {

      //  System.out.println("visit assign");
        String id = ctx.ID().getText();
        Value value = visit(ctx.expr());

        Temp temp  = new Temp();
        memory.put(id, value);
        tmemory.put(id,temp.toString());
        tval.put(new Value(temp.toString()),value);

        System.out.println(temp.toString()+ " = " + value);
        System.out.println(id.toString() + " = " + temp.toString());

        return new Value(temp.toString());

    }
    @Override
    public Value visitInt(CoolParser.IntContext ctx) {
    //    System.out.println("visit int ");
        return new Value(Integer.valueOf(ctx.getText()));
    }

    @Override public Value visitString(CoolParser.StringContext ctx) {

        return  new Value(String.valueOf(ctx.getText()));
    }


    @Override public Value visitFalse(CoolParser.FalseContext ctx) {
		return new Value(Boolean.valueOf(ctx.getText()));
	}

    @Override public Value visitTrue(CoolParser.TrueContext ctx) {

        return new Value(Boolean.valueOf(ctx.getText()));
    }

    @Override public Value visitId(CoolParser.IdContext ctx) {
       // System.out.println("Visit id");
        String id = ctx.getText();
        Value value = memory.get(id);
        if(value == null) {
            throw new RuntimeException("no such variable: " + id);
        }
        String t = tmemory.get(id);

        return new Value(t);
    }

    @Override public  Value visitParentheses(CoolParser.ParenthesesContext ctx) {

        return visit(ctx.expr());
    }

    @Override public Value visitBoolNot(CoolParser.BoolNotContext ctx) {

        Value value = this.visit(ctx.expr());
        Temp temp = new Temp();
        System.out.println(temp.toString()+ " = " + value);

        return new Value(!value.asBoolean());
    }

    @Override public Value visitPlus(CoolParser.PlusContext ctx) {
        System.out.println("visit plus");

        Value left = this.visit(ctx.expr(0)); //t VALUE
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
      //  Value res = new Value(left + right);
       // tval.put(new Value(temp.toString()),res);
        System.out.println(temp.toString() + " = " + left + " + " + right);

        return new Value(temp.toString());
       }
    @Override public Value visitMinus(CoolParser.MinusContext ctx) {

        Value left = this.visit(ctx.expr(0)); //t VALUE
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
        //  Value res = new Value(left + right);
        // tval.put(new Value(temp.toString()),res);
        System.out.println(temp.toString() + " = " + left + " - " + right);

        return new Value(temp.toString());
    }

    @Override public Value visitMultiplication(CoolParser.MultiplicationContext ctx) {

        System.out.println("visit Multply");

        Value left = this.visit(ctx.expr(0)); //t VALUE
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
        //  Value res = new Value(left + right);
        // tval.put(new Value(temp.toString()),res);
        System.out.println(temp.toString() + " = " + left + " * " + right);

        return new Value(temp.toString());
    }

    @Override public Value visitDivision(CoolParser.DivisionContext ctx) {

        System.out.println("visit Division");

        Value left = this.visit(ctx.expr(0)); //t VALUE
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
        //  Value res = new Value(left + right);
        // tval.put(new Value(temp.toString()),res);
        System.out.println(temp.toString() + " = " + left + " / " + right);

        return new Value(temp.toString());
    }

    @Override public Value visitLessOREqual(CoolParser.LessOREqualContext ctx) {
        System.out.println("Visit <=");
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
        System.out.println(temp.toString() + " = " + left + " <= " + right);

        return new Value(temp.toString());
    }


    @Override public Value visitSmallerThan(CoolParser.SmallerThanContext ctx) {
      //  System.out.println("Visit <");
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
        System.out.println(temp.toString() + " = " + left + " < " + right);

        return new Value(temp.toString());
    }
    @Override public Value visitNegative(CoolParser.NegativeContext ctx) {
        System.out.println("Visit ~");

        Value eval = this.visit(ctx.expr());
        Temp temp = new Temp();
        System.out.println(temp.toString() + " = " + " ~ " + eval);

        return new Value(temp.toString());
    }

    @Override public Value visitEqual(CoolParser.EqualContext ctx) {
        System.out.println("Visit =");
        Value left = this.visit(ctx.expr(0));
        Value right = this.visit(ctx.expr(1));
        Temp temp = new Temp();
        System.out.println(temp.toString() + " = " + left + " == " + right);

        return new Value(temp.toString());
    }
    //IF expr THEN expr ELSE expr FI # if
    @Override public Value visitIf(CoolParser.IfContext ctx) {
        Label label = new Label();
        System.out.println("IF ");
        this.visit(ctx.expr(0));
        System.out.println("go to " + label.toString()  + "\n" );
        this.visit(ctx.expr(1));
        System.out.println("\n" + label.toString() +" : ");
        this.visit(ctx.expr(2));

        return Value.VOID;
    }
    //need test
    @Override public Value visitIsvoid(CoolParser.IsvoidContext ctx) {
        Temp temp  = new Temp();
        System.out.println(temp.toString() +"Is Void");
        Value val = this.visit(ctx.expr());

        return new Value(temp.toString());
    }
    // WHILE expr LOOP expr POOL # while
    //need test
   @Override public Value visitWhile(CoolParser.WhileContext ctx) {
       Label label = new Label();
       System.out.println("Loop: " + label.toString()  + "\n" );
       System.out.println("While");
       this.visit(ctx.expr(0));
       this.visit(ctx.expr(1));
       System.out.println("\n" + label.toString() +" : ");

       return Value.VOID }


}
