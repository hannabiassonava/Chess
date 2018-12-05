import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Game extends Application {
	
	private static boolean[][] spaceTakenByWhite;
	private static boolean[][] spaceTakenByBlack;
	private Rectangle[][] theSquares = new Rectangle[0][0];
	private int extraInGroup;
	private int amountInGroup;
	private boolean whitePlayerTurn;
	private int[][] squaresLocation;
	
	private Pawn whitepawn1 = new Pawn(true, 1, 2); 
	private Pawn whitepawn2 = new Pawn(true, 2, 2);
	private Pawn whitepawn3 = new Pawn(true, 3, 2);
	private Pawn whitepawn4 = new Pawn(true, 4, 2);
	private Pawn whitepawn5 = new Pawn(true, 5, 2);
	private Pawn whitepawn6 = new Pawn(true, 6, 2);
	private Pawn whitepawn7 = new Pawn(true, 7, 2);
	private Pawn whitepawn8 = new Pawn(true, 8, 2);
	private Rook whiterook1 = new Rook(true, 1, 1);
	private Knight whiteknight1 = new Knight(true, 2, 1);
	private Bishop whitebishop1 = new Bishop(true, 3, 1);
	private Queen whitequeen1 = new Queen(true, 4, 1);
	private King whiteking1 = new King(true, 5, 1);
	private Bishop whitebishop2 = new Bishop(true, 6, 1);
	private Knight whiteknight2 = new Knight(true, 7, 1);
	private Rook whiterook2 = new Rook(true, 8, 1);
	
	private Pawn blackpawn1 = new Pawn(false, 1, 7);
	private Pawn blackpawn2 = new Pawn(false, 2, 7);
	private Pawn blackpawn3 = new Pawn(false, 3, 7);
	private Pawn blackpawn4 = new Pawn(false, 4, 7);
	private Pawn blackpawn5 = new Pawn(false, 5, 7);
	private Pawn blackpawn6 = new Pawn(false, 6, 7);
	private Pawn blackpawn7 = new Pawn(false, 7, 7);
	private Pawn blackpawn8 = new Pawn(false, 8, 7);
	private Rook blackrook1 = new Rook(false, 1, 8);
	private Knight blackknight1 = new Knight(false, 2, 8);
	private Bishop blackbishop1 = new Bishop(false, 3, 8);
	private Queen blackqueen1 = new Queen(false, 4, 8);
	private King blackking1 = new King(false, 5, 8);
	private Bishop blackbishop2 = new Bishop(false, 6, 8);
	private Knight blackknight2 = new Knight(false, 7, 8);
	private Rook blackrook2 = new Rook(false, 8, 8);
	
	public final int x = 8;
	public final int y = 8;
	public final int side = 100;
	
	private Image whitepawn = new Image("pieces2/pawn - white.png");
	private Image blackpawn = new Image("pieces2/pawn - black.png");
	private Image whiterook = new Image("pieces2/rook - white.png");
	private Image blackrook = new Image("pieces2/rook - black.png");
	private Image whiteknight = new Image("pieces2/knight - white.png");
	private Image blackknight = new Image("pieces2/knight - black.png");
	private Image whitebishop = new Image("pieces2/bishop - white.png");
	private Image blackbishop = new Image("pieces2/bishop - black.png");
	private Image whitequeen = new Image("pieces2/queen - white.png");
	private Image blackqueen = new Image("pieces2/queen - black.png");
	private Image whiteking = new Image("pieces2/king - white.png");
	private Image blackking = new Image("pieces2/king - black.png");
	
	private ImageView viewwhitepawn1 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn2 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn3 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn4 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn5 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn6 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn7 = new ImageView(whitepawn); 
	private ImageView viewwhitepawn8 = new ImageView(whitepawn); 
	private ImageView viewwhiterook1 = new ImageView(whiterook); 
	private ImageView viewwhiteknight1 = new ImageView(whiteknight); 
	private ImageView viewwhitebishop1 = new ImageView(whitebishop); 
	private ImageView viewwhitequeen = new ImageView(whitequeen); 
	private ImageView viewwhiteking = new ImageView(whiteking); 
	private ImageView viewwhitebishop2 = new ImageView(whitebishop); 
	private ImageView viewwhiteknight2 = new ImageView(whiteknight); 
	private ImageView viewwhiterook2 = new ImageView(whiterook); 
	
	private ImageView viewblackpawn1 = new ImageView(blackpawn); 
	private ImageView viewblackpawn2 = new ImageView(blackpawn); 
	private ImageView viewblackpawn3 = new ImageView(blackpawn); 
	private ImageView viewblackpawn4 = new ImageView(blackpawn); 
	private ImageView viewblackpawn5 = new ImageView(blackpawn); 
	private ImageView viewblackpawn6 = new ImageView(blackpawn); 
	private ImageView viewblackpawn7 = new ImageView(blackpawn); 
	private ImageView viewblackpawn8 = new ImageView(blackpawn); 
	private ImageView viewblackrook1 = new ImageView(blackrook);
	private ImageView viewblackknight1 = new ImageView(blackknight); 
	private ImageView viewblackbishop1 = new ImageView(blackbishop); 
	private ImageView viewblackqueen = new ImageView(blackqueen); 
	private ImageView viewblackking = new ImageView(blackking); 
	private ImageView viewblackbishop2 = new ImageView(blackbishop); 
	private ImageView viewblackknight2 = new ImageView(blackknight); 
	private ImageView viewblackrook2 = new ImageView(blackrook); 
	
	private Group startScreen = new Group();
	private Group root = new Group();
	 
	public static void main (String [] args) {
		launch();
	}
	
	public void startGame(Stage primaryStage, Scene scene) {
		scene = new Scene(root, side*x, side*y);
		int skew = 1;
		
		for(int i = 0; i < x; i++) {
			for(int j = skew; j < y; j+=2) {
				Rectangle black = new Rectangle(side, side, Color.BLACK);
				black.setX(j*side);
				black.setY(i*side);
				root.getChildren().add(black);
			}
			if(skew==1)
				skew = 0;
			else
				skew = 1;
		}
		primaryStage.setScene(scene);
		primaryStage.show();
		
		spaceTakenByWhite = new boolean[x][y];
		spaceTakenByBlack = new boolean[x][y];
		
		for(int var = 0; var < y; var++) {
			spaceTakenByWhite[var][0] = true;
			spaceTakenByWhite[var][1] = true;
			spaceTakenByBlack[var][y-2] = true;
			spaceTakenByBlack[var][y-1] = true;
		}
		
		//should use coordinates of the initialized pieces above instead of solid integer values
		viewwhitepawn1.setX(side/4); viewwhitepawn1.setY(side * 6.25);
		viewwhitepawn2.setX(side + (side/4)); viewwhitepawn2.setY(side * 6.25);
		viewwhitepawn3.setX((side * 2) + (side/4)); viewwhitepawn3.setY(side * 6.25);
		viewwhitepawn4.setX((side * 3) + (side/4)); viewwhitepawn4.setY(side * 6.25);
		viewwhitepawn5.setX((side * 4) + (side/4)); viewwhitepawn5.setY(side * 6.25);
		viewwhitepawn6.setX((side * 5) + (side/4)); viewwhitepawn6.setY(side * 6.25);
		viewwhitepawn7.setX((side * 6) + (side/4)); viewwhitepawn7.setY(side * 6.25);
		viewwhitepawn8.setX((side * 7) + (side/4)); viewwhitepawn8.setY(side * 6.25);
		viewwhiterook1.setY(side * 7);
		viewwhiteknight1.setX(side); viewwhiteknight1.setY(side * 7);
		viewwhitebishop1.setX(side*2); viewwhitebishop1.setY(side * 7);
		viewwhitequeen.setX(side*3); viewwhitequeen.setY(side * 7);
		viewwhiteking.setX(side*4); viewwhiteking.setY(side * 7);
		viewwhitebishop2.setX(side*5); viewwhitebishop2.setY(side * 7);
		viewwhiteknight2.setX(side*6); viewwhiteknight2.setY(side * 7);
		viewwhiterook2.setX(side*7); viewwhiterook2.setY(side * 7);
		
		viewblackpawn1.setX(side/4); viewblackpawn1.setY(side * 1.25);
		viewblackpawn2.setX(side + (side/4)); viewblackpawn2.setY(side * 1.25);
		viewblackpawn3.setX((side*2) + (side/4)); viewblackpawn3.setY(side * 1.25);
		viewblackpawn4.setX((side*3) + (side/4)); viewblackpawn4.setY(side * 1.25);
		viewblackpawn5.setX((side*4) + (side/4)); viewblackpawn5.setY(side * 1.25);
		viewblackpawn6.setX((side*5) + (side/4)); viewblackpawn6.setY(side * 1.25);
		viewblackpawn7.setX((side*6) + (side/4)); viewblackpawn7.setY(side * 1.25);
		viewblackpawn8.setX((side*7) + (side/4)); viewblackpawn8.setY(side * 1.25);
		// blackrook1 stays
		viewblackknight1.setX(side);
		viewblackbishop1.setX(side*2);
		viewblackqueen.setX(side*3);
		viewblackking.setX(side*4);
		viewblackbishop2.setX(side*5);
		viewblackknight2.setX(side*6);
		viewblackrook2.setX(side*7);
		
		root.getChildren().addAll(viewwhitepawn1, viewwhitepawn2, viewwhitepawn3, viewwhitepawn4, viewwhitepawn5, viewwhitepawn6, 
				viewwhitepawn7,	viewwhitepawn8, viewwhiterook1, viewwhiteknight1, viewwhitebishop1, viewwhitequeen, viewwhiteking, 
				viewwhitebishop2, viewwhiteknight2,	viewwhiterook2, viewblackpawn1, viewblackpawn2, viewblackpawn3, viewblackpawn4, 
				viewblackpawn5, viewblackpawn6, viewblackpawn7, viewblackpawn8, viewblackrook1, viewblackknight1, viewblackbishop1, 
				viewblackking, viewblackqueen, viewblackbishop2, viewblackknight2, viewblackrook2); 
		
		//////////////////////////////////////////////////////////////////////////
		
		whitePlayerTurn = false;
		extraInGroup = 0;
		amountInGroup = 64;
		
		toggleTurn();
		
		viewwhitepawn1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn1, viewwhitepawn1);
            }
		});
			
		viewwhitepawn2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn2, viewwhitepawn2);
            }
        });
			
		viewwhitepawn3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn3, viewwhitepawn3);
            }
        });
			
		viewwhitepawn4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn4, viewwhitepawn4);
            }
        });
			
		viewwhitepawn5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn5, viewwhitepawn5);
            }
        });

		viewwhitepawn6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn6, viewwhitepawn6);
            }
        });
			
		viewwhitepawn7.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn7, viewwhitepawn7);
            }
        });
			
		viewwhitepawn8.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitepawn8, viewwhitepawn8);
            }
        });
	
		viewwhiterook1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whiterook1, viewwhiterook1);
            }
        });
			
		viewwhiteknight1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whiteknight1, viewwhiteknight1);
            }
        });
			
		viewwhitebishop1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitebishop1, viewwhitebishop1);
            }
        });
			
		viewwhitequeen.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitequeen1, viewwhitequeen);
            }
        });
		
		viewwhiteking.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whiteking1, viewwhiteking);
            }
        });
			
		viewwhitebishop2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whitebishop2, viewwhitebishop2);
            }
        });
			
		viewwhiteknight2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whiteknight2, viewwhiteknight2);
            }
        });
			
		viewwhiterook2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, whiterook2, viewwhiterook2);
            }
        });
		
		viewblackpawn1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn1, viewblackpawn1);
            }
        });
			
		viewblackpawn2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn2, viewblackpawn2);
            }
        });
			
		viewblackpawn3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn3, viewblackpawn3);
            }
        });
			
		viewblackpawn4.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn4, viewblackpawn4);
            }
        });
			
		viewblackpawn5.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn5, viewblackpawn5);
            }
        });
			
		viewblackpawn6.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn6, viewblackpawn6);
            }
        });
		
		viewblackpawn7.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn7, viewblackpawn7);
            }
        });
			
		viewblackpawn8.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackpawn8, viewblackpawn8);
            }
        });
			
		viewblackrook1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackrook1, viewblackrook1);
            }
        });
			
		viewblackknight1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackknight1, viewblackknight1);
            }
        });
			
		viewblackbishop1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackbishop1, viewblackbishop1);
            }
        });
			
		viewblackqueen.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackqueen1, viewblackqueen);
            }
        });
			
		viewblackking.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackking1, viewblackking);
            }
        });
			
		viewblackbishop2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackbishop2, viewblackbishop2);
            }
        });
			
		viewblackknight2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackknight2, viewblackknight2);
            }
        });
			
		viewblackrook2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event) {
            	pieceClicked(event, blackrook2, viewblackrook2);
            }
        });
	}
	
	public void start(Stage primaryStage) {
		
		//////////////////////////////////////////////////////
		
		Scene scene = new Scene(startScreen, side*x, side*y);
		Button startBtn = new Button("Start 2 Player Game");
		startBtn.setOnMouseClicked(e -> { startGame(primaryStage, scene); });
		Button quitBtn = new Button("Quit");
		quitBtn.setOnMouseClicked(e -> {System.exit(0);});
		
		startScreen.getChildren().addAll(startBtn, quitBtn);
		startBtn.setTranslateX(side*((x/2)-1));
		startBtn.setTranslateY(side*((y/2)-1));
		quitBtn.setTranslateX(side*((x/2)-1));
		quitBtn.setTranslateY((side*((y/2)-1))+40);
		
		primaryStage.setScene(scene);
		primaryStage.show();	
		
	}
	
	//piece gets clicked
	public void pieceClicked(MouseEvent event, Piece p, ImageView vp) {
    	if(p.getNotTaken() && p.getPlaying()) {
        	p.setPieceSelected(true);
        	for(; extraInGroup > 0; extraInGroup--) {
        		root.getChildren().remove(amountInGroup);
        	}
        	theSquares = new Rectangle[x][y];
        	// CHANGE FROM ARRAY TO LIST
    		squaresLocation = new int[0][2];
    		if(p instanceof King)
    			theSquares = getSquaresForKing((King)p, whiterook1, whiterook2, blackrook1, blackrook2);
    		else
    			theSquares = getSquaresForPiece(p);
        	for(int c = 0; c < theSquares.length; c++) {
        		for(int r = 0; r <  theSquares[c].length; r++) {
        			if(theSquares[c][r] != null) {
        				addToEndSquaresLocation(c, r);
        				root.getChildren().add(theSquares[c][r]);
        				extraInGroup++;
        			}
        		}
        	}
			if (p.getNotTaken() && p.getPlaying() && p.getPieceSelected()) {
				for (int i = 1; i < squaresLocation.length; i++) {
					Rectangle r = theSquares[squaresLocation[i][0]][squaresLocation[i][1]];
					r.setOnMouseClicked(new EventHandler<MouseEvent>() {
						public void handle(MouseEvent event) {
							if (p.getIsWhite())
								whitePieceMoved(event, p, vp);
							else
								blackPieceMoved(event, p, vp);
						}
					});
				}
			}
    	}
	}
	
	//piece is moved
	public void whitePieceMoved(MouseEvent event, Piece p, ImageView vp) {
		int x = (int)event.getX()/100;
    	int y = 7 - ((int)event.getY()/100); //
		if(spaceTakenByBlack[x][y]) {
    		if(blackpawn1.getX()-1 == x && blackpawn1.getY()-1 == y) {
    			blackpawn1.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn1);
    			amountInGroup--;
    		}
    		else if(blackpawn2.getX()-1 == x && blackpawn2.getY()-1 == y) {
    			blackpawn2.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn2);
    			amountInGroup--;
    		}
    		else if(blackpawn3.getX()-1 == x && blackpawn3.getY()-1 == y) {
    			blackpawn3.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn3);
    			amountInGroup--;
    		}
    		else if(blackpawn4.getX()-1 == x && blackpawn4.getY()-1 == y) {
    			blackpawn4.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn4);
    			amountInGroup--;
    		}
    		else if(blackpawn5.getX()-1 == x && blackpawn5.getY()-1 == y) {
    			blackpawn5.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn5);
    			amountInGroup--;
    		}
    		else if(blackpawn6.getX()-1 == x && blackpawn6.getY()-1 == y) {
    			blackpawn6.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn6);
    			amountInGroup--;
    		}
    		else if(blackpawn7.getX()-1 == x && blackpawn7.getY()-1 == y) {
    			blackpawn7.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn7);
    			amountInGroup--;
    		}
    		else if(blackpawn8.getX()-1 == x && blackpawn8.getY()-1 == y) {
    			blackpawn8.setNotTaken(false);
    			root.getChildren().remove(viewblackpawn8);
    			amountInGroup--;
    		}
    		else if(blackrook1.getX()-1 == x && blackrook1.getY()-1 == y) {
    			blackrook1.setNotTaken(false);
    			root.getChildren().remove(viewblackrook1);
    			amountInGroup--;
    		}
    		else if(blackrook2.getX()-1 == x && blackrook2.getY()-1 == y) {
    			blackrook2.setNotTaken(false);
    			root.getChildren().remove(viewblackrook2);
    			amountInGroup--;
    		}
    		else if(blackbishop1.getX()-1 == x && blackbishop1.getY()-1 == y) {
    			blackbishop1.setNotTaken(false);
    			root.getChildren().remove(viewblackbishop1);
    			amountInGroup--;
    		}
    		else if(blackbishop2.getX()-1 == x && blackbishop2.getY()-1 == y) {
    			blackbishop2.setNotTaken(false);
    			root.getChildren().remove(viewblackbishop2);
    			amountInGroup--;
    		}
    		else if(blackknight1.getX()-1 == x && blackknight1.getY()-1 == y) {
    			blackknight1.setNotTaken(false);
    			root.getChildren().remove(viewblackknight1);
    			amountInGroup--;
    		}
    		else if(blackknight2.getX()-1 == x && blackknight2.getY()-1 == y) {
    			blackknight2.setNotTaken(false);
    			root.getChildren().remove(viewblackknight2);
    			amountInGroup--;
    		}
    		else if(blackqueen1.getX()-1 == x && blackqueen1.getY()-1 == y) {
    			blackqueen1.setNotTaken(false);
    			root.getChildren().remove(viewblackqueen);
    			amountInGroup--;
    		}
    		spaceTakenByBlack[x][y] = false;
    	}
    	for(; extraInGroup > 0; extraInGroup--) {
    		root.getChildren().remove(amountInGroup);
    	}
    	root.getChildren().remove(vp);
    	theSquares = new Rectangle[8][8];
    	squaresLocation = new int[0][2];
    	spaceTakenByWhite[p.getX()-1][p.getY()-1] = false;
    	spaceTakenByWhite[x][y] = true;
    	if(p instanceof Pawn) {
	    	p.setX(x+1);
	    	p.setY(y+1);
	    	vp.setX((x * 100) + 25);
	    	vp.setY((700 - (y * 100)) + 25);
    	}else {
    		p.setX(x+1);
	    	p.setY(y+1);
	    	vp.setX(x * 100);
	    	vp.setY(700 - (y * 100));
    	}
    	root.getChildren().add(vp);
    	p.generatePossibleMoves();
    	if(p.getAttackEnemyPossible()[blackking1.getX()-1][blackking1.getY()-1]) {
    		blackking1.setIsChecked(true);
    		blackking1.generatePossibleMoves();
    	}
    	if(p.getAttackEnemyPossible()[blackrook1.getX()-1][blackrook1.getY()-1])
    		blackrook1.setUnderAttack(true);
    	if(p.getAttackEnemyPossible()[blackrook2.getX()-1][blackrook2.getY()-1])
    		blackrook2.setUnderAttack(true);
    	if(blackking1.getIsChecked() && blackking1.getGeneratedPossibleMoves().length == 0) {
    		System.out.println("THE WHITE TEAM WINS");
    	}
    	else {
			toggleTurn();
			p.setPieceSelected(false);
    	}
	}
	
	public void blackPieceMoved(MouseEvent event, Piece p, ImageView vp) {
		int x = (int)event.getX()/100;
    	int y = 7 - ((int)event.getY()/100); //
		if(spaceTakenByWhite[x][y]) {
    		if(whitepawn1.getX()-1 == x && whitepawn1.getY()-1 == y) {
    			whitepawn1.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn1);
    			amountInGroup--;
    		}
    		else if(whitepawn2.getX()-1 == x && whitepawn2.getY()-1 == y) {
    			whitepawn2.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn2);
    			amountInGroup--;
    		}
    		else if(whitepawn3.getX()-1 == x && whitepawn3.getY()-1 == y) {
    			whitepawn3.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn3);
    			amountInGroup--;
    		}
    		else if(whitepawn4.getX()-1 == x && whitepawn4.getY()-1 == y) {
    			whitepawn4.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn4);
    			amountInGroup--;
    		}
    		else if(whitepawn5.getX()-1 == x && whitepawn5.getY()-1 == y) {
    			whitepawn5.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn5);
    			amountInGroup--;
    		}
    		else if(whitepawn6.getX()-1 == x && whitepawn6.getY()-1 == y) {
    			whitepawn6.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn6);
    			amountInGroup--;
    		}
    		else if(whitepawn7.getX()-1 == x && whitepawn7.getY()-1 == y) {
    			whitepawn7.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn7);
    			amountInGroup--;
    		}
    		else if(whitepawn8.getX()-1 == x && whitepawn8.getY()-1 == y) {
    			whitepawn8.setNotTaken(false);
    			root.getChildren().remove(viewwhitepawn8);
    			amountInGroup--;
    		}
    		else if(whiterook1.getX()-1 == x && whiterook1.getY()-1 == y) {
    			whiterook1.setNotTaken(false);
    			root.getChildren().remove(viewwhiterook1);
    			amountInGroup--;
    		}
    		else if(whiterook2.getX()-1 == x && whiterook2.getY()-1 == y) {
    			whiterook2.setNotTaken(false);
    			root.getChildren().remove(viewwhiterook2);
    			amountInGroup--;
    		}
    		else if(whitebishop1.getX()-1 == x && whitebishop1.getY()-1 == y) {
    			whitebishop1.setNotTaken(false);
    			root.getChildren().remove(viewwhitebishop1);
    			amountInGroup--;
    		}
    		else if(whitebishop2.getX()-1 == x && whitebishop2.getY()-1 == y) {
    			whitebishop2.setNotTaken(false);
    			root.getChildren().remove(viewwhitebishop2);
    			amountInGroup--;
    		}
    		else if(whiteknight1.getX()-1 == x && whiteknight1.getY()-1 == y) {
    			whiteknight1.setNotTaken(false);
    			root.getChildren().remove(viewwhiteknight1);
    			amountInGroup--;
    		}
    		else if(whiteknight2.getX()-1 == x && whiteknight2.getY()-1 == y) {
    			whiteknight2.setNotTaken(false);
    			root.getChildren().remove(viewwhiteknight2);
    			amountInGroup--;
    		}
    		else if(whitequeen1.getX()-1 == x && whitequeen1.getY()-1 == y) {
    			whitequeen1.setNotTaken(false);
    			root.getChildren().remove(viewwhitequeen);
    			amountInGroup--;
    		}
    		spaceTakenByWhite[x][y] = false;
    	}
    	for(; extraInGroup > 0; extraInGroup--) {
    		root.getChildren().remove(amountInGroup);
    	}
    	root.getChildren().remove(vp);
    	theSquares = new Rectangle[8][8];
    	squaresLocation = new int[0][2];
    	spaceTakenByBlack[p.getX()-1][p.getY()-1] = false;
    	spaceTakenByBlack[x][y] = true;
    	if(p instanceof Pawn) {
    		//check this (black pawn placement)
    		p.setX(x+1);
        	p.setY(y+1);
        	vp.setX((x * 100) + 25);
        	vp.setY((700 - (y * 100)) + 25);
    	}else {
    		p.setX(x+1);
        	p.setY(y+1);
        	vp.setX((x * 100));
        	vp.setY((700 - (y * 100)));
    	}
    	root.getChildren().add(vp);
    	p.generatePossibleMoves();
    	if(p.getAttackEnemyPossible()[whiteking1.getX()-1][whiteking1.getY()-1]) {
    		whiteking1.setIsChecked(true);
    		whiteking1.generatePossibleMoves();
    	}
    	if(p.getAttackEnemyPossible()[whiterook1.getX()-1][whiterook1.getY()-1])
    		whiterook1.setUnderAttack(true);
    	if(p.getAttackEnemyPossible()[whiterook2.getX()-1][whiterook2.getY()-1])
    		whiterook2.setUnderAttack(true);
    	if(whiteking1.getIsChecked() && whiteking1.getGeneratedPossibleMoves().length == 0) {
    		System.out.println("THE BLACK TEAM WINS");
    	}
    	else {
			toggleTurn();
			blackrook2.setPieceSelected(false);
    	}
    }
	
	public static boolean toggle(boolean value) {
		if(value)
			return false;
		else
			return true;
	}
	
	public static boolean[][] getSpaceTakenByWhite(){
		return spaceTakenByWhite;
	}
	
	public static boolean[][] getSpaceTakenByBlack(){
		return spaceTakenByBlack;
	}
	
	public Rectangle[][] getSquaresForPiece(Piece p) {
		Rectangle[][] squares = new Rectangle[8][8];
		p.generatePossibleMoves();
		squares[p.getX()-1][p.getY()-1] = new Rectangle(100, 100, Color.BLUE);
		squares[p.getX()-1][p.getY()-1].setX((p.getX()-1)*100);
		squares[p.getX()-1][p.getY()-1].setY(700-(p.getY()-1)*100);
		squares[p.getX()-1][p.getY()-1].setOpacity(0.4);
    	for(int i = 0; i < p.getGeneratedMoves().length; i++) {
    		if(!p.getAttackEnemyPossible()[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1])
    			squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1] = new Rectangle(100, 100, Color.YELLOW);
    		else
    			squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1] = new Rectangle(100, 100, Color.RED);
    		squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1].setX((p.getGeneratedMoves()[i][0]-1) * 100);
    		squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1].setY(700 - ((p.getGeneratedMoves()[i][1]-1) * 100));
    		squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1].setOpacity(0.5);
    	}
    	return squares;
	}
	
	public Rectangle[][] getSquaresForKing(King p, Rook r1, Rook r2, Rook r3, Rook r4) {
		Rectangle[][] squares = new Rectangle[8][8];
		p.generatePossibleMoves(r1, r2, r3, r4);
		squares[p.getX()-1][p.getY()-1] = new Rectangle(100, 100, Color.BLUE);
		squares[p.getX()-1][p.getY()-1].setX((p.getX()-1)*100);
		squares[p.getX()-1][p.getY()-1].setY((100*(8-1))-(p.getY()-1)*100);
		squares[p.getX()-1][p.getY()-1].setOpacity(0.4);
    	for(int i = 0; i < p.getGeneratedMoves().length; i++) {
    		if(!p.getAttackEnemyPossible()[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1])
    			squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1] = new Rectangle(100, 100, Color.YELLOW);
    		else
    			squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1] = new Rectangle(100, 100, Color.RED);
    		squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1].setX((p.getGeneratedMoves()[i][0]-1) * 100);
    		squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1].setY((100*(8-1))-((p.getGeneratedMoves()[i][1]-1) * 100));
    		squares[p.getGeneratedMoves()[i][0]-1][p.getGeneratedMoves()[i][1]-1].setOpacity(0.5);
    	}
    	return squares;
	}
	
	public void addToEndSquaresLocation(int c, int r) {
		int[][] newArr = new int[squaresLocation.length+1][2];
		for(int i = 0; i < newArr.length-1; i++) {
			for(int j = 0; j < 2; j++) {
				newArr[i][j] = squaresLocation[i][j];
			}
		}
		newArr[newArr.length-1][0] = c;
		newArr[newArr.length-1][1] = r;
		squaresLocation = newArr;
	}
	
	public void toggleTurn() {
		whitePlayerTurn = toggle(whitePlayerTurn);
		if(whitePlayerTurn) {
			blackpawn1.setPlaying(false);
			blackpawn2.setPlaying(false);
			blackpawn3.setPlaying(false);
			blackpawn4.setPlaying(false);
			blackpawn5.setPlaying(false);
			blackpawn6.setPlaying(false);
			blackpawn7.setPlaying(false);
			blackpawn8.setPlaying(false);
			blackrook1.setPlaying(false);
			blackrook2.setPlaying(false);
			blackknight1.setPlaying(false);
			blackknight2.setPlaying(false);
			blackbishop1.setPlaying(false);
			blackbishop2.setPlaying(false);
			blackqueen1.setPlaying(false);
			blackking1.setPlaying(false);

			whitepawn1.setPlaying(true);
			whitepawn2.setPlaying(true);
			whitepawn3.setPlaying(true);
			whitepawn4.setPlaying(true);
			whitepawn5.setPlaying(true);
			whitepawn6.setPlaying(true);
			whitepawn7.setPlaying(true);
			whitepawn8.setPlaying(true);
			whiterook1.setPlaying(true);
			whiterook2.setPlaying(true);
			whiteknight1.setPlaying(true);
			whiteknight2.setPlaying(true);
			whitebishop1.setPlaying(true);
			whitebishop2.setPlaying(true);
			whitequeen1.setPlaying(true);
			whiteking1.setPlaying(true);
		}
		else {
			blackpawn1.setPlaying(true);
			blackpawn2.setPlaying(true);
			blackpawn3.setPlaying(true);
			blackpawn4.setPlaying(true);
			blackpawn5.setPlaying(true);
			blackpawn6.setPlaying(true);
			blackpawn7.setPlaying(true);
			blackpawn8.setPlaying(true);
			blackrook1.setPlaying(true);
			blackrook2.setPlaying(true);
			blackknight1.setPlaying(true);
			blackknight2.setPlaying(true);
			blackbishop1.setPlaying(true);
			blackbishop2.setPlaying(true);
			blackqueen1.setPlaying(true);
			blackking1.setPlaying(true);
			
			whitepawn1.setPlaying(false);
			whitepawn2.setPlaying(false);
			whitepawn3.setPlaying(false);
			whitepawn4.setPlaying(false);
			whitepawn5.setPlaying(false);
			whitepawn6.setPlaying(false);
			whitepawn7.setPlaying(false);
			whitepawn8.setPlaying(false);
			whiterook1.setPlaying(false);
			whiterook2.setPlaying(false);
			whiteknight1.setPlaying(false);
			whiteknight2.setPlaying(false);
			whitebishop1.setPlaying(false);
			whitebishop2.setPlaying(false);
			whitequeen1.setPlaying(false);
			whiteking1.setPlaying(false);
		}
	}
}