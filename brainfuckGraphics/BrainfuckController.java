package brainfuckGraphics;

import java.awt.*;
import javax.swing.*;
import java.util.function.Consumer;

public class BrainfuckController {
    BrainfuckInterpreter engine;
    JFrame jframe;
    Canvas canvas;
    
    public BrainfuckController(BrainfuckInterpreter engine){
        this.engine = engine;
        this.jframe = new JFrame();
        this.canvas = new Canvas();
        this.jframe.add("Center", this.canvas);
        this.jframe.setLayout(new BorderLayout());
        this.jframe.setSize(500, 375);
        this.jframe.setTitle("BrainFuck Draw");
        this.jframe.setVisible(true);
    }
    
    public boolean step(){
        boolean thingy = this.engine.exec(this.engine.memoryPointer);
        if (this.engine.getValAtIndex(0) != 0){
            this.engine.programMemory.set(0, (byte)0);
            int opCode = Byte.toUnsignedInt(this.engine.getValAtIndex(1));
            byte[] args =  new byte[14];
            for(int i = 2; i < args.length; i++){
                args[i] = this.engine.getValAtIndex(i);
            }
            var x = GraphicsAPI.callAPI(opCode, args);
            canvas.redrawWithConsumer(x);
        }
        return thingy;
    }

    public void execute(){
        while(step()){}
    }
}
