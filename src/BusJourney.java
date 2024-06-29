import java.math.BigDecimal;

public class BusJourney extends Journey{
    Card card = new Card();
    BigDecimal fare = fares.get("bus");

    public BusJourney(Card card){
        this.card = card;
    }

    public BusJourney(){}

    @Override
    public void travel() {
        card.checkBalance(fare);
        card.removeBalance(fare);

    }

    @Override
    public BigDecimal getFare() {
        return fares.get("bus").setScale(2);
    }
}
