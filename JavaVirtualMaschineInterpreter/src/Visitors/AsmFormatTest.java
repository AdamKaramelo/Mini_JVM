package Visitors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
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

public class AsmFormatTest {
	private static final int EQUALS = 0;
	private static final int LESS = 1;

  @Test
  public void test() {
    
    Instruction[] instructions = new Instruction[] {
      new Add(),
      new And(),
      new Brc(42),
      new Call(10),
      new Cmp(EQUALS),
      new Decl(5),
      new Div(),
      new Halt(),
      new In(),
      new Out(),
      new Ldi(10),
      new Lfs(3),
      new Mod(),
      new Mul(),
      new Nop(),
      new Not(),
      new Or(),
      new Pop(1),
      new Push(0),
      new Return(3),
      new Sts(2),
      new Sub(),
      new Cmp(LESS)
    };
    
    String expected =
      "0: ADD\n" + 
      "1: AND\n" + 
      "2: BRC 42\n" + 
      "3: CALL 10\n" + 
      "4: CMP 0\n" + 
      "5: DECL 5\n" + 
      "6: DIV\n" + 
      "7: HALT\n" + 
      "8: IN\n" + 
      "9: OUT\n" + 
      "10: LDI 10\n" + 
      "11: LFS 3\n" + 
      "12: MOD\n" + 
      "13: MUL\n" + 
      "14: NOP\n" + 
      "15: NOT\n" + 
      "16: OR\n" + 
      "17: POP 1\n" + 
      "18: PUSH 0\n" + 
      "19: RETURN 3\n" + 
      "20: STS 2\n" + 
      "21: SUB\n" +
      "22: CMP 1\n";
    
    AsmFormatVisitor afv = new AsmFormatVisitor(instructions);
    assertEquals(expected, afv.getFormattedCode());
  }

}
