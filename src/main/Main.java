package main;


import controller.Controller;
import model.Whiteboard;
import view.View;
import javafx.application.Application;

public class Main {

	/**
	 * @param args
	 */
	public static Whiteboard wb = new Whiteboard();
	public static void main(String[] args) {
		Controller c = new Controller();
		c.launch();
	}
}
