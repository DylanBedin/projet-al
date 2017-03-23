package model;

public class RegularPolygon extends AbstractShape {
	private int edgeLength;
	private int nbEdges;
	
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
