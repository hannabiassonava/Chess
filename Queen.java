
public class Queen extends Piece{

	public Queen(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}
	
	//queens cannot take opponent pieces
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
}