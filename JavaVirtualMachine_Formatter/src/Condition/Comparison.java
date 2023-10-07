package Condition;

import Expression.Expression;
import Visitor.Visitor;
import codegen.Comp;

public class Comparison extends Condition {

	public Comparison(Expression lhs, Comp op, Expression rhs) {
		super();
		this.lhs = lhs;
		this.op = op;
		this.rhs = rhs;
	}

	private Expression lhs;
	private Comp op;
	private Expression rhs;

	public Expression getLhs() {
		return lhs;
	}

	public Comp getOperator() {
		return op;
	}

	public Expression getRhs() {
		return rhs;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
