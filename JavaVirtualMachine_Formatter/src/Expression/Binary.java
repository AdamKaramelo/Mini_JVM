package Expression;

import Visitor.Visitor;
import codegen.Binop;

public class Binary extends Expression {
	public Binary(Expression lhs, Binop op, Expression rhs) {
		super();
		this.lhs = lhs;
		this.op = op;
		this.rhs = rhs;
	}

	private Expression lhs;
	private Binop op;
	private Expression rhs;

	public Expression getLhs() {
		return lhs;
	}

	public Binop getOperator() {
		return op;
	}

	public Expression getRhs() {
		return rhs;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
