//THE BAREBONES


/*import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

import java.text.DecimalFormat;

public class Main extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}


	@Override
	public void start(Stage window) throws Exception
	{
		TextField numberField1 = new TextField();
		TextField numberField2 = new TextField();
		TextField numberField3 = new TextField();
		Button calculate = new Button("Calculate Your Offer");
		Label opponentStake = new Label("Opponent's Offer");
		Label winRate = new Label("Odds");
		Label percentEV = new Label("Minimum EV%");
		Label myOffer = new Label("Suggested Offer");
		TextField offer = new TextField();
		AnchorPane mainAnchor = new AnchorPane(numberField1, numberField2, numberField3, calculate, opponentStake, winRate, percentEV, myOffer, offer);

		mainAnchor.setTopAnchor(opponentStake, 5.);
		mainAnchor.setLeftAnchor(opponentStake, 20.0);

		mainAnchor.setTopAnchor(numberField1, 20.0);
		mainAnchor.setLeftAnchor(numberField1, 20.0);

		mainAnchor.setTopAnchor(winRate, 45.0);
		mainAnchor.setLeftAnchor(winRate, 20.0);

		mainAnchor.setTopAnchor(numberField2, 60.0);
		mainAnchor.setLeftAnchor(numberField2, 20.0);

		mainAnchor.setTopAnchor(percentEV, 85.0);
		mainAnchor.setLeftAnchor(percentEV, 20.0);

		mainAnchor.setTopAnchor(numberField3, 100.0);
		mainAnchor.setLeftAnchor(numberField3, 20.0);

		mainAnchor.setBottomAnchor(calculate, 20.0);
		mainAnchor.setLeftAnchor(calculate, 20.0);

		mainAnchor.setBottomAnchor(myOffer, 50.0);
		mainAnchor.setRightAnchor(myOffer,20.0);

		mainAnchor.setBottomAnchor(offer, 20.0);
		mainAnchor.setRightAnchor(offer, 20.0);



		numberField1.textProperty().addListener((observable, oldValue, newValue) ->
		{
			if(!newValue.matches("\\d*"))
			{
				numberField1.setText(newValue.replaceAll("[^\\d]", ""));
			}
		});
		*/

		/*numberField2.textProperty().addListener((observable, oldValue, newValue) ->
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

		DecimalFormat shortHand = new DecimalFormat("##.##");




		calculate.setOnAction(event ->
		{
			offer.setText("");
			double initialStake = Double.parseDouble(numberField1.getText());
			double winOdds = Double.parseDouble(numberField2.getText());
			double expectedValuePercent = Double.parseDouble(numberField3.getText());

			double yourOffer = expectedValue(winOdds, expectedValuePercent, initialStake);

			offer.appendText(shortHand.format(yourOffer));
		} );







		window.setTitle("EV Calculator");
		window.setScene(new Scene(mainAnchor, 350, 200));
		window.show();
	}

	private static double expectedValue(double winRate, double minEV, double opponentStake)
	{
		winRate = winRate / 100;
		minEV = minEV / 100;

		double yourStake = (winRate * opponentStake) / (minEV + (1 - winRate));

		return yourStake;

	}


}*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{
	private Stage primaryStage;
	private AnchorPane layout;


	@Override
	public void start(Stage primaryStage)
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("EV Calculator");

		initLayout();


	}



	public void initLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Calculator.fxml"));
			layout = loader.load();

			Scene scene = new Scene(layout);

			primaryStage.getIcons().add(new Image("/cx.jpg"));
			scene.getStylesheets().add(getClass().getResource("/stylesheet.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();



			Calculator controller = loader.getController();
			controller.setMain(this);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


	public static void main(String[] args)
	{

		launch(args);



	}






}
