package view;


import java.util.ArrayList;


import controller.Controller;
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

public class View extends Application{
	
	protected static final double LAYOUT_X_GROUP2 = 5;
	protected static final double LAYOUT_Y_GROUP2 = 50;
	protected static final double LAYOUT_X_WHITEBOARD = 85;
	protected static final double LAYOUT_Y_WHITEBOARD = 20;
		
	public static Controller controller;
	
	static Stage stage;
	static Rectangle whiteboard;
	public static ArrayList<Shape> listSelectionShapes;

	
	public static void main(String[] args) {
		Application.launch(View.class, args);
	}

	
	public void begin(){
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

	
	
	@SuppressWarnings("static-access")
	@Override
    public void start(Stage primaryStage) {
		this.stage = primaryStage;
        primaryStage.setTitle("Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 600, Color.WHITE);

        this.controller = new Controller(this);

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
//        Image buttonImg = new Image(getClass().getResourceAsStream("../img/Undo.png"));
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
        
        
        Rectangle rect = GraphicalObjects.createRectangle(
        		rect2.getX() + 10, rect2.getY() + 10, 
        		50, 40, 
        		0, 0,
        		Color.BLUE, Color.BLACK, 
        		EventMouse.OnMousePressedToolbar, 
        		EventMouse.OnMouseDraggedEventHandler, 
        		false);
        
        rect.setOnMouseReleased(EventMouse.mouseReleasedOnWhiteboardEventHandler);
        

        
        
        Polygon poly = GraphicalObjects.createPolygon(
        		6, 30, 
        		rect.getX() + 10, rect.getY() + rect.getHeight() + 30, 
        		Color.BLACK, Color.BLACK, 
        		EventMouse.OnMousePressedToolbar, 
        		EventMouse.OnMouseDraggedEventHandler, 
        		false);
        
        Button TrashCan = GraphicalObjects.createButton(20,490, null, null);
        Image buttonImg3 = new Image(getClass().getResourceAsStream("../img/TrashCan.png"));
//		ImageView iV3 = new ImageView(buttonImg3);
//		iV3.setFitHeight(20);
//		iV3.setFitWidth(20);
//		TrashCan.setGraphic(iV3);


		
		//Sélection de formes
		whiteboard.addEventHandler(MouseEvent.MOUSE_PRESSED, EventMouse.buttonPressedOnWhiteboardForSelection);
		whiteboard.addEventHandler(MouseEvent.MOUSE_RELEASED, EventMouse.buttonReleasedOnWhiteboardForSelection);
		
		gr2.getChildren().add(TrashCan);
        gr2.getChildren().add(rect);
        gr2.getChildren().add(poly);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}







