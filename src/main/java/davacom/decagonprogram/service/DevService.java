package davacom.decagonprogram.service;

import davacom.decagonprogram.dto.DevGuarator;
import davacom.decagonprogram.entities.Decadev;
import davacom.decagonprogram.enums.STACK;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DevService {
    DevGuarator saveNewDev (DevGuarator devDto);
    ResponseEntity<?> getDev (Long id);
    List<Decadev> fetchDecadevs ();

    List<Decadev> searchForDevs(String query);

    List<Decadev> getDevByStack(STACK stack);

    List<Decadev> findDevByGuarantorName(String gname);

    Decadev findDevByGuarantorEmail(String email);

}
