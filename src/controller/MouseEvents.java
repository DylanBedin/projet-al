package controller;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import model.IShape;
import model.Model;
import model.ShapeRectangle;
import model.Toolbar;
import model.Whiteboard;

public class MouseEvents {
	static final double GLOBAL_LAYOUT_Xmin_WHITEBOARD = 85;
	static final double GLOBAL_LAYOUT_Ymin_WHITEBOARD = 20;
	static final double GLOBAL_LAYOUT_Xmax_WHITEBOARD = GLOBAL_LAYOUT_Xmin_WHITEBOARD + 400;
	static final double GLOBAL_LAYOUT_Ymax_WHITEBOARD = GLOBAL_LAYOUT_Ymin_WHITEBOARD + 510;
	static final double GLOBAL_LAYOUT_Xmin_BUTTONTRASH = 25;
	static final double GLOBAL_LAYOUT_Ymin_BUTTONTRASH = 510;
	static final double GLOBAL_LAYOUT_Xmax_BUTTONTRASH = 125;
	static final double GLOBAL_LAYOUT_Ymax_BUTTONTRASH = 50;
//
//
//	static public void checkPosition(Shape s, MouseEvent t){
//		boolean existInList = false;
//		if(t.getSceneX() <= GLOBAL_LAYOUT_Xmin_BUTTONTRASH ||
//				t.getSceneY() <= GLOBAL_LAYOUT_Ymin_BUTTONTRASH ||
//				t.getSceneX() >= GLOBAL_LAYOUT_Xmax_BUTTONTRASH ||
//				t.getSceneY() >= GLOBAL_LAYOUT_Ymax_BUTTONTRASH){
//			if(s instanceof Rectangle){
//				Rectangle rect = (Rectangle) s;	
//				ShapeRectangle shapeRect = new ShapeRectangle(((Rectangle)s).getWidth(), 
//						((Rectangle)s).getHeight(), rect.)
//						if (rect.getLayoutX() < GLOBAL_LAYOUT_Xmin_WHITEBOARD){
//							rect.setLayoutX(GLOBAL_LAYOUT_Xmin_WHITEBOARD);
//						}
//				if (rect.getLayoutY() < GLOBAL_LAYOUT_Ymin_WHITEBOARD){
//					rect.setLayoutY(GLOBAL_LAYOUT_Ymin_WHITEBOARD);
//				}
//				if (rect.getLayoutX() +  rect.getWidth() > GLOBAL_LAYOUT_Xmax_WHITEBOARD){
//					rect.setLayoutX(GLOBAL_LAYOUT_Xmax_WHITEBOARD - rect.getWidth());
//				}
//				if (rect.getLayoutY() +  rect.getHeight() > GLOBAL_LAYOUT_Ymax_WHITEBOARD){
//					rect.setLayoutY(GLOBAL_LAYOUT_Ymax_WHITEBOARD - rect.getHeight());
//				}
//				if ( rect.getLayoutX() < GLOBAL_LAYOUT_Xmin_WHITEBOARD || 
//						rect.getLayoutY() < GLOBAL_LAYOUT_Ymin_WHITEBOARD ||
//						rect.getLayoutX() +  rect.getWidth() > GLOBAL_LAYOUT_Xmax_WHITEBOARD ||
//						rect.getLayoutY() +  rect.getHeight() > GLOBAL_LAYOUT_Ymax_WHITEBOARD){
//
//					rect.setVisible(false);
//				}
//				if(rect.getLayoutX() >= GLOBAL_LAYOUT_Xmin_WHITEBOARD &&
//						rect.getLayoutX() <= GLOBAL_LAYOUT_Xmax_WHITEBOARD &&
//						rect.getLayoutY() >= GLOBAL_LAYOUT_Ymin_WHITEBOARD &&
//						rect.getLayoutY() <= GLOBAL_LAYOUT_Ymax_WHITEBOARD){
//					for(Shape shape:listShapes){
//						if(shape == rect){
//							existInList = true;
//						}
//					}
//					if(!existInList){
//						listShapes.add(rect);
//						View.controller.addRectangleToWhiteboard(rect);	
//					}
//					existInList = false;
//				}
//			}
//			if(s instanceof Polygon){
//				Polygon poly = (Polygon) s;
//
//				if ( checkPositionPoints(GLOBAL_LAYOUT_Xmin_WHITEBOARD, "x", poly, "min") )
//					poly.setLayoutX(GLOBAL_LAYOUT_Xmin_WHITEBOARD +12);
//
//				if ( checkPositionPoints(GLOBAL_LAYOUT_Ymin_WHITEBOARD, "y", poly, "min"))
//					poly.setLayoutY(GLOBAL_LAYOUT_Ymin_WHITEBOARD +15);
//
//				if (checkPositionPoints(GLOBAL_LAYOUT_Xmax_WHITEBOARD, "x", poly, "max"))
//					poly.setLayoutX(GLOBAL_LAYOUT_Xmax_WHITEBOARD - getMaxX(poly.getPoints()));
//
//				if (checkPositionPoints(GLOBAL_LAYOUT_Ymax_WHITEBOARD, "y", poly, "max"))
//					poly.setLayoutY(GLOBAL_LAYOUT_Ymax_WHITEBOARD - getMaxY(poly.getPoints()));
//
//
//				if ( checkPositionPoints(GLOBAL_LAYOUT_Xmin_WHITEBOARD, "x", poly, "min") || 
//						checkPositionPoints(GLOBAL_LAYOUT_Ymin_WHITEBOARD, "y", poly, "min") ||
//						checkPositionPoints(GLOBAL_LAYOUT_Xmax_WHITEBOARD, "x", poly, "max") ||
//						checkPositionPoints(GLOBAL_LAYOUT_Ymax_WHITEBOARD, "y", poly, "max")){
//					poly.setVisible(false);
//				}
//
//				for(Shape shape:listShapes){
//					if(shape == poly){
//						existInList = true;
//					}
//				}
//				if(!existInList){
//					listShapes.add(poly);
//					View.controller.addPolygonToWhiteboard(poly);	
//				}
//				if(poly.getLayoutX() >= GLOBAL_LAYOUT_Xmin_WHITEBOARD &&
//						poly.getLayoutX() <= GLOBAL_LAYOUT_Xmax_WHITEBOARD &&
//						poly.getLayoutY() >= GLOBAL_LAYOUT_Ymin_WHITEBOARD &&
//						poly.getLayoutY() <= GLOBAL_LAYOUT_Ymax_WHITEBOARD){
//					for(Shape shape:listShapes){
//						if(shape == poly){
//							existInList = true;
//						}
//					}
//					if(!existInList){
//						listShapes.add(poly);
//						View.controller.addPolygonToWhiteboard(poly);	
//					}
//					existInList = false;
//				}
//			}
//		}
//	}
//
//	static private boolean checkPositionPoints(double limite, String xy, Polygon s, String maxmin){
//		Double[] tab = toTab(s.getPoints().toArray());
//		int i;
//		double layoutPos = 0;
//		if(xy.compareTo("x") == 0){
//			i=0;public
//			layoutPos = s.getLayoutX();
//		}
//		else{
//			i=1;
//			layoutPos = s.getLayoutY();
//		}
//		while(i < tab.length){
//
//			if(maxmin.compareTo("max") == 0){
//				if(tab[i] + layoutPos> limite){
//					return true;
//				}
//			}
//			else{
//				if(tab[i] + layoutPos < limite){
//					return true;
//				}
//			}
//			i = i + 2;
//		}
//		return false;
//	}	
//
//
//
//	static private double getMaxX(ObservableList<Double> tab ) {
//		Iterator<Double> i = tab.iterator();
//		double max = 0;
//		while(i.hasNext()){
//			double a = i.next();
//			if ( a > max ){
//				max = a;
//				i.next();
//			}
//		}
//		return max;
//	}
//
//	static private double getMaxY(ObservableList<Double> tab ) {
//		Iterator<Double> i = tab.iterator();
//		double max = 0;
//		i.next();
//		while(i.hasNext()){
//			double a = i.next();
//			if ( a > max ){
//				max = a;
//				i.next();
//			}
//		}
//		return max;
//	}
//
//	static private Double[] transTab(int vertices, double r){
//		double centerX = r/2;
//		double centerY = r/2;
//		Double[] tab = new Double[vertices*2];
//		double verticeX = centerX;
//		double verticeY = centerY;
//		double angleToAdd = (2 * Math.PI) / vertices;
//		double angle = 0;
//		for(int i = 0; i<vertices;i++){			
//			verticeX = centerX + r*Math.sin(angle);
//			verticeY = centerY + r*Math.cos(angle);
//			tab[2*i] = verticeX;
//			tab[(2*i)+1] = verticeY;
//			angle = angle + angleToAdd;
//		}
//		return tab;
//	}
//
//	static private double barycentreX(Double[] tab){
//		double res = 0;
//		for(int i =0; i<tab.length; i= i+2){
//			res += tab[i];
//		}
//		return res / (tab.length /2) ;
//	}
//
//	static private double barycentreY(Double[] tab){
//		double res = 0;
//		for(int i =1; i<tab.length; i= i+2){
//			res += tab[i];
//		}
//		return res / (tab.length /2) ;
//	}
//
//
//	static private Double [] toTab( Object[] o){
//		Double [] tab = new Double[o.length];
//		for(int i = 0; i< o.length; i++){
//			tab[i] = (Double) o[i];
//		}
//		return tab;
//	}
//
//	/***********************************************************************************/
//	/*************************Deplacement et changement de couleur d'un shape*************************/
//	/***********************************************************************************/
	private static double orgSceneX, orgSceneY;
	private static double newTranslateX, newTranslateY;
//	/***********************************************************************************/
//
//	static EventHandler<MouseEvent> OnMousePressedWhiteboard =
//			new EventHandler<MouseEvent>() {
//
//		@Override
//		public void handle(final MouseEvent t) {
//			if (t.getButton() == MouseButton.PRIMARY){
//				orgSceneX = t.getSceneX();
//				orgSceneY = t.getSceneY();				
//				if(t.getSource() instanceof Shape){
//					((Shape) t.getSource()).toFront();
//				}
//			}
//			if(t.getButton() == MouseButton.SECONDARY){
//				Stage stagePopUp = new Stage();
//				stagePopUp.initModality(Modality.APPLICATION_MODAL);
//				stagePopUp.initOwner(View.stage);
//				Group root = new Group();
//				Scene theScene = new Scene(root, 300, 160);
//
//				//Buttons
//				Button red = GraphicalObjects.createButton(2, 5, Color.RED, ((Shape)(t.getSource())));
//
//				Button blue = GraphicalObjects.createButton(22, 5, Color.BLUE, ((Shape)(t.getSource())));
//
//				Button green = GraphicalObjects.createButton(42, 5, Color.GREEN, ((Shape)(t.getSource())));
//
//				Button aqua = GraphicalObjects.createButton(62, 5, Color.AQUA, ((Shape)(t.getSource())));
//
//				Button beige = GraphicalObjects.createButton(82, 5, Color.BEIGE, ((Shape)(t.getSource())));
//
//				Button turquoise = GraphicalObjects.createButton(102, 5, Color.TURQUOISE, ((Shape)(t.getSource())));
//
//				Button brown = GraphicalObjects.createButton(122, 5, Color.BROWN, ((Shape)(t.getSource())));
//
//				Button cyan = GraphicalObjects.createButton(142, 5, Color.CYAN, ((Shape)(t.getSource())));
//
//				Button grey = GraphicalObjects.createButton(162, 5, Color.GRAY, ((Shape)(t.getSource())));
//
//				Button pink = GraphicalObjects.createButton(182, 5, Color.PINK, ((Shape)(t.getSource())));
//
//				Button orange = GraphicalObjects.createButton(202, 5, Color.ORANGE, ((Shape)(t.getSource())));
//
//				Button lGreen = GraphicalObjects.createButton(222, 5, Color.LIGHTGREEN, ((Shape)(t.getSource())));
//
//				Button purple = GraphicalObjects.createButton(242, 5, Color.PURPLE, ((Shape)(t.getSource())));
//
//				Button black = GraphicalObjects.createButton(262, 5, Color.BLACK, ((Shape)(t.getSource())));
//
//				Button white = GraphicalObjects.createButton(282, 5, Color.WHITE, ((Shape)(t.getSource())));
//
//				if (t.getSource() instanceof Rectangle){
//
//					/**/
//
//					Label hauteur = new Label("Hauteur :");
//					final TextField textFieldHauteur = new TextField ();
//					textFieldHauteur.setMaxWidth(60);
//					textFieldHauteur.setText("");
//					Label largeur = new Label("Largeur :");new Model();
//					final TextField textFieldLargeur = new TextField ();
//					textFieldLargeur.setMaxWidth(60);
//					textFieldLargeur.setText("");
//
//					/**/
//
//					Label centre = new Label("Centre de rotation:");
//					final TextField textFieldCentreX = new TextField();
//					textFieldCentreX.setMaxWidth(60);
//					textFieldCentreX.setText("");
//					textFieldCentreX.setPromptText( String.valueOf( ((Rectangle) t.getSource()).getLayoutX() + ((Rectangle) t.getSource()).getWidth()/2 - GLOBAL_LAYOUT_Xmin_WHITEBOARD));
//					final TextField textFieldCentreY = new TextField();
//					textFieldCentreY.setMaxWidth(60);
//					textFieldCentreY.setText("");
//					textFieldCentreY.setPromptText(String.valueOf( ((Rectangle) t.getSource()).getLayoutY() + ((Rectangle) t.getSource()).getHeight()/2 - GLOBAL_LAYOUT_Ymin_WHITEBOARD));
//
//					Label rotation = new Label("Rotation :");
//					final TextField textFieldRotation = new TextField ();
//					textFieldRotation.setMaxWidth(60);
//					textFieldRotation.setText("");
//					textFieldRotation.setPromptText("degrès");
//					final Button ok = GraphicalObjects.createButton(0,0,null, null);
//					ok.setText("Ok!");
//					ok.setOnAction(new EventHandler<ActionEvent>() {
//
//						@Override
//						public void handle(ActionEvent e) {
//							if ( textFieldHauteur.getText().trim().isEmpty() == false){
//								double res = Double.parseDouble(textFieldHauteur.getText());
//								((Rectangle) t.getSource()).setHeight(res);
//
//							}
//
//							if ( textFieldLargeur.getText().trim().isEmpty() == false){
//								double res = Double.parseDouble(textFieldLargeur.getText());
//								((Rectangle) t.getSource()).setWidth(res);
//							}
//
//
//							if ( textFieldRotation.getText().trim().isEmpty() == false && 
//									textFieldCentreX.getText().trim().isEmpty() == false &&
//									textFieldCentreY.getText().trim().isEmpty() == false){
//
//								double rotation = Double.parseDouble(textFieldRotation.getText());
//								double pointCentreX = Double.parseDouble(textFieldCentreX.getText()) ;
//								double pointCentreY = Double.parseDouble(textFieldCentreY.getText());
//
//								double rotaRadian = rotation * (Math.PI / 180);
//								double cosRotation = Math.cos(rotaRadian);
//								double sinRotation = Math.sin(rotaRadian);
//								double coorX = ((Rectangle) t.getSource()).getLayoutX() + ((Rectangle) t.getSource()).getWidth()/2 - GLOBAL_LAYOUT_Xmin_WHITEBOARD;
//								double coorY = ((Rectangle) t.getSource()).getLayoutY() + ((Rectangle) t.getSource()).getHeight()/2 -  GLOBAL_LAYOUT_Ymin_WHITEBOARD;
//
//								if( ( coorX - pointCentreX ) * cosRotation - ( coorY - pointCentreY ) * sinRotation + pointCentreX < 0 ||
//										( coorX - pointCentreX ) * cosRotation - ( coorY - pointCentreY ) * sinRotation + pointCentreX > GLOBAL_LAYOUT_Xmax_WHITEBOARD - GLOBAL_LAYOUT_Xmin_WHITEBOARD ||
//										( coorX - pointCentreX ) * sinRotation + ( coorY - pointCentreY ) * cosRotation + pointCentreY < 0 ||
//										( coorX - pointCentreX ) * sinRotation + ( coorY - pointCentreY ) * cosRotation + pointCentreY > GLOBAL_LAYOUT_Ymax_WHITEBOARD - GLOBAL_LAYOUT_Ymin_WHITEBOARD) {
//									GraphicalObjects.errorMessage("Erreur, rotation dépassant la taille du whiteboard!");
//								}
//								else{
//									((Rectangle) t.getSource()).getTransforms().add(new Rotate(rotation, 
//											pointCentreX - ( ((Rectangle) t.getSource()).getLayoutX() - GLOBAL_LAYOUT_Xmin_WHITEBOARD), 
//											pointCentreY - ( ((Rectangle) t.getSource()).getLayoutY() - GLOBAL_LAYOUT_Ymin_WHITEBOARD)));
//
//									checkPosition(((Rectangle) t.getSource()), t);
//									ok.getParent().getScene().getWindow().hide();
//								}
//							}
//							checkPosition(((Rectangle) t.getSource()), t);
//							ok.getParent().getScene().getWindow().hide();
//						}
//					});
//
//					/**/
//
//					HBox hbHauteurLargeur = new HBox();
//					hbHauteurLargeur.setLayoutX(2);
//					hbHauteurLargeur.setLayoutY(42);
//					hbHauteurLargeur.getChildren().add(hauteur);
//					hbHauteurLargeur.getChildren().add(textFieldHauteur);
//					hbHauteurLargeur.getChildren().add(largeur);
//					hbHauteurLargeur.getChildren().add(textFieldLargeur);
//
//					/**/
//
//					HBox hbCentreRotation = new HBox();
//					hbCentreRotation.setLayoutX(2);
//					hbCentreRotation.setLayoutY(82);
//					hbCentreRotation.getChildren().add(centre);
//					hbCentreRotation.getChildren().add(textFieldCentreX);
//					hbCentreRotation.getChildren().add(textFieldCentreY);
//
//					/**/
//
//					HBox hbRotation = new HBox();
//					hbRotation.setLayoutX(2);
//					hbRotation.setLayoutY(122);
//					hbRotation.getChildren().add(rotation);
//					hbRotation.getChildren().add(textFieldRotation);
//					hbRotation.getChildren().add(ok);
//					root.getChildren().add(hbHauteurLargeur);
//					root.getChildren().add(hbCentreRotation);
//					root.getChildren().add(hbRotation);					
//
//				}
//				////////////POLYGON//////////////
//				if (t.getSource() instanceof Polygon){
//
//					/**/
//
//					Label points = new Label("Nombre de points :");
//					final TextField textFieldPoints = new TextField ();
//					textFieldPoints.setMaxWidth(60);
//					textFieldPoints.setText("");
//					Label rayon = new Label("Rayon :");
//					final TextField textFieldRayon = new TextField ();
//					textFieldRayon.setMaxWidth(60);
//					textFieldRayon.setText("");
//
//					/**/
//
//					Label centre = new Label("Centre de rotation:");
//					final TextField textFieldCentreX = new TextField();
//					textFieldCentreX.setMaxWidth(60);
//					textFieldCentreX.setText("");
//					textFieldCentreX.setPromptText(String.valueOf(((Polygon) t.getSource()).getLayoutX()));
//					final TextField textFieldCentreY = new TextField();
//					textFieldCentreY.setMaxWidth(60);
//					textFieldCentreY.setText("");
//					textFieldCentreY.setPromptText(String.valueOf(((Polygon) t.getSource()).getLayoutY()));
//
//					/**/
//
//					Label rotation = new Label("Rotation :");
//					final TextField textFieldRotation = new TextField ();
//					textFieldRotation.setMaxWidth(60);
//					textFieldRotation.setText("");
//					textFieldRotation.setPromptText("degrès");
//					final Button ok = GraphicalObjects.createButton(0,0,null, null);
//					ok.setText("Ok!");
//					ok.setOnAction(new EventHandler<ActionEvent>() {
//						/**
//						 * TODO ROTATION
//						 */
//						@Override
//						public void handle(ActionEvent e) {
//
//
//
//							if ( !textFieldPoints.getText().trim().isEmpty() &&
//									!textFieldRayon.getText().trim().isEmpty()){
//
//								int res1 = Integer.parseInt(textFieldPoints.getText());
//								double res2 = Double.parseDouble(textFieldRayon.getText());
//
//								Double [] tab = transTab(res1, res2);
//								((Polygon)t.getSource()).getPoints().clear();
//								((Polygon)t.getSource()).getPoints().addAll(tab);
//							}
//							/**
//							 * Trouver un moyen pour choper le rayon / centre du cercle
//							 */
//							else if ( !textFieldPoints.getText().trim().isEmpty()){
//
//								int res1 = Integer.parseInt(textFieldPoints.getText());
//								Object[] listObject = ((Polygon)t.getSource()).getPoints().toArray();
//								Double [] tab1 = toTab(listObject);
//								double intX = barycentreX(tab1);
//								double intY = barycentreY(tab1);
//								double px = tab1[0];
//								double py = tab1[1];
//								double dist = Math.sqrt( (intX - px) * (intX - px) + (intY - py) * (intY - py) );
//								Double [] tab2 = transTab(res1, dist);
//
//								((Polygon)t.getSource()).getPoints().clear();
//								((Polygon)t.getSource()).getPoints().addAll(tab2);
//							}
//
//							else if (!textFieldRayon.getText().trim().isEmpty()){
//
//								double res2 = Double.parseDouble(textFieldRayon.getText());
//								int tailleTab = ((Polygon) t.getSource()).getPoints().size() /2;
//								Double [] tab = transTab(tailleTab, res2);
//								((Polygon) t.getSource()).getPoints().clear();
//								((Polygon) t.getSource()).getPoints().addAll(tab);
//
//							}
//
//							if ( textFieldRotation.getText().trim().isEmpty() == false && 
//									textFieldCentreX.getText().trim().isEmpty() == false &&
//									textFieldCentreY.getText().trim().isEmpty() == false){
//
//								double rotation = Double.parseDouble(textFieldRotation.getText());
//								double pointCentreX = Double.parseDouble(textFieldCentreX.getText()) ;
//								double pointCentreY = Double.parseDouble(textFieldCentreY.getText());
//
//
//								double rotaRadian = rotation * (Math.PI / 180);
//								double cosRotation = Math.cos(rotaRadian);
//								double sinRotation = Math.sin(rotaRadian);
//								double coorX = barycentreX(toTab(((Polygon) t.getSource()).getPoints().toArray())) + ((Polygon) t.getSource()).getLayoutX();
//								double coorY = barycentreX(toTab(((Polygon) t.getSource()).getPoints().toArray())) + ((Polygon) t.getSource()).getLayoutY();
//
//								if( ( coorX - pointCentreX ) * cosRotation - ( coorY - pointCentreY ) * sinRotation + pointCentreX < 0 ||
//										( coorX - pointCentreX ) * cosRotation - ( coorY - pointCentreY ) * sinRotation + pointCentreX > GLOBAL_LAYOUT_Xmax_WHITEBOARD - GLOBAL_LAYOUT_Xmin_WHITEBOARD ||
//										( coorX - pointCentreX ) * sinRotation + ( coorY - pointCentreY ) * cosRotation + pointCentreY < 0 ||
//										( coorX - pointCentreX ) * sinRotation + ( coorY - pointCentreY ) * cosRotation + pointCentreY > GLOBAL_LAYOUT_Ymax_WHITEBOARD - GLOBAL_LAYOUT_Ymin_WHITEBOARD) {
//									GraphicalObjects.errorMessage("Erreur, rotation dépassant la taille du whiteboard!");
//								}
//								else{
//									((Polygon) t.getSource()).getTransforms().add(new Rotate(rotation, 
//											pointCentreX - ( ((Polygon) t.getSource()).getLayoutX() - GLOBAL_LAYOUT_Xmin_WHITEBOARD), 
//											pointCentreY - ( ((Polygon) t.getSource()).getLayoutY() - GLOBAL_LAYOUT_Ymin_WHITEBOARD)));
//
//									checkPosition(((Polygon) t.getSource()), t);
//									ok.getParent().getScene().getWindow().hide();
//								}
//							}
//							checkPosition(((Shape) t.getSource()), t);
//							ok.getParent().getScene().getWindow().hide();
//						}
//					});
//
//					/**/
//
//
//					/**/
//
//					HBox hbHauteurLargeur = new HBox();
//					hbHauteurLargeur.setLayoutX(2);
//					hbHauteurLargeur.setLayoutY(42);
//					hbHauteurLargeur.getChildren().add(points);
//					hbHauteurLargeur.getChildren().add(textFieldPoints);
//					hbHauteurLargeur.getChildren().add(rayon);
//					hbHauteurLargeur.getChildren().add(textFieldRayon);
//
//					/**/
//
//					HBox hbCentreRotation = new HBox();
//					hbCentreRotation.setLayoutX(2);
//					hbCentreRotation.setLayoutY(82);
//					hbCentreRotation.getChildren().add(centre);
//					hbCentreRotation.getChildren().add(textFieldCentreX);
//					hbCentreRotation.getChildren().add(textFieldCentreY);
//
//					/**/
//
//					HBox hbRotation = new HBox();
//					hbRotation.setLayoutX(2);
//					hbRotation.setLayoutY(122);
//					hbRotation.getChildren().add(rotation);
//					hbRotation.getChildren().add(textFieldRotation);
//					hbRotation.getChildren().add(ok);
//
//					root.getChildren().add(hbHauteurLargeur);
//					root.getChildren().add(hbCentreRotation);
//					root.getChildren().add(hbRotation);
//
//				}
//
//
//
//				root.getChildren().add(red);
//				root.getChildren().add(blue);
//				root.getChildren().add(green);
//				root.getChildren().add(aqua);
//				root.getChildren().add(beige);
//				root.getChildren().add(black);
//				root.getChildren().add(brown);
//				root.getChildren().add(cyan);
//				root.getChildren().add(grey);
//				root.getChildren().add(pink);
//				root.getChildren().add(orange);
//				root.getChildren().add(lGreen);
//				root.getChildren().add(purple);
//				root.getChildren().add(turquoise);
//				root.getChildren().add(white);
//
//
//				stagePopUp.setScene(theScene);
//				stagePopUp.show();
//			}
//		}
//	};
//
	public static void majOrgScene(MouseEvent event){
		orgSceneX = event.getSceneX();
		orgSceneY = event.getSceneY();
	}
	
