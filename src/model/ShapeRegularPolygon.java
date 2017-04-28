package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;

public class ShapeRegularPolygon extends AbstractShape {
	
	private double ray;
	private int nbVertices;
	private Double [] tabVertices;
	private Point2D center;


	
	
	/*******************************/
	/*        CONSTRUCTOR          */
	/*******************************/

	
	public ShapeRegularPolygon(int sommet, double rayon){
		super();
		assert (rayon > 0 && sommet > 2);
		this.nbVertices = sommet;
		this.ray = rayon;
		this.center = new Point2D.Double(0,0);
		assert (rayon > 0 && sommet > 2);
		this.tabVertices = createTab(rayon, sommet, center);
		}		
	
	
	/*******************************/
	/*          METHODS            */
	/*******************************/	
	
	
	private Double[] createTab(double ray, int vertices, Point2D center){
		double verticeX = center.getX();
		double verticeY = center.getY();
		double angleToAdd = (2 * Math.PI) / vertices;
		double angle = 0;
		Double[] tableau = new Double[vertices*2];
		double edgeX = 0;
		double edgeY = 0;
		for(int i = 0; i<vertices;i++){			
			edgeX = verticeX + this.ray * Math.sin(angle);
			edgeY = verticeY + this.ray * Math.cos(angle);
			tableau[2*i] = edgeX;
			tableau[(2*i)+1] = edgeY;
			angle = angle + angleToAdd;
		}
		return tableau;
	}
	
	
	
	static private double barycentreX(Double[] tab){
		double res = 0;
		for(int i =0; i<tab.length; i= i+2){
			res += tab[i];
		}
		return res / (tab.length /2) ;
	}
	
	static private double barycentreY(Double[] tab){
		double res = 0;
		for(int i =1; i<tab.length; i= i+2){
			res += tab[i];
		}
		return res / (tab.length /2) ;
	}
	
	
	/*******************************/
	/*        SET  /  GET          */
	
	/*******************************/
	/**
	 * 	Commentaire : Les polygones ont leurs champ dépendant les un des autre (Tab <=> Rayon / Tab <=> NombreSommet ...)
	 * 				  Donc a chaque set de ray / tab / nbVertices, il faut les modifier entre eux.
	 */
	
	
	public double getRay(){
		return this.ray;
	}
	
	public void setRay(int ray){
		this.ray = ray;
		this.tabVertices = createTab(this.ray, this.nbVertices, this.center);
	}
	
	public int getNbEdges(){
		return this.nbVertices;
	}
	
	public void setNbEdges(int nbEdges){
		this.nbVertices = nbEdges;
		this.tabVertices = createTab(this.ray, this.nbVertices, this.center);

	}
	
	public Double [] getTab(){
		return this.tabVertices;
	}
	
	public void setTab(Double [] tab){
		this.tabVertices = tab;
	}
	
	public Point2D getPosition(){
		return this.center;
	}
	
	public void setPosition(Point2D p){
		this.center = p;
		this.tabVertices = createTab(this.ray, this.nbVertices, p);
	}
	
	public void setPosition(double x, double y){
		this.center = new Point2D.Double(x, y);
		this.tabVertices = createTab(this.ray, this.nbVertices, this.center);
	}
	
	/*******************************/
	/*       OTHERS_METHODS        */
	/*******************************/
	
	@Override
	public void setRotation(double rotat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRotationCenter(double rotatCenterX, double rotatCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getRotationCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRotationCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}
}
