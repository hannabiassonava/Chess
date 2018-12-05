
public class Rook extends Piece{

	private boolean hasMoved;
	private boolean underAttack;
	
	public Rook(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
		hasMoved = false;
	}
	
	public void generatePossibleMoves() {
		generatedPossibleMoves = new int[0][2];
		if(notTaken) {
			if(isWhite) {
				for(int x = xaxis - 1; x > 0; x--) {
					if(Game.getSpaceTakenByWhite()[x-1][yaxis-1]) {
						x = 0;
					}
					else {
						this.addToEndOfDoubleArray(x, yaxis);
						if(Game.getSpaceTakenByBlack()[x-1][yaxis-1]) {
							attackEnemyPossible[x-1][yaxis-1] = true;
							x = 0;
						}
					}
				}
				for(int x = xaxis + 1; x < 9; x++) {
					if(Game.getSpaceTakenByWhite()[x-1][yaxis-1]) {
						x = 9;
					}
					else {
						this.addToEndOfDoubleArray(x, yaxis);
						if(Game.getSpaceTakenByBlack()[x-1][yaxis-1]) {
							attackEnemyPossible[x-1][yaxis-1] = true;
							x = 9;
						}
					}
				}
				
				for(int y = yaxis - 1; y > 0; y--) {
					if(Game.getSpaceTakenByWhite()[xaxis-1][y-1]) {
						y = 0;
					}
					else {
						this.addToEndOfDoubleArray(xaxis, y);
						if(Game.getSpaceTakenByBlack()[xaxis-1][y-1]) {
							attackEnemyPossible[xaxis-1][y-1] = true;
							y = 0;
						}
					}
				}
				for(int y = yaxis + 1; y < 9; y++) {
					if(Game.getSpaceTakenByWhite()[xaxis-1][y-1]) {
						y = 9;
					}
					else {
						this.addToEndOfDoubleArray(xaxis, y);
						if(Game.getSpaceTakenByBlack()[xaxis-1][y-1]) {
							attackEnemyPossible[xaxis-1][y-1] = true;
							y = 9;
						}
					}
				}
			}
			else {
				for(int x = xaxis - 1; x > 0; x--) {
					if(Game.getSpaceTakenByBlack()[x-1][yaxis-1]) {
						x = 0;
					}
					else {
						this.addToEndOfDoubleArray(x, yaxis);
						if(Game.getSpaceTakenByWhite()[x-1][yaxis-1]) {
							attackEnemyPossible[x-1][yaxis-1] = true;
							x = 0;
						}
					}
				}
				for(int x = xaxis + 1; x < 9; x++) {
					if(Game.getSpaceTakenByBlack()[x-1][yaxis-1]) {
						x = 9;
					}
					else {
						this.addToEndOfDoubleArray(x, yaxis);
						if(Game.getSpaceTakenByWhite()[x-1][yaxis-1]) {
							attackEnemyPossible[x-1][yaxis-1] = true;
							x = 9;
						}
					}
				}
				
				for(int y = yaxis - 1; y > 0; y--) {
					if(Game.getSpaceTakenByBlack()[xaxis-1][y-1]) {
						y = 0;
					}
					else {
						this.addToEndOfDoubleArray(xaxis, y);
						if(Game.getSpaceTakenByWhite()[xaxis-1][y-1]) {
							attackEnemyPossible[xaxis-1][y-1] = true;
							y = 0;
						}
					}
				}
				for(int y = yaxis + 1; y < 9; y++) {
					if(Game.getSpaceTakenByBlack()[xaxis-1][y-1]) {
						y = 9;
					}
					else {
						this.addToEndOfDoubleArray(xaxis, y);
						if(Game.getSpaceTakenByWhite()[xaxis-1][y-1]) {
							attackEnemyPossible[xaxis-1][y-1] = true;
							y = 9;
						}
					}
				}
			}
		}
	}
	
	public boolean getHasMoved() {
		return hasMoved;
	}
	
	public boolean getUnderAttack() {
		return underAttack;
	}
	
	public void setUnderAttack(boolean v) {
		underAttack = v;
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