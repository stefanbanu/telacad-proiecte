package ro.marian.vicea.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class PieDao {
    public Map<String, Number> getPieData() {
        Map<String, Number> pieData = new HashMap<>();
        pieData.put("Valoare 1", 543);
        pieData.put("Valoare 2", 33);
        pieData.put("Valoare 3", 134);
        pieData.put("Valoare 4", 76);
        return pieData;
    }
}
