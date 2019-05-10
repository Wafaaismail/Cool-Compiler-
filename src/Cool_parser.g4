parser grammar Cool_parser;

options {
	tokenVocab = Cool_lexer;
}

@header{

	import java.util.*;
}

// Parser Rules
program returns [AST.Program obj]
    : blocks= programBlocks //EOF
    {
        $obj = new AST.Program($blocks.obj, $blocks.obj.get(0).lineNo);

    }
    ;

// block = class
programBlocks returns [ArrayList<AST.Block> obj]
    @init
	{
		$obj = new ArrayList<AST.Block>();
		$obj.add(new AST.Block("", "", new ArrayList<AST.Feature>(), 1));
	}
    : (def=classDefine {$obj.add($def.obj);} SEMICOLUN )+ # classes
    | EOF # EOF
    ;

//block = class
classDefine returns [AST.Block obj]
    //: CLASS type= TYPE (INHERITS itype=TYPE)? OPEN_CURLY (featre= feature SEMICOLUN)* CLOSE_CURLY
    // Class without Inherits
    : def=CLASS type=TYPE OPEN_CURLY fl=featureList CLOSE_CURLY
    {
        $obj = new AST.Block($type.getText(), "No_inherits", $fl.obj, $def.getLine());
    }
    // Class with Inherits
    | def=CLASS type=TYPE INHERITS itype=TYPE OPEN_CURLY fl=featureList CLOSE_CURLY
    {
        $obj = new AST.Block($type.getText(), $itype.getText(), $fl.obj, $def.getLine());
    }
    ;


featureList returns [ArrayList<AST.Feature> obj]
    @init
    {
        $obj = new ArrayList<AST.Feature>();
    }
    : (f=feature {$obj.add($f.obj);} SEMICOLUN)*
    ;

feature returns [AST.Feature obj]
    : m = method
    {
        $obj = $m.obj;
    }
    | p = property
    {
        $obj = $p.obj;
    }
    ;

method returns [AST.Method obj]
    //: id= ID OPENP_PRANSIS (forml= formal (COMMA formal)*)* CLOSE_PRANSIS COLUN TYPE OPEN_CURLY expr CLOSE_CURLY
     /*x(): Int {..}*/
    : id=ID OPENP_PRANSIS CLOSE_PRANSIS COLUN type=TYPE OPEN_CURLY e=expr CLOSE_CURLY
    {
        $obj = new AST.Method($id.getText(), $type.getText(), new ArrayList<AST.Formal>(), $e.obj, $id.getLine());
    }

    /*x(a, b ..): Int {..}*/
    | id=ID OPENP_PRANSIS fl=formalList CLOSE_PRANSIS COLUN type=TYPE OPEN_CURLY e=expr CLOSE_CURLY
    {
        $obj = new AST.Method($id.getText(), $type.getText(), $fl.obj, $e.obj, $id.getLine());
    }
    ;

property returns [AST.Property obj]
    // x:Int
    // x:Int <- expr
    : {Boolean flag = false;}
    id=ID COLUN type=TYPE (ASSIGN_OPERATOR e=expr{flag=true;})?
    {
      if(flag)
        $obj = new AST.Property($id.getText(), $type.getText(), $id.getLine(), $e.obj);
      else
        $obj = new AST.Property($id.getText(), $type.getText(), $id.getLine());
    }
    ;

formalList returns [ArrayList<AST.Formal> obj]
    @init
    {
        $obj = new ArrayList<AST.Formal>();
    }
    : f=formal {$obj.add($f.obj);} (COMMA fi=formal {$obj.add($fi.obj);})*
    ;

formal returns [AST.Formal obj]
    /*x: Int*/
    : id=ID COLUN type=TYPE
    {
        $obj = new AST.Formal($id.getText(), $type.getText());
    }
    ;

/* Branch for holding cases of expression case
 * branch_entity corresponds to a single branch.
 * branch_entity -> expr:TYPE => expr ;
 */
branch_list returns [ArrayList<AST.branch> obj]
	@init
	{
		$obj = new ArrayList<AST.branch>();
	}
	:
		(b = branch_entity SEMICOLUN {$obj.add($b.obj);} )+
	;


branch_entity returns [AST.branch obj] :
	id=ID COLUN type=TYPE CASE_ARROW ex=expr
		{
			$obj = new AST.branch($id.getText(), $type.getText(),$ex.obj, $id.getLine());
		}
	;


/* e_list is a list of expressions.
 * These are used in dispatch.
 */
e_list returns [List<AST.Expression> obj]
	@init
	{
		$obj = new ArrayList<AST.Expression>();
	}
	:
		(e=expr{$obj.add($e.obj);}(COMMA e=expr{$obj.add($e.obj);})*)?

	;

