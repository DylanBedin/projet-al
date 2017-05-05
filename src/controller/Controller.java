package controller;


import main.Main;
import model.*;
import view.*;


public class Controller {
	private View v;
	
	public void launch(){
		this.v.launchApp();
	}
	
	public Controller(){
		this.v = new View();
		Main.m = new Model();
	}	
}

