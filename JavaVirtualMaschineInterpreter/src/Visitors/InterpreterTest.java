package Visitors;


import Instructions.Add;
import Instructions.Brc;
import Instructions.Call;
import Instructions.Halt;
import Instructions.In;
import Instructions.Instruction;
import Instructions.Ldi;
import Instructions.Lfs;
import Instructions.Mod;
import Instructions.Mul;
import Instructions.Not;
import Instructions.Out;
import Instructions.Return;
import Instructions.Sts;
import Instructions.Sub;
import Instructions.Cmp;
import Instructions.Decl;

/**
 * Tests the {@link Interpreter} functionality. It interprets and executes Assembly instruction code.
 * Tests the {@link AsmFormatVisitor} functionality. It prints out the Assembly instructions. 
 *
 *
 */
public class InterpreterTest {
	private static final int EQUALS = 0;
	private static final int LESS = 1;

	public static void factorial() {
		//Factorial: k!
				Instruction[] fak = new Instruction[] {
						new In(),
						new Ldi(6),
						new Call(1),
						new Out(),
						new Ldi(0),
						new Halt(),
						new Ldi(1),
						new Lfs(0),
						new Cmp(EQUALS),
						new Not(),
						new Brc(13), 
						new Ldi(1),
						new Return(1),
						new Ldi(1), 
						new Lfs(0),
						new Sub(),
						new Ldi(6),
						new Call(1),
						new Lfs(0),
						new Mul(),
						new Return(1)
						};

		System.out.println("Factorial function interpreter:");
		Interpreter inter = new Interpreter(fak);
		System.out.println(inter.execute());
		
		System.out.println();
		
		System.out.println("Assembly code instructions executed by the CPU:");
		AsmFormatVisitor visitor = new AsmFormatVisitor(fak);
		System.out.println(visitor.getFormattedCode());
		
	}
	
	//Greatest common divisor
	public static void ggt() {
		Instruction[] ggt = new Instruction[] {
				 new In(),
				 new In(),
				 new Ldi(7),
				 new Call(2),
				 new Out(),
				 new Ldi(0),
				 new Halt(),
				 new Decl(1),
				 new Lfs(-1),
				 new Lfs(0),
				 new Cmp(LESS),
				 new Brc(16),
				 new Lfs(0),
				 new Lfs(-1),
				 new Sts(0),
				 new Sts(-1),
				 new Lfs(0), //16
				 new Sts(1),
				 new Lfs(0),
				 new Lfs(-1),
				 new Mod(),
				 new Sts(0),
				 new Lfs(1),
				 new Sts(-1),
				 new Ldi(0),
				 new Lfs(0),
				 new Cmp(EQUALS),
				 new Not(),
				 new Brc(16),
				 new Lfs(-1),
				 new Return(3)
			};
		
		System.out.println("Greatest common divisor function interpreter:");
		Interpreter inter = new Interpreter(ggt);
		System.out.println(inter.execute());
		
		System.out.println();
		
		System.out.println("Assembly code instructions executed by the CPU:");
		AsmFormatVisitor visitor = new AsmFormatVisitor(ggt);
		System.out.println(visitor.getFormattedCode());
	}
	
	public static void main(String[] args) {
		factorial();
		ggt();
	}
}