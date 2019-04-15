grammar Cool;
stats : stat+;
stat : NUMBER '+' NUMBER;

//key words
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

//primative
INTEGER : [0-9]+ ;
LITERAL :  '"'([a-zA-Z0-9\\: .!@#$%^-]|'+')*'"' ; ////////
ID : [a-zA-Z][_a-zA-Z0-9]*; //////////////////

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

SEMICOLUN : ';';
COLUN : ':' ;
COMMA : ',' ;
DOT : '.';
AT : '@';

ERROR : . ;





