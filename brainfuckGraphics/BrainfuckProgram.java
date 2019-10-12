/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainfuckGraphics;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import static brainfuckGraphics.BrainfuckInstruction.*;

/**
 *
 * @author Eva Moniz
 */
public class BrainfuckProgram {

    private BrainfuckInstruction[] instructions;
    private Map<Integer, Integer> matchingBrackets;

    public BrainfuckProgram(String code) {
        this.compile(code);
        this.matchBrackets();
    }

    public BrainfuckInstruction getInstruction(int location) {
        return instructions[location];
    }

    public int getMatchingBracket(int location) {
        if (!matchingBrackets.containsKey(location)) {
            throw new IllegalArgumentException("No loop instruction at location " + location);
        }

        return matchingBrackets.get(location);
    }

    private void matchBrackets() {
        var bracketStack = new Stack<Integer>();
        int i = 0;
        try {
            for (; i < this.instructions.length; i++) {
                if (this.instructions[i] == LOOP_BEGIN) {
                    bracketStack.push(i);
                } else if (this.instructions[i] == LOOP_END) {
                    int beginLocation = bracketStack.pop();
                    this.matchingBrackets.put(beginLocation, i);
                    this.matchingBrackets.put(i, beginLocation);
                }
            }
        } catch (EmptyStackException e) {
            throw new RuntimeException("Unmatched loop instruction at index " + i);
        }
    }

    private void compile(String code) {
        var insList = new ArrayList<BrainfuckInstruction>();
        for (int c : code.toCharArray()) {
            var ins = BrainfuckInstruction.fromChar((char) c);
            if (ins != null) {
                insList.add(ins);
            }
        }
        this.instructions = insList.toArray(new BrainfuckInstruction[]{});
    }
}
