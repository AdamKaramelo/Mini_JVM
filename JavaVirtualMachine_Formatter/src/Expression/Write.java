package Expression;

import Visitor.Visitor;

public class Write extends Expression {
	public Write(Expression expr) {
		super();
		this.expr = expr;
	}

	private Expression expr;

	public Expression getExpression() {
		return expr;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
