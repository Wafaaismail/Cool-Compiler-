
lexer grammar Cool_lexer;

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
DIVIDE : '/' ;
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
OPENP_PRANSIS : '(' ;
CLOSE_PRANSIS : ')' ;
OPEN_SQUARE : '[';
CLOSE_SQUARE: ']';

SEMICOLUN : ';';
COLUN : ':' ;
COMMA : ',' ;
DOT : '.';
AT : '@';
ERROR : . ;
