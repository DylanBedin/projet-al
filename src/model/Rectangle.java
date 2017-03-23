package model;

public class Rectangle extends AbstractShape {
	private double width;
	private double height;
	private double round;
	private double roundedEdges;
	
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
