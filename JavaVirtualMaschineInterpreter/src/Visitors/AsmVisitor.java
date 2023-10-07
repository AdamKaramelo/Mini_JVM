package Visitors;

import Instructions.Add;
import Instructions.And;
import Instructions.Brc;
import Instructions.Call;
import Instructions.Cmp;
import Instructions.Decl;
import Instructions.Div;
import Instructions.Halt;
import Instructions.In;
import Instructions.Ldi;
import Instructions.Lfs;
import Instructions.Mod;
import Instructions.Mul;
import Instructions.Nop;
import Instructions.Not;
import Instructions.Or;
import Instructions.Out;
import Instructions.Pop;
import Instructions.Push;
import Instructions.Sts;
import Instructions.Sub;
import Instructions.Return;

public interface AsmVisitor {
	
	public void visit(Add add);
	public void visit(And and);
	public void visit(Brc brc);
	public void visit(Call call);
	public void visit(Cmp cmp);
	public void visit(Decl decl);
	public void visit(Div div);
	public void visit(Halt halt);
	public void visit(In in);
	public void visit(Ldi ldi);
	public void visit(Lfs lfs);
	public void visit(Mod mod);
	public void visit(Mul mul);
	public void visit(Nop nop);
	public void visit(Not not);
	public void visit(Or or);
	public void visit(Out out);
	public void visit(Pop pop);
	public void visit(Push push);
	public void visit(Return return1);
	public void visit(Sts sts);
	public void visit(Sub sub);



}
