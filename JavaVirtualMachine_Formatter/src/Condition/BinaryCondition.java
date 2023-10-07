package Condition;

import Visitor.Visitor;
import codegen.Bbinop;

public class BinaryCondition extends Condition {
	public BinaryCondition(Condition lhs, Bbinop op, Condition rhs) {
		super();
		this.lhs = lhs;
		this.op = op;
		this.rhs = rhs;
	}

	private Condition lhs;
	private Bbinop op;
	private Condition rhs;

	public Condition getLhs() {
		return lhs;
	}

	public Bbinop getOperator() {
		return op;
	}

	public Condition getRhs() {
		return rhs;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
