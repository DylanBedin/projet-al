package main;


import controller.Controller;
import model.Model;
import model.ShapeRegularPolygon;
import model.Whiteboard;
import view.View;
import javafx.application.Application;

public class Main {

	/**
	 * @param args
	 */
	public static Model m = null;
	public static void main(String[] args) {
		Controller c = new Controller();
		c.launch();
	}
}
