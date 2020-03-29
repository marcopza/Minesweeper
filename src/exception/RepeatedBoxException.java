package exception;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RepeatedBoxException extends Exception {
	public RepeatedBoxException(String message) {
		super(message);
	}
	

}
