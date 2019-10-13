package brainfuckGraphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Main extends JPanel{
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
    }
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(200, 200, 200, 200);
		g.setColor(Color.red);
	}
}
