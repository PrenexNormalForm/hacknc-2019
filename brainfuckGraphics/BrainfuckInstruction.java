/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainfuckGraphics;

/**
 *
 * @author Eva Moniz
 */
public enum BrainfuckInstruction {
    SHIFT_LEFT('<'),
    SHIFT_RIGHT('>'),
    INCREMENT('+'),
    DECREMENT('-'),
    LOOP_BEGIN('['),
    LOOP_END(']'),
    INPUT(','),
    OUTPUT('.');

    private final char charValue;

    public static BrainfuckInstruction fromChar(char ch) {
        for (var ins : values()) {
            if (ins.charValue == ch) {
                return ins;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Character.toString(this.charValue);
    }

    private BrainfuckInstruction(char ch) {
        this.charValue = ch;
    }
}
