package brainfuckGraphics;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;

public class BrainfuckInterpreter {

    ArrayList<Byte> programMemory = new ArrayList<>();
    int memoryPointer = 0;
    int instructionPointer = 0;
    Queue<Byte> inputBuffer;
    BrainfuckProgram bfp;
    Scanner kb = new Scanner(System.in);

    public BrainfuckInterpreter(BrainfuckProgram bfp) {
        this.programMemory.add((byte)0);
        this.bfp = bfp;
    }

    public void increaseMemoryPointer() {
        this.memoryPointer++;
        try {
            this.programMemory.get(this.memoryPointer);
        } catch (IndexOutOfBoundsException e) {
            this.programMemory.add((byte) 0);
        }
    }

    public void decreaseMemoryPointer() {
        if (this.memoryPointer - 1 < 0) {
            System.out.println("Some crash message");
            System.exit(2);
        } else {
            memoryPointer--;
        }
    }

    public void incrementMemcell() {
        byte currentVal = (byte) this.programMemory.get(this.memoryPointer);
        currentVal++;
        this.programMemory.set(this.memoryPointer, currentVal);
    }

    public void decrementMemcell() {
        this.programMemory.set(this.memoryPointer, (byte) (this.programMemory.get(this.memoryPointer) - 1));
    }

    public void printMemCell() {
        System.out.print((char) this.programMemory.get(this.memoryPointer).byteValue());
    }

    public void getUserInput() {
        if (inputBuffer.isEmpty()) {
            byte[] inputs = kb.nextLine().getBytes();
            for (int i = 0; i < inputs.length; i++) {
                inputBuffer.add(inputs[i]);
            }
        }
        programMemory.set(this.memoryPointer, inputBuffer.poll());
    }

    public void doALoop(){
        if (programMemory.get(memoryPointer) == 0){
            this.instructionPointer = this.bfp.getMatchingBracket(this.instructionPointer);
        }
    }

    public ArrayList<Byte> getMemory(){
        return this.programMemory;
    }

    public void setinstructionPointer(int aThing){
        this.instructionPointer = aThing;
    }

    public void endALoop(){
            this.instructionPointer = this.bfp.getMatchingBracket(this.instructionPointer) - 1;
    }

    public boolean exec(Integer instruction) {
        switch (this.bfp.getInstruction(instructionPointer)) {
            case SHIFT_RIGHT:
                increaseMemoryPointer();
                break;
            case SHIFT_LEFT:
                decreaseMemoryPointer();
                break;
            case INCREMENT:
                incrementMemcell();
                break;
            case DECREMENT:
                decrementMemcell();
                break;
            case OUTPUT:
                printMemCell();
                break;
            case INPUT:
                getUserInput();
                break;
            case LOOP_BEGIN:
                doALoop();
                break;
            case LOOP_END:
                endALoop();
                break;
        }
        instructionPointer++;
        return instructionPointer < this.bfp.getLength();
    }

    public void execAll(){
        while(exec(instructionPointer)){}
    }
}
