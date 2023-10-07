package Expression;

import Visitor.Visitor;

public class Read extends Expression{
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