expr returns [AST.Expression obj]:
    id=ID op=ASSIGN_OPERATOR expr1=expr
    {
        $obj = new AST.Assignment($id.getText(), $expr1.obj);
    }
    # assignment

    /* DISPATCH EXPRESSION
     * expr -> expr.OBJECT([[expr[,expr]*]])
     * expr -> OBJECT([[expr[,expr]*]])
     */
    | expr1=expr DOT id=ID OPENP_PRANSIS e=e_list CLOSE_PRANSIS
    {
        $obj= new AST.dispatch($expr1.obj, $id.getText(), $e.obj, $id.getLine());
    }
    # dispatch
    |
      id=ID OPENP_PRANSIS e=e_list CLOSE_PRANSIS
    {
        $obj = new AST.dispatch(new AST.no_expr($id.getLine()), $id.getText(), $e.obj, $id.getLine());
    }
    # own_dispatch_call
    /* STATIC DISPATCH EXPRESSION
     * expr -> expr@TYPE.OBJECT([[expr[,expr]*]])
     */
    | expr1=expr AT type=TYPE DOT id=ID OPENP_PRANSIS e=e_list CLOSE_PRANSIS
    {
        $obj = new AST.static_dispatch($expr1.obj, $type.getText(), $id.getText(), $e.obj, $expr1.obj.lineNo);
    }
    # static_dispatch

    | //IF cond= expr THEN texpr= expr ELSE fexpr= expr FI
        IF expr1= expr THEN expr2= expr ELSE expr3= expr FI
    {
        $obj = new AST.If($expr1.obj, $expr2.obj, $expr3.obj);
    }
    # if

    | WHILE expr1= expr LOOP expr2=expr POOL
    {
        $obj= new AST.While($expr1.obj, $expr2.obj);
    }
    # while

    | OPEN_CURLY
    { ArrayList<AST.Expression> list = new ArrayList<AST.Expression>(); }
    (exp=expr SEMICOLUN {list.add($exp.obj);}) + CLOSE_CURLY
    {
        $obj = new AST.BlockOfExpressions(list);
    }
    # block //block of expressions
     |
        {
            ArrayList<AST.Expression> exprs = new ArrayList<>();
            ArrayList<String> ids = new ArrayList<>();
            ArrayList<Boolean> flags = new ArrayList<>();
            Boolean flag;
            AST.Expression ex;
        }
        LET i1=ID {flag = false; ex = new AST.Expression(); ids.add($i1.getText());} COLUN TYPE
        (ASSIGN_OPERATOR e1=expr {flag = true; ex = $e1.obj;})? {flags.add(flag); exprs.add(ex);}
        (COMMA i=ID {flag = false; ex = new AST.Expression(); ids.add($i.getText());} COLUN TYPE
        (ASSIGN_OPERATOR e=expr {flag = true; ex = $e.obj;})? {flags.add(flag); exprs.add(ex);})* IN e2=expr
        {
            $obj = new AST.Let(flags, ids, exprs, $e2.obj);
        }
        # letIn

    //| CASE expr1=expr OF (id= ID COLUN type=TYPE CASE_ARROW expr2=expr SEMICOLUN)+ESAC
    | CASE expr1=expr OF bl=branch_list ESAC
    {
        $obj = new AST.Case($expr1.obj, $bl.obj, $expr1.obj.lineNo);
    }
    # case

    | NEW type=TYPE
    {
        $obj= new AST.NewType($type.getText());
    }
    # new

    | ISVOID e=expr
    {
        $obj= new AST.IsVoid($e.obj);
    }
    # isvoid

    | expr1=expr op=PLUS expr2=expr
    {
           $obj= new AST.Arithmetic(
                        $expr1.obj,
                        $expr2.obj,
                        $op.getText());
    }
    # plus

    | expr1=expr op=MINUS expr2=expr
    {
         $obj= new AST.Arithmetic(
                 $expr1.obj,
                 $expr2.obj,
                $op.getText());
    }
    # minus

    | expr1=expr op=MULTIPLY expr2=expr
    {
           $obj= new AST.Arithmetic(
                        $expr1.obj,
                        $expr2.obj,
                        $op.getText());
    }
    # multiplication

    | expr1=expr op=DIVIDE expr2=expr
    {
           $obj= new AST.Arithmetic(
                        $expr1.obj,
                        $expr2.obj,
                        $op.getText());
    }
    # division

    | op=INTEGER_NEGATIVE expr2=expr
    {
           $obj= new AST.Arithmetic(
                        $expr2.obj,
                        $expr2.obj,
                        $op.getText());
    }
    # negative

    | expr1=expr op=SMALLER_THAN expr2=expr
    {
        $obj= new AST.Relational($expr1.obj, $expr2.obj, $op.getText());
    }
    # smallerThan

    | expr1=expr op=LESS_THAN_OR_EQUAL expr2=expr
    {
        $obj= new AST.Relational($expr1.obj, $expr2.obj, $op.getText());
    }
    # lessOREqual

    | expr1=expr op=EQUAL expr2=expr
    {
        $obj= new AST.Relational($expr1.obj, $expr2.obj, $op.getText());
    } # equal

    | op=NOT expr2=expr
    {
        $obj= new AST.LogOp($expr2.obj, $op.getText());
    }
    # boolNot

    | OPENP_PRANSIS expr1= expr CLOSE_PRANSIS
    {
        $obj = new AST.Parentheses($expr1.obj);
    }
    # parentheses

    | id=ID
    {
        $obj = new AST.Id($id.getText());
    }
    # id

    | value= INTEGER
    {
        $obj = new AST.IntConst(Integer.parseInt($value.getText()));
    }
    #int

    | value= LITERAL
    {
        $obj= new AST.Literal($value.getText());
    }
    # string

    | bool= TRUE
    {
        $obj= new AST.Bool($bool.getText().toUpperCase());
    }
    # true
    | bool= FALSE
    {
        $obj= new AST.Bool($bool.getText().toUpperCase());
    }
    # false
    ;

