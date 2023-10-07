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
import Instructions.Stack;
import Instructions.Sts;
import Instructions.Sub;


public class Interpreter implements AsmVisitor{
	private Stack stack = new Stack(128);
	private int programCounter = 0;
	private int framePointer = -1;
	private int [] registers = {0, 0};
	
	private static final int EQUALS = 0;
	private static final int LESS = 1;
	
	public Interpreter(Instruction[] instructions) {
		super();
		this.instructions = instructions;
	}

	private Instruction [] instructions;
	
	public int execute() {
//		int loopCounter = 0;
		while(programCounter != -1) {
//			System.out.println("Loop " + loopCounter + "; Executing PC: " + (programCounter -1));
//			System.out.println("Stack:");
//			for (int i = stack.getNumElements() - 1; i >=0; i--) {
//				System.out.println(stack.peek(i));
//			}
//			System.out.println("----------------------------");
			Instruction instruction = instructions[programCounter];
			instruction.accept(this);
//			loopCounter++;
		}
		System.out.print("Execute: ");
		return  stack.pop();
	}

	@Override
	public void visit(Add add) {
		int a = this.stack.pop();
		int b = this.stack.pop();
		stack.push(a + b);
		programCounter++;
	}

	@Override
	public void visit(And and) {
		int a = this.stack.pop();
		int b = this.stack.pop();
		stack.push(a & b);
		programCounter++;
		
	}

	@Override
	public void visit(Brc brc) {
		int i = brc.getImmediate();
                int compare=stack.pop();
		if(compare == -1) {
			programCounter = i;
		}else {
                    programCounter++;
                }
	}

	@Override
	public void visit(Call call) {
		int numParams = call.getImmediate();
		int newProgramCounter = stack.pop();
		stack.shift(stack.getNumElements() - numParams, 2);
		int pcIndex = stack.getNumElements() - numParams - 2;
		int fpIndex = pcIndex + 1;
		stack.set(pcIndex, programCounter + 1);
		stack.set(fpIndex, framePointer);
		programCounter = newProgramCounter;
		framePointer = stack.getNumElements() - 1;
		
	}

	@Override
	public void visit(Cmp cmp) {
		int op = cmp.getImmediate();
		int first = stack.pop();
		int second = stack.pop();
		if (op == EQUALS) {
			if(first == second) {
				stack.push(-1);
			}
			else {
				stack.push(0);
			}
		} else if (op == LESS){
			if(first < second) {
				stack.push(-1);
			}
			else {
				stack.push(0);
			}
		}
                programCounter++;
		
	}

	@Override
	public void visit(Decl decl) {
		int numSpaces = decl.getImmediate();
		stack.shift(framePointer + 1, numSpaces);
                programCounter++;
	}

	@Override
	public void visit(Div div) {
		int a = this.stack.pop();
		int b = this.stack.pop();
                if(b!=0){
		stack.push(a / b);
                programCounter++;
                }else {
                    System.out.println("Divisor needs to be different from 0.");
                    programCounter=-1;
                }
	}

	@Override
	public void visit(Halt halt) {
		programCounter = -1;
		
	}

	@Override
	public void visit(In in) {
		System.out.print("Input: ");
		int input = Terminal.readInt(); 
		stack.push(input);
		programCounter++;
	}

	@Override
	public void visit(Ldi ldi) {
		this.stack.push(ldi.getImmediate());
		programCounter++;
	}

	@Override
	public void visit(Lfs lfs) {
		int i = lfs.getImmediate();
		int value = stack.peek(framePointer + i);
		stack.push(value);
		programCounter++;
	}

	@Override
	public void visit(Mod mod) {
		int a = this.stack.pop();
		int b = this.stack.pop();
                if(a>0 && b>0){
		stack.push(a % b);
                programCounter++;
                }else{
                    System.out.println("Both number need to be positive.");
                    programCounter=-1;
                }
	}

	@Override
	public void visit(Mul mul) {
		int a = this.stack.pop();
		int b = this.stack.pop();
		stack.push(a * b);
		programCounter++;
	}

	@Override
	public void visit(Nop nop) {
		programCounter++;
	}

	@Override
	public void visit(Not not) {
		int a = this.stack.pop();
		stack.push(~a);
		programCounter++;
		
	}

	@Override
	public void visit(Or or) {
		int a = this.stack.pop();
		int b = this.stack.pop();
		stack.push(a | b);
		programCounter++;
	}

	@Override
	public void visit(Out out) {
		System.out.println("Output: "+ stack.pop());
		programCounter++;
	}

	@Override
	public void visit(Pop pop) {
		registers[pop.getImmediate()] = stack.pop();
		programCounter++;
	}

	@Override
	public void visit(Push push) {
		int i = push.getImmediate();
		stack.push(registers[i]);
		programCounter++;
		
	}

	@Override
	public void visit(Return return1) {
		int numParams = return1.getImmediate();
        int fpIndex = stack.getNumElements() -2 - numParams;
		int pcIndex = fpIndex - 1;
        framePointer = stack.peek(fpIndex);
		programCounter = stack.peek(pcIndex);
		stack.removeSlice(pcIndex, numParams + 2);
	}

	@Override
	public void visit(Sts sts) {
		int i = sts.getImmediate();
		int top = stack.pop();
		stack.set(i + framePointer, top);
		programCounter++;
	}

	@Override
	public void visit(Sub sub) {
		int a = this.stack.pop();
		int b = this.stack.pop();
		stack.push(a - b);
		programCounter++;
		
	}

}
