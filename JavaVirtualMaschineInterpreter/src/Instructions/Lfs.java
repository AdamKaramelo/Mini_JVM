package Instructions;

import Visitors.AsmVisitor;

public class Lfs extends Instruction {

	public Lfs(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
