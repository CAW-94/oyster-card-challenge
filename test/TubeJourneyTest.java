import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TubeJourneyTest {

    @Test
    public void tappingInChargesMaxFare(){
        TubeJourney journey = new TubeJourney();
        Card oysterCard = new Card(BigDecimal.valueOf(30));
        Station station = new Station("Holborn");

        journey.tapIn(oysterCard,station);

        assertEquals(BigDecimal.valueOf(26.80),oysterCard.getBalance());
    }

    @Test
    public void tappingOutWithoutTappingInChargesMaxFare(){
        TubeJourney journey = new TubeJourney();
        Card oysterCard = new Card(BigDecimal.valueOf(30));
        Station station1 = new Station("Wimbledon");

        journey.tapOut(oysterCard,station1);

        assertEquals(BigDecimal.valueOf(26.80),oysterCard.getBalance());
    }

    @Test
    public void tappingInWithoutMinFareThrowsError(){
        TubeJourney journey = new TubeJourney();
        Card oysterCard = new Card(BigDecimal.valueOf(30));
        Station station1 = new Station("Wimbledon");

    }

    @Test
    public void travellingInZoneOneChargesCorrectFare(){
        Station station = new Station("Holborn");
        TubeJourney journey = new TubeJourney(station, station);
        assertEquals(BigDecimal.valueOf(2.5),journey.calculateFare());
    }

    @Test
    public void travellingInOneZoneChargesCorrectFare(){
        Station station = new Station("Hammersmith");
        TubeJourney journey = new TubeJourney(station, station);
        assertEquals(BigDecimal.valueOf(2),journey.calculateFare());
    }

}