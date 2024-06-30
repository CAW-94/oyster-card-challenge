import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    public void addBalanceUpdatesCurrentBalance(){
        Card oysterCard = new Card();
        oysterCard.addBalance(BigDecimal.valueOf(30));
        assertEquals(BigDecimal.valueOf(30),oysterCard.getBalance());
    }

    @Test
    public void checkBalanceThrowsExceptionIfBalanceNotMinFare(){
        Card card = new Card();

        assertThrows(IllegalArgumentException.class, () -> card.checkBalance(BigDecimal.valueOf(1.80)));
    }

    @Test
    public void removeBalanceSubtractsBusFare(){
        Card card = new Card(BigDecimal.valueOf(10));
        BusJourney journey = new BusJourney(card);
        BigDecimal fare = journey.getFare();

        card.removeBalance(fare);

        assertEquals(BigDecimal.valueOf(8.20).setScale(2, RoundingMode.HALF_EVEN),card.getBalance());

    }

    @Test
    public void removeBalanceSubtractsZonedFare(){
        Card card= new Card(BigDecimal.valueOf(10));
        Station station1 = new Station("Holborn");
        Station station2 = new Station("Wimbledon");
        TubeJourney journey = new TubeJourney(station1, station2);

        card.removeBalance(journey.determineFare());

        assertEquals(BigDecimal.valueOf(6.80).setScale(2, RoundingMode.HALF_EVEN),card.getBalance().setScale(2, RoundingMode.HALF_EVEN));


    }

}