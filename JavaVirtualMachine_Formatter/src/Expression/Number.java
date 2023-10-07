package Expression;

import Visitor.Visitor;

public class Number extends Expression {
	public Number(int value) {
		super();
		this.value = value;
	}

	private int value;

	public int getValue() {
		return value;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
