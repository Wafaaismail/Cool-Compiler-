// Generated from C:/Users/manar/IdeaProjects/trial/src\Cool.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CoolParser#stats}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStats(CoolParser.StatsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CoolParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(CoolParser.StatContext ctx);
}