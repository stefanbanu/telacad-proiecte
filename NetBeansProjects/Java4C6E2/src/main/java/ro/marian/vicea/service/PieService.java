package ro.marian.vicea.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.marian.vicea.dao.PieDao;

@Service
public class PieService {
    @Autowired
    private PieDao pieDao;
    
    public Map<String, Number> getPieData() {
        return pieDao.getPieData();
    }
}
