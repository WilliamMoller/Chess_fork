package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

	public class Rook extends Piece {
	
		
		public Rook(Color c) {
			super(c);
		}
	
		public void showMove(int x, int y){
			
			for (int i = 1; i <= y; i++) {
				Square s = ChessBoard.getSquare(x, y-i);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
			
			for (int i = 1; i <= 7-y; i++) {
				Square s = ChessBoard.getSquare(x, y+i);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
			
			for (int i = 1; i <= x; i++) {
				Square s = ChessBoard.getSquare(x-i, y);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
			
			for (int i = 1; i <= 7-x; i++) {
				Square s = ChessBoard.getSquare(x+i, y);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
		}
		
		public void move(){
			
		}
		
}