package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

import javafx.collections.ObservableList;


import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class Whiteboard extends ShapeRectangle implements Serializable{
	private ArrayList<IShape> listShapes;

	private double height, width;
	private Point2D upLeftCorner;

	private final double WIDTH = 400, HEIGHT = 510;
	private final double LAYOUT_XMIN_WHITEBOARD = 85;
	private final double LAYOUT_YMIN_WHITEBOARD = 20;
	private final double LAYOUT_XMAX_WHITEBOARD = LAYOUT_XMIN_WHITEBOARD + WIDTH;
	private final double LAYOUT_YMAX_WHITEBOARD = LAYOUT_YMIN_WHITEBOARD + HEIGHT;


	public Whiteboard(){
		this.listShapes = new ArrayList<IShape>();
		this.setPosition(LAYOUT_XMIN_WHITEBOARD, LAYOUT_YMIN_WHITEBOARD);
		this.setWidth(WIDTH);
		this.setHeight(HEIGHT);
		this.setFill(Color.WHITE);
		this.setStroke(Color.BLACK);
		this.setArcHeight(0);
		this.setArcWidth(0);
	}


	public void add(IShape shape){
		this.listShapes.add(shape);
	}

	public void remove(IShape shape){
		if(this.listShapes.contains(shape)){
			this.listShapes.remove(shape);
		}
	}

	public List<IShape> getListShapes(){
		return this.listShapes;
	}

	public boolean containsShape(IShape s){
		return this.listShapes.contains(s);
	}

	public boolean isShapeIn(IShape s){
		if(s instanceof ShapeRectangle){
			double x = s.getPosition().getX();
			double y = s.getPosition().getY();
			return x >= this.LAYOUT_XMIN_WHITEBOARD && x <= LAYOUT_XMAX_WHITEBOARD - ((ShapeRectangle) s).getHeight()
					&& y >= this.LAYOUT_YMIN_WHITEBOARD && y <= LAYOUT_YMAX_WHITEBOARD - ((ShapeRectangle) s).getWidth();
		}
		else if (s instanceof ShapeRegularPolygon){
			double x = s.getPosition().getX();
			double y = s.getPosition().getY();
			return x >= this.LAYOUT_XMIN_WHITEBOARD && x <= LAYOUT_XMAX_WHITEBOARD
					&& y >= this.LAYOUT_YMIN_WHITEBOARD && y <= LAYOUT_YMAX_WHITEBOARD ;
		}
		return false;
	}

	public void getShapeBackInTheWhiteboard(IShape s){
		double x = s.getPosition().getX();
		double y = s.getPosition().getY();
		if (s instanceof ShapeRectangle){

			if( x < this.LAYOUT_XMIN_WHITEBOARD ){
				x = LAYOUT_XMIN_WHITEBOARD;
				s.setPosition(x, y);
			}
			if( y < this.LAYOUT_YMIN_WHITEBOARD ){
				y = LAYOUT_YMIN_WHITEBOARD;
				s.setPosition(x, y);
			}
			if( x + ((ShapeRectangle) s).getWidth() > LAYOUT_XMAX_WHITEBOARD ){
				x = LAYOUT_XMAX_WHITEBOARD - ((ShapeRectangle) s).getWidth();
				s.setPosition(x, y);
			}
			if( y + ((ShapeRectangle) s).getHeight() > LAYOUT_YMAX_WHITEBOARD ){
				y = LAYOUT_YMAX_WHITEBOARD - ((ShapeRectangle) s).getHeight();
				s.setPosition(x, y);
			}
		}

		if (s instanceof ShapeRegularPolygon){
			ShapeRegularPolygon shapePoly = (ShapeRegularPolygon) s;
			Double [] tab = shapePoly.getTab();
			Double baryX = ShapeRegularPolygon.barycentreX(tab);
			Double baryY = ShapeRegularPolygon.barycentreY(tab);
			Double ray = shapePoly.getRay();
			if ( baryX - ray > LAYOUT_XMIN_WHITEBOARD ){
				x = LAYOUT_XMIN_WHITEBOARD + ray;
				shapePoly.setPosition(x,y);
			}
			if ( baryY - ray > LAYOUT_YMIN_WHITEBOARD){
				y = LAYOUT_YMIN_WHITEBOARD + ray;
				shapePoly.setPosition(x,y);
			}
			if (baryX + ray < LAYOUT_XMAX_WHITEBOARD){
				x = LAYOUT_XMAX_WHITEBOARD - getMaxY(tab);
				shapePoly.setPosition(x,y);
			}
			if (baryY + ray < LAYOUT_YMAX_WHITEBOARD){
				y = LAYOUT_YMAX_WHITEBOARD - getMaxX(tab);
				shapePoly.setPosition(x,y);	
			}

		}
	}
	static private double getMaxX(Double[] tab ) {

		double max = 0;
		for(int i = 0; i < tab.length; i++){
			if ( tab[i] > max ){
				max = tab[i];
			}
		}
		return max;
	}

	static private double getMaxY(Double[] tab ) {
		double min = 1000;
		for(int i = 0; i < tab.length; i++){
			if ( tab[i] < min ){
				min = tab[i];
			}
			
		}	
		return min;
	}

	public void setListShapes(ArrayList<IShape> listShapes){
		this.listShapes = listShapes;
	}
	
	public Whiteboard clone() throws CloneNotSupportedException{
		Whiteboard wb = new Whiteboard();
		ArrayList<IShape> listShapes = new ArrayList<IShape>();
		for(IShape ishape:this.getListShapes()){
			listShapes.add((IShape) ishape.clone());
		}
		wb.setListShapes(listShapes);
		return wb;
	}

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
	

