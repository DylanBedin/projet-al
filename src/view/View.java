package view;


import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View extends Application{
	
	private static final double LAYOUT_X_RECTANGLE = 15;
	private static final double LAYOUT_Y_RECTANGLE = 30;
	private static final double LAYOUT_X_POLYGON = 10;
	private static final double LAYOUT_Y_POLYGON = 90;
	private static final double LAYOUT_X_WHITEBOARD = 85;
	private static final double LAYOUT_Y_WHITEBOARD = 70;
	
	private Controller c;
	
	static Stage stage;
	static Rectangle whiteboard;
	

	
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

	
	
	@Override
    public void start(Stage primaryStage) {
		this.stage = primaryStage;
        primaryStage.setTitle("Test");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 600, Color.WHITE);

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
        Image buttonImg = new Image(getClass().getResourceAsStream("../img/Undo.png"));
		ImageView iV = new ImageView(buttonImg);
		iV.setFitHeight(20);
		iV.setFitWidth(20);
		btnUndo.setGraphic(iV);
                        
        Button btnRedo = GraphicalObjects.createButton(200,15, null, null);
        Image buttonImg2 = new Image(getClass().getResourceAsStream("../img/Redo.png"));
		ImageView iV2 = new ImageView(buttonImg2);
		iV2.setFitHeight(20);
		iV2.setFitWidth(20);
		btnRedo.setGraphic(iV2);
        
        gr1.getChildren().add(rect1);
        gr1.getChildren().add(btnRedo);
        gr1.getChildren().add(btnUndo);
        gr1.getChildren().add(btnSave);
        gr1.getChildren().add(btnLoad);
        root.getChildren().add(gr1);
        
        
        /***********************************************************************************************/
        /*
         * DEUXIEME GROUPE: Fenetre contenant les formes à afficher.
         */
        
        Group gr3 = GraphicalObjects.createGroup(LAYOUT_X_WHITEBOARD,LAYOUT_Y_WHITEBOARD);
                
        whiteboard = GraphicalObjects.createRectangle(0,0,400,510,0,0,Color.WHITE,Color.BLACK, null, null, true);
        
        
        
        gr3.getChildren().add(whiteboard);
        root.getChildren().add(gr3);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        /***********************************************************************************************/
        /*
         * TROISIEME: Barre contenant les formes stockées ainsi que les groupes de formes.
         */
        
        Group gr2 = GraphicalObjects.createGroup(5,50);
        
        Rectangle rect2 = GraphicalObjects.createRectangle(5, 20, 70, 515, 20, 20, 
        		Color.WHITE, Color.BLACK, null, null, true);
        
        Rectangle rect = GraphicalObjects.createRectangle(rect2.getX() + 10, rect2.getY() + 10, 50, 50, 0, 0,
        		Color.BLUE, Color.BLACK, EventMouse.OnMousePressedEventHandlerv2, 
        		EventMouse.OnMouseDraggedEventHandler, false);
        
        rect.setOnMouseReleased(EventMouse.mouseReleasedOnWhiteboardEventHandler);

        Double[] tab = new Double[]{
        		30.0, 0.0,
        		60.0, 30.0,
        		45.0, 60.0,
        		15.0, 60.0,
        		00.0, 30.0
        };
        
        Polygon poly = GraphicalObjects.createPolygon(tab, rect2.getX() + 5, rect.getY() + rect.getHeight() + 10, Color.BLACK, 
        		Color.BLACK, EventMouse.OnMousePressedEventHandlerv2, EventMouse.OnMouseDraggedEventHandler, false);
        

        
        Button TrashCan = GraphicalObjects.createButton(20,490, null, null);
        Image buttonImg3 = new Image(getClass().getResourceAsStream("../img/TrashCan.png"));
		ImageView iV3 = new ImageView(buttonImg3);
		iV3.setFitHeight(20);
		iV3.setFitWidth(20);
		TrashCan.setGraphic(iV3);

        gr2.getChildren().add(rect2);
		gr2.getChildren().add(TrashCan);
        gr2.getChildren().add(rect);
        gr2.getChildren().add(poly);
        root.getChildren().add(gr2);

    }
	
	
}







