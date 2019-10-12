/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainfuckGraphics;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Eva Moniz
 */
public class BrainfuckProgram {

    private String code;
    private Map<Integer, Integer> matchingBrackets;

    public BrainfuckProgram(String code) {
        this.code = code;
        this.matchBrackets();
    }

    public BrainfuckInstruction getInstruction(int location) {
        return null;
    }

    private void matchBrackets() {

    }
}
