package model;

import java.util.ArrayList;
import java.util.Observable;
import java.awt.Color;
import java.awt.geom.Point2D;

public class Whiteboard extends ShapeRectangle{
	private ArrayList<Point2D.Double> listPositionShapes;
	private ArrayList<IShape> listShapes;
	private double height, width;
	private Point2D upLeftCorner;
	
	private final double LAYOUT_X_WHITEBOARD = 85;
	private final double LAYOUT_Y_WHITEBOARD = 20;
	private final double WIDTH = 400, HEIGHT = 510;
	
	
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
		this.setPosition(LAYOUT_X_WHITEBOARD, LAYOUT_Y_WHITEBOARD);
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setArcHeight(0);
		this.setArcWidth(0);
	}
//	
//	public void translateShape(IShape shape, double x, double y){
//		int index = -1;
//		for(int i = 0; i < this.listPositionShapes.size(); i++){
//			if(this.listShapes.get(index) == shape){
//				shape.setTranslation(x, y);
//				this.listPositionShapes.get(i).setLocation(new Point2D.Double(
//						this.listPositionShapes.get(i).getX()+x,
//						this.listPositionShapes.get(i).getY()+y));
//			}
//		}
//		setChanged();
//		notifyObservers(shape);
//	}
//	
//	public void add(IShape shape, Point2D.Double position){
//		this.listShapes.add(shape);
//		this.listPositionShapes.add(position);
//		setChanged();
//		notifyObservers(shape);
//	}
//	
//	public void removeShape(IShape shape, Point2D position){
//		for(int i = 0; i < this.listPositionShapes.size(); i++){
//			if(this.listShapes.get(i) == shape && this.listPositionShapes.get(i) == position){
//				this.listShapes.remove(i);
//				this.listPositionShapes.remove(i);
//			}
//		}
//	}
//	
//	public ArrayList<Point2D.Double> getListPositionShapes(){
//		return this.listPositionShapes;
//	}
//	
//	public ArrayList<IShape> getListShapes(){
//		return this.listShapes;
//	}
	
}
