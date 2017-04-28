package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public class ShapeRectangle extends AbstractShape {
	private double round;
	private double roundedEdges;
	private double width, height;
	private final static double ROUND = 0, ROUNDEDEDGES = 0;


	public ShapeRectangle(double width, double height, double round,
			double roundedEdges, double rotat, 
			double rotatCenterX, double rotatCenterY, 
			double translateX, double translateY, 
			Color fill, Color stroke, Point2D.Double position){
		super(rotat, rotatCenterX, rotatCenterY, translateX, translateY, fill, stroke, position);
		this.width = width;
		this.height = height;
		this.round = round;
		this.roundedEdges = roundedEdges;
	}
	
	public ShapeRectangle(double width, double height, Point2D.Double position){
		super();
		this.width = width;
		this.height = height;
		this.round = ROUND;
		this.roundedEdges = ROUNDEDEDGES;
	}

	private double WIDTH = 70, HEIGHT = 215;
	public ShapeRectangle(){
		super();
		this.width = WIDTH;
		this.height = HEIGHT;
		this.width = WIDTH;
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
	
	public void setRound(double round){
		this.round = round;
	}
	
	public double getRound(){
		return this.round;
	}
	
	public void setRoundedEdges(double roundedEdges){
		this.roundedEdges = roundedEdges;
	}
	
	public double roundedEdges(){
		return this.roundedEdges;
	}

}
