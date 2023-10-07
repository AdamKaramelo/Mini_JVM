package Instructions;

import Visitors.AsmVisitor;

public class Pop extends Instruction{

	public Pop(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
