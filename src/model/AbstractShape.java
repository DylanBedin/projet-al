package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public abstract class AbstractShape implements Shape {
	protected double rotat;
	protected double rotatCenter;
	protected double translate;
	protected Color color;
	protected double size;
	protected Point2D position;

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
}
