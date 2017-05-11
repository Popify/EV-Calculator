import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Snizzle on 5/11/2017.
 */
public class Offer
{
	private final StringProperty percentEV;
	private final DoubleProperty offerResult;

	public Offer()
	{
		this(null, null);
	}

	public Offer(String percentEV, Double offerResult)
	{
		this.percentEV = new SimpleStringProperty(percentEV);
		this.offerResult = new SimpleDoubleProperty(offerResult);
	}

	public String getPercentEV()
	{
		return percentEV.get();
	}

	public void setPercentEV(String percentEV)
	{
		this.percentEV.set(percentEV);
	}

	public StringProperty percentEVProperty()
	{
		return percentEV;
	}

	public double getOfferResult()
	{
		return offerResult.get();
	}

	public void setOfferResult(double offerResult)
	{
		this.offerResult.set(offerResult);
	}

	public DoubleProperty offerResultProperty()
	{
		return offerResult;
	}
}
