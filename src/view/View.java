package view;


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import controller.MouseEvents;

import main.Main;
import model.ShapeRectangle;
import model.Whiteboard;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class View extends Application implements Observer{
	
	protected static final double LAYOUT_X_GROUP2 = 5;
	protected static final double LAYOUT_Y_GROUP2 = 50;
	protected static final double LAYOUT_X_WHITEBOARD = 85;
	protected static final double LAYOUT_Y_WHITEBOARD = 20;
			
	static Stage stage;
	static Rectangle whiteboard;
//	public static ArrayList<Shape> listSelectionShapes;

	
//	public static void main(String[] args) {
//		Application.launch(View.class, args);
//	}

	
	public void launchApp(){
		Application.launch(View.class);
	}
	
	
	
/***************************************************************************************************************************/
/**
 * TODO : Faire une liste répertoriant toutes les formes présentes DANS LE WHITEBOARD 
 * 		  (ignorer ceux qui sont passé en invisible)
 * 
 */
	

	/********************************************************************************************/
	/***************************CREATION GRAPHIC INTERFACE***************************************/
	/********************************************************************************************/

	
	private Polygon originPoly;
	private Rectangle originRect;
	private Whiteboard wb;
	private MouseEvents mouseEvents;
	@SuppressWarnings("static-access")
	@Override
    public void start(Stage primaryStage) {
		this.stage = primaryStage;
        primaryStage.setTitle("Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 600, Color.WHITE);
        this.wb = Main.wb;
        this.wb.addObserver(this);
        this.mouseEvents = new MouseEvents(this.wb);
        /***************************************************************************************/
        /**
         * PREMIER GROUPE : Barre du haut contenant les boutons permettant la gestion
         * de données.
         */
        
        Group gr1 = GraphicalObjects.createGroup(5,5);
        
        Rectangle rect1 = GraphicalObjects.createRectangle(5,5,480,50,30,30,Color.WHITE,Color.BLACK,null,null,true);
        
        /**
         *  TODO img SaveAs
         */
        Button btnSave = new Button();
        btnSave.setLayoutX(15);
        btnSave.setLayoutY(15);
        btnSave.setText("Save As");
                
        /**
         * TODO img Load
         */
        Button btnLoad = new Button();
        btnLoad.setLayoutX(85);
        btnLoad.setLayoutY(15);
        btnLoad.setText("Load");
                
        Button btnUndo = GraphicalObjects.createButton(145,15, null, null);
//      Image buttonImg = new Image(getClass().getResourceAsStream("../img/Undo.png"));
//		ImageView iV = new ImageView(buttonImg);
//		iV.setFitHeight(20);
//		iV.setFitWidth(20);
//		btnUndo.setGraphic(iV);
                        
        Button btnRedo = GraphicalObjects.createButton(200,15, null, null);
//        Image buttonImg2 = new Image(getClass().getResourceAsStream("../img/Redo.png"));
//		ImageView iV2 = new ImageView(buttonImg2);
//		iV2.setFitHeight(20);
//		iV2.setFitWidth(20);
//		btnRedo.setGraphic(iV2);
        
        gr1.getChildren().add(rect1);
        gr1.getChildren().add(btnRedo);
        gr1.getChildren().add(btnUndo);
        gr1.getChildren().add(btnSave);
        gr1.getChildren().add(btnLoad);
        root.getChildren().add(gr1);
        
        

        
        /***********************************************************************************************/
        /*
         * DEUXIEME GROUPE: Barre contenant les formes stockées ainsi que les groupes de formes.
         */
        
        final Group gr2 = GraphicalObjects.createGroup(LAYOUT_X_GROUP2, LAYOUT_Y_GROUP2);
        
        Rectangle rect2 = GraphicalObjects.createRectangle(5, 20, 70, 515, 20, 20, 
        		Color.WHITE, Color.BLACK, null, null, true);

        gr2.getChildren().add(rect2);
        
        /***********************************************************************************************/
        /*
         * TROISIEME GROUPE: Fenetre contenant les formes à afficher.
         */
        
                
        whiteboard = GraphicalObjects.createRectangle(LAYOUT_X_WHITEBOARD, LAYOUT_Y_WHITEBOARD, 
        		400, 510, 0, 0, 
        		Color.WHITE,Color.BLACK, 
        		null, null, false);
        
        
        
        gr2.getChildren().add(whiteboard);
        root.getChildren().add(gr2);

        /***********************************************************************************************/
        
        /*
         * Les formes d'origines
         */
        
        
//        originRect = GraphicalObjects.createRectangle(
//        		rect2.getX() + 10, rect2.getY() + 10, 
//        		50, 40, 
//        		0, 0,
//        		Color.BLUE, Color.BLACK, 
//        		EventMouse.OnMousePressedToolbar, 
//        		EventMouse.OnMouseDraggedEventHandler, 
//        		false);

        
        //Rectangle rect2 = GraphicalObjects.createRectangle(5, 20, 70, 515, 20, 20, 
        originRect = GraphicalObjects.createRectangle(
        		rect2.getX() + 10, rect2.getY() + 10, 
        		50, 40, 
        		0, 0,
        		Color.BLUE, Color.BLACK, 
        		MouseEvents.OnMousePressedToolbar, 
        		MouseEvents.OnMouseDraggedEventHandler, 
        		false);
//        
//        originRect.setOnMouseReleased(EventMouse.mouseReleasedOnWhiteboardEventHandler);
        

        
        
//        originPoly = GraphicalObjects.createPolygon(
//        		6, 30, 
//        		originRect.getX() + 10, originRect.getY() + originRect.getHeight() + 30, 
//        		Color.BLACK, Color.BLACK, 
//        		EventMouse.OnMousePressedToolbar, 
//        		EventMouse.OnMouseDraggedEventHandler, 
//        		false);
        
        originPoly = GraphicalObjects.createPolygon(
        		6, 30, 
        		originRect.getX() + 10, originRect.getY() + originRect.getHeight() + 30, 
        		Color.BLACK, Color.BLACK, 
        		MouseEvents.OnMousePressedToolbar, 
        		null, 
        		false);
        
        Button TrashCan = GraphicalObjects.createButton(20,490, null, null);
//        Image buttonImg3 = new Image(getClass().getResourceAsStream("../img/TrashCan.png"));
//		ImageView iV3 = new ImageView(buttonImg3);
//		iV3.setFitHeight(20);
//		iV3.setFitWidth(20);
//		TrashCan.setGraphic(iV3);


		
		//Sélection de formes
//		whiteboard.addEventHandler(MouseEvent.MOUSE_PRESSED, EventMouse.buttonPressedOnWhiteboardForSelection);
//		whiteboard.addEventHandler(MouseEvent.MOUSE_RELEASED, EventMouse.buttonReleasedOnWhiteboardForSelection);
//		
		gr2.getChildren().add(TrashCan);
        gr2.getChildren().add(originRect);
        gr2.getChildren().add(originPoly);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	
	private static double orgSceneX, orgSceneY;
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof ShapeRectangle){
			ShapeRectangle shapeRect = (ShapeRectangle) arg1;
			System.out.println(arg0);
			Shape rect = GraphicalObjects.cloneShape(originRect);
//			orgSceneX = shapeRect.getPosition().getX();
//			orgSceneY = shapeRect.getPosition().getY();
		}
	}
}







