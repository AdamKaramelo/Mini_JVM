package Statement;

import Visitor.Visitor;

public class Composite extends Statement{
	public Composite(Statement[] statement) {
		super();
		this.statement = statement;
	}

	private Statement[] statement;
	
	public Statement[] getStatements () {
			return statement;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
