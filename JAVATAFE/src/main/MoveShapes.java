package main;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

//...Demonstrates the application of Inheritance.

public class MoveShapes extends Applet implements ActionListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2274691009553098742L;

	Button left, right, up, down, red, blue, which;
	ARectangle myRectangle;
	ACircle myCircle;
	AHouse myHouse;
	String whichItem;

	public void init() {
		left = new Button("Left");
		right = new Button("Right");
		up = new Button("Up");
		down = new Button("Down");
		red = new Button("Red");
		blue = new Button("Blue");
		which = new Button("Which Item");

		add(left);
		add(right);
		add(up);
		add(down);
		add(red);
		add(blue);
		add(which);

		left.addActionListener(this);
		left.setFocusable(false);
		
		right.addActionListener(this);
		right.setFocusable(false);
		
		up.addActionListener(this);
		up.setFocusable(false);
		
		down.addActionListener(this);
		down.setFocusable(false);
		
		red.addActionListener(this);
		red.setFocusable(false);
		
		blue.addActionListener(this);
		blue.setFocusable(false);
		
		which.addActionListener(this);
		which.setFocusable(false);

		addKeyListener(this);
		setFocusable(true);
		myRectangle = new ARectangle(100, 100);
		myCircle = new ACircle(180, 130);
		myHouse = new AHouse(20, 200, 100, 50, 0, 0, 0);
		whichItem = "Rectangle";
	}

	public void paint(Graphics g) {
		myRectangle.drawShape(g);
		myCircle.drawShape(g);
		myHouse.drawShape(g);
		g.drawString("Current Shape is: " + whichItem, 100, 60);
	}

	public void actionPerformed(ActionEvent e) {
		if (whichItem.equals("Rectangle")) {
			if (e.getSource() == left) {
				myRectangle.setX(-5);
			}
			if (e.getSource() == right) {
				myRectangle.setX(5);
			}
			if (e.getSource() == up) {
				myRectangle.setY(-5);
			}
			if (e.getSource() == down) {
				myRectangle.setY(5);
			}
			if (e.getSource() == red) {
				myRectangle.setColor(255, 0, 0);
			}
			if (e.getSource() == blue) {
				myRectangle.setColor(0, 0, 128);
			}
			if (e.getSource() == which) {
				whichItem = "Circle";
			}
		} else if (whichItem.equals("Circle")) {
			if (e.getSource() == left) {
				myCircle.setX(-5);
			}
			if (e.getSource() == right) {
				myCircle.setX(5);
			}
			if (e.getSource() == up) {
				myCircle.setY(-5);
			}
			if (e.getSource() == down) {
				myCircle.setY(5);
			}
			if (e.getSource() == red) {
				myCircle.setColor(255, 0, 0);
			}
			if (e.getSource() == blue) {
				myCircle.setColor(0, 0, 128);
			}
			if (e.getSource() == which) {
				whichItem = "House";
			}
		} else if (whichItem.equals("House")) {
			if (e.getSource() == left) {
				myHouse.setX(-5);
			}
			if (e.getSource() == right) {
				myHouse.setX(5);
			}
			if (e.getSource() == up) {
				myHouse.setY(-5);
			}
			if (e.getSource() == down) {
				myHouse.setY(5);
			}
			if (e.getSource() == red) {
				myHouse.setColor(255, 0, 0);
			}
			if (e.getSource() == blue) {
				myHouse.setColor(0, 0, 128);
			}
			if (e.getSource() == which) {
				whichItem = "Rectangle";
			}
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key;
		key = e.getKeyCode();
				
		if (whichItem.equals("House")) {
			if (key == KeyEvent.VK_A) {
				myHouse.setX(-5);
				System.out.println(e.getKeyCode());
			}
			if (key == KeyEvent.VK_D) {
				myHouse.setX(5);
				System.out.println(e.getKeyCode());
			}
			if (key == KeyEvent.VK_W) {
				myHouse.setY(-5);
				System.out.println(e.getKeyCode());
			}
			if (key == KeyEvent.VK_S) {
				myHouse.setY(5);
				System.out.println(e.getKeyChar());
			}
			if (key == KeyEvent.VK_R) {
				myHouse.setColor(255, 0, 0);
			}
		}
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}

class AShape {
	protected int x, y, a, b;
	Color c;

	public AShape() {
		x = 130;
		y = 120;
		a = 50;
		b = 50;
		c = new Color(0, 128, 0);
	}

	public AShape(int newX, int newY) {
		x = newX;
		y = newY;
		a = 50;
		b = 50;
		c = new Color(0, 128, 0);
	}

	public AShape(int newX, int newY, int newA, int newB, int c1, int c2, int c3) {
		x = newX;
		y = newY;
		a = newA;
		b = newB;
		c = new Color(c1, c2, c3);
	}

	public void setX(int newX) {
		x = x + newX;
	}

	public void setY(int newY) {
		y = y + newY;
	}

	public void setA(int newA) {
		a = a + newA;
	}

	public void setB(int newB) {
		b = b + newB;
	}

	public void setColor(int c1, int c2, int c3) {
		c = new Color(c1, c2, c3);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		// there is no specific shape to draw
	}

}

class AHouse extends AShape {
	public AHouse() {
		super();
	}

	public AHouse(int newX, int newY) {
		super(newX, newY);
	}

	public AHouse(int newX, int newY, int newA, int newB, int c1, int c2, int c3) {
		super(newX, newY, newA, newB, c1, c2, c3);
	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, a, b);
		g.drawLine(x, y, x + 50, y - 25);
		g.drawLine(x + 50, y - 25, x + 100, y);
	}
}

class ARectangle extends AShape {
	public ARectangle() {
		super();
	}

	public ARectangle(int newX, int newY) {
		super(newX, newY);
	}

	public ARectangle(int newX, int newY, int newA, int newB, int c1, int c2, int c3) {
		super(newX, newY, newA, newB, c1, c2, c3);
	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		g.fillRect(x, y, a, b);
	}

}

class ACircle extends AShape {
	public ACircle() {
		super();
	}

	public ACircle(int newX, int newY) {
		super(newX, newY);
	}

	public ACircle(int newX, int newY, int newA, int newB, int c1, int c2, int c3) {
		super(newX, newY, newA, newB, c1, c2, c3);
	}

	public void drawShape(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, a, b);
	}

}
