package maps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import environment.Editor;

import actions.MapViewListener;

import objects.VisibleObject;


//this is the part of the map which is being showed in the game frame
public class MapView extends JPanel{

	private static final long serialVersionUID = -8553682581273392572L;
	
	// data about the map
	private Map map;

	private Dimension visualSize;

	private long lastMoved = 0;

	private Point location;

	public MapView(Map m) {
		
		//init
		this.location = new Point(0,0);
		this.map = m;
		visualSize = new Dimension(getToolkit().getScreenSize().width - 200,getToolkit().getScreenSize().height - 200);
		
		//GUI
		setSize(visualSize);
		setLocation(100,70);
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		MapViewListener listeners = new MapViewListener(this);
		addMouseListener(listeners);
		addMouseMotionListener(listeners);
		addMouseWheelListener(listeners);
		System.out.println(getSize());
	}
	
	public void addObject(Point p){
		Point l = new Point(p.x/VisibleObject.objectSize + location.x,p.y/VisibleObject.objectSize+location.y);
		map.add(l, new VisibleObject(((Editor)getParent().getParent().getParent().getParent()).getSelect()));
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		//size of objects
		int os = VisibleObject.objectSize;
		
		int i,j = 0;
		for(i=location.x;i<map.getSize().width && i<=location.x+visualSize.width/os;i++){
			for(j=location.y;j<map.getSize().height && j<=location.y + visualSize.height/os;j++){
				if(map.getMap(i,j) == null)
					continue;
				
				Image img = map.getMap(i,j).getImage();
				g.drawImage(img, (i - location.x)*os, (j - location.y)*os, ((i - location.x)+1)*os, ((j - location.y)+1)*os,
						0, 0,img.getWidth(null), img.getHeight(null), null);
			}
		}
		
		//the "+" in the middle
		g.setColor(new Color(250,250,0));
		g.drawLine(getWidth()/2,(getHeight()-10)/2,getWidth()/2,(getHeight()+10)/2);
		g.drawLine((getWidth()-10)/2,getHeight()/2,(getWidth()+10)/2,getHeight()/2);
	}

	public void moveTo(int i) {
		switch(i){
		case 0:
			if(location.x>=1)
				location.x --;
			break;
		case 1:
			if(location.y>=1)
				location.y--;
			break;
		case 2:
			if(location.x<map.getSize().width-visualSize.width/VisibleObject.objectSize)
				location.x ++;
			break;
		case 3:
			if(location.y<map.getSize().height)
				location.y ++;
			break;
		}
		repaint();
	}

	public void moveTo(int x, int y) {
		if(System.currentTimeMillis() - lastMoved < 100){
			return ;
		}
		if(x<15)
			moveTo(0);
		if(x>visualSize.width-15)
			moveTo(2);
		if(y<15)
			moveTo(1);
		if(y>visualSize.height - 15)
			moveTo(3);
		lastMoved = System.currentTimeMillis();
	}

	public void zoom(int i) {
		if( i == 0 && VisibleObject.objectSize-10>VisibleObject.MIN_OBJECT_SIZE)
			VisibleObject.objectSize -= 10;
		else if( VisibleObject.objectSize+10<VisibleObject.MAX_OBJECT_SIZE )
			VisibleObject.objectSize += 10;
		repaint();
	}

	public Point getLastPoint() {
		return new Point(location.x + visualSize.width/VisibleObject.objectSize,location.y + visualSize.height/VisibleObject.objectSize);
	}
	
	public Point getLocationVar(){
		return location;
	}
}

