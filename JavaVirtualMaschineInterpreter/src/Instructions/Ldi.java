package Instructions;

import Visitors.AsmVisitor;

public class Ldi extends Instruction{

	public Ldi(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
