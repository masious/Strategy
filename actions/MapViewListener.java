package actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import maps.MapView;

public class MapViewListener implements MouseListener,MouseMotionListener,MouseWheelListener {
	
	private MapView that;

	public MapViewListener(MapView that) {
		this.that = that;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		that.addObject(e.getPoint());
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		that.moveTo(e.getX(),e.getY());
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if( arg0.getWheelRotation() > 0 ){
			that.zoom(0);
		}
		else
			that.zoom(1);
		
	}

}
