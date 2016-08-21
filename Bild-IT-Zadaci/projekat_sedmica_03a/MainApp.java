
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
 */
public class MainApp extends Application{
	private Stage primaryStage;
    private AnchorPane rootLayout;
    private Scene scene;
    private String[] tableList = {
			"Images\\Table_01.png",
			"Images\\Table_02.png",
			"Images\\Table_03.png",
			"Images\\Table_04.png",
	};
    
    private String[] player1List = {
			"Images\\Player1_01.png",
			"Images\\Player1_02.png",
			"Images\\Player1_03.png",
			"Images\\Player1_04.png",
			"Images\\Player1_05.png",
			"Images\\Player1_06.png"
	};
	private String[] player2List = {
			"Images\\Player2_01.png",
			"Images\\Player2_02.png",
			"Images\\Player2_03.png",
			"Images\\Player2_04.png",
			"Images\\Player2_05.png",
			"Images\\Player2_06.png"
	};
    private String[] player1Move = {
    		"Images\\Player1Move.png"
    };
    private String[] player2Move = {
    		"Images\\Player2Move.png"
    };
    private String[] player1Won = {
    		"Images\\Player1Won.png"
    };
    private String[] player2Won = {
    		"Images\\Player2Won.png"
    };
	private String player1 = "X";
	private String player2 = "O";
	private Place[][] ticPaths = new Place[8][3];
	private boolean turns = false;
	
	
	@Override
    public void start(Stage primaryStage) {
		refilTable();
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Game: Tic Tac Toe");
        initRootLayout();
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
    private Image getRandom(String[] pathList) {
		int rndIndex = (int)(Math.random() * pathList.length);
		Image img = new Image(RootLayoutController.class.getResourceAsStream(pathList[rndIndex]));
		return img;
	}
    public void pickImage(int place, int player) {
    	ImageView img = (ImageView) scene.lookup("#place" + place);
    	if (img.getImage() == null) {
    		if (player == 1) {
				img.setImage(getRandom(player1List));
			} else if (player == 2) {
				img.setImage(getRandom(player2List));
			}
    	} else {
    		System.out.println("Already made move.");
    	}
    }
    /**
	 * Print whole table.
	 */
	public void printTable() {
		// for all rows eg. combination of 123
		for (int i = 0; i < ticPaths.length; i++) {
			for (int j = 0; j < ticPaths[i].length; j++) {
				System.out.print(ticPaths[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
	public void printList(int[] list) {
		for (int i : list) {
			System.out.println(i + " ");
		}
		System.out.println();
	}
    /**
	 * Method for filling place in table.
	 * @param place
	 * @param player
	 */
	public void makeMove(int place) {
		int player = makeTurn();
		ImageView img = (ImageView) scene.lookup("#place" + place);
    	if (img.getImage() == null) {
    		if (player == 1) {
				img.setImage(getRandom(player1List));
				ticPaths[(place-1)/3][(place-1)%3].setValue(player1);
				showNotification(player2Move, 2000);
			} else if (player == 2) {
				img.setImage(getRandom(player2List));
				ticPaths[(place-1)/3][(place-1)%3].setValue(player2);
				showNotification(player1Move, 2000);
			}
    	} else {
    		System.out.println("Already made move.");
    	}
		printTable();
		System.out.println(getWinner());
	}
	private String getWinner() {
		int counter = 0;
		for (Place[] places : ticPaths) {
			int p1 = 0;
			int p2 = 0;
			for (Place place : places) {
				if (place.getValue() == player1) {
					p1++;
					counter++;
				} else if (place.getValue() == player2) {
					p2++;
					counter++;
				}
				if (p1 == 3) return player1;
				else if (p2 == 3) return player2;
			}
		}
		if (counter == 24) return "Draw";
		return null;
	}
	private void showNotification(String[] list, int duration) {
		ImageView notification = (ImageView) scene.lookup("#notification");
		notification.setImage(getRandom(list));
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
	private void refilTable() {
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
	private int makeTurn() {
		turns = !turns;
		return turns ? 1 : 2;
	}
    
	public void changeBackground() {
		ImageView table = (ImageView) scene.lookup("#table");
		table.setImage(getRandom(tableList));
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}

