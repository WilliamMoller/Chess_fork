package board;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;
	public static Square active;
	
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;

	public Square(Color c) {
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			// EXEMPEL:
			if (hasPiece()) {	
				makeActive();
			}
		});
	}
	
	public void makeInactive(){
		this.getBackground().setFill(originalColor);
		active = null;
	}
	
	
	public void makeActive(){
		if(active != null){
			active.makeInactive();
		}
		active = this;
		this.getBackground().setFill(Color.RED);
	}
	

	public void addPiece(Piece p) {
		this.piece = p;
		this.getChildren().add(p);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}

	public Rectangle getBackground() {
		return this.bg;
	}
	
	public int getX(){
		int y = getY();
		for (int i = 0; i < 8; i++) {
			if(ChessBoard.map.get(getY()).get(i) == this){
				return i;
			}
		}
		return -1;
		
	}

	public int getY(){
		for (int i = 0; i < 8; i++) {
			if(ChessBoard.map.get(i).contains(this)){
				return i;
			}
		}
		return -1;
	}
}
