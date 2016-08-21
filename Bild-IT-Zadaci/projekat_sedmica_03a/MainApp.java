
package projekat_sedmica_03a;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 *  
 *  <br>This project is made with help of the
 *  <a href="http://code.makery.ch/library/javafx-8-tutorial/">Code Makery JavaFX 8 Tutorial</a>.
 */
public class MainApp extends Application{
	private Stage primaryStage;
    private AnchorPane rootLayout;
    private AnchorPane endLayout;
    private Scene scene;
    private Scene endScene;
    
    // list of table images
    private String[] tableList = {
			"Images\\Table_01.png",
			"Images\\Table_02.png",
			"Images\\Table_03.png",
			"Images\\Table_04.png",
	};
    // list of al "X" images for player1
    private String[] player1List = {
			"Images\\Player1_01.png",
			"Images\\Player1_02.png",
			"Images\\Player1_03.png",
			"Images\\Player1_04.png",
			"Images\\Player1_05.png",
			"Images\\Player1_06.png"
	};
    // list of all "O" images for player2
	private String[] player2List = {
			"Images\\Player2_01.png",
			"Images\\Player2_02.png",
			"Images\\Player2_03.png",
			"Images\\Player2_04.png",
			"Images\\Player2_05.png",
			"Images\\Player2_06.png"
	};
	// list of all notification messages for players turns
    private String[] player1Move = {
    		"Images\\Player1Move_01.png"
    };
    private String[] player2Move = {
    		"Images\\Player2Move_01.png"
    };
    // list of all notification messages for game over status
    private String[] drawsWon = {
    		"Images\\Draws_01.png"
    };
    private String[] player1Won = {
    		"Images\\Player1Won.png"
    };
    private String[] player2Won = {
    		"Images\\Player2Won.png"
    };
    // matching string for two players
	private String player1 = "X";
	private String player2 = "O";
	// all possible combinations of paths on table
	private Place[][] ticPaths = new Place[8][3];
	// boolean to control which player has turn
	private boolean turns = false;
	
