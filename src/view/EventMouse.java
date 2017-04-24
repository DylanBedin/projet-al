package view;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EventMouse {
	private static ArrayList<Shape> listShapes = new ArrayList<>();

	static final double GLOBAL_LAYOUT_Xmin_WHITEBOARD = 85;
	static final double GLOBAL_LAYOUT_Ymin_WHITEBOARD = 20;
	static final double GLOBAL_LAYOUT_Xmax_WHITEBOARD = GLOBAL_LAYOUT_Xmin_WHITEBOARD + 400;
	static final double GLOBAL_LAYOUT_Ymax_WHITEBOARD = GLOBAL_LAYOUT_Ymin_WHITEBOARD + 510;
	static final double GLOBAL_LAYOUT_Xmin_BUTTONTRASH = View.LAYOUT_X_GROUP2 + 20;
	static final double GLOBAL_LAYOUT_Ymin_BUTTONTRASH = View.LAYOUT_Y_GROUP2 + 490;
	static final double GLOBAL_LAYOUT_Xmax_BUTTONTRASH = GLOBAL_LAYOUT_Xmin_BUTTONTRASH + 40;
	static final double GLOBAL_LAYOUT_Ymax_BUTTONTRASH = GLOBAL_LAYOUT_Ymin_BUTTONTRASH + 30;


	static public void checkPosition(Shape s){
		boolean existInList = false;
		if(s instanceof Rectangle){
			Rectangle rect = (Rectangle) s;		
			for(Shape shape:listShapes){
				if(shape == rect){
					existInList = true;
				}
			}
//			if(rect instanceof Shape &&
//					rect.getX() <= GLOBAL_LAYOUT_Xmin_BUTTONTRASH &&
//					rect.getY() <= GLOBAL_LAYOUT_Ymin_BUTTONTRASH &&
//					rect.getX() >= GLOBAL_LAYOUT_Xmax_BUTTONTRASH &&
//					rect.getY() >= GLOBAL_LAYOUT_Ymax_BUTTONTRASH){
				System.out.println("papoubelle");
				if (rect.getX() < GLOBAL_LAYOUT_Xmin_WHITEBOARD){
					rect.setX(GLOBAL_LAYOUT_Xmin_WHITEBOARD);
				}
				if (rect.getY() < GLOBAL_LAYOUT_Ymin_WHITEBOARD){
					rect.setY(GLOBAL_LAYOUT_Ymin_WHITEBOARD);
				}
				if (rect.getX() +  rect.getWidth() > GLOBAL_LAYOUT_Xmax_WHITEBOARD){
					rect.setX(GLOBAL_LAYOUT_Xmax_WHITEBOARD - rect.getWidth());
				}
				if (rect.getY() +  rect.getHeight() > GLOBAL_LAYOUT_Ymax_WHITEBOARD){
					rect.setY(GLOBAL_LAYOUT_Ymax_WHITEBOARD - rect.getHeight());
				}
				if ( rect.getX() < GLOBAL_LAYOUT_Xmin_WHITEBOARD || 
						rect.getY() < GLOBAL_LAYOUT_Ymin_WHITEBOARD ||
						rect.getX() +  rect.getWidth() > GLOBAL_LAYOUT_Xmax_WHITEBOARD ||
						rect.getY() +  rect.getHeight() > GLOBAL_LAYOUT_Ymax_WHITEBOARD){

					rect.setVisible(false);
				}
				if(!existInList){
					listShapes.add(rect);
					View.controller.addRectangleToWhiteboard(rect);	
				}
//			}
		}

		if(s instanceof Polygon){
			Polygon poly = (Polygon) s;

			if ( poly.getLayoutX() < GLOBAL_LAYOUT_Xmin_WHITEBOARD)
				poly.setLayoutX(GLOBAL_LAYOUT_Xmin_WHITEBOARD);

			if ( poly.getLayoutY() < GLOBAL_LAYOUT_Ymin_WHITEBOARD)
				poly.setLayoutY(GLOBAL_LAYOUT_Ymin_WHITEBOARD);

			if (poly.getLayoutX() + getMaxX(poly.getPoints()) > GLOBAL_LAYOUT_Xmax_WHITEBOARD)
				poly.setLayoutX(GLOBAL_LAYOUT_Xmax_WHITEBOARD - getMaxX(poly.getPoints()));

			if (poly.getLayoutY() + getMaxY(poly.getPoints()) > GLOBAL_LAYOUT_Ymax_WHITEBOARD)
				poly.setLayoutY(GLOBAL_LAYOUT_Ymax_WHITEBOARD - getMaxY(poly.getPoints()));

			if ( poly.getLayoutX() < GLOBAL_LAYOUT_Xmin_WHITEBOARD || 
					poly.getLayoutY() < GLOBAL_LAYOUT_Ymin_WHITEBOARD ||
					poly.getLayoutX() + getMaxX(poly.getPoints()) > GLOBAL_LAYOUT_Xmax_WHITEBOARD ||
					poly.getLayoutY() + getMaxY(poly.getPoints()) > GLOBAL_LAYOUT_Ymax_WHITEBOARD){

				poly.setVisible(false);
			}
			for(Shape shape:listShapes){
				if(shape == poly){
					existInList = true;
				}
			}
			if(!existInList){
				listShapes.add(poly);
				View.controller.addPolygonToWhiteboard(poly);	
			}
		}
		for(Shape shape:listShapes){
			System.out.println(shape);
		}
	}





	static private double getMaxX(ObservableList<Double> tab ) {
		Iterator<Double> i = tab.iterator();
		double max = 0;
		while(i.hasNext()){
			double a = i.next();
			if ( a > max ){
				max = a;
				i.next();
			}
		}
		return max;
	}

	static private double getMaxY(ObservableList<Double> tab ) {
		Iterator<Double> i = tab.iterator();
		double max = 0;
		i.next();
		while(i.hasNext()){
			double a = i.next();
			if ( a > max ){
				max = a;
				i.next();
			}
		}
		return max;
	}




	/***********************************************************************************/
	/*************************Deplacement et changement de couleur d'un shape*************************/
	/***********************************************************************************/
	private static double orgSceneX, orgSceneY;
	private static double orgTranslateX, orgTranslateY;
	private static double newTranslateX, newTranslateY;
	/***********************************************************************************/


	static EventHandler<MouseEvent> OnMousePressedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(final MouseEvent t) {
			if (t.getButton() == MouseButton.PRIMARY){
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();				

				if(t.getSource() instanceof Rectangle){
					orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
					orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
					((Rectangle)(t.getSource())).toFront();
				}
				else if (t.getSource() instanceof Polygon){
					orgTranslateX = ((Polygon)(t.getSource())).getTranslateX();
					orgTranslateY = ((Polygon)(t.getSource())).getTranslateY();
					((Polygon)(t.getSource())).toFront();
				}
			}
			else if(t.getButton() == MouseButton.SECONDARY){
				Stage stagePopUp = new Stage();
				stagePopUp.initModality(Modality.APPLICATION_MODAL);
				stagePopUp.initOwner(View.stage);
				Group root = new Group();
				Scene theScene = new Scene(root, 300, 160);

				//Buttons
				Button red = GraphicalObjects.createButton(2, 5, Color.RED, ((Shape)(t.getSource())));

				Button blue = GraphicalObjects.createButton(22, 5, Color.BLUE, ((Shape)(t.getSource())));

				Button green = GraphicalObjects.createButton(42, 5, Color.GREEN, ((Shape)(t.getSource())));

				Button aqua = GraphicalObjects.createButton(62, 5, Color.AQUA, ((Shape)(t.getSource())));

				Button beige = GraphicalObjects.createButton(82, 5, Color.BEIGE, ((Shape)(t.getSource())));

				Button turquoise = GraphicalObjects.createButton(102, 5, Color.TURQUOISE, ((Shape)(t.getSource())));

				Button brown = GraphicalObjects.createButton(122, 5, Color.BROWN, ((Shape)(t.getSource())));

				Button cyan = GraphicalObjects.createButton(142, 5, Color.CYAN, ((Shape)(t.getSource())));

				Button grey = GraphicalObjects.createButton(162, 5, Color.GRAY, ((Shape)(t.getSource())));

				Button pink = GraphicalObjects.createButton(182, 5, Color.PINK, ((Shape)(t.getSource())));

				Button orange = GraphicalObjects.createButton(202, 5, Color.ORANGE, ((Shape)(t.getSource())));

				Button lGreen = GraphicalObjects.createButton(222, 5, Color.LIGHTGREEN, ((Shape)(t.getSource())));

				Button purple = GraphicalObjects.createButton(242, 5, Color.PURPLE, ((Shape)(t.getSource())));

				Button black = GraphicalObjects.createButton(262, 5, Color.BLACK, ((Shape)(t.getSource())));

				Button white = GraphicalObjects.createButton(282, 5, Color.WHITE, ((Shape)(t.getSource())));

				if (t.getSource() instanceof Rectangle){

					/**/

					Label hauteur = new Label("Hauteur :");
					final TextField textFieldHauteur = new TextField ();
					textFieldHauteur.setMaxWidth(60);
					textFieldHauteur.setText("");
					Label largeur = new Label("Largeur :");
					final TextField textFieldLargeur = new TextField ();
					textFieldLargeur.setMaxWidth(60);
					textFieldLargeur.setText("");

					/**/

					Label centre = new Label("Centre de rotation:");
					final TextField textFieldCentreX = new TextField();
					textFieldCentreX.setMaxWidth(60);
					textFieldCentreX.setText("");
					textFieldCentreX.setPromptText("x");
					final TextField textFieldCentreY = new TextField();
					textFieldCentreY.setMaxWidth(60);
					textFieldCentreY.setText("");
					textFieldCentreY.setPromptText("y");

					/**/

					Label rotation = new Label("Rotation :");
					final TextField textFieldRotation = new TextField ();
					textFieldRotation.setMaxWidth(60);
					textFieldRotation.setText("");
					final Button ok = GraphicalObjects.createButton(0,0,null, null);
					ok.setText("Ok!");
					ok.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent e) {
							if ( textFieldHauteur.getText().trim().isEmpty() == false){
								double res = Double.parseDouble(textFieldHauteur.getText());
								((Rectangle) t.getSource()).setHeight(res);
							}

							if ( textFieldLargeur.getText().trim().isEmpty() == false){
								double res = Double.parseDouble(textFieldLargeur.getText());
								((Rectangle) t.getSource()).setWidth(res);
							}

							if ( textFieldRotation.getText().trim().isEmpty() == false && 
									textFieldCentreX.getText().trim().isEmpty() == false &&
									textFieldCentreY.getText().trim().isEmpty() == false){
								double resR = Double.parseDouble(textFieldRotation.getText());
								double resX = Double.parseDouble(textFieldCentreX.getText());
								double resY = Double.parseDouble(textFieldCentreY.getText());
								((Rectangle) t.getSource()).getTransforms().add(new Rotate(resR, resX, resY));
							}
							checkPosition(((Rectangle) t.getSource()));
							ok.getParent().getScene().getWindow().hide();

						}
					});

					/**/

					HBox hbHauteurLargeur = new HBox();
					hbHauteurLargeur.setLayoutX(2);
					hbHauteurLargeur.setLayoutY(42);
					hbHauteurLargeur.getChildren().add(hauteur);
					hbHauteurLargeur.getChildren().add(textFieldHauteur);
					hbHauteurLargeur.getChildren().add(largeur);
					hbHauteurLargeur.getChildren().add(textFieldLargeur);

					/**/

					HBox hbCentreRotation = new HBox();
					hbCentreRotation.setLayoutX(2);
					hbCentreRotation.setLayoutY(82);
					hbCentreRotation.getChildren().add(centre);
					hbCentreRotation.getChildren().add(textFieldCentreX);
					hbCentreRotation.getChildren().add(textFieldCentreY);

					/**/

					HBox hbRotation = new HBox();
					hbRotation.setLayoutX(2);
					hbRotation.setLayoutY(122);
					hbRotation.getChildren().add(rotation);
					hbRotation.getChildren().add(textFieldRotation);
					hbRotation.getChildren().add(ok);

					root.getChildren().add(hbHauteurLargeur);
					root.getChildren().add(hbCentreRotation);
					root.getChildren().add(hbRotation);

				}

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


	static EventHandler<MouseEvent> OnMouseDraggedEventHandler =
			new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {

			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			newTranslateX = orgTranslateX + offsetX;
			newTranslateY = orgTranslateY + offsetY;


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

	static EventHandler<MouseEvent> OnMousePressedEventHandlerv2 =
			new EventHandler<MouseEvent>(){

		@SuppressWarnings("unused")
		public void handle(MouseEvent t) {
			if (t.getSource() instanceof Rectangle) {
				Shape rect = GraphicalObjects.cloneShape((Shape) t.getSource());
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
				orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
				orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
				((Rectangle)(t.getSource())).setOnMousePressed(OnMousePressedEventHandler);
				((Rectangle)(t.getSource())).setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);
			}
			if (t.getSource() instanceof Polygon) {
				Shape poly = GraphicalObjects.cloneShape((Shape) t.getSource());
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
				orgTranslateX = ((Polygon)(t.getSource())).getTranslateX();
				orgTranslateY = ((Polygon)(t.getSource())).getTranslateY();
				((Polygon)(t.getSource())).setOnMousePressed(OnMousePressedEventHandler);				
				((Polygon)(t.getSource())).setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);


			}
		}
	};
	static EventHandler<MouseEvent> mouseReleasedOnWhiteboardEventHandler =
			new EventHandler<MouseEvent>(){

		public void handle(MouseEvent t){		

			if(t.getSource() instanceof Shape &&
					t.getSceneX() > GLOBAL_LAYOUT_Xmin_BUTTONTRASH &&
					t.getSceneY() > GLOBAL_LAYOUT_Ymin_BUTTONTRASH &&
					t.getSceneX() < GLOBAL_LAYOUT_Xmax_BUTTONTRASH &&
					t.getSceneY() < GLOBAL_LAYOUT_Ymax_BUTTONTRASH){
				listShapes.remove(t.getSource());
				((Shape) t.getSource()).setVisible(false);
			}

			if (t.getSource() instanceof Rectangle){
				((Rectangle)(t.getSource())).setX(((Rectangle)(t.getSource())).getTranslateX() + 
						((Rectangle)(t.getSource())).getX());
				((Rectangle)(t.getSource())).setTranslateX(0);

				((Rectangle)(t.getSource())).setY(((Rectangle)(t.getSource())).getTranslateY() + 
						((Rectangle)(t.getSource())).getY());
				((Rectangle)(t.getSource())).setTranslateY(0);


			}


			if (t.getSource() instanceof Polygon){
				((Polygon)(t.getSource())).setLayoutX((((Polygon)(t.getSource())).getTranslateX() + ((Polygon)(t.getSource())).getLayoutX()));
				((Polygon)(t.getSource())).setTranslateX(0);
				((Polygon)(t.getSource())).setLayoutY(((Polygon)(t.getSource())).getTranslateY() + ((Polygon)(t.getSource())).getLayoutY());
				((Polygon)(t.getSource())).setTranslateY(0);

			}

			checkPosition(((Shape) t.getSource()));

			if (t.getSource() instanceof Rectangle)
				//c.addRectangleToWhiteboard((Rectangle) t.getSource());
				;


		}
	};

	static EventHandler<MouseEvent> buttonTrashReleased =
			new EventHandler<MouseEvent>(){

		public void handle(MouseEvent t){
			if ( t.getSource() instanceof Shape){
				((Shape) t.getSource()).setVisible(false);
			}

		}
	};

}





