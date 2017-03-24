package model;

import java.awt.Color;
import java.awt.geom.Point2D;

public class ShapeRegularPolygon extends AbstractShape {
	private int edgeLength;
	private int nbEdges;
	
	public ShapeRegularPolygon(int edgeLength, int nbEdges, 
						  double rotat, double rotatCenter, double translate, Color color, double size, Point2D position){
		super(rotat, rotatCenter, translate, color, size, position);
		this.edgeLength = edgeLength;
		this.nbEdges = nbEdges;
	}
	
	public void setEdgeLength(int edgeLength){
		this.edgeLength = edgeLength;
	}
	
	public int getEdgeLength(){
		return this.edgeLength;
	}
	
	public void setNbEdges(int nbEdges){
		this.nbEdges = nbEdges;
	}
	
	public int getNbEdges(){
		return this.nbEdges;
	}
}
