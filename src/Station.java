import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Station {

    String name;
    Set<Integer> zone;
    BigDecimal minFare;
    Map<String, Set<Integer>> zones = new HashMap<String, Set<Integer>>(){{
        put("Holborn",Set.of(1));
        put("Earl's Court",Set.of(1,2));
        put("Wimbledon",Set.of(3));
        put("Hammersmith",Set.of(2));
    }};


    public Station(String name){
        this.name = name;
        this.zone = zones.get(name);
    }

    public String getName(){
        return this.name;
    }

    public Set<Integer> getZone(){
        return this.zone;
    }

    public BigDecimal getminFare() {
        if(this.zone.contains(1)){
            this.minFare = BigDecimal.valueOf(2.50);
        } else this.minFare = BigDecimal.valueOf(2.00);
        return this.minFare;
    }
}
