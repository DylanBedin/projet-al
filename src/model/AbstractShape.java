package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class AbstractShape implements IShape {
	protected double rotat;
	protected double rotatCenterX, rotatCenterY;
	protected double translateX, translateY;
	protected Color color;
	protected Point2D position;
	protected ArrayList<Memento> mementoList;
	
	private final static double ROTAT = 0, ROTATCENTERX = 0, ROTATCENTERY = 0, TRANSLATEX = 0, TRANSLATEY = 0;
	private final static Color COLOR = new Color(0, 0, 0);
	
	public AbstractShape(double rotat, double rotatCenterX, 
			double rotatCenterY, double translateX, 
			double translateY, Color color, 
			Point2D.Double position){
		this.rotat = rotat;
		this.rotatCenterX = rotatCenterX;
		this.rotatCenterY = rotatCenterY;
		this.translateX = translateX;
		this.translateY = translateY;
		this.color = color;
		this.position = (Point2D) position.clone();
		this.mementoList = new ArrayList<Memento>();
	}
	
	public AbstractShape(Point2D.Double position){
		this.rotat = ROTAT;
		this.rotatCenterX = ROTATCENTERX;
		this.rotatCenterY = ROTATCENTERY;
		this.translateX = TRANSLATEX;
		this.translateY = TRANSLATEY;
		this.color = COLOR;
		this.position = (Point2D) position.clone();
		this.mementoList = new ArrayList<Memento>();
	}
	
	public void addMemento(Memento state){
		this.mementoList.add(state);
	}
	
	public void setPosition(double x, double y) {
		this.position = new Point2D.Double(x, y);
	}

	public Point2D getPosition() {
		return this.position;
	}
	
	public void setColor(Color c){
		this.color = c;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public void setRotation(double rotat){
		this.rotat = rotat;
	}
	public double getRotation(){
		return this.rotat;
	}
	
	public void setRotationCenter(double rotatCenterX, double rotatCenterY){
		this.rotatCenterX = rotatCenterX;
		this.rotatCenterY = rotatCenterY;
	}
	
	public double getRotationCenterX(){
		return this.rotatCenterX;
	}
	
	public double getRotationCenterY(){
		return this.rotatCenterY;
	}
	
	public void setTranslation(double translateX, double translateY){
		this.translateX = translateX;
		this.translateY = translateY;
	}
	
	public double getTranslationX(){
		return this.translateX;
	}
	
	public double getTranslationY(){
		return this.translateY;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
