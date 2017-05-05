package view;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.tools.Tool;

import controller.MouseEvents;

import main.Main;
import model.IShape;
import model.Model;
import model.ShapeRectangle;
import model.ShapeRegularPolygon;
import model.Toolbar;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class View extends Application implements Observer{
	
	protected static final double LAYOUT_X_GROUP2 = 5;
	protected static final double LAYOUT_Y_GROUP2 = 50;

			
	static Stage stage;
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
	private Model m;
	private MouseEvents mouseEvents;
	private Group gr2 = null;
	@SuppressWarnings("static-access")
	@Override
    public void start(Stage primaryStage) {
		this.stage = primaryStage;
        primaryStage.setTitle("Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 600, Color.WHITE);
        this.m = Main.m;
        this.m.addObserver(this);
        this.mouseEvents = new MouseEvents();
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
                
        /**	static Rectangle whiteboard;

         * TODO img Load
         */
        Button btnLoad = new Button();
        btnLoad.setLayoutX(85);
        btnLoad.setLayoutY(15);
        btnLoad.setText("Load");
                
        Button btnUndo = GraphicalObjects.createButton(145,15, null, null);
        Image buttonImg = new Image(getClass().getResourceAsStream("./../img/Undo.png"));
		ImageView iV = new ImageView(buttonImg);
		iV.setFitHeight(20);
		iV.setFitWidth(20);
		btnUndo.setGraphic(iV);
                        
        Button btnRedo = GraphicalObjects.createButton(200,15, null, null);
        Image buttonImg2 = new Image(getClass().getResourceAsStream("./../img/Redo.png"));
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
         * DEUXIEME GROUPE: Toolbar
         */
        
        gr2 = GraphicalObjects.createGroup( Model.getInstance().getLayoutGroup2X(), Model.getInstance().getLayoutGroup2Y());
      
        this.m.getToolbar();
        this.m.getWhiteboard();

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

        
//        originRect.setOnMouseReleased(EventMouse.mouseReleasedOnWhiteboardEventHandler);
        

        
        

//        Button TrashCan = GraphicalObjects.createButton(20,490, null, null);
//        Image buttonImg3 = new Image(getClass().getResourceAsStream("./../img/TrashCan.png"));
//		ImageView iV3 = new ImageView(buttonImg3);
//		iV3.setFitHeight(20);
//		iV3.setFitWidth(20);
//		TrashCan.setGraphic(iV3);


		
		//Sélection de formes
//		whiteboard.addEventHandler(MouseEvent.MOUSE_PRESSED, EventMouse.buttonPressedOnWhiteboardForSelection);
//		whiteboard.addEventHandler(MouseEvent.MOUSE_RELEASED, EventMouse.buttonReleasedOnWhiteboardForSelection);
//		
		root.getChildren().add(gr2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	private Rectangle toolbar, whiteboard;
	
	public void createToolbar(Toolbar toolbar){
		Color stroke = new Color(toolbar.getStroke().getRed()/255, toolbar.getStroke().getGreen()/255, 
				toolbar.getStroke().getBlue()/255, 1);
		Color fill = new Color(toolbar.getFill().getRed()/255, toolbar.getFill().getGreen()/255,
				toolbar.getFill().getBlue()/255, 1);
		this.toolbar = GraphicalObjects.createRectangle(toolbar.getPosition().getX(), 
				toolbar.getPosition().getY(), 
				toolbar.getWidth(), 
				toolbar.getHeight(), 
				toolbar.getArcWidth(), 
				toolbar.getArcHeight(), 
				fill, 
				stroke, 
				null, null, true);
		gr2.getChildren().add(this.toolbar);


		ShapeRectangle shapeRect = (ShapeRectangle) toolbar.getShape(0);
		Color fillShape = new Color(shapeRect.getFill().getRed()/255, shapeRect.getFill().getGreen()/255,
				shapeRect.getFill().getBlue()/255, 1);
		this.originRect = GraphicalObjects.createRectangle(
				shapeRect.getPosition().getX(), shapeRect.getPosition().getY(), 
				shapeRect.getWidth(), shapeRect.getHeight(), 
        		shapeRect.getArcWidth(), shapeRect.getArcHeight(),
        		fillShape, stroke, 
        		null, 
        		null, 
        		false);
		this.originRect.setUserData(Toolbar.getInstance().listShapes.get(0));
        gr2.getChildren().add(this.originRect);
        
        ShapeRegularPolygon shapePoly = (ShapeRegularPolygon) toolbar.getShape(1);
        this.originPoly = GraphicalObjects.createPolygon(shapePoly.getTab(), 
        		shapePoly.getPosition().getX(), shapePoly.getPosition().getY(), 
        		fillShape, stroke, 
        		null, 
        		null, 
        		false);
        gr2.getChildren().add(this.originPoly);
             
        
        Button TrashCan = GraphicalObjects.createButton(Toolbar.getInstance().getTrashcanX(), 
        												Toolbar.getInstance().getTrashcanY(), null, null);
        Image buttonImg3 = new Image(getClass().getResourceAsStream("./../img/TrashCan.png"));
		ImageView iV3 = new ImageView(buttonImg3);
		iV3.setFitHeight(Toolbar.getInstance().getTrashcanHeight());
		iV3.setFitWidth(Toolbar.getInstance().getTrashcanWidth());
		TrashCan.setGraphic(iV3);
		gr2.getChildren().add(TrashCan);
		this.listShapes = new ArrayList<Shape>();
		
	}
	
	
	public void createWhiteboard(Whiteboard whiteboard){
		Color stroke = new Color(whiteboard.getStroke().getRed()/255, whiteboard.getStroke().getGreen()/255, 
				whiteboard.getStroke().getBlue()/255, 1);
		Color fill = new Color(whiteboard.getFill().getRed()/255, whiteboard.getFill().getGreen()/255,
				whiteboard.getFill().getBlue()/255, 1);
		this.whiteboard = GraphicalObjects.createRectangle(whiteboard.getPosition().getX(), 
				whiteboard.getPosition().getY(), 
				whiteboard.getWidth(), whiteboard.getHeight(), 
				whiteboard.getArcWidth(), whiteboard.getArcHeight(), 
				fill, stroke, 
				null, null, true);
		gr2.getChildren().add(this.whiteboard);
	}

	
	private ArrayList<Shape> listShapes;
	
	public void createNewShape(IShape shape){
		Color stroke = new Color(shape.getStroke().getRed()/255, shape.getStroke().getGreen()/255, 
				shape.getStroke().getBlue()/255, 1);
		Color fill = new Color(shape.getFill().getRed()/255, shape.getFill().getGreen()/255,
				shape.getFill().getBlue()/255, 1);
		if(shape instanceof ShapeRectangle){
			Rectangle r = GraphicalObjects.createRectangle(shape.getPosition().getX(), shape.getPosition().getY(),
					((ShapeRectangle) shape).getWidth(),
					((ShapeRectangle) shape).getHeight(),
					((ShapeRectangle) shape).getArcWidth(),
					((ShapeRectangle) shape).getArcHeight(),
					Color.PINK,
					stroke,
					null, null,
					false);
			r.setUserData(shape);
			Group g = (Group) this.whiteboard.getParent();
			g.getChildren().add(r);
			this.listShapes.add(r);
			shape.setOriginalShape(false);
			r.addEventHandler(MouseEvent.MOUSE_DRAGGED, this.mouseEvents.OnMouseDraggedEventHandler);
			r.setOnMousePressed(this.mouseEvents.OnMousePressed);
			r.setOnMouseReleased(this.mouseEvents.OnMouseReleasedTranslationEventHandler);
		}
		else{
			if(shape instanceof ShapeRegularPolygon){
				ShapeRegularPolygon srp = (ShapeRegularPolygon) shape;
				Shape s = GraphicalObjects.createPolygon(((ShapeRegularPolygon) shape).getTab(),
						srp.getPosition().getX(),
						srp.getPosition().getY(),
						Color.PINK,
						stroke,
						null, null,
						false);
				s.setUserData(shape);
				Group g = (Group) this.whiteboard.getParent();
				g.getChildren().add(s);
				shape.setOriginalShape(false);
				s.setOnMousePressed(this.mouseEvents.OnMousePressed);
				s.setOnMouseDragged(this.mouseEvents.OnMouseDraggedEventHandler);
			}
		}
	}

	public void majShape(IShape shape){
		for(Shape s:this.listShapes){
			if(s.getUserData().equals(shape)){
				s.setTranslateX(shape.getTranslationX());
				s.setTranslateY(shape.getTranslationY());
				s.setLayoutX(shape.getPosition().getX());
				s.setLayoutY(shape.getPosition().getY());
				if(s instanceof Rectangle){
					Rectangle r = (Rectangle) s;
					r.setX(0);
					r.setY(0);
				}
			}
		}
	}
	
	public void majList(IShape ishape){
		List<Shape> copyList = (List<Shape>) this.listShapes.clone();
		for(Shape s:copyList){
			if(s.getUserData() instanceof ShapeRectangle){
				if(s.getUserData() == ishape){
					this.listShapes.remove(s);
					s.setVisible(false);
				}
			}
		}
	}
	
	private static double orgSceneX, orgSceneY;
	@Override 
	public void update(Observable arg0, Object arg1) {
		if(arg1 instanceof Toolbar){
			createToolbar((Toolbar) arg1);
			this.originRect.addEventHandler(MouseEvent.MOUSE_PRESSED, this.mouseEvents.OnMousePressedClone);
			this.originPoly.addEventHandler(MouseEvent.MOUSE_PRESSED, this.mouseEvents.OnMousePressedClone);
		}
		else{
			if(arg1 instanceof Whiteboard){
				createWhiteboard((Whiteboard) arg1);
			}
			else{//liste d'IShape
				if(arg1 instanceof ShapeRectangle){
					ShapeRectangle shapeRect = (ShapeRectangle) arg1;
					if(shapeRect.isOriginalShape()){
						if(Toolbar.getInstance().isShapeIn((shapeRect))){
							createNewShape(shapeRect);		
						}
					}
					else{
						majShape(shapeRect);
						if(Toolbar.getInstance().isInTrashcan(shapeRect)){
							majList(shapeRect);
						}
					}
				}
			}
		}
	}
	
	public static Color createWindow(MouseEvent m){
		Stage stagePopUp = new Stage();
		stagePopUp.initModality(Modality.APPLICATION_MODAL);
		stagePopUp.initOwner(View.stage);
		Group root = new Group();
		Scene theScene = new Scene(root, 300, 160);
		stagePopUp.setScene(theScene);
		stagePopUp.show();
		return Color.BLACK;
	}
//    gr2.getChildren().add(whiteboard);
//		}
//		if(arg1 instanceof ShapeRectangle){
//			ShapeRectangle shapeRect = (ShapeRectangle) arg1;
//			System.out.println(arg0);
//			Shape rect = GraphicalObjects.cloneShape(originRect);
//			orgSceneX = shapeRect.getPosition().getX();
//			orgSceneY = shapeRect.getPosition().getY();
//		}
//	}
}







