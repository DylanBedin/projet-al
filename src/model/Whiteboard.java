package model;

import java.util.ArrayList;

import javafx.geometry.Point2D;


public class Whiteboard{
	private ArrayList<Point2D> listPositionShapes;
	private ArrayList<IShape> listShapes;
	
	public void add(IShape shape, Point2D position){
		this.listShapes.add(shape);
		this.listPositionShapes.add(position);
	}
	
	public void removeShape(IShape shape, Point2D position){
		for(int i = 0; i < this.listPositionShapes.size(); i++){
			if(this.listShapes.get(i) == shape && this.listPositionShapes.get(i) == position){
				this.listShapes.remove(i);
				this.listPositionShapes.remove(i);
			}
		}
	}
}
