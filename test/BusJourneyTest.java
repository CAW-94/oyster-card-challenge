import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

public class BusJourneyTest {

    @Test
    public void getFareReturnsBusFare(){
        BusJourney journey = new BusJourney();
        assertEquals(BigDecimal.valueOf(1.80).setScale(2, RoundingMode.HALF_EVEN),journey.getFare());

    }

    @Test
    public void whenJourneyIsTakenCardIsChargedBusFare(){
        Card card = new Card(BigDecimal.valueOf(10));
        BusJourney journey = new BusJourney(card);

        journey.travel();

        assertEquals(BigDecimal.valueOf(8.20),card.getBalance());
    }

}