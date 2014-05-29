package maps;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;

import objects.VisibleObject;

import framework.FileIO;

// the whole map is stored in this one
public class Map{

	//
	private VisibleObject [][] mapArray;
	private Dimension size;
	

	//making new map
	public Map(Dimension d) {
		this.size = d;
		mapArray = new VisibleObject[d.width][d.height];
	}
	
	//loading map
	public Map(VisibleObject [][] mapArray){
		this.mapArray = mapArray;
	}
	
	//saves the map into a file
	private void save(){
		String arrStr = "";
		for(int i=0;i<mapArray.length;i++){
			for(int j=0;j<mapArray[i].length;j++){
				arrStr += mapArray[i][j];
			}
		}
		FileIO.writeToFile("data/map.txt", arrStr);
	}
	
	public void add(Point p,VisibleObject vo){
		System.out.println("added to "+p.x+" "+p.y);
		mapArray[p.x][p.y] = vo;
	}

	public Dimension getSize() {
		return size;
	}
	
	public VisibleObject getMap(int i,int j){
		try{
			return mapArray[i][j];
		}catch( ArrayIndexOutOfBoundsException e){
			System.err.println("out of bounds exception in getMap() in Map.java: "+i+" "+j);
			return null;
		}
	}
}
