
public class Pawn extends Piece{

	private boolean hasMoved;
	
	public Pawn(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
		hasMoved = false;
	}
	
	public void generatePossibleMoves() {
		generatedPossibleMoves = new int[0][2];
		if(notTaken) {
			if(isWhite) {
					if(yaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis-1][yaxis] && !Game.getSpaceTakenByBlack()[xaxis-1][yaxis])
						this.addToEndOfDoubleArray(xaxis, yaxis+1);
					if(xaxis != 8 && yaxis != 8 && Game.getSpaceTakenByBlack()[xaxis][yaxis]) {
						this.addToEndOfDoubleArray(xaxis+1, yaxis+1);
						attackEnemyPossible[xaxis][yaxis] = true;
					}
					if(xaxis != 1 && yaxis != 8 && Game.getSpaceTakenByBlack()[xaxis-2][yaxis]) {
						this.addToEndOfDoubleArray(xaxis-1, yaxis+1);
						attackEnemyPossible[xaxis-2][yaxis] = true;
					}
					if(!hasMoved) {
						if(!Game.getSpaceTakenByWhite()[xaxis-1][yaxis+1] && !Game.getSpaceTakenByBlack()[xaxis-1][yaxis+1] 
								&& !Game.getSpaceTakenByWhite()[xaxis-1][yaxis] && !Game.getSpaceTakenByBlack()[xaxis-1][yaxis]) {
							this.addToEndOfDoubleArray(xaxis, yaxis+2);
							if(xaxis != 8 && Game.getSpaceTakenByBlack()[xaxis][yaxis])
								attackEnemyPossible[xaxis][yaxis] = true;
							else if(xaxis != 1 && Game.getSpaceTakenByBlack()[xaxis-2][yaxis])
								attackEnemyPossible[xaxis-2][yaxis] = true;
						}
					}
			}
			else { //black pawn only moves forward if it has opportunity to take white piece, otherwise does not respond and turn ends if blue square is clicked... only goes forward the first move, but not forward two
				if(!Game.getSpaceTakenByBlack()[xaxis-1][yaxis-2] && !Game.getSpaceTakenByWhite()[xaxis-1][yaxis-2])
					this.addToEndOfDoubleArray(xaxis, yaxis-1);
				if(xaxis != 8 && Game.getSpaceTakenByWhite()[xaxis][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis-1);
					attackEnemyPossible[xaxis][yaxis-2] = true;
				}
				if(xaxis != 1 && Game.getSpaceTakenByWhite()[xaxis-2][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis-1);
					attackEnemyPossible[xaxis-2][yaxis-2] = true;
				}
				if(!hasMoved) {
					if(!Game.getSpaceTakenByBlack()[xaxis-1][yaxis-2] && !Game.getSpaceTakenByWhite()[xaxis-1][yaxis-2] 
							&& !Game.getSpaceTakenByBlack()[xaxis-1][yaxis-3] && !Game.getSpaceTakenByWhite()[xaxis-1][yaxis-3]) {
						this.addToEndOfDoubleArray(xaxis, yaxis-2);
						if(xaxis != 8 && Game.getSpaceTakenByWhite()[xaxis][yaxis-2])
							attackEnemyPossible[xaxis][yaxis-2] = true;
						else if(xaxis != 1 && Game.getSpaceTakenByWhite()[xaxis-2][yaxis-2])
							attackEnemyPossible[xaxis-2][yaxis-2] = true;
					}
				}
			}
		}
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public void setX(int x) {
		xaxis = x;
		hasMoved = true;
	}
	
	public void setY(int y) {
		yaxis = y;
		hasMoved = true;
	}
}