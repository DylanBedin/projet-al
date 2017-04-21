package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;

public class ShapeRectangle extends AbstractShape {
	private double round;
	private double roundedEdges;
	private Dimension size;
	private final static double ROUND = 0, ROUNDEDEDGES = 0;


	public ShapeRectangle(Dimension size, double round,
			double roundedEdges, double rotat, 
			double rotatCenterX, double rotatCenterY, 
			double translateX, double translateY, 
			Color color, Point2D.Double position){
		super(rotat, rotatCenterX, rotatCenterY, translateX, translateY, color, position);
		this.size = size;
		this.round = round;
		this.roundedEdges = roundedEdges;
	}
	
	public ShapeRectangle(Dimension size, Point2D.Double position){
		super(position);
		this.size = size;
		this.round = ROUND;
		this.roundedEdges = ROUNDEDEDGES;
	}
	
	public void setWidth(double width){
		this.size.setSize(width, this.getHeight());
	}
	
	public double getWidth(){
		return this.size.getWidth();
	}
	
	public void setHeight(double height){
		this.size.setSize(this.getWidth(), height);
	}
	
	public double getHeight(){
		return this.size.getHeight();
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
