package model;

import java.awt.geom.Point2D;

@SuppressWarnings("serial")
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
		this.tabVertices = createTab(rayon, sommet);
		}		
	
	
	/*******************************/
	/*          METHODS            */
	/*******************************/	
	
	
	public static Double[] createTab(double ray, int vertices){
		double verticeX = 0;
		double verticeY = 0;
		double angleToAdd = (2 * Math.PI) / vertices;
		double angle = 0;
		Double[] tableau = new Double[vertices*2];
		double edgeX = 0;
		double edgeY = 0;
		for(int i = 0; i<vertices;i++){			
			edgeX = verticeX + ray * Math.sin(angle);
			edgeY = verticeY + ray * Math.cos(angle);
			tableau[2*i] = edgeX;
			tableau[(2*i)+1] = edgeY;
			angle = angle + angleToAdd;
		}
		return tableau;
	}
	
	
	
	public static double barycentreX(Double[] tab){
		double res = 0;
		for(int i =0; i<tab.length; i= i+2){
			res += tab[i];
		}
		return res / (tab.length /2) ;
	}
	
	public static double barycentreY(Double[] tab){
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
	 * 	Commentaire : Les polygones ont leurs champs dépendant les un aux 
	 * 				  autres (Tab <=> Rayon / Tab <=> NombreSommet ...)
	 * 				  Donc à chaque set de ray / tab / nbVertices, il faut les 
	 * 				  modifier entre eux.
	 */
	
	
	public double getRay(){
		return this.ray;
	}
	
	public void setRay(int ray){
		this.ray = ray;
		this.tabVertices = createTab(this.ray, this.nbVertices);
	}
	
	public int getNbEdges(){
		return this.nbVertices;
	}
	
	public void setNbEdges(int nbEdges){
		this.nbVertices = nbEdges;
		this.tabVertices = createTab(this.ray, this.nbVertices);

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
	}
	
	public void setPosition(double x, double y){
		this.center = new Point2D.Double(x, y);
	}
}
