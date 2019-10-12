import java.util.ArrayList;

public class BrainfuckInterpreter {
    
    ArrayList<Byte> programMemory = new ArrayList<Byte>();
    Integer memoryPointer = 0;
    String program;
    
    public BrainfuckInterpreter(String bfstring){
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
            exit(2)
        } else {
            memoryPointer--;
        }
    }


}
