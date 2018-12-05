package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class King extends Piece {

	public King(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {
		int top = x;
		int left = y;
		int right = 7 - y;
		int down = 7 - x;

		for (int i = 1; i <= Math.min(top, left);) {
			Square s = ChessBoard.getSquare(x - 1, y - 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
				
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= Math.min(top, right);) {
			Square s = ChessBoard.getSquare(x - 1, y + 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= Math.min(down, left);) {
			Square s = ChessBoard.getSquare(x + 1, y - 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= Math.min(down, right);) {
			Square s = ChessBoard.getSquare(x + 1, y + 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= y;) {
			Square s = ChessBoard.getSquare(x, y - 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= 7 - y;) {
			Square s = ChessBoard.getSquare(x, y + 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= x;) {
			Square s = ChessBoard.getSquare(x - 1, y);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}

		for (int i = 1; i <= 7 - x;) {
			Square s = ChessBoard.getSquare(x + 1, y);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
			break;
		}
	}
	public void move(){
		ChessBoard.turn++;
	}
}