// Generated from C:/Users/manar/IdeaProjects/trial/src\Cool.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, WHITESPACE=2, NEWLINE=3, OPEN_COMMENT=4, CLOSE_COMMENT=5, COMMENT=6, 
		ONE_LINE_COMMENT=7, INHERITS=8, CLASS=9, IF=10, THEN=11, FI=12, WHILE=13, 
		LOOP=14, POOL=15, LET=16, IN=17, CASE=18, OF=19, ESAC=20, ISVOID=21, NOT=22, 
		NEW=23, TRUE=24, FALSE=25, OPEN_CARLY=26, CLOSE_CARLY=27, OPENP_RANSIS=28, 
		CLOSE_PRANSIS=29, SEMICOLUN=30, COLUN=31, COMMA=32, DOT=33, AT=34, ASSIGN_OPERATOR=35, 
		CASE_ARROW=36, EQUAL=37, SMALLERTHAN=38, BIGGERTHAN=39, PLUS=40, MINUS=41, 
		DIVIDED=42, MULTIPLY=43, INTEGER_NEGATIVE=44, LETTER=45, ID=46, LITERAL=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBER", "WHITESPACE", "NEWLINE", "OPEN_COMMENT", "CLOSE_COMMENT", "COMMENT", 
			"ONE_LINE_COMMENT", "INHERITS", "CLASS", "IF", "THEN", "FI", "WHILE", 
			"LOOP", "POOL", "LET", "IN", "CASE", "OF", "ESAC", "ISVOID", "NOT", "NEW", 
			"TRUE", "FALSE", "OPEN_CARLY", "CLOSE_CARLY", "OPENP_RANSIS", "CLOSE_PRANSIS", 
			"SEMICOLUN", "COLUN", "COMMA", "DOT", "AT", "ASSIGN_OPERATOR", "CASE_ARROW", 
			"EQUAL", "SMALLERTHAN", "BIGGERTHAN", "PLUS", "MINUS", "DIVIDED", "MULTIPLY", 
			"INTEGER_NEGATIVE", "LETTER", "ID", "LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'(*'", "'*)'", null, null, "'inherits'", "'class'", 
			"'if'", "'then'", "'fi'", "'while'", "'loop'", "'pool'", "'let'", "'in'", 
			"'case'", "'of'", "'esac'", "'isvoid'", "'not'", "'new'", "'true'", "'false'", 
			"'{'", "'}'", "'('", "')'", "';'", "':'", "','", "'.'", "'@'", "'<-'", 
			"'=>'", "'='", "'<'", "'>'", "'+'", "'-'", "'/'", "'*'", "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "WHITESPACE", "NEWLINE", "OPEN_COMMENT", "CLOSE_COMMENT", 
			"COMMENT", "ONE_LINE_COMMENT", "INHERITS", "CLASS", "IF", "THEN", "FI", 
			"WHILE", "LOOP", "POOL", "LET", "IN", "CASE", "OF", "ESAC", "ISVOID", 
			"NOT", "NEW", "TRUE", "FALSE", "OPEN_CARLY", "CLOSE_CARLY", "OPENP_RANSIS", 
			"CLOSE_PRANSIS", "SEMICOLUN", "COLUN", "COMMA", "DOT", "AT", "ASSIGN_OPERATOR", 
			"CASE_ARROW", "EQUAL", "SMALLERTHAN", "BIGGERTHAN", "PLUS", "MINUS", 
			"DIVIDED", "MULTIPLY", "INTEGER_NEGATIVE", "LETTER", "ID", "LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0127\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\6\2c\n\2\r\2\16\2d\3\3\3\3\3\3"+
		"\3\3\3\4\5\4l\n\4\3\4\3\4\5\4p\n\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\7\7{\n\7\f\7\16\7~\13\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0088\n\b"+
		"\f\b\16\b\u008b\13\b\3\b\5\b\u008e\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3%"+
		"\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3"+
		"/\3/\7/\u011a\n/\f/\16/\u011d\13/\3\60\3\60\7\60\u0121\n\60\f\60\16\60"+
		"\u0124\13\60\3\60\3\60\3|\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"\3\2\7\3\2\62;\4\2\13\13\"\"\3\2\f\f\4\2C\\c|\4\2$$``\2\u0130\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3b\3\2\2\2\5"+
		"f\3\2\2\2\7o\3\2\2\2\tq\3\2\2\2\13t\3\2\2\2\rw\3\2\2\2\17\u0083\3\2\2"+
		"\2\21\u0091\3\2\2\2\23\u009a\3\2\2\2\25\u00a0\3\2\2\2\27\u00a3\3\2\2\2"+
		"\31\u00a8\3\2\2\2\33\u00ab\3\2\2\2\35\u00b1\3\2\2\2\37\u00b6\3\2\2\2!"+
		"\u00bb\3\2\2\2#\u00bf\3\2\2\2%\u00c2\3\2\2\2\'\u00c7\3\2\2\2)\u00ca\3"+
		"\2\2\2+\u00cf\3\2\2\2-\u00d6\3\2\2\2/\u00da\3\2\2\2\61\u00de\3\2\2\2\63"+
		"\u00e3\3\2\2\2\65\u00e9\3\2\2\2\67\u00eb\3\2\2\29\u00ed\3\2\2\2;\u00ef"+
		"\3\2\2\2=\u00f1\3\2\2\2?\u00f3\3\2\2\2A\u00f5\3\2\2\2C\u00f7\3\2\2\2E"+
		"\u00f9\3\2\2\2G\u00fb\3\2\2\2I\u00fe\3\2\2\2K\u0101\3\2\2\2M\u0103\3\2"+
		"\2\2O\u0105\3\2\2\2Q\u0107\3\2\2\2S\u0109\3\2\2\2U\u010b\3\2\2\2W\u010d"+
		"\3\2\2\2Y\u010f\3\2\2\2[\u0111\3\2\2\2]\u0113\3\2\2\2_\u011e\3\2\2\2a"+
		"c\t\2\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\4\3\2\2\2fg\t\3\2\2"+
		"gh\3\2\2\2hi\b\3\2\2i\6\3\2\2\2jl\7\17\2\2kj\3\2\2\2kl\3\2\2\2lm\3\2\2"+
		"\2mp\7\f\2\2np\7\17\2\2ok\3\2\2\2on\3\2\2\2p\b\3\2\2\2qr\7*\2\2rs\7,\2"+
		"\2s\n\3\2\2\2tu\7,\2\2uv\7+\2\2v\f\3\2\2\2w|\5\t\5\2x{\5\r\7\2y{\13\2"+
		"\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2|}\3\2\2\2|z\3\2\2\2}\177\3\2\2\2~|"+
		"\3\2\2\2\177\u0080\5\13\6\2\u0080\u0081\3\2\2\2\u0081\u0082\b\7\2\2\u0082"+
		"\16\3\2\2\2\u0083\u0084\7/\2\2\u0084\u0085\7/\2\2\u0085\u0089\3\2\2\2"+
		"\u0086\u0088\n\4\2\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008e\7\f\2\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\b\b\2\2\u0090\20\3\2\2\2\u0091\u0092\7k\2\2\u0092\u0093"+
		"\7p\2\2\u0093\u0094\7j\2\2\u0094\u0095\7g\2\2\u0095\u0096\7t\2\2\u0096"+
		"\u0097\7k\2\2\u0097\u0098\7v\2\2\u0098\u0099\7u\2\2\u0099\22\3\2\2\2\u009a"+
		"\u009b\7e\2\2\u009b\u009c\7n\2\2\u009c\u009d\7c\2\2\u009d\u009e\7u\2\2"+
		"\u009e\u009f\7u\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7"+
		"h\2\2\u00a2\26\3\2\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7j\2\2\u00a5\u00a6"+
		"\7g\2\2\u00a6\u00a7\7p\2\2\u00a7\30\3\2\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa"+
		"\7k\2\2\u00aa\32\3\2\2\2\u00ab\u00ac\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae"+
		"\7k\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7g\2\2\u00b0\34\3\2\2\2\u00b1\u00b2"+
		"\7n\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7r\2\2\u00b5"+
		"\36\3\2\2\2\u00b6\u00b7\7r\2\2\u00b7\u00b8\7q\2\2\u00b8\u00b9\7q\2\2\u00b9"+
		"\u00ba\7n\2\2\u00ba \3\2\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7g\2\2\u00bd"+
		"\u00be\7v\2\2\u00be\"\3\2\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7p\2\2\u00c1"+
		"$\3\2\2\2\u00c2\u00c3\7e\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7u\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6&\3\2\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7h\2\2\u00c9"+
		"(\3\2\2\2\u00ca\u00cb\7g\2\2\u00cb\u00cc\7u\2\2\u00cc\u00cd\7c\2\2\u00cd"+
		"\u00ce\7e\2\2\u00ce*\3\2\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d2\7x\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7f\2\2"+
		"\u00d5,\3\2\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7v\2"+
		"\2\u00d9.\3\2\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7"+
		"y\2\2\u00dd\60\3\2\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7t\2\2\u00e0\u00e1"+
		"\7w\2\2\u00e1\u00e2\7g\2\2\u00e2\62\3\2\2\2\u00e3\u00e4\7h\2\2\u00e4\u00e5"+
		"\7c\2\2\u00e5\u00e6\7n\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7g\2\2\u00e8"+
		"\64\3\2\2\2\u00e9\u00ea\7}\2\2\u00ea\66\3\2\2\2\u00eb\u00ec\7\177\2\2"+
		"\u00ec8\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee:\3\2\2\2\u00ef\u00f0\7+\2\2\u00f0"+
		"<\3\2\2\2\u00f1\u00f2\7=\2\2\u00f2>\3\2\2\2\u00f3\u00f4\7<\2\2\u00f4@"+
		"\3\2\2\2\u00f5\u00f6\7.\2\2\u00f6B\3\2\2\2\u00f7\u00f8\7\60\2\2\u00f8"+
		"D\3\2\2\2\u00f9\u00fa\7B\2\2\u00faF\3\2\2\2\u00fb\u00fc\7>\2\2\u00fc\u00fd"+
		"\7/\2\2\u00fdH\3\2\2\2\u00fe\u00ff\7?\2\2\u00ff\u0100\7@\2\2\u0100J\3"+
		"\2\2\2\u0101\u0102\7?\2\2\u0102L\3\2\2\2\u0103\u0104\7>\2\2\u0104N\3\2"+
		"\2\2\u0105\u0106\7@\2\2\u0106P\3\2\2\2\u0107\u0108\7-\2\2\u0108R\3\2\2"+
		"\2\u0109\u010a\7/\2\2\u010aT\3\2\2\2\u010b\u010c\7\61\2\2\u010cV\3\2\2"+
		"\2\u010d\u010e\7,\2\2\u010eX\3\2\2\2\u010f\u0110\7\u0080\2\2\u0110Z\3"+
		"\2\2\2\u0111\u0112\t\5\2\2\u0112\\\3\2\2\2\u0113\u0114\5[.\2\u0114\u011b"+
		"\7a\2\2\u0115\u0116\5[.\2\u0116\u0117\7a\2\2\u0117\u011a\3\2\2\2\u0118"+
		"\u011a\5\3\2\2\u0119\u0115\3\2\2\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c^\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011e\u0122\7$\2\2\u011f\u0121\t\6\2\2\u0120\u011f\3\2\2\2\u0121"+
		"\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0125\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7$\2\2\u0126`\3\2\2\2\r\2dkoz|\u0089"+
		"\u008d\u0119\u011b\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}