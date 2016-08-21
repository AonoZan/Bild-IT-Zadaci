
package projekat_sedmica_03a;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 *  @author AonoZan Dejan Petrovic 2016 ©
 */
public class EndLayoutController {
	private MainApp mainApp;
	
	@FXML
	private ImageView notification;
	
	@FXML
	private void resetGoBack() {
		mainApp.retart();
		mainApp.changeScene("main");
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

