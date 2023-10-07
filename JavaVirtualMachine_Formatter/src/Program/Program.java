package Program;

import Funktion.Function;
import Visitor.Visitor;

public class Program {
	private Function[] function;

	public Program(Function[] function) {
		super();
		this.function = function;
	}

	public Function[] getFunctions() {
		return function;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
