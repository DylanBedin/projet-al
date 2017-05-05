package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import main.Main;
import model.IShape;
import model.Model;
import model.ShapeRectangle;
import model.ShapeRegularPolygon;

public class MouseEvents {
	static final double GLOBAL_LAYOUT_Xmin_WHITEBOARD = 85;
	static final double GLOBAL_LAYOUT_Ymin_WHITEBOARD = 20;
	static final double GLOBAL_LAYOUT_Xmax_WHITEBOARD = GLOBAL_LAYOUT_Xmin_WHITEBOARD + 400;
	static final double GLOBAL_LAYOUT_Ymax_WHITEBOARD = GLOBAL_LAYOUT_Ymin_WHITEBOARD + 510;
	static final double GLOBAL_LAYOUT_Xmin_BUTTONTRASH = 25;
	static final double GLOBAL_LAYOUT_Ymin_BUTTONTRASH = 510;
	static final double GLOBAL_LAYOUT_Xmax_BUTTONTRASH = 125;
	static final double GLOBAL_LAYOUT_Ymax_BUTTONTRASH = 50;

	private static double orgSceneX, orgSceneY;
	private static double newTranslateX, newTranslateY;

	public static void majOrgScene(MouseEvent event){
		orgSceneX = event.getSceneX();
		orgSceneY = event.getSceneY();
	}

