public abstract class Piece {
	protected boolean isWhite;
	protected boolean playing;
	protected int xaxis;
	protected int yaxis;
	protected boolean[][] attackEnemyPossible; ///gets generated with generatePossibleMoves
	protected int[][] generatedPossibleMoves;
	protected boolean pieceSelected;
	protected boolean notTaken;
	
	public Piece(boolean isWhite, int x, int y) {
		this.isWhite = isWhite;
		xaxis = x; 
		yaxis = y;
		attackEnemyPossible = new boolean[8][8];
		generatedPossibleMoves = new int[0][0];
		pieceSelected = false;
		notTaken = true;
		if(isWhite)
			playing = false;
		else
			playing = true;
			
	}
	
	public int[][] getGeneratedMoves() {
		return generatedPossibleMoves;
	}
	
	public boolean[][] getAttackEnemyPossible() {
		return attackEnemyPossible;
	}
	
	public boolean getIsWhite() {
		return isWhite;
	}
	
	public int getX() {
		return xaxis;
	}
	
	public int getY() {
		return yaxis;
	}
	
	public boolean getPlaying() {
		return playing;
	}
	
	public boolean getPieceSelected() {
		return pieceSelected;
	}
	
	public boolean getNotTaken() {
		return notTaken;
	}
	
	public void setNotTaken(boolean v) {
		notTaken = v;
	}
	
	public void setPieceSelected(boolean v) {
		pieceSelected = v;
	}
	
	public void setPlaying(boolean value) {
		playing = value;
	}
	
	public void setX(int x) {
		xaxis = x;
	}
	
	public void setY(int y) {
		yaxis = y;
	}
	
	public abstract void generatePossibleMoves();
	
	public void addToEndOfDoubleArray(int x, int y){
		int[][] newArr = new int[generatedPossibleMoves.length+1][2];
		for(int i = 0; i < newArr.length-1; i++) {
			for(int j = 0; j < 2; j++) {
				newArr[i][j] = generatedPossibleMoves[i][j];
			}
		}
		newArr[newArr.length-1][0] = x;
		newArr[newArr.length-1][1] = y;
		generatedPossibleMoves = newArr;
	}
	
	public int[][] getGeneratedPossibleMoves(){
		return generatedPossibleMoves;
	}
}