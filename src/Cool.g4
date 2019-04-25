// This file contains the grammer of COOL
grammar Cool;

// Parser Rules
program: programBlocks;

programBlocks
    : classDefine SEMICOLUN programBlocks # classes
    | EOF #eof
    ;

classDefine: CLASS TYPE (INHERITS TYPE)? OPEN_CURLY (feature SEMICOLUN)* CLOSE_CURLY;

feature: ID OPENP_RANSIS (formal (COMMA formal)*)* CLOSE_PRANSIS COLUN TYPE OPEN_CURLY expr CLOSE_CURLY # method
    | ID COLUN TYPE (ASSIGN_OPERATOR expr)? # property
    ;

formal: ID COLUN TYPE;
expr: ID ASSIGN_OPERATOR expr # assignment
    | expr (AT TYPE)? DOT ID OPENP_RANSIS (expr (COMMA expr)*)* CLOSE_PRANSIS # methodCall
    | ID OPENP_RANSIS (expr (COMMA expr)*)* CLOSE_PRANSIS # ownMethodCall
    | IF expr THEN expr ELSE expr FI # if
    | WHILE expr LOOP expr POOL # while
    | OPEN_CURLY (expr SEMICOLUN)+ CLOSE_CURLY # block
    | LET ID COLUN TYPE (ASSIGN_OPERATOR expr)? (COMMA ID COLUN TYPE (ASSIGN_OPERATOR expr)?)* IN expr # letIn
    | CASE expr OF (ID COLUN TYPE CASE_ARROW expr SEMICOLUN)+ESAC # case
    | NEW TYPE # new
    | ISVOID expr # isvoid
    | expr PLUS expr # plus
    | expr MINUS expr # minus
    | expr MULTIPLY expr # multiplication
    | expr DIVIDED expr # division
    | INTEGER_NEGATIVE expr # negative
    | expr SMALLER_THAN expr # smallerThan
    | expr LESS_THAN_OR_EQUAL expr # lessOREqual
    | expr EQUAL expr # equal
    | NOT expr # boolNot
    | OPENP_RANSIS expr CLOSE_PRANSIS # parentheses
    | ID # id
    | INTEGER # int
    | LITERAL # string
    | TRUE # true
    | FALSE # false
    ;

// Lexical Rules

fragment A
   : [aA]
   ;
fragment C
   : [cC]
   ;
fragment D
   : [dD]
   ;
fragment E
   : [eE]
   ;
fragment F
   : [fF]
   ;
fragment H
   : [hH]
   ;
fragment I
   : [iI]
   ;
fragment L
   : [lL]
   ;
fragment N
   : [nN]
   ;
fragment O
   : [oO]
   ;
fragment P
   : [pP]
   ;
fragment R
   : [rR]
   ;
fragment S
   : [sS]
   ;
fragment T
   : [tT]
   ;
fragment U
   : [uU]
   ;
fragment V
   : [vV]
   ;
fragment W
   : [wW]
   ;

// Keywords
INHERITS : I N H E R I T S ;
CLASS : C L A S S ;
IF  : I F ;
THEN : T H E N ;
ELSE : E L S E;
FI : F I ;

WHILE : W H I L E ;
LOOP : L O O P ;
POOL : P O O L ;

LET  : L E T ;
IN   : I N ;

CASE : C A S E ;
OF   : O F ;
ESAC : E S A C;

ISVOID : I S V O I D ;

NOT  : N O T ;

NEW  : N E W ;

TRUE : 't' R U E ;
FALSE : 'f' A L S E ;


// primitives
INTEGER : [0-9]+ ;
LITERAL :  '"'([a-zA-Z0-9\\: .!@#'$%^-]|'+')*'"' ;
TYPE: [A-Z][_0-9A-Za-z]*;
ID : [a-zA-Z][_a-zA-Z0-9]*;


ASSIGN_OPERATOR : '<-' ;
CASE_ARROW : '=>' ;

EQUAL : '=' ;
SMALLER_THAN : '<' ;
BIGGER_THAN : '>' ;
LESS_THAN_OR_EQUAL : '<=';
PLUS : '+' ;
MINUS : '-' ;
DIVIDED : '/' ;
MULTIPLY : '*' ;
INTEGER_NEGATIVE: '~';

WHITESPACE : (' '  | '\t') -> skip;
NEWLINE : ('\r'? '\n' | '\r')-> skip;

OPEN_COMMENT: '(*';
CLOSE_COMMENT : '*)';
COMMENT : OPEN_COMMENT (COMMENT | .)*? CLOSE_COMMENT -> skip ;
ONE_LINE_COMMENT: '--' (~ '\n')* '\n'? -> skip ;

OPEN_CURLY : '{' ;
CLOSE_CURLY : '}' ;
OPENP_RANSIS : '(' ;
CLOSE_PRANSIS : ')' ;
OPEN_SQUARE : '[';
CLOSE_SQUARE: ']';

SEMICOLUN : ';';
COLUN : ':' ;
COMMA : ',' ;
DOT : '.';
AT : '@';

ERROR : . ;
