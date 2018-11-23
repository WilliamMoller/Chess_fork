package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Pawn extends Piece {

	private boolean hasMoved = false;
	
	public Pawn(Color c) {
		super(c);
	}

	@Override
	public void showMove(int x, int y) {
		
		if(this.getColor() == Color.WHITE){
			
			if(x-1 >= 0){
				Square attackLeft = ChessBoard.getSquare(x - 1, y - 1);
				if(attackLeft.hasPiece() && attackLeft.getPieceColor() != this.getColor()){
					attackLeft.attackMark();
				}
			}
				if(x+1 <= 7){
			Square attackRight = ChessBoard.getSquare(x + 1, y - 1);
				if(attackRight.hasPiece() && attackRight.getPieceColor() != this.getColor()){
					attackRight.attackMark();
				}
			}
			
			Square s1 = ChessBoard.getSquare(x, y - 1);
			if(!s1.hasPiece()){
				s1.moveMark();
			}
			else {
				return;
			}
			if(!hasMoved) {
				Square s2 = ChessBoard.getSquare(x, y - 2);
				if(!s2.hasPiece()) {
					s2.moveMark();
				}
			}
		}
		else {
			
			if(x-1 >= 0){
				Square attackLeft = ChessBoard.getSquare(x - 1, y + 1);
				if(attackLeft.hasPiece() && attackLeft.getPieceColor() != this.getColor()){
					attackLeft.attackMark();
				}
			}
				if(x+1 <= 7){
					Square attackRight = ChessBoard.getSquare(x + 1, y + 1);
				if(attackRight.hasPiece() && attackRight.getPieceColor() != this.getColor()){
					attackRight.attackMark();
				}
			}
			
			Square s1 = ChessBoard.getSquare(x, y + 1);
			if(!s1.hasPiece()){
				s1.moveMark();
			}
			else {
				return;
			}
			if(!hasMoved) {
				Square s2 = ChessBoard.getSquare(x, y + 2);
				if(!s2.hasPiece()) {
					s2.moveMark();
				}

			}

		}
	}

	public void move() {
		hasMoved = true;
	}
	
}
