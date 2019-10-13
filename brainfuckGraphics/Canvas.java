package brainfuckGraphics;
import javax.swing.*;
import java.awt.*;
//draw primitives
public class Canvas extends JPanel{
	final int width = 1200;
	final int height = width / 16 * 9;
	final int x = 100;
	final int y = 100;
	JFrame frame = new JFrame("Rock");
	
	//Constructor
	public Canvas() {
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setTitle("This is the title!!");
	}
	
	protected void paintComponent(Graphics g) {
		paintComponent(g);
		g.drawRect(x, y, 200, 200);
		g.setColor(Color.red);
	}
	
	/* public void ____ (Graphics, g) {
	 * g.drawRect(parameters);
	 * g.paint;
	 * }
	 */
	/*Creating the canvas.
	canvas.setSize(width, height);
	canvas.setBackground(Color.BLACK);
	canvas.setVisible(true);
	canvas.setFocusable(false);
	
	frame.addCanvas();
	
	boolean Running = true;
	
	BufferStrategy buggerStrategy;
	Graphics graphics;
	
	while Running {
    	bufferStrategy = canvas.getBufferStrategy();
    	graphics = bufferStrategy.getDrawGraphics();
    	graphics.clearRect(0, 0, width, height);

    	graphics.setColor(Color.GREEN);
    	graphics.drawString("This is some text placed in the top left corner.", 5, 15);

    	bufferStrategy.show();
    	graphics.dispose();
	}*/
}