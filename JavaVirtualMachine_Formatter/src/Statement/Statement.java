package Statement;

import Visitor.Visitor;

public abstract class Statement {

	public abstract void accept(Visitor visitor);
}
