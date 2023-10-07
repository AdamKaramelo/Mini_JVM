package Statement;
import Condition.Condition;
import Visitor.Visitor;

public class IfThen extends Statement{
	public IfThen(Condition cond, Statement branch) {
		super();
		this.cond = cond;
		this.branch = branch;
	}
	private Condition cond;
	private Statement branch;
	public Condition getCond () {
		return cond;
	}
	public Statement getThenBranch () {
		return branch;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}


}
