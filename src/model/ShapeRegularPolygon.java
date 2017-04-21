package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;

public class ShapeRegularPolygon extends AbstractShape {
	private double edgeLength;
	private int nbEdges;
	
	public ShapeRegularPolygon(int edgeLength, int nbEdges, 
						  double rotat, double rotatCenterX,
						  double rotatCenterY, double translateX, 
						  double translateY, Color color, 
						  Dimension size, Point2D.Double position){
		super(rotat, rotatCenterX, rotatCenterY, translateX, translateY, color, position);
		this.edgeLength = edgeLength;
		this.nbEdges = nbEdges;
	}
	
	public ShapeRegularPolygon(double edgeLength, int nbEdges, Point2D.Double position){
		super(position);
		this.edgeLength = edgeLength;
		this.nbEdges = nbEdges;
	}
	
	public void setEdgeLength(int edgeLength){
		this.edgeLength = edgeLength;
	}
	
	public double getEdgeLength(){
		return this.edgeLength;
	}
	
	public void setNbEdges(int nbEdges){
		this.nbEdges = nbEdges;
	}
	
	public int getNbEdges(){
		return this.nbEdges;
	}
}
