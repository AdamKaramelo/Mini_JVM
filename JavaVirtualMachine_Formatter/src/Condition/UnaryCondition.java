package Condition;

import Visitor.Visitor;
import codegen.Bunop;

public class UnaryCondition extends Condition {
	public UnaryCondition(Bunop op, Condition operand) {
		super();
		this.op = op;
		this.operand = operand;
	}

	private Bunop op;
	private Condition operand;

	public Bunop getOperator() {
		return op;
	}

	public Condition getOperand() {
		return operand;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