	public static EventHandler<MouseEvent> OnMousePressedClone =
			new EventHandler<MouseEvent>(){
		public void handle(MouseEvent event) {
			if (event.getSource() instanceof Rectangle) {
				Rectangle rect = (Rectangle) event.getSource();
				ShapeRectangle shapeRect;
				try {
					shapeRect = (ShapeRectangle) Toolbar.getInstance().getShape(0).clone();
					if(Toolbar.getInstance().isShapeIn(shapeRect)){
						//Initialise les positions pour le drag
						majOrgScene(event);
						Point2D.Double position = new Point2D.Double(event.getSceneX(), event.getSceneY());
						Model.getInstance().notifyChangeShape(shapeRect);
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
			if (event.getSource() instanceof Rectangle) {
				majOrgScene(event);

			}
		}
	};

//				orgSceneX = t.getSceneX();
//				orgSceneY = t.getSceneY();
					//				((Rectangle)(t.getSource())).setOnMousePressed(OnMousePressedWhiteboard);
					//				((Rectangle)(t.getSource())).setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);
		
//			if (event.getSource() instanceof Polygon) {
//				Shape poly = GraphicalObjects.cloneShape((Shape) t.getSource());
//				Polygon poly = (Polygon) event.getSource();
//				orgSceneX = t.getSceneX();
//				orgSceneY = t.getSceneY();
//				((Polygon)(t.getSource())).setOnMousePressed(OnMousePressedWhiteboard);				
//				((Polygon)(t.getSource())).setOnMouseReleased(mouseReleasedOnWhiteboardEventHandler);

//
//	static EventHandler<MouseEvent> OnMouseReleasedToolbar = 
//			new EventHandler<MouseEvent>() {
//
//		public void handle(MouseEvent event){
//			if(event.getSource().equals(selectionRectangle)){
//				ShapeComposite comp = null;
//				for(Shape s:listShapes){
//					if(s instanceof ShapeComposite){
//						comp = (ShapeComposite) s;
//					}
//				}
//
//			}
//		}
//	};
//
	public static EventHandler<MouseEvent> OnMouseDraggedEventHandler =
			new EventHandler<MouseEvent>() {

//		public void translateRectangle(Rectangle r){
//			r.setTranslateX(newTranslateX);
//			r.setTranslateY(newTranslateY);
//		}
//
//		public void translatePolygon(Polygon p){
//			p.setTranslateX(newTranslateX);
//			p.setTranslateY(newTranslateY);
//		}

		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() instanceof Rectangle){
				ShapeRectangle shapeRect = (ShapeRectangle) ((Rectangle) event.getSource()).getUserData();
				double offsetX = event.getSceneX() - orgSceneX;
				double offsetY = event.getSceneY() - orgSceneY;
				newTranslateX = offsetX;
				newTranslateY = offsetY;
				shapeRect.setTranslation(newTranslateX, newTranslateY);
				Model.getInstance().notifyChangeShape(shapeRect);
			}
		}
	};
}
//
//			double offsetX = t.getSceneX() - orgSceneX;
//			double offsetY = t.getSceneY() - orgSceneY;
//			newTranslateX = offsetX;
//			newTranslateY = offsetY;
//			if(selectionRectangle != null && t.getSource().equals(selectionRectangle)){
//				this.translateRectangle(selectionRectangle);
//				for(Shape shape:listShapes){
//					if(shape.getStroke().equals(selectionColor)){
//						if(shape instanceof Rectangle){
//							this.translateRectangle((Rectangle) shape);
//						}
//						else{
//							if(shape instanceof Polygon){
//								this.translatePolygon((Polygon) shape);
//							}
//						}
//					}
//				}
//			}
////			else{
//			if(t.getSource() instanceof Rectangle){
//				this.translateRectangle((Rectangle) t.getSource());
//			}
//			else{
//				if(t.getSource() instanceof Polygon){
//					this.translatePolygon(((Polygon) t.getSource()));
//				}
//				}
//			}

//
//
//	static EventHandler<MouseEvent> mouseReleasedOnWhiteboardEventHandler =
//			new EventHandler<MouseEvent>(){
//
//		public void handle(MouseEvent t){		
//
//			if(t.getSource() instanceof Shape &&
//					t.getSceneX() > GLOBAL_LAYOUT_Xmin_BUTTONTRASH &&
//					t.getSceneY() > GLOBAL_LAYOUT_Ymin_BUTTONTRASH &&
//					t.getSceneX() < GLOBAL_LAYOUT_Xmax_BUTTONTRASH &&
//					t.getSceneY() < GLOBAL_LAYOUT_Ymax_BUTTONTRASH){
//				if(t.getTarget() instanceof Shape){
//					Shape shapeTarget = (Shape) t.getTarget();
//					Shape toRemove = null;
//					for(Shape shape:listShapes){
//						if(shape == shapeTarget){
//							toRemove = shape;
//						}
//					}
//					listShapes.remove(toRemove);
//				}
//				((Shape) t.getSource()).setVisible(false);
//			}
//
//			if (t.getSource() instanceof Rectangle){
//				((Rectangle) t.getSource() ).setLayoutX(((Rectangle) t.getSource() ).getLayoutX() + ((Rectangle) t.getSource() ).getTranslateX() + ((Rectangle) t.getSource() ).getX());
//				((Rectangle) t.getSource() ).setLayoutY(((Rectangle) t.getSource() ).getLayoutY() + ((Rectangle) t.getSource() ).getTranslateY() + ((Rectangle) t.getSource() ).getY());
//				((Rectangle) t.getSource() ).setX(0);
//				((Rectangle) t.getSource() ).setY(0);
//				((Rectangle) t.getSource() ).setTranslateX(0);
//				((Rectangle) t.getSource() ).setTranslateY(0);
//
//			}
//
//
//			if (t.getSource() instanceof Polygon){
//				((Polygon)(t.getSource())).setLayoutX(((Polygon)(t.getSource())).getTranslateX() + ((Polygon)(t.getSource())).getLayoutX());
//				((Polygon)(t.getSource())).setTranslateX(0);
//				((Polygon)(t.getSource())).setLayoutY(((Polygon)(t.getSource())).getTranslateY() + ((Polygon)(t.getSource())).getLayoutY());
//				((Polygon)(t.getSource())).setTranslateY(0);
//			}
//
//			for(Shape shape:listShapes){
//				if(shape.getStroke().equals(selectionColor)){
//					shape.setLayoutX(shape.getLayoutX() + shape.getTranslateX());
//					shape.setLayoutY(shape.getLayoutY() + shape.getTranslateY());
//					shape.setTranslateX(0);
//					shape.setTranslateY(0);
//					checkPosition( shape, t);
//				}
//			}
//			checkPosition(((Shape) t.getSource()), t);
//		}
//	};
//
//
//	static EventHandler<MouseEvent> buttonTrashReleased =
//			new EventHandler<MouseEvent>(){
//		public void handle(MouseEvent t){
//			if ( t.getSource() instanceof Shape){
//				((Shape) t.getSource()).setVisible(false);
//			}
//
//		}
//	};
//
//	public static Rectangle selectionRectangle = null;
//	public final static Color selectionColor = new Color(0.7, 0.7, 1, 1);
//	public static final int MIN_WIDTH_SELECTION = 10, MIN_HEIGHT_SELECTION = 10;
//
//	static EventHandler<MouseEvent> buttonPressedOnWhiteboardForSelection =
//			new EventHandler<MouseEvent>(){
//		public void handle(MouseEvent event) {
//			if(selectionRectangle != null){
//				selectionRectangle.setVisible(false);
//				selectionRectangle = null;
//				for(Shape shape:listShapes){
//					if(shape instanceof ShapeComposite){
//						listShapes.remove(shape);
//					}
//					shape.setStroke(Color.BLACK);
//				}
//			}
//			double x = event.getX();
//			double y = event.getY();
//			selectArea[0] = new Point2D(x, y);
//		}
//	};	
//
//
//	static EventHandler<MouseEvent> buttonReleasedOnWhiteboardForSelection =
//			new EventHandler<MouseEvent>(){
//		public void handle(MouseEvent event) {
//			double x = event.getX();
//			double y = event.getY();
//			selectArea[1] = new Point2D(x, y);
//			double leftX = Math.min(selectArea[0].getX(), selectArea[1].getX());
//			double leftY = Math.min(selectArea[0].getY(), selectArea[1].getY());
//			double width = Math.max(selectArea[0].getX(), selectArea[1].getX()) - leftX;
//			double height = Math.max(selectArea[0].getY(), selectArea[1].getY()) - leftY;
//			if(width >= MIN_WIDTH_SELECTION && height >= MIN_HEIGHT_SELECTION){
//
//				selectionRectangle = GraphicalObjects.createRectangle(leftX, leftY, width, height, 
//						0, 0, Color.TRANSPARENT, selectionColor, 
//						OnMousePressedWhiteboard, OnMouseDraggedEventHandler, false);
//				selectionRectangle.addEventHandler(MouseEvent.MOUSE_RELEASED, mouseReleasedOnWhiteboardEventHandler);
//
//
//				Group gr = (Group) ((Rectangle) event.getSource()).getParent();
//				gr.getChildren().add(selectionRectangle);
//
//				//préciser aux shapes qu'elles sont sélectionnées 
//				ShapeComposite comp = new ShapeComposite();
//				for(Shape shape:listShapes){
//					if(shape.getLayoutX() >= selectionRectangle.getX() &&
//							shape.getLayoutX() <= selectionRectangle.getX() + selectionRectangle.getWidth() &&
//							shape.getLayoutY() >= selectionRectangle.getY() &&
//							shape.getLayoutY() <= selectionRectangle.getY() + selectionRectangle.getHeight()){
//						shape.setStroke(selectionColor);
//						comp.addShape(shape);
//					}
//				}
//			}
//		}
//	};
//}
//}
