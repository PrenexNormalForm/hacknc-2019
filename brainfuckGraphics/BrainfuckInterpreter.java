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
        this.bfp = BrainfuckProgram;
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
        this.programMemory.set(this.memoryPointer, (byte)(this.programMemory.get(this.memoryPointer) - 1));
    }

    public void printMemCell() {
        System.out.print((char) this.programMemory.get(this.memoryPointer).byteValue());
    }

    public void getUserInput() {
        if (inputBuffer.isEmpty()){
            byte[] inputs = kb.nextLine().getBytes();
            for (int i = 0; i < inputs.length; i++){
                inputBuffer.add(inputs[i]);
            }
        }
        programMemory.set(this.memoryPointer, inputBuffer.poll());
    }

    public void exec(Integer instruction) {
        switch (this.bfp.getInstruction(instructionPointer)) {
            case BrainfuckInstruction.SHIFT_RIGHT:
                increaseMemoryPointer();
                break;
            case BrainfuckInstruction.SHIFT_LEFT:
                decreaseMemoryPointer();
                break;
            case BrainfuckInstruction.INCREMENT:
                incrementMemcell();
                break;
            case BrainfuckInstruction.DECREMENT:
                decrementMemcell();
                break;
            case BrainfuckInstruction.OUTPUT:
                printMemCell();
                break;
            case BrainfuckInstruction.INPUT:
                getUserInput();
                break;
        }
    }

    public static void main(String[] args) {

    }
}
