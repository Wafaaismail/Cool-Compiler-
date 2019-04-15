// Generated from C:/Users/manar/IdeaProjects/trial/src\Cool.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CoolParser}.
 */
public interface CoolListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CoolParser#stats}.
	 * @param ctx the parse tree
	 */
	void enterStats(CoolParser.StatsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#stats}.
	 * @param ctx the parse tree
	 */
	void exitStats(CoolParser.StatsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CoolParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(CoolParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CoolParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(CoolParser.StatContext ctx);
}