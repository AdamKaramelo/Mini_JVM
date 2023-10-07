package Statement;
import Expression.Expression;
import Visitor.Visitor;

public class ExpressionStatement extends Statement{
	public ExpressionStatement(Expression expr) {
		super();
		this.expr = expr;
	}

	private Expression expr;
	
	public Expression getExpression () {
		return expr;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
   
}
