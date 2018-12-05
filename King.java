
public class King extends Piece{
	
	private boolean hasMoved;
	private boolean isChecked;
	
	public King(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
		hasMoved = false;
	}
	
	public void generatePossibleMoves() {}
	
	public void generatePossibleMoves(Rook whiteRook1, Rook whiteRook2, Rook blackRook1, Rook blackRook2) {
		generatedPossibleMoves = new int[0][2];
		if(notTaken) {
			if(isWhite) {
				if(!hasMoved && !isChecked) {
					if(!whiteRook1.getHasMoved() && !whiteRook1.getUnderAttack() && !Game.getSpaceTakenByWhite()[xaxis-3][yaxis-1] 
							&& !Game.getSpaceTakenByBlack()[xaxis-3][yaxis-1] && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis-1] 
									&& !Game.getSpaceTakenByBlack()[xaxis-2][yaxis-1] && !Game.getSpaceTakenByWhite()[xaxis-4][yaxis-1] 
											&& !Game.getSpaceTakenByBlack()[xaxis-4][yaxis-1]) {
						this.addToEndOfDoubleArray(xaxis-2, yaxis);
					}
					else if(!whiteRook2.getHasMoved() && !whiteRook2.getUnderAttack() && !Game.getSpaceTakenByWhite()[xaxis][yaxis-1] 
							&& !Game.getSpaceTakenByBlack()[xaxis][yaxis-1] && !Game.getSpaceTakenByWhite()[xaxis+1][yaxis-1] 
									&& !Game.getSpaceTakenByBlack()[xaxis+1][yaxis-1]) {
						this.addToEndOfDoubleArray(xaxis+2, yaxis);
					}	
				}
				if(xaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis][yaxis-1]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis);
					if(Game.getSpaceTakenByBlack()[xaxis][yaxis-1]) {
						attackEnemyPossible[xaxis][yaxis-1] = true;
					}
				}
				if(xaxis != 1 && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis-1]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis);
					if(Game.getSpaceTakenByBlack()[xaxis-2][yaxis-1]) {
						attackEnemyPossible[xaxis-2][yaxis-1] = true;
					}
				}
				if(xaxis != 8 && yaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis][yaxis]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis+1);
					if(Game.getSpaceTakenByBlack()[xaxis][yaxis]) {
						attackEnemyPossible[xaxis][yaxis] = true;
					}
				}
				if(xaxis != 1 && yaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis+1);
					if(Game.getSpaceTakenByBlack()[xaxis-2][yaxis]) {
						attackEnemyPossible[xaxis-2][yaxis] = true;
					}
				}	
				if(xaxis != 8 && yaxis != 1 && !Game.getSpaceTakenByWhite()[xaxis][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis-1);
					if(Game.getSpaceTakenByBlack()[xaxis][yaxis-2]) {
						attackEnemyPossible[xaxis][yaxis-2] = true;
					}
				}	
				if(xaxis != 1 && yaxis != 1 && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis-1);
					if(Game.getSpaceTakenByBlack()[xaxis-2][yaxis-2]) {
						attackEnemyPossible[xaxis-2][yaxis-2] = true;
					}
				}		
				if(yaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis-1][yaxis]) {
					this.addToEndOfDoubleArray(xaxis, yaxis+1);
					if(Game.getSpaceTakenByBlack()[xaxis-1][yaxis]) {
						attackEnemyPossible[xaxis-1][yaxis] = true;
					}
				}
				if(yaxis != 1 && !Game.getSpaceTakenByWhite()[xaxis-1][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis, yaxis-1);
					if(Game.getSpaceTakenByBlack()[xaxis-1][yaxis-2]) {
						attackEnemyPossible[xaxis-1][yaxis-2] = true;
					}
				}				
			}
			else {
				if(!hasMoved && !isChecked) {
					if(!blackRook1.getHasMoved() && !blackRook1.getUnderAttack() && !Game.getSpaceTakenByWhite()[xaxis-3][yaxis-1] 
							&& !Game.getSpaceTakenByBlack()[xaxis-3][yaxis-1] && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis-1] 
									&& !Game.getSpaceTakenByBlack()[xaxis-2][yaxis-1] && !Game.getSpaceTakenByWhite()[xaxis-4][yaxis-1] 
											&& !Game.getSpaceTakenByBlack()[xaxis-4][yaxis-1]) {
						this.addToEndOfDoubleArray(xaxis-2, yaxis);
					}
					else if(!blackRook2.getHasMoved() && !blackRook2.getUnderAttack() && !Game.getSpaceTakenByWhite()[xaxis-3][yaxis-1] 
							&& !Game.getSpaceTakenByBlack()[xaxis-3][yaxis-1] && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis-1] 
									&& !Game.getSpaceTakenByBlack()[xaxis-2][yaxis-1]) {
						this.addToEndOfDoubleArray(xaxis+2, yaxis);
					}	
				}
				if(xaxis != 8 && !Game.getSpaceTakenByBlack()[xaxis][yaxis-1]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis);
					if(Game.getSpaceTakenByWhite()[xaxis][yaxis-1]) {
						attackEnemyPossible[xaxis][yaxis-1] = true;
					}
				}
				if(xaxis != 1 && !Game.getSpaceTakenByBlack()[xaxis-2][yaxis-1]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis);
					if(Game.getSpaceTakenByWhite()[xaxis-2][yaxis-1]) {
						attackEnemyPossible[xaxis-2][yaxis-1] = true;
					}
				}
				if(xaxis != 8 && yaxis != 8 && !Game.getSpaceTakenByBlack()[xaxis][yaxis]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis+1);
					if(Game.getSpaceTakenByWhite()[xaxis][yaxis]) {
						attackEnemyPossible[xaxis][yaxis] = true;
					}
				}
				if(xaxis != 1 && yaxis != 8 && !Game.getSpaceTakenByBlack()[xaxis-2][yaxis]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis+1);
					if(Game.getSpaceTakenByWhite()[xaxis-2][yaxis]) {
						attackEnemyPossible[xaxis-2][yaxis] = true;
					}
				}	
				if(xaxis != 8 && yaxis != 1 && !Game.getSpaceTakenByBlack()[xaxis][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis+1, yaxis-1);
					if(Game.getSpaceTakenByWhite()[xaxis][yaxis-2]) {
						attackEnemyPossible[xaxis][yaxis-2] = true;
					}
				}	
				if(xaxis != 1 && yaxis != 1 && !Game.getSpaceTakenByBlack()[xaxis-2][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis-1, yaxis-1);
					if(Game.getSpaceTakenByWhite()[xaxis-2][yaxis-2]) {
						attackEnemyPossible[xaxis-2][yaxis-2] = true;
					}
				}		
				if(yaxis != 8 && !Game.getSpaceTakenByBlack()[xaxis-1][yaxis]) {
					this.addToEndOfDoubleArray(xaxis, yaxis+1);
					if(Game.getSpaceTakenByWhite()[xaxis-1][yaxis]) {
						attackEnemyPossible[xaxis-1][yaxis] = true;
					}
				}
				if(yaxis != 1 && !Game.getSpaceTakenByBlack()[xaxis-1][yaxis-2]) {
					this.addToEndOfDoubleArray(xaxis, yaxis-1);
					if(Game.getSpaceTakenByWhite()[xaxis-1][yaxis-2]) {
						attackEnemyPossible[xaxis-1][yaxis-2] = true;
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
	
	public void setIsChecked(boolean v) {
		isChecked = v;
	}
	
	public boolean getIsChecked() {
		return isChecked;
	}
}