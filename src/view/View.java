package view;


import controller.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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
	
	private Stage stage;
	private Rectangle whiteboard;
	

	
	public static void main(String[] args) {
		Application.launch(View.class, args);
	}

	
	public void begin(){
		Application.launch(View.class);
	}
	/****************************************************************************************************************************/
	
	
	public Rectangle getWhiteboard(){
		return this.whiteboard;
	}
	
	//*****************************************************************************//
	//********************CREATION GRAPHICAL OBJECTS*******************************//
	//*****************************************************************************//
	
		//BUTTON
		Button createButton(int layoutX, int layoutY, String cheminImage, Paint color, Shape source){
			Button button = new Button();
			button.setLayoutX(layoutX);
			button.setLayoutY(layoutY);
			if (cheminImage != null){
				Image buttonImg = new Image(getClass().getResourceAsStream(cheminImage));
				ImageView iV = new ImageView(buttonImg);
				iV.setFitHeight(20);
				iV.setFitWidth(20);
				button.setGraphic(iV);
			}
			if (color != null && source != null){
				button.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
                button.setOnAction(new EventHandler<ActionEvent>() {
                	@Override
                	public void handle(ActionEvent e){
                		source.setFill(color);
                		button.getParent().getScene().getWindow().hide();
                	}
                });
			}
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
		Polygon createPolygon(Double[] tabDouble, double layoutX, double layoutY,  Color fill, Color stroke,
				EventHandler<MouseEvent> pressed, EventHandler<MouseEvent> dragged, boolean transp){
			Polygon poly = new Polygon();
			poly.getPoints().addAll(tabDouble);
	        poly.setLayoutX(layoutX);
	        poly.setLayoutY(layoutY); 
	        poly.setFill(fill);
	        poly.setStroke(stroke);
	        poly.setMouseTransparent(transp);
	        poly.setOnMousePressed(pressed);
	        poly.setOnMouseDragged(dragged);
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
		
		
		/***********************************************************************************/
		/**********************************Clone of a shape*********************************/
		/***********************************************************************************/
		
		public Shape cloneShape(Shape s){
			if (s instanceof Rectangle){
				Rectangle rect = createRectangle( 
						LAYOUT_X_RECTANGLE,
						LAYOUT_Y_RECTANGLE,
						((Rectangle) s).getWidth(),
						((Rectangle) s).getHeight(),
						((Rectangle) s).getArcWidth(),
						((Rectangle) s).getArcHeight(),
						(Color) ((Rectangle) s).getFill(),
						(Color) ((Rectangle) s).getStroke(),
						OnMousePressedEventHandlerv2,
						OnMouseDraggedEventHandler,
						false);
				return (Shape) rect;
			}
			
			if (s instanceof Polygon){
				Polygon poly = createPolygon(
						new Double[]{},
						LAYOUT_X_POLYGON,
						LAYOUT_Y_POLYGON,
						(Color) ((Polygon) s).getFill(),
						(Color) ((Polygon) s).getStroke(),
						OnMousePressedEventHandlerv2,
						OnMouseDraggedEventHandler,
						false
						);
				poly.getPoints().addAll( ((Polygon) s).getPoints());
				return (Shape) poly;
			}
			return null;
		}



	
/****************************************************************************************************************************/
	
	
	
	/***********************************************************************************/
	/*************************Deplacement et changement de couleur d'un shape*************************/
	/***********************************************************************************/
	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;
	/***********************************************************************************/
	
	EventHandler<MouseEvent> OnMousePressedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			if (t.getButton() == MouseButton.PRIMARY){
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
				
				if(t.getSource() instanceof Rectangle){
					orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
					orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
				}
				else if (t.getSource() instanceof Polygon){
					orgTranslateX = ((Polygon)(t.getSource())).getTranslateX();
					orgTranslateY = ((Polygon)(t.getSource())).getTranslateY();
				}
			}
			else if(t.getButton() == MouseButton.SECONDARY){
				Stage stagePopUp = new Stage();
                stagePopUp.initModality(Modality.APPLICATION_MODAL);
                stagePopUp.initOwner(stage);
                Group root = new Group();
                Scene theScene = new Scene(root, 300, 30);
                
                //Buttons
                Button red = createButton(2, 5, null, Color.RED, ((Shape)(t.getSource())));
                
                Button blue = createButton(22, 5, null, Color.BLUE, ((Shape)(t.getSource())));

                Button green = createButton(42, 5, null, Color.GREEN, ((Shape)(t.getSource())));

                Button aqua = createButton(62, 5, null, Color.AQUA, ((Shape)(t.getSource())));
                
                Button beige = createButton(82, 5, null, Color.BEIGE, ((Shape)(t.getSource())));
                
                Button turquoise = createButton(102, 5, null, Color.TURQUOISE, ((Shape)(t.getSource())));
                
                Button brown = createButton(122, 5, null, Color.BROWN, ((Shape)(t.getSource())));
                
                Button cyan = createButton(142, 5, null, Color.CYAN, ((Shape)(t.getSource())));
                
                Button grey = createButton(162, 5, null, Color.GRAY, ((Shape)(t.getSource())));
                
                Button pink = createButton(182, 5, null, Color.PINK, ((Shape)(t.getSource())));
                
                Button orange = createButton(202, 5, null, Color.ORANGE, ((Shape)(t.getSource())));
                
                Button lGreen = createButton(222, 5, null, Color.LIGHTGREEN, ((Shape)(t.getSource())));
                
                Button purple = createButton(242, 5, null, Color.PURPLE, ((Shape)(t.getSource())));
                               
                Button black = createButton(262, 5, null, Color.BLACK, ((Shape)(t.getSource())));
                
                Button white = createButton(282, 5, null, Color.WHITE, ((Shape)(t.getSource())));
                
                root.getChildren().add(red);
                root.getChildren().add(blue);
                root.getChildren().add(green);
                root.getChildren().add(aqua);
                root.getChildren().add(beige);
                root.getChildren().add(black);
                root.getChildren().add(brown);
                root.getChildren().add(cyan);
                root.getChildren().add(grey);
                root.getChildren().add(pink);
                root.getChildren().add(orange);
                root.getChildren().add(lGreen);
                root.getChildren().add(purple);
                root.getChildren().add(turquoise);
                root.getChildren().add(white);
                
                stagePopUp.setScene(theScene);
                stagePopUp.show();
			}
		}
	};
	
	EventHandler<MouseEvent> OnMouseDraggedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			
			if(t.getSource() instanceof Rectangle){
				((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
				((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
			}
			else if (t.getSource() instanceof Polygon){
				((Polygon)(t.getSource())).setTranslateX(newTranslateX);
				((Polygon)(t.getSource())).setTranslateY(newTranslateY);
			}
		}
	};
	
	/***********************************************************************************/
	/*********************Copie et Deplacement simple d'un rectangle********************/
	/***********************************************************************************/
	
	
	EventHandler<MouseEvent> OnMousePressedEventHandlerv2 =
			new EventHandler<MouseEvent>(){

		public void handle(MouseEvent t) {
			if (t.getSource() instanceof Rectangle) {
				Shape rect = cloneShape((Shape) t.getSource());
				Group n = (Group) ((Rectangle) t.getSource()).getParent();
				n.getChildren().add(rect);
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
				orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
				orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
				((Rectangle)(t.getSource())).setOnMousePressed(OnMousePressedEventHandler);
				((Rectangle)(t.getSource())).setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);
			}
			if (t.getSource() instanceof Polygon) {
				Shape poly = cloneShape((Shape) t.getSource());
				Group n = (Group) ((Polygon) t.getSource()).getParent();
				n.getChildren().add(poly);
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
				orgTranslateX = ((Polygon)(t.getSource())).getTranslateX();
				orgTranslateY = ((Polygon)(t.getSource())).getTranslateY();
				((Polygon)(t.getSource())).setOnMousePressed(OnMousePressedEventHandler);				
				((Polygon)(t.getSource())).setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);

			}
		}
	};
	
	EventHandler<MouseEvent> mouseReleasedOnWhiteboardEventHandler =
			new EventHandler<MouseEvent>(){
		
		public void handle(MouseEvent t){
			
			if (t.getSceneX() < LAYOUT_X_WHITEBOARD || t.getSceneY() < LAYOUT_Y_WHITEBOARD){
				((Shape) t.getSource()).setVisible(false);
			}
			else{
				//Appel au controleur
				c.addShapeToWhiteboard((Shape) t.getSource());
			}
		}
	};
	
	

	
