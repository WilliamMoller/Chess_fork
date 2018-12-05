package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

	public class Queen extends Piece {
	
		
		public Queen(Color c) {
			super(c);
		}
		
		public void showMove(int x, int y){
					
			int top = x;
			int left = y;
			int right = 7-y;
			int down = 7-x;
			
			for (int i = 1; i <= Math.min(top, left); i++) {
				Square s = ChessBoard.getSquare(x-i, y-i);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
			
			for (int i = 1; i <= Math.min(top, right); i++) {
				Square s = ChessBoard.getSquare(x-i, y+i);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
			
			for (int i = 1; i <= Math.min(down, left); i++) {
				Square s = ChessBoard.getSquare(x+i, y-i);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
			
			for (int i = 1; i <= Math.min(down, right); i++) {
				Square s = ChessBoard.getSquare(x+i, y+i);
				if(s.hasPiece()){
					if(s.getPieceColor() != this.getColor())
						s.attackMark();
					break;
				} else {
					s.moveMark();
				}
			}
		
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
			ChessBoard.turn++;
		}
		
}