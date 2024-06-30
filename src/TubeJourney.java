import java.math.BigDecimal;

public class TubeJourney extends Journey{
    private Station startStation;
    private Station endStation;
    private Boolean tappedIn = false;

    public TubeJourney(){
    }

    public TubeJourney(Station startStation, Station endStation){
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public void travel(Card card, Station startStation, Station endStation){
        tapIn(card, startStation);
        tapOut(card, endStation);
    }

    public void tapIn(Card card, Station startStation){
        this.startStation = startStation;
        card.checkBalance(this.startStation.getminFare());
        card.removeBalance(fares.get("max"));
        this.tappedIn = true;
    }

    public void tapOut(Card card, Station endStation){
        this.endStation = endStation;
        BigDecimal fare = this.determineFare();
        if(this.tappedIn) {
            card.addBalance(fares.get("max"));
        }card.removeBalance(fare);
            }

    public BigDecimal determineFare(){
        if(this.startStation == null){
            return fares.get("max");
        }
        else {
            int numFares = this.startStation.getZone().size() + this.endStation.getZone().size();
            if (numFares == 2) {
                return calculateFare();
            } else return calculateBoundaryFare();
        }
    }

    private BigDecimal calculateBoundaryFare(){
        //accounting for Earl's court - if travelling to EC from zone 1 and vice versa, zone 1 fare applies.
        if(this.startStation.getZone().size() == 2 && this.endStation.getZone().contains(1)
                || this.endStation.getZone().size() == 2 && this.startStation.getZone().contains(1)){
            return fares.get("zone1");
        }
        //if travelling to EC from zone 2 and vice versa, oneZone fare applies
        else return fares.get("oneZone");
    }

    private BigDecimal calculateFare(){
        if((this.startStation.getZone().contains(1) && this.endStation.getZone().contains(3))
                || (this.startStation.getZone().contains(3) && this.endStation.getZone().contains(1))){
            return fares.get("max");
        }
        if((this.startStation.getZone().contains(1) && this.endStation.getZone().contains(2))
                || (this.startStation.getZone().contains(2) && this.endStation.getZone().contains(1))){
            return fares.get("twoZoneIncl");
        }
        if((this.startStation.getZone().contains(2) && this.endStation.getZone().contains(3))
                || (this.startStation.getZone().contains(3) && this.endStation.getZone().contains(2))){
            return fares.get("twoZoneExcl");
        }
        if(this.startStation.getZone().contains(1) && this.endStation.getZone().contains(1)){
            return fares.get("zone1");
        }
        else return fares.get("oneZone");
    }


}
