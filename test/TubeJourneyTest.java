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
        assertEquals(BigDecimal.valueOf(2.5),journey.determineFare());
    }

    @Test
    public void travellingInOneZoneChargesCorrectFare(){
        Station station = new Station("Hammersmith");
        TubeJourney journey = new TubeJourney(station, station);
        assertEquals(BigDecimal.valueOf(2),journey.determineFare());
    }

    @Test
    public void travellingInBoundaryStationChargesLowestFare(){
        Station station1 = new Station("Holborn");
        Station station2 = new Station("Earl's Court");
        Station station3 = new Station("Hammersmith");

        TubeJourney journey = new TubeJourney(station1, station2);
        TubeJourney journey2 = new TubeJourney(station2, station3);

        assertEquals(BigDecimal.valueOf(2.5),journey.determineFare());
        assertEquals(BigDecimal.valueOf(2),journey2.determineFare());
    }

    @Test
    public void usingTravelMethodChargesCorrectAmount(){
        Station station1 = new Station("Holborn");
        Station station2 = new Station("Earl's Court");
        TubeJourney journey = new TubeJourney();
        Card card = new Card(BigDecimal.valueOf(10));

        journey.travel(card, station1, station2);

        assertEquals(BigDecimal.valueOf(7.50),card.getBalance());

    }

}