
public class Bishop extends Piece{

	public Bishop(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}
	
	public void generatePossibleMoves() {
		generatedPossibleMoves = new int[0][2];
		if(notTaken) {
			if(isWhite) {
				int tempx = xaxis;
				int tempy = yaxis;
				while(tempx>1 && tempy>1) {
					tempx--; tempy--;
					if(!Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 1; tempy = 1;
						}
					}
					else {
						tempx = 0; tempy = 0;
					}
				}
				tempx = xaxis;
				tempy = yaxis;
				while(tempx>1 && tempy<8) {
					tempx--; tempy++;
					if(!Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 1; tempy = 8;
						}
					}
					else {
						tempx = 1; tempy = 8;
					}
				}
				tempx = xaxis;
				tempy = yaxis;
				while(tempx<8 && tempy<8) {
					tempx++; tempy++;
					if(!Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 8; tempy = 8;
						}
					}
					else {
						tempx = 8; tempy = 8;
					}
				}
				tempx = xaxis;
				tempy = yaxis;
				while(tempx<8 && tempy>1) {
					tempx++; tempy--;
					if(!Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 8; tempy = 0;
						}
					}
					else {
						tempx = 8; tempy = 0;
					}
				}
			}
			else {
				int tempx = xaxis;
				int tempy = yaxis;
				while(tempx>1 && tempy>1) {
					tempx--; tempy--;
					if(!Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 1; tempy = 1;
						}
					}
					else {
						tempx = 1; tempy = 1;
					}
				}
				tempx = xaxis;
				tempy = yaxis;
				while(tempx>1 && tempy<8) {
					tempx--; tempy++;
					if(!Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 1; tempy = 8;
						}
					}
					else {
						tempx = 1; tempy = 8;
					}
				}
				tempx = xaxis;
				tempy = yaxis;
				while(tempx<8 && tempy<8) {
					tempx++; tempy++;
					if(!Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 8; tempy = 8;
						}
					}
					else {
						tempx = 8; tempy = 8;
					}
				}
				tempx = xaxis;
				tempy = yaxis;
				while(tempx<8 && tempy>1) {
					tempx++; tempy--;
					if(!Game.getSpaceTakenByBlack()[tempx-1][tempy-1]) {
						this.addToEndOfDoubleArray(tempx, tempy);
						if(Game.getSpaceTakenByWhite()[tempx-1][tempy-1]) {
							attackEnemyPossible[tempx-1][tempy-1] = true;
							tempx = 8; tempy = 1;
						}
					}
					else {
						tempx = 8; tempy = 1;
					}
				}
			}
		}
	}
}