//THE BAREBONES


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class Main extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}


	@Override
	public void start(Stage window) throws Exception
	{
		Stage stage = new Stage();
		TextField numberField1 = new TextField();
		TextField numberField2 = new TextField();
		TextField numberField3 = new TextField();
		Button calculate = new Button();


		numberField1.textProperty().addListener((observable, oldValue, newValue) ->
		{
			if(!newValue.matches("\\d*"))
			{
				numberField1.setText(newValue.replaceAll("[^\\d]", ""));
			}
		});

		numberField2.textProperty().addListener((observable, oldValue, newValue) ->
		{
			if(!newValue.matches("\\d*"))
			{
				numberField2.setText(newValue.replaceAll("[^\\d]", ""));
			}
		});

		numberField3.textProperty().addListener(((observable, oldValue, newValue) ->
		{
			if(!newValue.matches("\\d*"))
			{
				numberField3.setText(newValue.replaceAll("[^\\d]", ""));
			}
		}));




		calculate.setOnAction(event ->
		{
			expectedValue();
		} );



		window.setTitle("EV Calculator");
		window.setScene(new Scene(numberField1, 350, 200));
		window.show();
	}

	private static double expectedValue(double winRate, double minEV, double opponentStake)
	{
		winRate = winRate / 100;
		minEV = minEV / 100;

		double yourStake = (winRate * opponentStake) / (minEV + (1 - winRate));

		return yourStake;

	}


}
