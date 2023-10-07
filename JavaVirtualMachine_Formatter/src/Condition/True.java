package Condition;

import Visitor.Visitor;

public class True extends Condition{
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
