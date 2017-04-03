package view;

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
        
        Group gr1 = createGroup(5,5);
        
        Rectangle rect1 = createRectangle(5,5,480,50,30,30,Color.WHITE,Color.BLACK,null,null,true);
        
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
                
        Button btnUndo = createButton(145,15,"../img/Redo.png");
                        
        Button btnRedo = createButton(200,15,"../img/Redo.png");
       
        
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
        
        Group gr3 = createGroup(80,50);
        
        //Rectangle pour l'instant mais à changer.
        
        Rectangle rect3 = createRectangle(5,20,400,510,0,0,Color.WHITE,Color.BLACK, null, null, true);


        gr3.getChildren().add(rect3);
        root.getChildren().add(gr3);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        /***********************************************************************************************/
        /*
         * TROISIEME: Barre contenant les formes stockées ainsi que les groupes de formes.
         */
        
        Group gr2 = createGroup(5,50);
        
        Rectangle rect2 = createRectangle(5, 20, 70, 515, 20, 20, 
        		Color.WHITE, Color.BLACK, null, null, true);
        
        Rectangle rectTest = createRectangle(rect2.getX() + 10, rect2.getY() + 10, 50, 50, 0, 0,
        		Color.BLUE, Color.BLACK, rectOnMousePressedEventHandler, 
        		rectOnMouseDraggedEventHandler, false);


        Double[] tab = new Double[]{
        		30.0, 0.0,
        		60.0, 30.0,
        		45.0, 60.0,
        		15.0, 60.0,
        		00.0, 30.0
        };
        
        Polygon polyTest = createPolygon(tab, rect2.getX() + 5, rectTest.getY() + rectTest.getHeight() + 10, Color.BLACK, Color.BLACK);
             
        
        Text polygonText = createText("polygon", 14,
        				  			  polyTest.getLayoutX(),polyTest.getLayoutY() + 80);

        
        Button TrashCan = createButton(20,490,"../img/TrashCan.png");

        gr2.getChildren().add(rect2);
        gr2.getChildren().add(rectTest);
        gr2.getChildren().add(polyTest);
        gr2.getChildren().add(polygonText);
        gr2.getChildren().add(TrashCan);
        root.getChildren().add(gr2);

    }
	
	//********************CREATION GRAPHICAL OBJECTS*******************************//
	
	//BOUTON
	Button createButton(int layoutX, int layoutY, String cheminImage){
		Button button = new Button();
		button.setLayoutX(layoutX);
		button.setLayoutY(layoutY);
		Image buttonImg = new Image(getClass().getResourceAsStream(cheminImage));
        ImageView iV = new ImageView(buttonImg);
        iV.setFitHeight(20);
        iV.setFitWidth(20);
        button.setGraphic(iV);
		return button;
	}
	
	//TEXT
	Text createText(String text, int font, double layoutX, double layoutY){
		Text t = new Text(text);
		t.setFont(new Font(font));
		t.setLayoutX(layoutX);
		t.setLayoutY(layoutY);
		return t;
	}
	
	//POLYGON
	Polygon createPolygon(Double[] tabDouble, double layoutX, double layoutY,  Color fill, Color stroke){
		Polygon poly = new Polygon();
		poly.getPoints().addAll(tabDouble);
        poly.setLayoutX(layoutX);
        poly.setLayoutY(layoutY); 
        poly.setFill(fill);
        poly.setStroke(stroke);
        return poly;
	}
	
	//RECTANGLE
	Rectangle createRectangle(double x, double y, double width, double height, double arcWidth,
			double arcHeight , Color fill, Color stroke, EventHandler<MouseEvent> pressed,
			EventHandler<MouseEvent> dragged, boolean transp){
		Rectangle rectTest = new Rectangle();
		rectTest.setX(x);
        rectTest.setY(y);
        rectTest.setWidth(width);
        rectTest.setHeight(height);
        rectTest.setArcWidth(arcWidth);
        rectTest.setArcHeight(arcHeight);
        rectTest.setFill(fill);
        rectTest.setStroke(stroke);
        rectTest.setMouseTransparent(transp);
        rectTest.setOnMousePressed(pressed);
        rectTest.setOnMouseDragged(dragged);
		return rectTest;
	}
	
	//GROUP
	Group createGroup(double x, double y){
		Group gr = new Group();
		gr.setLayoutX(x);
		gr.setLayoutY(y);
		return gr;
	}
}
