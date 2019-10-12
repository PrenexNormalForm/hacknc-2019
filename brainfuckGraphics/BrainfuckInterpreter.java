import java.util.ArrayList;
import java.util.Queue;

public class BrainfuckInterpreter {
    
    ArrayList<Byte> programMemory = new ArrayList<Byte>();
    Integer memoryPointer = 0;
    Byte[] program;
    Integer instructionPointer = 0;
    Queue<Byte> inputBuffer;
    
    public BrainfuckInterpreter(Byte[] bfstring){
        program = bfstring;
    }

    public void increaseMemoryPointer(){
        this.memoryPointer++;
        try {
            this.programMemory.get(this.memoryPointer);
        } catch (IndexOutOfBoundsException e){
            this.programMemory.add((byte)0);
        }
    }

    public void decreaseMemoryPointer(){
        if (this.memoryPointer - 1 < 0){
            System.out.println("Some crash message");
            System.exit(2);
        } else {
            memoryPointer--;
        }
    }

    public void incrementMemcell(){
        this.programMemory.set(this.memoryPointer.intValue(), this.programMemory.get(this.memoryPointer.intValue()) + Integer(1).byteValue());
    }
    
    public void decrementMemcell(){
        this.programMemory.set(this.memoryPointer.intValue(), this.programMemory.get(this.memoryPointer) - 1);
    }

    public void printMemCell(){
        System.out.print((char)this.programMemory.get(this.memoryPointer));
    }

    public void exec(Integer instruction){
        switch((char)this.program[instruction]){
            case '>' :
                increaseMemoryPointer();
                break;
            case '<' :
                decreaseMemoryPointer();
                break;
            case '+' :
                incrementMemcell();
                break;
            case '-' :
                decrementMemcell();
                break;
            case '.':
                printMemCell();
                break;
            case ',':
                
                break;
        }
    }

    public static void main(String[] args){

    }
}
