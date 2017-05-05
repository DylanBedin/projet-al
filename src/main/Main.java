package main;


import controller.Controller;
import model.Model;

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
