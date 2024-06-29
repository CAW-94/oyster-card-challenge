import org.junit.Test;

import javax.swing.*;
import java.math.BigDecimal;

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

        assertEquals(BigDecimal.valueOf(8.20).setScale(2),card.getBalance());

    }

    @Test
    public void removeBalanceSubtractsZonedFare(){

    }

}