package controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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

