package view;


import controller.Controller;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class View extends Application{

	public static void main(String[] args) {
		Application.launch(View.class, args);
	}

	
/********************************************************************************************/
	/*************************Deplacement simple d'une forme****************************/
	/***********************************************************************************/
	double orgSceneX, orgSceneY;
	double orgTranslateX, orgTranslateY;
	/***********************************************************************************/
	
	EventHandler<MouseEvent> rectOnMousePressedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
			orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
		}
	};
	
	EventHandler<MouseEvent> rectOnMouseDraggedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
			((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
		}
	};
	
/********************************************************************************************/
/********************************************************************************************/
	/*********************Copie et Deplacement simple d'une forme***********************/
	/***********************************************************************************/
	//double orgSceneX, orgSceneY;
	//double orgTranslateX, orgTranslateY;
	/***********************************************************************************/
	
	EventHandler<MouseEvent> rectOnMousePressedEventHandlerv2 =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			Rectangle rectTest = new Rectangle( t.getSceneX(),
												t.getSceneY());
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();
			orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
			orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
		}
	};
	
	EventHandler<MouseEvent> rectOnMouseDraggedEventHandlerv2 =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
			((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
		}
	};
	
/********************************************************************************************/
	
	
	
	
	
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 600, Color.WHITE);

/***************************************************************************************/
        /**
         * PREMIER GROUPE : Barre du haut contenant les boutons permettant la gestion
         * de données.
         */
        
        Group gr1 = new Group();
        gr1.setLayoutX(5);
        gr1.setLayoutY(5);
        
        Rectangle rect1 = new Rectangle();
        rect1.setX(5);
        rect1.setY(5);
        rect1.setWidth(480);
        rect1.setHeight(50);
        rect1.setArcWidth(30);
        rect1.setArcHeight(30);
        rect1.setFill(Color.WHITE);
        rect1.setStroke(Color.BLACK);
        rect1.setMouseTransparent(true);
        
        Button btnSave = new Button();
        btnSave.setLayoutX(15);
        btnSave.setLayoutY(15);
        btnSave.setText("Save As");
                
        Button btnLoad = new Button();
        btnLoad.setLayoutX(85);
        btnLoad.setLayoutY(15);
        btnLoad.setText("Load");
                
        Button btnUndo = new Button();
        btnUndo.setLayoutX(145);
        btnUndo.setLayoutY(15);
        Image UndoImg = new Image(getClass().getResourceAsStream("../img/Undo.png"));
        ImageView uI = new ImageView(UndoImg);
        uI.setFitHeight(20);
        uI.setFitWidth(20);
        btnUndo.setGraphic(uI);
                        
        Button btnRedo = new Button();
        btnRedo.setLayoutX(200);
        btnRedo.setLayoutY(15);
        Image RedoImg = new Image(getClass().getResourceAsStream("../img/Redo.png"));
        ImageView rI = new ImageView(RedoImg);
        rI.setFitHeight(20);
        rI.setFitWidth(20);
        btnRedo.setGraphic(rI);
                
        
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
        
        Group gr2 = new Group();
        gr2.setLayoutX(5);
        gr2.setLayoutY(50);
        
        Rectangle rect2 = new Rectangle();
        rect2.setX(5);
        rect2.setY(20);
        rect2.setWidth(70);
        rect2.setHeight(515);
        rect2.setArcWidth(30);
        rect2.setArcHeight(30);
        rect2.setFill(Color.WHITE);
        rect2.setStroke(Color.BLACK);
        rect2.setMouseTransparent(true);
        
        
        //Liste des formes 
        Rectangle rectTest = new Rectangle();
        rectTest.setX(rect2.getX() + 10);
        rectTest.setY(rect2.getY() + 10);
        rectTest.setWidth(50);
        rectTest.setHeight(50);
        rectTest.setFill(Color.BLUE);
        rectTest.setStroke(Color.BLACK);
        rectTest.setOnMousePressed(rectOnMousePressedEventHandler);
        rectTest.setOnMouseDragged(rectOnMouseDraggedEventHandler);

        Polygon polyTest = new Polygon();
        polyTest.getPoints().addAll(new Double[]{
        		30.0, 0.0,
        		60.0, 30.0,
        		45.0, 60.0,
        		15.0, 60.0,
        		00.0, 30.0
        });
        polyTest.setLayoutX(rect2.getX() + 5);
        polyTest.setLayoutY(rectTest.getY() + rectTest.getHeight() + 10);     
        
        Text polygonText = new Text("polygon");
        polygonText.setFont(new Font(14));
        polygonText.setLayoutX(polyTest.getLayoutX());
        polygonText.setLayoutY(polyTest.getLayoutY() + 80);
        
        //Bouton TrashCan
        Button TrashCan = new Button();
        TrashCan.setLayoutX(20);
        TrashCan.setLayoutY(490);
        Image TrashCanImg = new Image(getClass().getResourceAsStream("../img/TrashCan.png"));
        ImageView iV = new ImageView(TrashCanImg);
        iV.setFitHeight(20);
        iV.setFitWidth(20);
        TrashCan.setGraphic(iV);
        

        gr2.getChildren().add(rect2);
        gr2.getChildren().add(rectTest);
        gr2.getChildren().add(polyTest);
        gr2.getChildren().add(polygonText);
        gr2.getChildren().add(TrashCan);
        root.getChildren().add(gr2);
        
/***********************************************************************************************/
        /*
         * TROISIEME GROUPE: Fenetre contenant les formes à afficher.
         */
        
        Group gr3 = new Group();
        gr3.setLayoutX(80);
        gr3.setLayoutY(50);
        
        //Rectangle pour l'instant mais à changer.
        
        Rectangle rect3 = new Rectangle();
        rect3.setX(5);
        rect3.setY(20);
        rect3.setWidth(400);
        rect3.setHeight(510);
        rect3.setFill(Color.WHITE);
        rect3.setStroke(Color.BLACK);
        
        //Obsolete
        ScrollBar sc1 = new ScrollBar();
        sc1.setLayoutX(rect3.getX()+20);
        sc1.setLayoutY(rect3.getY()+5);
        sc1.setMin(0);
        sc1.setOrientation(Orientation.HORIZONTAL);
        sc1.setPrefWidth(370);
        sc1.setMax(370);
        
        //Obsolete
        ScrollBar sc2 = new ScrollBar();
        sc2.setLayoutX(rect3.getX()+5);
        sc2.setLayoutY(rect3.getY()+20);
        sc2.setMin(0);
        sc2.setOrientation(Orientation.VERTICAL);
        sc2.setPrefHeight(470);
        sc2.setMax(370);
        
        gr3.getChildren().add(rect3);
        //gr3.getChildren().add(sc1);
        //gr3.getChildren().add(sc2);
        root.getChildren().add(gr3);
        

        
        
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

