package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class GraphicalObjects {
	
	
	static final double LAYOUT_X_RECTANGLE = 15;
	static final double LAYOUT_Y_RECTANGLE = 30;
	static final double LAYOUT_X_POLYGON = 25;
	static final double LAYOUT_Y_POLYGON = 100;

	
	//BUTTON
	public static Button createButton(int layoutX, int layoutY, final Paint color, final Shape source){
		Button button = new Button();
		button.setLayoutX(layoutX);
		button.setLayoutY(layoutY);
		if (color != null && source != null){
			button.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
			button.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e){
					source.setFill(color);
					//button.getParent().getScene().getWindow().hide();
				}
			});
		}
		return button;
	}


	//POLYGONv1
	public static Polygon createPolygon(Double[] tabDouble, double layoutX, double layoutY,  Color fill, Color stroke,
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
	public static Rectangle createRectangle(double x, double y, double width, double height, double arcWidth,
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
	public static Group createGroup(double x, double y){
		Group gr = new Group();
		gr.setLayoutX(x);
		gr.setLayoutY(y);
		return gr;
	}



}