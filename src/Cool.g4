grammar Cool;

// Parser Rules
program
    : programBlocks
    ;

programBlocks
    : classDefine SEMICOLUN programBlocks
    | EOF
    ;

classDefine: CLASS TYPE (INHERITS TYPE)? OPEN_CURLY (feature SEMICOLUN)* CLOSE_CURLY;

feature: ID OPENP_RANSIS (formal (COMMA formal)*)* CLOSE_PRANSIS COLUN TYPE OPEN_CURLY expr CLOSE_CURLY
    | ID COLUN TYPE (ASSIGN_OPERATOR expr)
    ;

formal: ID COLUN TYPE;
expr: ID ASSIGN_OPERATOR expr
    | expr (AT TYPE)?DOT ID OPENP_RANSIS (expr (COMMA expr)*)* CLOSE_PRANSIS
    | ID OPENP_RANSIS (expr (COMMA expr)*)* CLOSE_PRANSIS
    | IF expr THEN expr ELSE expr FI
    | WHILE expr LOOP expr POOL
    | OPEN_CURLY (expr SEMICOLUN)+ CLOSE_CURLY
    | LET ID COLUN TYPE (ASSIGN_OPERATOR expr)? (COMMA ID COLUN TYPE (ASSIGN_OPERATOR expr)?)* IN expr
    | CASE expr OF (ID COLUN TYPE CASE_ARROW expr SEMICOLUN)+ESAC
    | NEW TYPE
    | ISVOID expr
    | expr PLUS expr
    | expr MINUS expr
    | expr MULTIPLY expr
    | expr DIVIDED expr
    | INTEGER_NEGATIVE expr
    | expr SMALLER_THAN expr
    | expr LESS_THAN_OR_EQUAL expr
    | expr EQUAL expr
    | NOT expr
    | OPENP_RANSIS expr CLOSE_PRANSIS
    | ID
    | INTEGER
    | LITERAL
    | TRUE
    | FALSE
    ;

// Lexical Rules
INHERITS : 'inherits' ;
CLASS : 'class' ;
IF  : 'if' ;
THEN : 'then' ;
ELSE : 'else';
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
TYPE: [A-Z][_0-9A-Za-z]*;
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
OPEN_SQUARE : '[';
CLOSE_SQUARE: ']';

SEMICOLUN : ';';
COLUN : ':' ;
COMMA : ',' ;
DOT : '.';
AT : '@';

ERROR : . ;





