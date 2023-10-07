package Statement;
import Expression.Expression;
import Visitor.Visitor;

public class Assignment extends Statement {
	private String name;
	private Expression expression;

	public Assignment(String name, Expression expression) {
		super();
		this.name = name;
		this.expression = expression;
	}

	public String getName() {
		return name;
	}

	public Expression getExpression() {
		return expression;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
