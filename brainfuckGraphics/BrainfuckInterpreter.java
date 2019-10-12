package brainfuckGraphics;

import java.util.ArrayList;
import java.util.Queue;

public class BrainfuckInterpreter {

    ArrayList<Byte> programMemory = new ArrayList<>();
    int memoryPointer = 0;
    byte[] program;
    int instructionPointer = 0;
    Queue<Byte> inputBuffer;

    public BrainfuckInterpreter(byte[] bfstring) {
        program = bfstring;
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
        this.programMemory.set(this.memoryPointer.intValue(), this.programMemory.get(this.memoryPointer) - 1);
    }

    public void printMemCell() {
        System.out.print((char) this.programMemory.get(this.memoryPointer));
    }

    public void exec(Integer instruction) {
        switch ((char) this.program[instruction]) {
            case '>':
                increaseMemoryPointer();
                break;
            case '<':
                decreaseMemoryPointer();
                break;
            case '+':
                incrementMemcell();
                break;
            case '-':
                decrementMemcell();
                break;
            case '.':
                printMemCell();
                break;
            case ',':

                break;
        }
    }

    public static void main(String[] args) {

    }
}
