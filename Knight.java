
public class Knight extends Piece{

	public Knight(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}
	
	//knights do not move in one of the two start options
	public void generatePossibleMoves() {
		generatedPossibleMoves = new int[0][2];
		if(notTaken) {
			if(isWhite) {
				if(xaxis != 1 && yaxis < 7 && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis+1])
					this.addToEndOfDoubleArray(xaxis-1, yaxis+2);
				if(xaxis != 8 && yaxis < 7 && !Game.getSpaceTakenByWhite()[xaxis][yaxis+1])
					this.addToEndOfDoubleArray(xaxis+1, yaxis+2);
				if(xaxis < 7 && yaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis+1][yaxis])
					this.addToEndOfDoubleArray(xaxis+2, yaxis+1);
				if(xaxis < 7 && yaxis != 1 && !Game.getSpaceTakenByWhite()[xaxis+1][yaxis-2])
					this.addToEndOfDoubleArray(xaxis+2, yaxis-1);
				if(xaxis != 8 && yaxis > 2 && !Game.getSpaceTakenByWhite()[xaxis][yaxis-3])
					this.addToEndOfDoubleArray(xaxis+1, yaxis-2);
				if(xaxis != 1 && yaxis > 2 && !Game.getSpaceTakenByWhite()[xaxis-2][yaxis-3])
					this.addToEndOfDoubleArray(xaxis-1, yaxis-2);
				if(xaxis > 2 && yaxis != 1 && !Game.getSpaceTakenByWhite()[xaxis-3][yaxis-2])
					this.addToEndOfDoubleArray(xaxis-2, yaxis-1);
				if(xaxis > 2 && yaxis != 8 && !Game.getSpaceTakenByWhite()[xaxis-3][yaxis])
					this.addToEndOfDoubleArray(xaxis-2, yaxis+1);
			}
			else {
				if(xaxis != 1 && yaxis < 7 && !Game.getSpaceTakenByBlack()[xaxis-2][yaxis+1])
					this.addToEndOfDoubleArray(xaxis-1, yaxis+2);
				if(xaxis != 8 && yaxis < 7 && !Game.getSpaceTakenByBlack()[xaxis][yaxis+1])
					this.addToEndOfDoubleArray(xaxis+1, yaxis+2);
				if(xaxis < 7 && yaxis != 8 && !Game.getSpaceTakenByBlack()[xaxis+1][yaxis])
					this.addToEndOfDoubleArray(xaxis+2, yaxis+1);
				if(xaxis < 7 && yaxis != 1 && !Game.getSpaceTakenByBlack()[xaxis+1][yaxis-2])
					this.addToEndOfDoubleArray(xaxis+2, yaxis-1);
				if(xaxis != 8 && yaxis > 2 && !Game.getSpaceTakenByBlack()[xaxis][yaxis-3]) 
					this.addToEndOfDoubleArray(xaxis+1, yaxis-2);
				if(xaxis != 1 && yaxis > 2 && !Game.getSpaceTakenByBlack()[xaxis-2][yaxis-3])
					this.addToEndOfDoubleArray(xaxis-1, yaxis-2);
				if(xaxis > 2 && yaxis != 1 && !Game.getSpaceTakenByBlack()[xaxis-3][yaxis-2])
					this.addToEndOfDoubleArray(xaxis-2, yaxis-1);
				if(xaxis > 2 && yaxis != 8 && !Game.getSpaceTakenByBlack()[xaxis-3][yaxis])
					this.addToEndOfDoubleArray(xaxis-2, yaxis+1);
			}
			if(isWhite) {
				for(int c = 0; c < generatedPossibleMoves.length; c++)
					if(Game.getSpaceTakenByBlack()[generatedPossibleMoves[c][0]-1][generatedPossibleMoves[c][1]-1])
							attackEnemyPossible[generatedPossibleMoves[c][0]-1][generatedPossibleMoves[c][1]-1] = true;
			}
			else {
				for(int c = 0; c < generatedPossibleMoves.length; c++)
					if(Game.getSpaceTakenByWhite()[generatedPossibleMoves[c][0]-1][generatedPossibleMoves[c][1]-1])
							attackEnemyPossible[generatedPossibleMoves[c][0]-1][generatedPossibleMoves[c][1]-1] = true;
			}
		}
	}
}