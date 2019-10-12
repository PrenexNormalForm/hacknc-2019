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
public enum BrainfuckInstruction {
    SHIFT_LEFT("<"),
    SHIFT_RIGHT(">"),
    INCREMENT("+"),
    DECREMENT("-"),
    LOOP_BEGIN("["),
    LOOP_END("]"),
    INPUT(","),
    OUTPUT("."),
    NOTHING("");

    private String stringValue;

    private BrainfuckInstruction(String str) {
        this.stringValue = str;
    }

    public static BrainfuckInstruction fromString(String string) {
        for (var ins : values()) {
            if (ins.toString().equals(string)) {
                return ins;
            }
        }
        return NOTHING;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
