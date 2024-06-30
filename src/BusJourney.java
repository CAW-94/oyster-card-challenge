import java.math.BigDecimal;
import java.math.RoundingMode;

public class BusJourney extends Journey{
    Card card = new Card();
    final BigDecimal fare = fares.get("bus");

    public BusJourney(Card card){
        this.card = card;
    }

    public BusJourney(){}

    public void travel() {
        card.checkBalance(fare);
        card.removeBalance(fare);

    }

    public BigDecimal getFare() {
        return fares.get("bus").setScale(2, RoundingMode.HALF_EVEN);
    }
}
