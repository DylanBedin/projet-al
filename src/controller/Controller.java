package controller;

import java.awt.geom.Point2D;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import model.*;
import view.*;

public class Controller {
	private View v;
	private Whiteboard wb;
	
	public Controller(){
		v = new View();
		v.begin();
	}
	
	public void addRectangleToWhiteboard(Rectangle r){
		IShape is;
		is = new ShapeRectangle(r.getHeight(), r.getWidth(), new Point2D.Double(r.getX(), r.getY()));
		this.wb.add(is, new Point2D.Double(is.getPosition().getX(), is.getPosition().getY()));
	}
	
	public void addPolygonToWhiteboard(Polygon polygon){
		IShape is;
		Point2D.Double firstPoint = new Point2D.Double(polygon.getPoints().get(0), polygon.getPoints().get(1));
		Point2D.Double secondPoint = new Point2D.Double(polygon.getPoints().get(2), polygon.getPoints().get(3));
		double edgeLength = Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) 
				+ Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
		is = new ShapeRegularPolygon(edgeLength, polygon.getPoints().size()/2,
				firstPoint);
		
		this.wb.add(is, firstPoint);
	}
	
}

