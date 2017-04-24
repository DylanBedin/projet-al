package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class GraphicalObjects {
	
	
	static final double LAYOUT_X_RECTANGLE = 15;
	static final double LAYOUT_Y_RECTANGLE = 30;
	static final double LAYOUT_X_POLYGON = 10;
	static final double LAYOUT_Y_POLYGON = 90;

	
	//BUTTON
	public static Button createButton(int layoutX, int layoutY, Paint color, Shape source){
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

	//TEXT
	public static Text createText(String text, int font, double layoutX, double layoutY){
		Text t = new Text(text);
		t.setFont(new Font(font));
		t.setLayoutX(layoutX);
		t.setLayoutY(layoutY);
		return t;
	}

	//POLYGON
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

	public static Shape cloneShape(Shape s){
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
					EventMouse.OnMousePressedEventHandlerv2,
					EventMouse.OnMouseDraggedEventHandler,
					false);
			Group parent = (Group) View.whiteboard.getParent();
			parent.getChildren().add(rect);
			return (Shape) rect;
		}
		
		if (s instanceof Polygon){
			Polygon poly = createPolygon(
					new Double[]{},
					LAYOUT_X_POLYGON,
					LAYOUT_Y_POLYGON,
					(Color) ((Polygon) s).getFill(),
					(Color) ((Polygon) s).getStroke(),
					EventMouse.OnMousePressedEventHandlerv2,
					EventMouse.OnMouseDraggedEventHandler,
					false
					);
			poly.getPoints().addAll( ((Polygon) s).getPoints());
			Group parent = (Group) View.whiteboard.getParent();
			parent.getChildren().add(poly);
			return (Shape) poly;
		}
		return null;
	}
	
	

}