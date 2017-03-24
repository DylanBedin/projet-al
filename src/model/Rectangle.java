package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public class Rectangle extends AbstractShape {
	private double width;
	private double height;
	private double round;
	private double roundedEdges;
	
	public Rectangle(double width, double height, double round, double roundedEdges,
					 double rotat, double rotatCenter, double translate, Color color, double size, Point2D position){
		super(rotat, rotatCenter, translate, color, size, position);
		this.width = width;
		this.height = height;
		this.round = round;
		this.roundedEdges = roundedEdges;
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
