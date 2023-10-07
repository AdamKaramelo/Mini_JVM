package Instructions;

import Visitors.AsmVisitor;

public class Brc extends Instruction{
	
	
	public Brc(int immediate) {
		super(immediate);
	}

	public void accept(AsmVisitor Asmvisitor) {
		Asmvisitor.visit(this);
	}

}
