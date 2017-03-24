package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public abstract class AbstractShape implements IShape {
	protected double rotat;
	protected double rotatCenter;
	protected double translate;
	protected Color color;
	protected double size;
	protected Point2D position;

	public AbstractShape(double rotat, double rotatCenter, double translate, Color color, double size, Point2D position){
		this.rotat = rotat;
		this.rotatCenter = rotatCenter;
		this.translate = translate;
		this.color = color;
		this.size = size;
		this.position = (Point2D) position.clone();
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
	
	public void setRotationCenter(double rotatCenter){
		this.rotatCenter = rotatCenter;
	}
	
	public double getRotationCenter(){
		return this.rotatCenter;
	}
	
	public void setTranslation(double translate){
		this.translate = translate;
	}
	
	public double getTranslation(){
		return this.translate;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
