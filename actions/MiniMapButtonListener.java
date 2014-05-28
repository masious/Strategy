package actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MiniMapButtonListener implements MouseListener{
	
	private JPanel miniMap;

	public MiniMapButtonListener(JPanel miniMap) {
		this.miniMap = miniMap;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		miniMap.setVisible(true);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		miniMap.setVisible(false);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
