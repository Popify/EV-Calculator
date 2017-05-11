import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.*;


public class Calculator
{
	@FXML
	private Label oddsPercent;

	@FXML
	private Label opponentStake;

	@FXML
	private TableView<Offer> calculationsTable;

	@FXML
	private TableColumn<Offer, String> percentEV;

	@FXML
	private TableColumn<Offer, Double> offer;

	@FXML
	private Button calculate;

	@FXML
	private TextField stakeAmount;

	@FXML
	private TextField winRate;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	private Main main;



	public Calculator()
	{




	}

	@FXML
	void initialize()
	{
		stakeAmount.setText("0");
		winRate.setText("0");

		offerData.add(new Offer("10.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 10)));
		offerData.add(new Offer("12.5%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 12.5)));
		offerData.add(new Offer("15.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 15)));
		offerData.add(new Offer("17.5%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 17.5)));
		offerData.add(new Offer("20.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 20)));
		offerData.add(new Offer("25.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 25)));
		offerData.add(new Offer("30.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 30)));
		offerData.add(new Offer("35.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 35)));
		offerData.add(new Offer("40.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 40)));




		percentEV.setCellValueFactory(cellData -> cellData.getValue().percentEVProperty());
		offer.setCellValueFactory(cellData -> cellData.getValue().offerResultProperty().asObject());


	}

	public void setMain(Main main)
	{
		this.main = main;



		calculationsTable.setItems(getOfferData());

		calculate.setOnAction(event ->
		{
			offerData.removeAll(offerData);
			offerData.add(new Offer("10.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 10)));
			offerData.add(new Offer("12.5%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 12.5)));
			offerData.add(new Offer("15.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 15)));
			offerData.add(new Offer("17.5%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 17.5)));
			offerData.add(new Offer("20.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 20)));
			offerData.add(new Offer("25.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 25)));
			offerData.add(new Offer("30.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 30)));
			offerData.add(new Offer("35.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 35)));
			offerData.add(new Offer("40.0%", expectedValue(Double.parseDouble(winRate.getText()), Double.parseDouble(stakeAmount.getText()), 40)));
			calculationsTable.refresh();
		});

	}

	private static double expectedValue(double winRate, double opponentStake, double preferredEV)
	{
		//DecimalFormat dollars = new DecimalFormat("#.##");
		winRate /= 100;

		double yourStake = (winRate * opponentStake) / (preferredEV + (1 - winRate));

		//yourStake = Double.valueOf(dollars.format(yourStake));

		return yourStake;

	}

	private ObservableList<Offer> offerData = FXCollections.observableArrayList();


	public ObservableList<Offer> getOfferData()
	{
		return offerData;
	}



}


