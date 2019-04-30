import java.util.HashMap;
import java.util.Map;

public class myVisitor extends CoolBaseVisitor<Value> {

    private Map <String, Value> memory = new HashMap <String, Value>();

    @Override
    public Value visitProgram(CoolParser.ProgramContext ctx) {
        Value progBlocks = visit(ctx.programBlocks());
        System.out.println("program Blocks :" + progBlocks);

        return visitChildren(ctx);
    }

    @Override
    public Value visitClasses(CoolParser.ClassesContext ctx) {
        Value classdef = visit(ctx.classDefine());
        Value progBlocks = visit(ctx.programBlocks());
        return visitChildren(ctx);
    }

    @Override
    public Value visitAssignment(CoolParser.AssignmentContext ctx) {
        String id = ctx.ID().getText();
        Value value = visit(ctx.expr());
        memory.put(id, value);
        return visitChildren(ctx);

    }

    @Override public Value visitFalse(CoolParser.FalseContext ctx) {
        System.out.println("False statmt");
		return new Value(Boolean.valueOf(ctx.getText()));

	}

}
