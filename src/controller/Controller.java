package controller;

import java.awt.*;
import java.awt.geom.Point2D;

import javafx.application.Application;
import javafx.scene.shape.Shape;
import model.*;
import view.*;

public class Controller {
	private View v;
	private Whiteboard wb;
	
	public static void main(String args[]){
		Controller c = new Controller();
	}
	
	
	
	public Controller(){
		v = new View();
		v.begin();
	}
	
	public void addShapeToWhiteboard(Shape s){
		this.wb.add(s, new Point2D.Double(s.getLayoutX(), s.getLayoutY());
	}
	
}

