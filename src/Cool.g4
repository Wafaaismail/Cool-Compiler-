grammar Cool;
stats : stat+;
stat : NUMBER '+' NUMBER;

NUMBER : [0-9]+ ;
WHITESPACE : (' '  | '\t') -> skip;
NEWLINE : ('\r'? '\n' | '\r');

OPEN_COMMENT: '(*';
CLOSE_COMMENT : '*)';
COMMENT : OPEN_COMMENT (COMMENT | .)*? CLOSE_COMMENT -> skip ;
ONE_LINE_COMMENT: '--' (~ '\n')* '\n'? -> skip ;


INHERITS : 'inherits' ;
CLASS : 'class' ;

IF  : 'if' ;
THEN : 'then' ;
FI : 'fi' ;

WHILE : 'while' ;
LOOP : 'loop' ;
POOL : 'pool' ;

LET  : 'let' ;
IN   : 'in' ;

CASE : 'case' ;
OF   : 'of' ;
ESAC : 'esac';

ISVOID : 'isvoid' ;

NOT  : 'not' ;

NEW  : 'new' ;

TRUE : 'true' ;
FALSE : 'false' ;

OPEN_CARLY : '{' ;
CLOSE_CARLY : '}' ;
OPENP_RANSIS : '(' ;
CLOSE_PRANSIS : ')' ;

SEMICOLUN : ';';
COLUN : ':' ;
COMMA : ',' ;
DOT : '.';
AT : '@';

ASSIGN_OPERATOR : '<-' ;
CASE_ARROW : '=>' ;
EQUAL : '=' ;
SMALLERTHAN : '<' ;
BIGGERTHAN : '>' ;
PLUS : '+' ;
MINUS : '-' ;
DIVIDED : '/' ;
MULTIPLY : '*' ;
INTEGER_NEGATIVE: '~';


LETTER : [a-zA-Z] ;
ID : LETTER'_'(LETTER'_'|NUMBER)* ;
LITERAL : '"'[^"]*'"';


