// Generated from C:/Users/manar/IdeaProjects/trial/src\Cool.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolParser extends Parser {
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
	public static final int
		RULE_stats = 0, RULE_stat = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"stats", "stat"
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

	@Override
	public String getGrammarFileName() { return "Cool.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StatsContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public StatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolListener ) ((CoolListener)listener).enterStats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolListener ) ((CoolListener)listener).exitStats(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitStats(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stats);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(4);
				stat();
				}
				}
				setState(7); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(CoolParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CoolParser.NUMBER, i);
		}
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolListener ) ((CoolListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolListener ) ((CoolListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolVisitor ) return ((CoolVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			match(NUMBER);
			setState(10);
			match(PLUS);
			setState(11);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\20\4\2\t\2\4\3"+
		"\t\3\3\2\6\2\b\n\2\r\2\16\2\t\3\3\3\3\3\3\3\3\3\3\2\2\4\2\4\2\2\2\16\2"+
		"\7\3\2\2\2\4\13\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\t\3\2\2\2\t\7\3\2\2"+
		"\2\t\n\3\2\2\2\n\3\3\2\2\2\13\f\7\3\2\2\f\r\7*\2\2\r\16\7\3\2\2\16\5\3"+
		"\2\2\2\3\t";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}