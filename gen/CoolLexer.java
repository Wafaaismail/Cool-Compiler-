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
		INHERITS=1, CLASS=2, IF=3, THEN=4, FI=5, WHILE=6, LOOP=7, POOL=8, LET=9, 
		IN=10, CASE=11, OF=12, ESAC=13, ISVOID=14, NOT=15, NEW=16, TRUE=17, FALSE=18, 
		NUMBER=19, LITERAL=20, ID=21, ASSIGN_OPERATOR=22, CASE_ARROW=23, EQUAL=24, 
		SMALLER_THAN=25, BIGGER_THAN=26, LESS_THAN_OR_EQUAL=27, PLUS=28, MINUS=29, 
		DIVIDED=30, MULTIPLY=31, INTEGER_NEGATIVE=32, WHITESPACE=33, NEWLINE=34, 
		OPEN_COMMENT=35, CLOSE_COMMENT=36, COMMENT=37, ONE_LINE_COMMENT=38, OPEN_CURLY=39, 
		CLOSE_CURLY=40, OPENP_RANSIS=41, CLOSE_PRANSIS=42, SEMICOLUN=43, COLUN=44, 
		COMMA=45, DOT=46, AT=47, ERROR=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INHERITS", "CLASS", "IF", "THEN", "FI", "WHILE", "LOOP", "POOL", "LET", 
			"IN", "CASE", "OF", "ESAC", "ISVOID", "NOT", "NEW", "TRUE", "FALSE", 
			"NUMBER", "LITERAL", "ID", "ASSIGN_OPERATOR", "CASE_ARROW", "EQUAL", 
			"SMALLER_THAN", "BIGGER_THAN", "LESS_THAN_OR_EQUAL", "PLUS", "MINUS", 
			"DIVIDED", "MULTIPLY", "INTEGER_NEGATIVE", "WHITESPACE", "NEWLINE", "OPEN_COMMENT", 
			"CLOSE_COMMENT", "COMMENT", "ONE_LINE_COMMENT", "OPEN_CURLY", "CLOSE_CURLY", 
			"OPENP_RANSIS", "CLOSE_PRANSIS", "SEMICOLUN", "COLUN", "COMMA", "DOT", 
			"AT", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'inherits'", "'class'", "'if'", "'then'", "'fi'", "'while'", "'loop'", 
			"'pool'", "'let'", "'in'", "'case'", "'of'", "'esac'", "'isvoid'", "'not'", 
			"'new'", "'true'", "'false'", null, null, null, "'<-'", "'=>'", "'='", 
			"'<'", "'>'", "'<='", "'+'", "'-'", "'/'", "'*'", "'~'", null, null, 
			"'(*'", "'*)'", null, null, "'{'", "'}'", "'('", "')'", "';'", "':'", 
			"','", "'.'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INHERITS", "CLASS", "IF", "THEN", "FI", "WHILE", "LOOP", "POOL", 
			"LET", "IN", "CASE", "OF", "ESAC", "ISVOID", "NOT", "NEW", "TRUE", "FALSE", 
			"NUMBER", "LITERAL", "ID", "ASSIGN_OPERATOR", "CASE_ARROW", "EQUAL", 
			"SMALLER_THAN", "BIGGER_THAN", "LESS_THAN_OR_EQUAL", "PLUS", "MINUS", 
			"DIVIDED", "MULTIPLY", "INTEGER_NEGATIVE", "WHITESPACE", "NEWLINE", "OPEN_COMMENT", 
			"CLOSE_COMMENT", "COMMENT", "ONE_LINE_COMMENT", "OPEN_CURLY", "CLOSE_CURLY", 
			"OPENP_RANSIS", "CLOSE_PRANSIS", "SEMICOLUN", "COLUN", "COMMA", "DOT", 
			"AT", "ERROR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u012a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\6\24\u00bd\n\24\r\24\16\24\u00be\3\25\3\25\7\25\u00c3"+
		"\n\25\f\25\16\25\u00c6\13\25\3\25\3\25\3\26\3\26\7\26\u00cc\n\26\f\26"+
		"\16\26\u00cf\13\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3\"\3\"\3#\5#\u00ef\n#\3#\3#\5#\u00f3\n#\3#\3#\3$\3$\3$\3%\3%\3%"+
		"\3&\3&\3&\7&\u0100\n&\f&\16&\u0103\13&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\7\'"+
		"\u010d\n\'\f\'\16\'\u0110\13\'\3\'\5\'\u0113\n\'\3\'\3\'\3(\3(\3)\3)\3"+
		"*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\u0101\2\62\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62\3\2\b\3\2\62;\13\2\"#%\'"+
		"--/\60\62<B\\^^``c|\4\2C\\c|\6\2\62;C\\aac|\4\2\13\13\"\"\3\2\f\f\2\u0132"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\3c\3\2\2\2\5l\3\2\2\2\7r\3\2\2\2\tu\3\2\2\2\13z\3\2\2\2\r}\3\2"+
		"\2\2\17\u0083\3\2\2\2\21\u0088\3\2\2\2\23\u008d\3\2\2\2\25\u0091\3\2\2"+
		"\2\27\u0094\3\2\2\2\31\u0099\3\2\2\2\33\u009c\3\2\2\2\35\u00a1\3\2\2\2"+
		"\37\u00a8\3\2\2\2!\u00ac\3\2\2\2#\u00b0\3\2\2\2%\u00b5\3\2\2\2\'\u00bc"+
		"\3\2\2\2)\u00c0\3\2\2\2+\u00c9\3\2\2\2-\u00d0\3\2\2\2/\u00d3\3\2\2\2\61"+
		"\u00d6\3\2\2\2\63\u00d8\3\2\2\2\65\u00da\3\2\2\2\67\u00dc\3\2\2\29\u00df"+
		"\3\2\2\2;\u00e1\3\2\2\2=\u00e3\3\2\2\2?\u00e5\3\2\2\2A\u00e7\3\2\2\2C"+
		"\u00e9\3\2\2\2E\u00f2\3\2\2\2G\u00f6\3\2\2\2I\u00f9\3\2\2\2K\u00fc\3\2"+
		"\2\2M\u0108\3\2\2\2O\u0116\3\2\2\2Q\u0118\3\2\2\2S\u011a\3\2\2\2U\u011c"+
		"\3\2\2\2W\u011e\3\2\2\2Y\u0120\3\2\2\2[\u0122\3\2\2\2]\u0124\3\2\2\2_"+
		"\u0126\3\2\2\2a\u0128\3\2\2\2cd\7k\2\2de\7p\2\2ef\7j\2\2fg\7g\2\2gh\7"+
		"t\2\2hi\7k\2\2ij\7v\2\2jk\7u\2\2k\4\3\2\2\2lm\7e\2\2mn\7n\2\2no\7c\2\2"+
		"op\7u\2\2pq\7u\2\2q\6\3\2\2\2rs\7k\2\2st\7h\2\2t\b\3\2\2\2uv\7v\2\2vw"+
		"\7j\2\2wx\7g\2\2xy\7p\2\2y\n\3\2\2\2z{\7h\2\2{|\7k\2\2|\f\3\2\2\2}~\7"+
		"y\2\2~\177\7j\2\2\177\u0080\7k\2\2\u0080\u0081\7n\2\2\u0081\u0082\7g\2"+
		"\2\u0082\16\3\2\2\2\u0083\u0084\7n\2\2\u0084\u0085\7q\2\2\u0085\u0086"+
		"\7q\2\2\u0086\u0087\7r\2\2\u0087\20\3\2\2\2\u0088\u0089\7r\2\2\u0089\u008a"+
		"\7q\2\2\u008a\u008b\7q\2\2\u008b\u008c\7n\2\2\u008c\22\3\2\2\2\u008d\u008e"+
		"\7n\2\2\u008e\u008f\7g\2\2\u008f\u0090\7v\2\2\u0090\24\3\2\2\2\u0091\u0092"+
		"\7k\2\2\u0092\u0093\7p\2\2\u0093\26\3\2\2\2\u0094\u0095\7e\2\2\u0095\u0096"+
		"\7c\2\2\u0096\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098\30\3\2\2\2\u0099\u009a"+
		"\7q\2\2\u009a\u009b\7h\2\2\u009b\32\3\2\2\2\u009c\u009d\7g\2\2\u009d\u009e"+
		"\7u\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7e\2\2\u00a0\34\3\2\2\2\u00a1\u00a2"+
		"\7k\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7x\2\2\u00a4\u00a5\7q\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7f\2\2\u00a7\36\3\2\2\2\u00a8\u00a9\7p\2\2\u00a9"+
		"\u00aa\7q\2\2\u00aa\u00ab\7v\2\2\u00ab \3\2\2\2\u00ac\u00ad\7p\2\2\u00ad"+
		"\u00ae\7g\2\2\u00ae\u00af\7y\2\2\u00af\"\3\2\2\2\u00b0\u00b1\7v\2\2\u00b1"+
		"\u00b2\7t\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7g\2\2\u00b4$\3\2\2\2\u00b5"+
		"\u00b6\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7u\2\2"+
		"\u00b9\u00ba\7g\2\2\u00ba&\3\2\2\2\u00bb\u00bd\t\2\2\2\u00bc\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"(\3\2\2\2\u00c0\u00c4\7$\2\2\u00c1\u00c3\t\3\2\2\u00c2\u00c1\3\2\2\2\u00c3"+
		"\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2"+
		"\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\7$\2\2\u00c8*\3\2\2\2\u00c9\u00cd"+
		"\t\4\2\2\u00ca\u00cc\t\5\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce,\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00d0\u00d1\7>\2\2\u00d1\u00d2\7/\2\2\u00d2.\3\2\2\2\u00d3\u00d4\7?\2"+
		"\2\u00d4\u00d5\7@\2\2\u00d5\60\3\2\2\2\u00d6\u00d7\7?\2\2\u00d7\62\3\2"+
		"\2\2\u00d8\u00d9\7>\2\2\u00d9\64\3\2\2\2\u00da\u00db\7@\2\2\u00db\66\3"+
		"\2\2\2\u00dc\u00dd\7>\2\2\u00dd\u00de\7?\2\2\u00de8\3\2\2\2\u00df\u00e0"+
		"\7-\2\2\u00e0:\3\2\2\2\u00e1\u00e2\7/\2\2\u00e2<\3\2\2\2\u00e3\u00e4\7"+
		"\61\2\2\u00e4>\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6@\3\2\2\2\u00e7\u00e8\7"+
		"\u0080\2\2\u00e8B\3\2\2\2\u00e9\u00ea\t\6\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\b\"\2\2\u00ecD\3\2\2\2\u00ed\u00ef\7\17\2\2\u00ee\u00ed\3\2\2\2"+
		"\u00ee\u00ef\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f3\7\f\2\2\u00f1\u00f3"+
		"\7\17\2\2\u00f2\u00ee\3\2\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2"+
		"\u00f4\u00f5\b#\2\2\u00f5F\3\2\2\2\u00f6\u00f7\7*\2\2\u00f7\u00f8\7,\2"+
		"\2\u00f8H\3\2\2\2\u00f9\u00fa\7,\2\2\u00fa\u00fb\7+\2\2\u00fbJ\3\2\2\2"+
		"\u00fc\u0101\5G$\2\u00fd\u0100\5K&\2\u00fe\u0100\13\2\2\2\u00ff\u00fd"+
		"\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u0102\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0102\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\5I"+
		"%\2\u0105\u0106\3\2\2\2\u0106\u0107\b&\2\2\u0107L\3\2\2\2\u0108\u0109"+
		"\7/\2\2\u0109\u010a\7/\2\2\u010a\u010e\3\2\2\2\u010b\u010d\n\7\2\2\u010c"+
		"\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\7\f\2\2\u0112"+
		"\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\b\'"+
		"\2\2\u0115N\3\2\2\2\u0116\u0117\7}\2\2\u0117P\3\2\2\2\u0118\u0119\7\177"+
		"\2\2\u0119R\3\2\2\2\u011a\u011b\7*\2\2\u011bT\3\2\2\2\u011c\u011d\7+\2"+
		"\2\u011dV\3\2\2\2\u011e\u011f\7=\2\2\u011fX\3\2\2\2\u0120\u0121\7<\2\2"+
		"\u0121Z\3\2\2\2\u0122\u0123\7.\2\2\u0123\\\3\2\2\2\u0124\u0125\7\60\2"+
		"\2\u0125^\3\2\2\2\u0126\u0127\7B\2\2\u0127`\3\2\2\2\u0128\u0129\13\2\2"+
		"\2\u0129b\3\2\2\2\r\2\u00be\u00c2\u00c4\u00cd\u00ee\u00f2\u00ff\u0101"+
		"\u010e\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}