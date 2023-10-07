package Declaration;

import Visitor.Visitor;

public class Declaration {
	private String [] names;
	public String [] getNames () {
		return names;
	}
	public Declaration(String[] names) {
		super();
		this.names = names;
	}
	public Declaration(Declaration declaration) {
		super();
		this.names = declaration.names;
	}
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
