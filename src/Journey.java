import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Journey {

    Map<String, BigDecimal> fares = new HashMap<String, BigDecimal>(){{
        put("bus",BigDecimal.valueOf(1.80));
        put("max",BigDecimal.valueOf(3.20));
        put("zone1",BigDecimal.valueOf(2.50));
        put("oneZone",BigDecimal.valueOf(2));
        put("twoZoneExcl",BigDecimal.valueOf(2.25));
        put("twoZoneIncl",BigDecimal.valueOf(3));
    }};

    void travel(){};

    BigDecimal getFare(){
        return null;
    };
}
