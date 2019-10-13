package brainfuckGraphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import java.util.function.Consumer;

public class BrainfuckController {

    BrainfuckInterpreter engine;
    List<Consumer<Graphics>> drawList;

    public BrainfuckController(BrainfuckInterpreter engine) {
        this.engine = engine;
        this.drawList = new LinkedList<>();
    }

    public boolean step() {
        boolean thingy = this.engine.exec(this.engine.memoryPointer);
        if (this.engine.getValAtIndex(0) != 0) {
            this.engine.programMemory.set(0, (byte) 0);
            int opCode = Byte.toUnsignedInt(this.engine.getValAtIndex(1));
            byte[] args = new byte[14];
            for (int i = 0; i < args.length; i++) {
                args[i] = this.engine.getValAtIndex(i + 2);
            }
            var x = GraphicsAPI.callAPI(opCode, args);
            this.drawList.add(x);
        }
        return thingy;
    }

    public void execute() {
        while (step()) {
        }
    }

    public void draw() {
        JFrame jframe = new JFrame();
        Canvas canvas = new Canvas(this.drawList);
        jframe.setLayout(new BorderLayout());
        jframe.add("Center", canvas);
        jframe.setSize(800, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setTitle("BrainFuck Draw");
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}
