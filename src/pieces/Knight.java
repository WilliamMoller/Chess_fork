package pieces;

import board.ChessBoard;
import board.Square;
import javafx.scene.paint.Color;

public class Knight extends Piece {

	public Knight(Color c) {
		super(c);
	}

	public void showMove(int x, int y) {
		if (!(x + 1 > 7 || y + 2 > 7)) {
			Square s = ChessBoard.getSquare(x + 1, y + 2);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}

		if (!(x + 1 > 7 || y - 2 < 0)) {
			Square s = ChessBoard.getSquare(x + 1, y - 2);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
		if (!(x + 2 > 7 || y + 1 > 7)) {
			Square s = ChessBoard.getSquare(x + 2, y + 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
		if (!(x + 2 > 7 || y - 1 < 0)) {
			Square s = ChessBoard.getSquare(x + 2, y - 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
		if (!(x - 1 < 0 || y + 2 > 7)) {
			Square s = ChessBoard.getSquare(x - 1, y + 2);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
		if (!(x - 1 < 0 || y - 2 < 0)) {
			Square s = ChessBoard.getSquare(x - 1, y - 2);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
		if (!(x - 2 < 0 || y + 1 > 7)) {
			Square s = ChessBoard.getSquare(x - 2, y + 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
		if (!(x - 2 < 0 || y - 1 < 0)) {
			Square s = ChessBoard.getSquare(x - 2, y - 1);
			if (s.hasPiece()) {
				if (s.getPieceColor() != this.getColor())
					s.attackMark();
			} else {
				s.moveMark();
			}
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		ChessBoard.turn++;

	}

}