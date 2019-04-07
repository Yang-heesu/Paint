
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyCanvas extends JLabel implements MouseListener, MouseMotionListener{
	private Color pen_color = Color.BLACK;
	private int pen_size = 1;
	private int pen_kind = 1;
	
	JPanel cp;
	MyCanvas c;
	
	private int startX, startY, endX, endY;
	
	Graphics2D g;
	
	Point p1,p2;
	
	MyCanvas(JPanel cp){
		this.cp = cp;
		c = this;

		setBounds(3,3,800,550);
		setVisible(true);
		setOpaque(true);
		setBackground(Color.WHITE);

		addMouseListener(this);
		addMouseMotionListener(this);
		cp.add(this);
	}

	MyCanvas(JPanel cp, int x, int y){
		this(cp);
		setPreferredSize(new Dimension(x,y));
	}
	
	void pen_color_change(Color color) {
		pen_color = color;
	}
	
	void pen_size_change(int size) {
		pen_size = size;
	}
	
	void pen_kind_change(int num) {
		pen_kind = num;
	}
	
	void pen_size() {
		System.out.println("펜크기 : " + pen_size);
	}
	
	void pen_kind() {
		System.out.println("펜종류 : "+ pen_kind);
	}
	
	void pen_color() {
		System.out.println("색깔 : " + pen_color);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		g = (Graphics2D) getGraphics();
		
		if(pen_kind == 1 || pen_kind == 5) {
		 endX = e.getX(); 
         endY = e.getY(); 
         
         if(pen_kind == 1) g.setColor(pen_color);
         else g.setColor(Color.WHITE);
         g.setStroke(new BasicStroke(pen_size, BasicStroke.CAP_ROUND,0));
         g.drawLine(startX, startY, endX, endY);       
         
         startX = endX; 
         startY = endY;
		}
		else {
			p2=e.getPoint();//마지막 누른 상태에서 끌때의 좌표를 얻는다.
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(pen_kind == 1 || pen_kind == 5) {
		 startX = e.getX();
         startY = e.getY();
		}
		else {
         p1=e.getPoint();//첫 좌표를 얻는다.
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(pen_kind == 1 || pen_kind == 5) {
			
		}
		else {
		p2=e.getPoint();//마지막 좌표를 얻는다.
		paint(g);
		}
	}
	
	public void paint(Graphics2D g){

		  g.setColor(pen_color);
		  g.setStroke(new BasicStroke(pen_size, BasicStroke.CAP_ROUND,0));
		  
		  if((p1 != null) && (p2 != null)) {
			  if(pen_kind == 2) {
				  g.drawLine(p1.x,p1.y,p2.x,p2.y);
			  }
			  else if(pen_kind == 3) {
				  g.drawOval(p1.x,p1.y,p2.x,p2.y);
			  }
			  else if(pen_kind == 4) {
				  g.drawRect(p1.x,p1.y,Math.abs(p2.x-p1.x),Math.abs(p2.y-p1.y));}
			  }
		  
			
		 }

}
