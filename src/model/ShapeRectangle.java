package model;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class ShapeRectangle extends AbstractShape{
	private double arcWidth, arcHeight;
	private double width, height;
	private final static double ROUND = 0, ROUNDEDEDGES = 0;


	public ShapeRectangle(double width, double height, double arcWidth,
			double arcHeight, double rotat, 
			double rotatCenterX, double rotatCenterY, 
			double translateX, double translateY, 
			Color fill, Color stroke, Point2D.Double position){
		super(rotat, rotatCenterX, rotatCenterY, translateX, translateY, fill, stroke, position);
		this.width = width;
		this.height = height;
		this.arcWidth = arcWidth;
		this.arcHeight = arcHeight;
	}
	
	public ShapeRectangle(double width, double height){
		super();
		this.width = width;
		this.height = height;
		this.arcWidth = ROUND;
		this.arcHeight = ROUNDEDEDGES;
	}

	public ShapeRectangle(){
		super();
		this.width = 0;
		this.height = 0;
		this.arcWidth = ROUND;
		this.arcHeight = ROUNDEDEDGES;
	}

	
	public void setWidth(double width){
		this.width = width;
	}
	
	public double getWidth(){
		return this.width;
	}
	
	public void setHeight(double height){
		this.height = height;
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public void setArcWidth(double arcWidth){
		this.arcWidth = arcWidth;
	}
	
	public double getArcWidth(){
		return this.arcWidth;
	}
	
	public void setArcHeight(double arcHeight){
		this.arcHeight = arcHeight;
	}
	
	public double getArcHeight(){
		return this.arcHeight;
	}

}
