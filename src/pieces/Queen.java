package pieces;

import board.ChessBoard;
import javafx.scene.paint.Color;

public class Queen extends Piece {

	
	public Queen(Color c) {
		super(c);
	}

	@Override
	public void showMove(int x, int y) {
		
		if(this.getColor() == Color.WHITE){
			ChessBoard.getSquare(x, y).moveMark();

		}
		else {
			ChessBoard.getSquare(x, y).moveMark();

		}
	}

	
	
}