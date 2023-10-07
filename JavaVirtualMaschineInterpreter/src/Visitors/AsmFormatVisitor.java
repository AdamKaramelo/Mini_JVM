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
import Instructions.Instruction;
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
import Instructions.Return;
import Instructions.Sts;
import Instructions.Sub;

public class AsmFormatVisitor implements AsmVisitor{
	
	public AsmFormatVisitor(Instruction[] instructions) {
		super();
		this.instructions = instructions;
		this.formattedCode = "";
	}

	private Instruction [] instructions; 
	String formattedCode;
	private int instructionPointer = 0;
	
	public String getFormattedCode() {
		for (Instruction instruction: this.instructions) {
			formattedCode+= Integer.toString(instructionPointer) + ": ";
			instructionPointer++;
			instruction.accept(this);
			formattedCode+="\n";
		}
		return formattedCode;
	}

	@Override
	public void visit(Add add) {
		formattedCode+= "ADD";
		
	}

	@Override
	public void visit(And and) {
		formattedCode+= "AND";		
	}

	@Override
	public void visit(Brc brc) {
		formattedCode+= "BRC " + brc.getImmediate();		
	}

	@Override
	public void visit(Call call) {
		formattedCode+= "CALL " + call.getImmediate();		
	}

	@Override
	public void visit(Cmp cmp) {
		formattedCode+= "CMP " + cmp.getImmediate();		
	}

	@Override
	public void visit(Decl decl) {
		formattedCode+= "DECL " + decl.getImmediate();		
	}

	@Override
	public void visit(Div div) {
		formattedCode+= "DIV";		
	}

	@Override
	public void visit(Halt halt) {
		formattedCode+= "HALT";		
	}

	@Override
	public void visit(In in) {
		formattedCode+= "IN";		
	}

	@Override
	public void visit(Ldi ldi) {
		formattedCode+= "LDI " + ldi.getImmediate();		
	}

	@Override
	public void visit(Lfs lfs) {
		formattedCode+= "LFS " +lfs.getImmediate();		
	}

	@Override
	public void visit(Mod mod) {
		formattedCode+= "MOD";		
	}

	@Override
	public void visit(Mul mul) {
		formattedCode+= "MUL";		
	}

	@Override
	public void visit(Nop nop) {
		formattedCode+= "NOP";		
	}

	@Override
	public void visit(Not not) {
		formattedCode+= "NOT";		
	}

	@Override
	public void visit(Or or) {
		formattedCode+= "OR";		
	}

	@Override
	public void visit(Out out) {
		formattedCode+= "OUT";		
	}

	@Override
	public void visit(Pop pop) {
		formattedCode+= "POP " + pop.getImmediate();		
	}

	@Override
	public void visit(Push push) {
		formattedCode+= "PUSH " + push.getImmediate();		
	}

	@Override
	public void visit(Return return1) {
		formattedCode+= "RETURN " + return1.getImmediate();		
	}

	@Override
	public void visit(Sts sts) {
		formattedCode+= "STS " + sts.getImmediate();		
	}

	@Override
	public void visit(Sub sub) {
		formattedCode+= "SUB";		
	}

}
