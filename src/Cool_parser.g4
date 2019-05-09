parser grammar Cool_parser;

options {
	tokenVocab = Cool_lexer;
}

@header{

	import java.util.*;
}

// Parser Rules
program returns [AST.Program obj]
: blocks= programBlocks
{
    $obj = new AST.Program();

};

// block = class
programBlocks returns [List<AST.Block> obj]
@init
	{
		$obj = new ArrayList<AST.Block>();
	}
    : def= classDefine SEMICOLUN programBlocks {$obj.add($def.obj);} // classes
    | EOF //eof
    ;

//block = class
classDefine returns [AST.Block obj]
: CLASS type= TYPE (INHERITS itype=TYPE)? OPEN_CURLY (featre= feature SEMICOLUN)* CLOSE_CURLY
{
    $obj = new AST.Block();
};


feature returns [List<AST.Feature> obj]
@init
    {
        $obj = new ArrayList<AST.Feature>();
    }
: id= ID OPENP_PRANSIS (forml= formal (COMMA formal)*)* CLOSE_PRANSIS COLUN TYPE OPEN_CURLY expr CLOSE_CURLY
{
    $obj.add(new AST.Method());
} # method
    | id = ID COLUN type= TYPE (ASSIGN_OPERATOR expr)?
    {
    $obj.add(new AST.Property());
    }# property
    ;

formal returns [AST.Formal obj]
: id = ID COLUN type = TYPE{
    $obj = new AST.Formal();
};
expr returns [AST.Expression obj]:
      id= ID
      op= ASSIGN_OPERATOR
      expr1=expr
      {$obj = new AST.Assignment($id.getText(),$exp1.value()); } # assignment

    | expr1=expr (AT type= TYPE)? DOT id= ID OPENP_PRANSIS (expr2= expr (COMMA expr3= expr)*)* CLOSE_PRANSIS

     {$obj= new AST.MethodCall();}# methodCall

    | id= ID OPENP_PRANSIS (expr1= expr (COMMA expr2= expr)*)* CLOSE_PRANSIS
     {$obj = new AST.OwnMethodCall();} # ownMethodCall

    | IF cond= expr THEN texpr= expr ELSE fexpr= expr FI {$obj = new AST.If();} #if

    | WHILE cond= expr LOOP bexpr=expr POOL { $obj= new AST.While();} #while

    | OPEN_CURLY { ArrayList<AST.Expression> list = new ArrayList<AST.Expression>(); }

        (exp=expr SEMICOLUN {list.add($exp.obj);}) +  CLOSE_CURLY
        {$obj = new AST.BlockOfExpressions(list);} #block //block of expressions

    | LET id=ID COLUN type=TYPE (ASSIGN_OPERATOR expr1=expr)?
        (COMMA id2=ID COLUN type2= TYPE (ASSIGN_OPERATOR expr2=expr)?)* IN expr3=expr
        { $obj = new AST.Let();}#letIn

    | CASE expr1=expr OF (id= ID COLUN type=TYPE CASE_ARROW expr2=expr SEMICOLUN)+ESAC
        {$obj = new AST.Case();} #case

    | NEW type=TYPE {$obj= new AST.NewType();} # new

    | ISVOID exp=expr { $obj= new AST.IsVoid();} # isvoid

    // modify all arithmatic exp to get op in var as it not assigned
    | expr1=expr op = PLUS expr2=expr {

        $obj= new AST.Arithmetic(
                $expr1.value(),
                $expr2.value(),
                $op.getText());
        } # plus

    | expr1=expr op = MINUS expr2=expr {

        $obj= new AST.Arithmetic(
                $expr1.value(),
                $expr2.value(),
                $op.getText());
        } # minus

    | expr1=expr op = MULTIPLY expr2=expr {
        $obj= new AST.Arithmetic(
            $expr1.value(),
            $expr2.value(),
            $op.getText());
        } # multiplication

    | expr1=expr op = DIVIDE expr2=expr {

        $obj= new AST.Arithmetic(
            $expr1.value(),
            $expr2.value(),
            $op.getText());
       } # division


    //does not follow Arithmatic constractor
    | INTEGER_NEGATIVE expr2=expr {$obj= new AST.Arithmetic();} # negative

    | expr1=expr SMALLER_THAN expr2=expr {$obj= new AST.Relational();} # smallerThan

    | expr1=expr LESS_THAN_OR_EQUAL expr2=expr {$obj= new AST.Relational();} # lessOREqual

    | expr1=expr EQUAL expr2=expr {$obj= new AST.Relational();} # equal

    | NOT expr2=expr {$obj= new AST.Logic();} # boolNot

    | OPENP_PRANSIS exp= expr CLOSE_PRANSIS {$obj = new AST.Expression($exp1.value());}#parentheses

    | id=ID {$obj = new AST.Id();} # id

    | value= INTEGER {$obj= new AST.Int();} #int

    | value= LITERAL {$obj= new AST.Literal();}# string

    | TRUE {$obj= new AST.Bool(true);} # true

    | FALSE {$obj= new AST.Bool(false);} # false
    ;
