package Expression;

import Visitor.Visitor;

public class Variable extends Expression {
	public Variable(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
