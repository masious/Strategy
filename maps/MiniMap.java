package maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MiniMap extends JPanel{
	
	private final static int width = 320;
	private final static int height = 156;
	
	private static final long serialVersionUID = -7029511616437899460L;
	private Map map;
	private MapView mapView;

	public MiniMap(Map map,MapView mv) {
		this.map = map;
		this.mapView = mv;
		
		//GUI
		setSize(width,height);
		setBackground(Color.GRAY);
		setLocation(10,10);
		setVisible(false);
	}
	
	@Override
	public void paint(Graphics arg0) {	
		super.paint(arg0);
		
		int bw = width/map.getSize().width;
		int bh = height/map.getSize().height;
		
		arg0.setColor(Color.LIGHT_GRAY);
		arg0.fillRect(mapView.getLocationVar().x*bw, mapView.getLocationVar().y*bh,
				mapView.getLastPoint().x*bw - mapView.getLocationVar().x*bw , mapView.getLastPoint().y*bh - mapView.getLocationVar().y*bh);
		
		for(int i=0;i<map.getSize().width;i++){
			for(int j=0;j<map.getSize().height;j++){
				if(map.getMap(i,j) == null)
					continue;
				
				Image img = map.getMap(i,j).getImage();
				
				arg0.drawImage(img,i*bw , j*bh, (i+1)*bw, (j+1)*bh,
						0, 0, img.getWidth(null), img.getHeight(null), null);
			}
		}
		arg0.setColor(Color.YELLOW);
		arg0.draw3DRect(mapView.getLocationVar().x*bw, mapView.getLocationVar().y*bh,
				mapView.getLastPoint().x*bw - mapView.getLocationVar().x*bw , mapView.getLastPoint().y*bh - mapView.getLocationVar().y*bh,true);
	}
}
