package board;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pieces.King;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 100;
	private static Square active;
	private static ArrayList<Square> marked = new ArrayList<Square>();
	
	private Rectangle bg;
	private Color originalColor;
	private Piece piece;

	public Square(Color c) {
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			if(marked.contains(this)){
				if(this.hasPiece()){
					if(this.piece instanceof King){
						Rectangle box = new Rectangle(400, 150);
						box.setTranslateX(chess.WIDTH/2 - box.getWidth()/2);
						box.setTranslateY(chess.HEIGHT/2 - box.getHeight()/2);
						box.setStrokeWidth(2);
						Text winner = new Text();
						winner.setTranslateX(chess.WIDTH/2 - 128);
						winner.setTranslateY(chess.HEIGHT/2 + 15);
						winner.setFont(new Font(50));
						if(this.piece.getColor() == Color.WHITE){
							box.setStroke(Color.WHITE);
							box.setFill(Color.BLACK);
							winner.setText("Black Wins!");
							winner.setFill(Color.WHITE);
						}
						else{
							box.setStroke(Color.BLACK);
							box.setFill(Color.WHITE);
							winner.setText("White Wins!");
							winner.setFill(Color.BLACK);
						}
						chess.root.getChildren().addAll(box, winner);
					}
					
					this.getChildren().remove(this.piece);
					this.piece = null;
				}
				
				Piece p = active.piece;
				active.piece = null;
				active.makeInactive();
				this.addPiece(p);
				p.move();
				return;
			}
			
			if (hasPiece()) {	
				if(ChessBoard.turn % 2 == 0){ // VIT
					if(this.piece.getColor() != Color.WHITE){
						if(active != null){
							active.makeInactive();
						}
						return; // STOPPA
					}
				}
				else{
					if(this.piece.getColor() != Color.BLACK){
						if(active != null){
							active.makeInactive();
						}
						return; // STOPPA
					}						
				}
				makeActive();
			}
			else{
				if(active != null){
					active.makeInactive();
				}
			}
		});
	}
	
	public void makeInactive(){
		this.getBackground().setFill(originalColor);
		active = null;
		removeMoveMark();
	}
	
	
	public void makeActive(){
		if(active != null){
			active.makeInactive();
		}
		active = this;
		this.piece.showMove(getX(),getY());
		
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
	
	public static void removeMoveMark(){
		
		for (Square square : marked) {
			square.getChildren().remove(square.getChildren().size()-1);
		}
		marked.clear();
	}
	
	public void moveMark(){
		
		Circle cir = new Circle(Square.SIZE/2,Square.SIZE/2,Square.SIZE/9,Color.BLACK);
		this.getChildren().add(cir);
		
		marked.add(this);
	}

	public void attackMark() {
		
		Circle cir = new Circle(Square.SIZE/2,Square.SIZE/2,Square.SIZE/9,Color.RED);
		this.getChildren().add(cir);
		
		marked.add(this);
		
	}

	public Color getPieceColor() {
		return this.piece.getColor();
	}
}
