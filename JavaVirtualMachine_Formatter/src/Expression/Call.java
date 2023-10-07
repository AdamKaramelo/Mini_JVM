package Expression;

import Visitor.Visitor;

public class Call extends Expression {
	public Call(String name, Expression[] arguments) {
		super();
		this.name = name;
		this.arguments = arguments;
	}

	private String name;
	private Expression[] arguments;

	public String getFunctionName() {
		return name;
	}

	public Expression[] getArguments() {
		return arguments;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
