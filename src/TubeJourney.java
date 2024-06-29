import java.math.BigDecimal;
import java.util.Set;

public class TubeJourney extends Journey{
    public Station startStation;
    public Station endStation;
    public Set<Integer> zones;
    public BigDecimal fare;
    private Boolean tappedIn = false;

    public TubeJourney(){
    }

    public TubeJourney(Station startStation, Station endStation){
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public Boolean tapIn(Card card, Station startStation){
        this.startStation = startStation;
        card.checkBalance(this.startStation.getminFare());
        card.removeBalance(fares.get("max"));
        this.tappedIn = true;
        return this.tappedIn;
    }

    public void tapOut(Card card, Station endStation){
        this.endStation = endStation;
        BigDecimal fare = this.calculateFare();
        if(this.tappedIn) {
            card.addBalance(fares.get("max"));
        }card.removeBalance(fare);
            }


    public BigDecimal calculateFare(){
        if(!(this.startStation == null)){
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
        else return fares.get("oneZone");}
        else return fares.get("max");
    }


}
