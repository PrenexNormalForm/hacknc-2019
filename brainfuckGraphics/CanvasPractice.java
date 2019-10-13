package brainfuckGraphics;
import java.awt.*;
import javax.swing.*;

public class CanvasPractice extends JFrame {
	
	private Canvas canvas = new Canvas ();
	
	public static void main(String[] args) {
		CanvasPractice window = new CanvasPractice();
		for (int i = 0; i < 10; i++) {
        	window.canvas.drawRect(i*10, i*10, i*10+20, i*10+40);
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	public CanvasPractice() {
		setLayout (new BorderLayout());
		setSize(500, 375);
		setTitle("Canvas Practice");
		add("Center", canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Another way to center the screen.
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	
}
