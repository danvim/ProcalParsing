package fx50.nodes;

import fx50.CalcMath.CalcMath;
import org.bychan.core.dynamic.UserParserCallback;

import java.math.BigDecimal;

import static fx50.CalculatorHelper.Tokens.lparen;
import static fx50.CalculatorHelper.Tokens.rparen;
import static fx50.ParsingHelper.nextIsStatementEnd;

/**
 * Parenthesis Node
 */
public class ParenthesisNode implements CalculatorNode {
    private CalculatorNode right;

    public ParenthesisNode(CalculatorNode left, UserParserCallback<CalculatorNode> parser) {
        this.right = parser.expression(left);
        if (parser.nextIs(lparen.getKey()))
            this.right = new MultiplicationNode(right, (CalculatorNode) parser.expression(right));
        if (!nextIsStatementEnd(parser))
            parser.expectSingleLexeme(rparen.getKey());
    }

    public BigDecimal evaluate() {
        return right.evaluate();
    }

    public String toString() {
        return "(" + right.toString() + ")";
    }
}
