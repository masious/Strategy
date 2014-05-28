package environment;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import actions.MiniMapButtonListener;
import actions.ObjectButtonListener;

import maps.Map;
import maps.MapView;
import maps.MiniMap;

public class Editor extends JFrame{

	private static final long serialVersionUID = 1917832408648595047L;

	private Container c;
	private String selectedButton;

	private JPanel buttonArea;

	private JButton miniMapButton;

	private JPanel miniMap;

	private Map map;
	
	public Editor() {
		
		//GUI
		setTitle("War God");
		setSize(getToolkit().getScreenSize().width,getToolkit().getScreenSize().height);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		for(LookAndFeelInfo l:UIManager.getInstalledLookAndFeels()){
			if(l.getName().equals("Nimbus")){
				try {
					UIManager.setLookAndFeel(l.getClassName());
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//init
		c = getContentPane();
		map = new Map(new Dimension(80, 30));
		
		//making components
		MapView mapView = new MapView(map);
		
		buttonArea = new JPanel(new GridLayout(1,6,5,5));
		buttonArea.setSize(mapView.getWidth(),35);
		buttonArea.setLocation(mapView.getLocation().x,mapView.getLocation().y +mapView.getHeight()+5);
		
		miniMap = new MiniMap(map,mapView);
		
		miniMapButton = new JButton("Show miniMap");
		miniMapButton.setLocation(0, getHeight() - 100);
		miniMapButton.setSize(120,30);
		miniMapButton.addMouseListener(new MiniMapButtonListener(miniMap));
		
		//adding components	
		c.add(miniMap);	
		c.add(mapView);
		c.add(buttonArea);
		c.add(miniMapButton);
		
		String [] buttonNames = {"Mountain","Tree","Field","Low Water","High Water","Rock","Mine"};
		for(String bn:buttonNames){
			createButton(bn);
		}
		
		setVisible(true);
	}
	
	private void createButton(String bn) {
		JButton b = new JButton(bn);
		b.addActionListener(new ObjectButtonListener(b));
		buttonArea.add(b);
		
	}

	public static void main(String[] args) {
		new Editor();
	}
	
	public void select(String txt){
		this.selectedButton = txt;
	}
	
	public String getSelect() {
		return selectedButton;
	}

}
