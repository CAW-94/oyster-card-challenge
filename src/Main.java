import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        //Set variables
        Station stationHol = new Station("Holborn");
        Station stationEC = new Station("Earl's Court");
        Station stationHam = new Station("Hammersmith");
        TubeJourney journeyTube = new TubeJourney();
        Card oysterCard = new Card();
        BusJourney journeyBus = new BusJourney(oysterCard);

        //load balance of £30
        oysterCard.addBalance(BigDecimal.valueOf(30));
        System.out.println("Balance of £30 loaded onto card");

        //Make journey from Holborn to Earl's Court
        journeyTube.tapIn(oysterCard, stationHol);
        System.out.println("Tapped in at " + stationHol.getName());

        journeyTube.tapOut(oysterCard,stationEC);
        System.out.printf("Tapped out at " + stationEC.getName());

        //Make bus journey from Earl's Court to Chelsea
        journeyBus.travel();
        System.out.println("\nBus journey");

        //Make return bus journey?
        journeyBus.travel();
        System.out.println("Return bus journey");

        //Make journey from Earl's Court to Hammersmith
        journeyTube.tapIn(oysterCard,stationEC);
        System.out.println("Tapped in at " + stationEC.getName());
        journeyTube.tapOut(oysterCard,stationHam);
        System.out.println("Tapped out at " + stationHam.getName());

        //Check balance

        oysterCard.checkBalance();
}
}