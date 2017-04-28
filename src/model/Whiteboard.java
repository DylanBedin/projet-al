package model;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.geom.Point2D;

public class Whiteboard extends Observable{
	private ArrayList<Point2D.Double> listPositionShapes;
	private ArrayList<IShape> listShapes;
	private double height, width;
	private Point2D upLeftCorner;
	
	private final static double HEIGHT = 100, WIDTH = 100;
	private final static Point2D.Double UPLEFTCORNER = new Point2D.Double(0, 0);
	
	public Whiteboard(Point2D p, double height, double width){
		this.listPositionShapes = new ArrayList<Point2D.Double>();
		this.listShapes = new ArrayList<IShape>();
		this.height = height;
		this.width = width;
		this.upLeftCorner = p;
	}
	
	public Whiteboard(){
		this.listPositionShapes = new ArrayList<Point2D.Double>();
		this.listShapes = new ArrayList<IShape>();
		this.height = HEIGHT;
		this.width = WIDTH;
		this.upLeftCorner = UPLEFTCORNER;
	}
	
	public void translateShape(IShape shape, double x, double y){
		int index = -1;
		for(int i = 0; i < this.listPositionShapes.size(); i++){
			if(this.listShapes.get(index) == shape){
				shape.setTranslation(x, y);
				this.listPositionShapes.get(i).setLocation(new Point2D.Double(
						this.listPositionShapes.get(i).getX()+x,
						this.listPositionShapes.get(i).getY()+y));
			}
		}
		setChanged();
		notifyObservers(shape);
	}
	
	public void add(IShape shape, Point2D.Double position){
		this.listShapes.add(shape);
		this.listPositionShapes.add(position);
		setChanged();
		notifyObservers(shape);
	}
	
	public void removeShape(IShape shape, Point2D position){
		for(int i = 0; i < this.listPositionShapes.size(); i++){
			if(this.listShapes.get(i) == shape && this.listPositionShapes.get(i) == position){
				this.listShapes.remove(i);
				this.listPositionShapes.remove(i);
			}
		}
	}
	
	public ArrayList<Point2D.Double> getListPositionShapes(){
		return this.listPositionShapes;
	}
	
	public ArrayList<IShape> getListShapes(){
		return this.listShapes;
	}
	
}