/****************************************************************************************************************************/

	
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
                
        Button btnUndo = createButton(145,15,"../img/Undo.png", null, null);
                        
        Button btnRedo = createButton(200,15,"../img/Redo.png", null, null);
       
        
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
        
        Group gr3 = createGroup(LAYOUT_X_WHITEBOARD,LAYOUT_Y_WHITEBOARD);
                
        whiteboard = createRectangle(0,0,400,510,0,0,Color.WHITE,Color.BLACK, null, null, true);

        gr3.getChildren().add(whiteboard);
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
        
        Rectangle rect = createRectangle(rect2.getX() + 10, rect2.getY() + 10, 50, 50, 0, 0,
        		Color.BLUE, Color.BLACK, OnMousePressedEventHandlerv2, 
        		OnMouseDraggedEventHandler, false);
        
        rect.setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);

        Double[] tab = new Double[]{
        		30.0, 0.0,
        		60.0, 30.0,
        		45.0, 60.0,
        		15.0, 60.0,
        		00.0, 30.0
        };
        
        Polygon poly = createPolygon(tab, rect2.getX() + 5, rect.getY() + rect.getHeight() + 10, Color.BLACK, 
        		Color.BLACK, OnMousePressedEventHandlerv2, OnMouseDraggedEventHandler, false);
        

        
        Button TrashCan = createButton(20,490,"../img/TrashCan.png", null, null);

        gr2.getChildren().add(rect2);
        gr2.getChildren().add(rect);
        gr2.getChildren().add(poly);
        gr2.getChildren().add(TrashCan);
        root.getChildren().add(gr2);

    }
	
	
}







