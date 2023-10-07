package Expression;

import Visitor.Visitor;
import codegen.Unop;

public class Unary extends Expression {
	public Unary(Unop op, Expression operand) {
		super();
		this.op = op;
		this.operand = operand;
	}

	private Unop op;
	private Expression operand;

	public Unop getOperator() {
		return op;
	}

	public Expression getOperand() {
		return operand;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
