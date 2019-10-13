/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainfuckGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 *
 * @author Eva Moniz
 */
public final class GraphicsAPI {

    public static final int SET_COLOR = 0x10;
    public static final int DRAW_RECT = 0x20;
    public static final int FILL_RECT = 0x21;
    public static final int DRAW_ELLIPSE = 0x22;
    public static final int FILL_ELLIPSE = 0x23;
    public static final int DRAW_TRIANGLE = 0x24;
    public static final int FILL_TRIANGLE = 0x25;

    /**
     * Calls an arbitrary API function with the given 14-byte argument list.
     * Returns a consumer which calls a rendering function on a swing Graphics
     * object.
     *
     * @param opcode
     * @param arguments
     * @return
     */
    public static Consumer<Graphics> callAPI(int opcode, byte[] arguments) {
        switch (opcode) {
            case SET_COLOR:
                return setColor(arguments);
            case DRAW_RECT:
                return drawRect(arguments);
            case FILL_RECT:
                return fillRect(arguments);
            case DRAW_ELLIPSE:
                return drawEllipse(arguments);
            case FILL_ELLIPSE:
                return fillEllipse(arguments);
            case DRAW_TRIANGLE:
                return drawTriangle(arguments);
            case FILL_TRIANGLE:
                return fillTriangle(arguments);
        }
        throw new IllegalArgumentException("Illegal Graphics API opcode " + opcode);
    }

    /**
     * Creates a Graphics consumer which will set the graphics color to the red,
     * green, and blue bytes passed as API call arguments.
     *
     * @param args r(1 byte) g(1 byte) b(1 byte)
     * @return
     */
    public static Consumer<Graphics> setColor(byte[] args) {
        int r = Byte.toUnsignedInt(args[0]);
        int g = Byte.toUnsignedInt(args[1]);
        int b = Byte.toUnsignedInt(args[2]);
        return graphics -> graphics.setColor(new Color(r, g, b));
    }

    /**
     * Creates a Graphics consumer which will draw a rectangle to the Graphics
     * object. The rectangle bounds are specified by two-byte words x1, y1, x2,
     * y2 as API call arguments.
     *
     * @param args x1(2 bytes) y1(2 bytes) x2(2 bytes) y2(2 bytes)
     * @return
     */
    public static Consumer<Graphics> drawRect(byte[] args) {
        int x1 = twoByteWord(args[0], args[1]);
        int y1 = twoByteWord(args[2], args[3]);
        int x2 = twoByteWord(args[4], args[5]);
        int y2 = twoByteWord(args[6], args[7]);
        return g -> g.drawRect(x1, y1, x2 - x1, y2 - y1);
    }

    /**
     * Creates a Graphics consumer which will fill a rectangle to the Graphics
     * object. The rectangle bounds are specified by two-byte words x1, y1, x2,
     * y2 as API call arguments.
     *
     * @param args x1(2 bytes) y1(2 bytes) x2(2 bytes) y2(2 bytes)
     * @return
     */
    public static Consumer<Graphics> fillRect(byte[] args) {
        int x1 = twoByteWord(args[0], args[1]);
        int y1 = twoByteWord(args[2], args[3]);
        int x2 = twoByteWord(args[4], args[5]);
        int y2 = twoByteWord(args[6], args[7]);
        return g -> g.fillRect(x1, y1, x2 - x1, y2 - y1);
    }

    /**
     * Creates a Graphics consumer which will draw a rectangle to the Graphics
     * object. The rectangle bounds are specified by two-byte words x1, y1, x2,
     * y2 as API call arguments.
     *
     * @param args x1(2 bytes) y1(2 bytes) x2(2 bytes) y2(2 bytes)
     * @return
     */
    public static Consumer<Graphics> drawEllipse(byte[] args) {
        int x1 = twoByteWord(args[0], args[1]);
        int y1 = twoByteWord(args[2], args[3]);
        int x2 = twoByteWord(args[4], args[5]);
        int y2 = twoByteWord(args[6], args[7]);
        return g -> g.drawArc(x1, y1, x2 - x1, y2 - y1, 0, 360);
    }

    /**
     * Creates a Graphics consumer which will fill a rectangle to the Graphics
     * object. The rectangle bounds are specified by two-byte words x1, y1, x2,
     * y2 as API call arguments.
     *
     * @param args x1(2 bytes) y1(2 bytes) x2(2 bytes) y2(2 bytes)
     * @return
     */
    public static Consumer<Graphics> fillEllipse(byte[] args) {
        int x1 = twoByteWord(args[0], args[1]);
        int y1 = twoByteWord(args[2], args[3]);
        int x2 = twoByteWord(args[4], args[5]);
        int y2 = twoByteWord(args[6], args[7]);
        return g -> g.fillArc(x1, y1, x2 - x1, y2 - y1, 0, 360);
    }

    /**
     * Creates a Graphics consumer which will draw a rectangle to the Graphics
     * object. The rectangle bounds are specified by two-byte words x1, y1, x2,
     * y2 as API call arguments.
     *
     * @param args x1(2 bytes) y1(2 bytes) x2(2 bytes) y2(2 bytes) x3(2 bytes)
     * y3(2 bytes)
     * @return
     */
    public static Consumer<Graphics> drawTriangle(byte[] args) {
        int x1 = twoByteWord(args[0], args[1]);
        int y1 = twoByteWord(args[2], args[3]);
        int x2 = twoByteWord(args[4], args[5]);
        int y2 = twoByteWord(args[6], args[7]);
        int x3 = twoByteWord(args[8], args[9]);
        int y3 = twoByteWord(args[10], args[11]);
        return g -> g.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
    }

    /**
     * Creates a Graphics consumer which will fill a rectangle to the Graphics
     * object. The rectangle bounds are specified by two-byte words x1, y1, x2,
     * y2 as API call arguments.
     *
     * @param args x1(2 bytes) y1(2 bytes) x2(2 bytes) y2(2 bytes) x3(2 bytes)
     * y3(2 bytes)
     * @return
     */
    public static Consumer<Graphics> fillTriangle(byte[] args) {
        int x1 = twoByteWord(args[0], args[1]);
        int y1 = twoByteWord(args[2], args[3]);
        int x2 = twoByteWord(args[4], args[5]);
        int y2 = twoByteWord(args[6], args[7]);
        int x3 = twoByteWord(args[8], args[9]);
        int y3 = twoByteWord(args[10], args[11]);
        return g -> g.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
    }

    /**
     * Helper function to interpret two bytes as a two-byte unsigned word.
     *
     * @param high
     * @param low
     * @return
     */
    private static int twoByteWord(byte high, byte low) {
        return (unsign(high) << 8) + unsign(low);
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
