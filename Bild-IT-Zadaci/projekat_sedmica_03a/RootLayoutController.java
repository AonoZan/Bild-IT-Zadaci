
package projekat_sedmica_03a;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class RootLayoutController {
	private MainApp mainApp;
	
	@FXML
	private ImageView place1;
	@FXML
	private ImageView place2;
	@FXML
	private ImageView place3;
	@FXML
	private ImageView place4;
	@FXML
	private ImageView place5;
	@FXML
	private ImageView place6;
	@FXML
	private ImageView place7;
	@FXML
	private ImageView place8;
	@FXML
	private ImageView place9;
	
	@FXML
	private ImageView table;
	@FXML
	private ImageView notification;
	
	@FXML
	private void changeBackground() {
		mainApp.changeBackground();
	}
	
	@FXML
	private void handleField1() {
		mainApp.makeMove(1);
	}
	@FXML
	private void handleField2() {
		mainApp.makeMove(2);
	}
	@FXML
	private void handleField3() {
		mainApp.makeMove(3);
	}
	@FXML
	private void handleField4() {
		mainApp.makeMove(4);
	}
	@FXML
	private void handleField5() {
		mainApp.makeMove(5);
	}
	@FXML
	private void handleField6() {
		mainApp.makeMove(6);
	}
	@FXML
	private void handleField7() {
		mainApp.makeMove(7);
	}
	@FXML
	private void handleField8() {
		mainApp.makeMove(8);
	}
	@FXML
	private void handleField9() {
		mainApp.makeMove(9);
	}
	
	
	/**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}

