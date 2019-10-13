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
    
    public void step(){
        this.engine.exec(this.engine.memoryPointer);
        if (this.engine.programMemory.get(0) != 0){
            int opCode = Byte.toUnsignedInt(this.engine.programMemory.get(1));
            var argList = this.engine.programMemory.subList(2, 16);
            byte[] args =  new byte[argList.size()];
            for(int i = 0; i < argList.size(); i++){
                args[i] = argList.get(i);
            }
            var x = GraphicsAPI.callAPI(opCode, args);
            canvas.redrawWithConsumer(x);
        }
    }
}
