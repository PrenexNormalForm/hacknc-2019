/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainfuckGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;
import java.util.function.Consumer;

/**
 *
 * @author Eva Moniz
 */
public final class GraphicsAPI {

    public static final int SET_COLOR = 16;
    public static final int DRAW_RECT = 20;
    public static final int FILL_RECT = 21;
    public static final int DRAW_CIRCLE = 22;
    public static final int FILL_CIRCLE = 23;
    public static final int DRAW_ELLIPSE = 24;
    public static final int FILL_ELLIPSE = 25;
    public static final int DRAW_TRIANGLE = 26;
    public static final int FILL_TRIANGLE = 27;

    public static Consumer<Graphics> callAPI(int opcode, byte[] arguments) {
        switch (opcode) {
            case SET_COLOR:
                return setColor(arguments);
        }
        throw new IllegalArgumentException("Illegal Graphics API opcode " + opcode);
    }

    /**
     * Creates a Graphics consumer which will set the graphics color to the RGB
     * value specified by the brainfuck program.
     *
     * @param args
     * @return
     */
    public static Consumer<Graphics> setColor(byte[] args) {
        int r = Byte.toUnsignedInt(args[0]);
        int g = Byte.toUnsignedInt(args[1]);
        int b = Byte.toUnsignedInt(args[2]);
        return graphics -> graphics.setColor(new Color(r, g, b));
    }

    public static Consumer<Graphics> drawRect(byte[] args) {
        throw new RuntimeException("blah!");
    }

    /**
     * Helper function to return the unsigned value of the byte.
     *
     * @param b
     * @return
     */
    private static int unsign(byte b) {
        return Byte.toUnsignedInt(b);
    }

    private GraphicsAPI() {
        //static only
    }
}