	public static EventHandler<MouseEvent> OnMousePressedClone =
			new EventHandler<MouseEvent>(){
		public void handle(MouseEvent event) {
			if (event.getSource() instanceof Rectangle) {
				ShapeRectangle shapeRect;
				try {
					shapeRect = (ShapeRectangle) Main.m.returnToolbar().getShape(0).clone();
					if(Main.m.returnToolbar().isShapeIn(shapeRect)){
						//Initialise les positions pour le drag
						majOrgScene(event);
						boolean bool;
						if(!shapeRect.isOriginalShape()){
							bool = false;
						}
						else{
							bool = true;
						}
						Main.m.notifyChangeShape(shapeRect, bool);
					}
				}
				catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (event.getSource() instanceof Polygon) {
				ShapeRegularPolygon shapePoly;
				try {
					shapePoly = (ShapeRegularPolygon) Main.m.returnToolbar().getShape(1).clone();
					if(Main.m.returnToolbar().isShapeIn(shapePoly)){
						//Initialise les positions pour le drag
						majOrgScene(event);
						boolean bool;
						if(!shapePoly.isOriginalShape()){
							bool = false;
						}
						else{
							bool = true;
						}
						Main.m.notifyChangeShape(shapePoly, bool);
					}
				}
				catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}



		}
	};

	public static EventHandler<MouseEvent> OnMousePressed =
			new EventHandler<MouseEvent>(){
		public void handle(MouseEvent event) {
			if( event.getButton() == MouseButton.PRIMARY){
				if(event.getSource() instanceof Shape){
					((Shape) event.getSource()).toFront();
				}
				majOrgScene(event);
			}
			if( event.getButton() == MouseButton.SECONDARY){

			}
		}
	};

	public static EventHandler<MouseEvent> OnMousePressedUndo = 
			new EventHandler<MouseEvent>(){
		public void handle(MouseEvent event){
			Main.m.notifyUndo();
		}
	};

	
	public static EventHandler<MouseEvent> OnMousePressedRedo =
			new EventHandler<MouseEvent>() {
		public void handle(MouseEvent event){
			Main.m.notifyRedo();
		}
	};
	
	public static EventHandler<MouseEvent> OnMouseDraggedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if( event.getButton() == MouseButton.SECONDARY){
				//do nothing
			}
			else if (event.getButton() == MouseButton.PRIMARY){
				IShape shapeRect = (IShape) ((Shape) event.getSource()).getUserData();
				double offsetX = event.getSceneX() - orgSceneX;
				double offsetY = event.getSceneY() - orgSceneY;
				newTranslateX = offsetX;
				newTranslateY = offsetY;
				shapeRect.setTranslation(newTranslateX, newTranslateY);
				Main.m.notifyChangeShape(shapeRect, false);
			}
		}
	};

	public static EventHandler<MouseEvent> OnMouseReleasedTranslationEventHandler =
			new EventHandler<MouseEvent>(){

		@Override
		public void handle(MouseEvent event){
			if(event.getSource() instanceof Rectangle){
				Rectangle rect = (Rectangle) event.getSource();
				ShapeRectangle shapeRect = (ShapeRectangle) rect.getUserData();
				//ajout d'une shape dans la wb
				if(Main.m.returnWhiteboard().isShapeIn(shapeRect) && !Main.m.returnWhiteboard().containsShape(shapeRect)){
					Main.m.returnWhiteboard().add(shapeRect);
					Main.m.notifyChangeListShapes(Main.m.returnWhiteboard().getListShapes());
				}

				shapeRect.setPosition(shapeRect.getPosition().getX() + shapeRect.getTranslationX(), 
						shapeRect.getPosition().getY() + shapeRect.getTranslationY());
				shapeRect.setTranslation(0, 0);
				//Suppression d'une shape dans la wb


				if(Main.m.returnToolbar().isInTrashcan(shapeRect)){
					Main.m.returnWhiteboard().remove(shapeRect);
					Main.m.notifyChangeListShapes(Main.m.returnWhiteboard().getListShapes());
				}
				else{




					shapeRect.setPosition(shapeRect.getPosition().getX() + shapeRect.getTranslationX(), 
							shapeRect.getPosition().getY() + shapeRect.getTranslationY());
					shapeRect.setTranslation(0, 0);
					if(!Main.m.returnWhiteboard().isShapeIn(shapeRect)){
						Main.m.returnWhiteboard().getShapeBackInTheWhiteboard(shapeRect);


					}
				}
				Main.m.notifyChangeShape(shapeRect, true);
			}
			if(event.getSource() instanceof Polygon){
				Shape s = (Shape) event.getSource();
				ShapeRegularPolygon shapePoly = (ShapeRegularPolygon) s.getUserData();
				if(Main.m.returnWhiteboard().isShapeIn(shapePoly) && !Main.m.returnWhiteboard().containsShape(shapePoly)){
					Main.m.returnWhiteboard().add(shapePoly);
					Main.m.notifyChangeListShapes(Main.m.returnWhiteboard().getListShapes());
				}
				shapePoly.setPosition(shapePoly.getPosition().getX() + shapePoly.getTranslationX(), 
						shapePoly.getPosition().getY() + shapePoly.getTranslationY());
				shapePoly.setTranslation(0, 0);
				if(Main.m.returnToolbar().isInTrashcan(shapePoly)){
					Main.m.returnWhiteboard().remove(shapePoly);
					Main.m.notifyChangeListShapes(Main.m.returnWhiteboard().getListShapes());
				}//Dépassement de la shape du whiteboard
				else{
					shapePoly.setPosition(shapePoly.getPosition().getX() + shapePoly.getTranslationX(), 
							shapePoly.getPosition().getY() + shapePoly.getTranslationY());
					shapePoly.setTranslation(0, 0);
					//Dépassement de la shape du whiteboard
					if(Main.m.returnToolbar().isInTrashcan(shapePoly)){
						System.out.println("Test");
						Main.m.returnWhiteboard().remove(shapePoly);
						Main.m.notifyChangeListShapes(Main.m.returnWhiteboard().getListShapes());
					}

					else if(!Main.m.returnWhiteboard().isShapeIn(shapePoly)){
						Main.m.returnWhiteboard().getShapeBackInTheWhiteboard(shapePoly);
					}

				}
				Main.m.notifyChangeShape(shapePoly, true);
			}
		}
	};

	public static EventHandler<ActionEvent> buttonSerialize =
			new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event){
			Model m = Main.m;
			JFileChooser fileChooser = new JFileChooser();
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(file)) ;
					oos.writeObject(m.returnWhiteboard().getListShapes());
					oos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
	};

	public static EventHandler<ActionEvent> buttonLoading = 
			new EventHandler<ActionEvent>(){
		@Override 
		public void handle(ActionEvent event){
			JFileChooser fileChooser = new JFileChooser();
			if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				try {
					@SuppressWarnings("resource")
					ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file)) ;
					@SuppressWarnings("unchecked")
					ArrayList<IShape> list = (ArrayList<IShape>) ois.readObject();
					Main.m.returnWhiteboard().getListShapes().clear();
					for(IShape i : list){
						Main.m.returnWhiteboard().add(i);
					}

					Main.m.notifyChangeListShapes((List<IShape>) Main.m.returnWhiteboard().getListShapes());

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
}