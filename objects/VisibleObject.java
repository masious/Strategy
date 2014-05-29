package objects;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class VisibleObject implements Serializable{
	
	private static final long serialVersionUID = 7065997982818674019L;
	
	public static final int MAX_OBJECT_SIZE = 100;
	public static final int DEFAULT_OBJECT_SIZE = 50;
	public static final int MIN_OBJECT_SIZE = 10;
	public static int objectSize = DEFAULT_OBJECT_SIZE;
	
	public static final String [] objects = {""};

	private String name;
	
	public VisibleObject(String name){
		this.name = name;
	}
	
	public Image getImage(){
		Image g = new ImageIcon("img/"+name+".png").getImage();
		return g;
	}
}
