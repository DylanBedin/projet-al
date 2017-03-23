package model;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import java.awt.geom.Point2D;

public class GroupShape implements Shape {
	private ArrayList<Shape> listShapes;
	
	public GroupShape(){
		this.listShapes = new ArrayList<Shape>();
	}
	
	public void addShape(Shape s){
		this.listShapes.add(s);
	}
	

	public void setPosition(double x, double y) {
		/*
		 * On cherche l'écart entre ce point et la coordonnée souhaitée et on l'applique sur toutes les shapes
		 */
		double gapX = this.getPosition().getX() - x;
		double gapY = this.getPosition().getY() - y;
		for(Shape s:this.listShapes){
			s.setPosition(s.getPosition().getX() - gapX, s.getPosition().getY() - gapY);
		}
	}

	public Point2D getPosition() {
		if(this.listShapes.isEmpty()){
			throw new IllegalStateException();
		}
		/*
		 * On cherche les coordonnées de la shape la plus en haut à gauche
		 */
		double minX = this.listShapes.get(0).getPosition().getX();
		double minY = this.listShapes.get(0).getPosition().getY();
		for(Shape s:this.listShapes){
			if(s.getPosition().getX() < minX){
				minX = s.getPosition().getX();
			}
			if(s.getPosition().getY() < minY){
				minY = s.getPosition().getY();
			}
		}
		return new Point2D.Double(minX, minY);
	}

	public void setColor(Color c) {
		for(Shape s:this.listShapes){
			s.setColor(c);
		}
	}

	public Color getColor() {
		if(this.listShapes.isEmpty()){
			throw new IllegalStateException();
		}
		Color c = this.listShapes.get(0).getColor();
		for(Shape s:this.listShapes){
			if(s.getColor() != c){
				throw new IllegalStateException();
			}
		}
		return c;
	}

	public void setRotation(double rotat) {
		// TODO Auto-generated method stub

	}

	public double getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setRotationCenter(double rotatCenter) {
		// TODO Auto-generated method stub

	}

	public double getRotationCenter() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setTranslation(double translate) {
		// TODO Auto-generated method stub

	}

	public double getTranslation() {
		// TODO Auto-generated method stub
		return 0;
	}

}