	/**
	 * Method that is called first time.
	 * Method refills combination table, sets stage and title
	 * and initiates layouts.
	 */
	@Override
    public void start(Stage primaryStage) {
		// set primary stage and title
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Game: Tic Tac Toe");
        // initiate layouts
        initRootLayout();
        initEndLayout();
        // set all possible combinations on table
        refillTable();
    }
	/**
	 * Method that restarts everything.
	 */
	public void retart() {
		// create new table and refill it
		this.ticPaths = new Place[8][3];
		refillTable();
		// get new background
		changeBackground();
		// erase every player turn image on table
		for (int i = 1; i <= 9; i++) {
			ImageView place = (ImageView) scene.lookup("#place" + i);
			Image img = place.getImage();
			if (img != null) img = null;
			place.setImage(null);
			// do system garbage collector
			System.gc();
		}
		// show first message for what player has turn
		if (!turns) {
			showNotification(player1Move, 5000);
		} else {
			showNotification(player2Move, 5000);
		}
	}
	/**
	 * Method for quick scene switching.
	 * @param arg
	 */
	public void changeScene(String arg) {
		if (arg == "game over") {
			primaryStage.setScene(endScene);
		} else if (arg == "main") {
			primaryStage.setScene(scene);
		}
	}
	/**
	 * End layout for game over scene.
	 */
	public void initEndLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("EndLayout.fxml"));
            endLayout = (AnchorPane) loader.load();
            
            // set scene to global variable
            endScene = new Scene(endLayout);
            
            // reference this class to the end controller
            EndLayoutController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("RootLayout.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            // Show the scene containing the root layout.
            scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.setResizable(false);
            primaryStage.show();
            
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            
            showNotification(player1Move, 5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method returns Image created with randomly picked path from list.
     * @param pathList
     * @return
     */
    private Image getRandomImage(String[] pathList) {
    	// get random index
		int rndIndex = (int)(Math.random() * pathList.length);
		// create new Image and return it
		Image img = new Image(RootLayoutController.class.getResourceAsStream(pathList[rndIndex]));
		return img;
	}
    /**
	 * Method is called when player clicks on any place on the table.
     * Method picks random image for whichever player played turn
     * and places it on the table.
	 * @param place
	 * @param player
	 */
	public void makeMove(int place) {
		// get current player as number
		int player = makeTurn();
		// get Image object using place number
		ImageView img = (ImageView) scene.lookup("#place" + place);
    	// if place is not already taken
		if (img.getImage() == null) {
			// for players set new image do calculations and show message
    		if (player == 1) {
				img.setImage(getRandomImage(player1List));
				ticPaths[(place-1)/3][(place-1)%3].setValue(player1);
				showNotification(player2Move, 2000);
			} else if (player == 2) {
				img.setImage(getRandomImage(player2List));
				ticPaths[(place-1)/3][(place-1)%3].setValue(player2);
				showNotification(player1Move, 2000);
			}
    	// if place on table is already taken
    	} else {
    		System.out.println("Already made move.");
    	}
		// get winner
		String winner = getWinner();
		// if winner is set
		if (winner != null) {
			// change to end scene and get notification Image object
			changeScene("game over");
			ImageView notification = (ImageView) endScene.lookup("#notification");
			// change image based on who is winner
			if (winner == "Draw") {
				notification.setImage(getRandomImage(drawsWon));
			} else if (winner == player1) {
				notification.setImage(getRandomImage(player1Won));
			} else if (winner == player2) {
				notification.setImage(getRandomImage(player2Won));
			}
		}
	}
	/**
	 * Method for checking if there is winner durning game.
	 * @return
	 */
	private String getWinner() {
		// counter for total number of turns(inside calculations)
		int counter = 0;
		for (Place[] places : ticPaths) {
			// counters for player places
			int p1 = 0;
			int p2 = 0;
			// loop over combinations of places
			for (Place place : places) {
				// count how many player 1 or 2 places
				if (place.getValue() == player1) {
					p1++;
					counter++;
				} else if (place.getValue() == player2) {
					p2++;
					counter++;
				}
				// if any of the players filled whole combination of 3 places
				// return that player
				if (p1 == 3) return player1;
				else if (p2 == 3) return player2;
			}
		}
		// if all turns taken place and no winner return draws
		if (counter == 24) return "Draw";
		// for no winner return null
		return null;
	}
	/**
	 * Method shows in game notification with fade out effect.
	 * @param list
	 * @param duration
	 */
	private void showNotification(String[] list, int duration) {
		// get notification object from scene and set image
		ImageView notification = (ImageView) scene.lookup("#notification");
		notification.setImage(getRandomImage(list));
		// create fadeout effect and play it on notification
		FadeTransition ft = new FadeTransition(Duration.millis(duration),
				notification);
		
		ft.setFromValue(1.0);
	    ft.setToValue(0.0);
	    ft.play();
	}
	/**
	 * Construct table of combinations.
	 * for table that looks like this:
	 * 1 2 3
	 * 4 5 6
	 * 7 8 9
	 * Player 1 wins if he fills for example 1,2 and 3 place.
	 * This method constructs all possible combination
	 * that player can fill to win.
	 */
	private void refillTable() {
		// for row combinations
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < ticPaths[0].length; j++) {
				ticPaths[i][j] = new Place();
			}
		}
		// copy places into vertical combinations
		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < ticPaths[0].length; j++) {
				ticPaths[i][j] = ticPaths[j][i-3];
			}
		}
		// and copy places into narrow combinations
		for (int j = 0; j < 3; j++) {
			ticPaths[6][j] = ticPaths[j][j];
			ticPaths[7][j] = ticPaths[j][2-j];
		}
	}
	// make turn and flip boolean for turns
	private int makeTurn() {
		turns = !turns;
		return turns ? 1 : 2;
	}
    /**
     * Method for changing table look.
     */
	public void changeBackground() {
		// get table object
		ImageView table = (ImageView) scene.lookup("#table");
		// erase old image
		Image img = table.getImage();
		if (img != null) img = null;
		table.setImage(null);
		// do garbage collector for old image
		System.gc();
		// change to new random image
		table.setImage(getRandomImage(tableList));
	}
	// main method that starts everything
	public static void main(String[] args) {
        launch(args);
    }
}

