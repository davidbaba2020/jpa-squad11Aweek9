package davacom.decagonprogram.repositories;

import davacom.decagonprogram.entities.Decadev;
import davacom.decagonprogram.enums.STACK;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class DecadevRepositoryTest {

    @Autowired
    private DecadevRepository decadevRepository;

        Decadev dev = Decadev.builder()
                .firstName("David")
                .lastName("Baba")
                .emailId("david@gmail.com")
                .stack(STACK.JAVA)
                .build();
    @Test
    public void saveDev () {
        decadevRepository.save(dev);
    }


    @Test
    public void getAllDevs () {
        List<Decadev> devs = decadevRepository.findAll();
        assertThat(devs.size()==1);
        System.out.println(devs);
    }
}