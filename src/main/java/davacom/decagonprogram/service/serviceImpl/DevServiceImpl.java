package davacom.decagonprogram.service.serviceImpl;

import davacom.decagonprogram.dto.DevGuarator;
import davacom.decagonprogram.entities.Decadev;
import davacom.decagonprogram.entities.Guarantor;
import davacom.decagonprogram.enums.STACK;
import davacom.decagonprogram.repositories.DecadevRepository;
import davacom.decagonprogram.service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DevServiceImpl implements DevService {

    private final DecadevRepository decadevRepository;

    @Override
    public DevGuarator saveNewDev(DevGuarator devGuarator) {
        Decadev decadev = new Decadev();
        BeanUtils.copyProperties(devGuarator,decadev);
        Guarantor guarantor = Guarantor.builder()
                .guarantor_email(devGuarator.getGuarantor_email())
                .fullName(devGuarator.getGuarantor_fullName())
                .guarantor_phoneNumber(devGuarator.getGuarantor_phoneNumber())
                .build();

        decadev.setGuarantor(guarantor);
        try {
            decadevRepository.save(decadev);
            return devGuarator;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<?> getDev(Long id) {
        Optional<Decadev> dev = decadevRepository.findById(id);
        if(dev.isEmpty()){
            return new ResponseEntity<>("No such dev with id: "+ id +" dev was found.", NOT_FOUND);
        }
        return new ResponseEntity<>(dev, FOUND);
    }

    @Override
    public List<Decadev> fetchDecadevs() {
        return decadevRepository.findAll();
    }

    @Override
    public List<Decadev> searchForDevs(String query) {
        List<Decadev> dev = decadevRepository.searchDevs(query);
        return dev;
    }


    @Override
    public List<Decadev> getDevByStack(STACK stack) {
        List<Decadev> devs = decadevRepository.findByStack(stack);
        return devs;
    }

    @Override
    public List<Decadev> findDevByGuarantorName(String gname) {
        return decadevRepository.findByGuarantorFullName(gname);
    }

    @Override
    public Decadev findDevByGuarantorEmail(String email) {
        return decadevRepository.findByGuarantorEmail(email);
    }


}
