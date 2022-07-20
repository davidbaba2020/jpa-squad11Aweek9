package davacom.decagonprogram.repositories;

import davacom.decagonprogram.entities.Decadev;
import davacom.decagonprogram.enums.STACK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DecadevRepository extends JpaRepository <Decadev, Long> {


    @Query("SELECT d FROM Decadev d WHERE " +
            "d.firstName LIKE CONCAT('%',:query, '%')" +
            "OR d.lastName LIKE CONCAT('%',:query, '%')" +
            "OR d.emailId LIKE CONCAT('%',:query, '%')"
    )
    List<Decadev> searchDevs(String query);

    List<Decadev> findByStack(STACK stack);
    List<Decadev> findByGuarantorFullName(String fullNameString);

    //JPQL -Java Persistent Query Language
    @Query("SELECT d FROM Decadev d WHERE d.guarantor.guarantor_email =?1")
    Decadev findByGuarantorEmail(String fullNameString);


//    @Modifying
//    @Transactional
//    @Query(
//            value = "update decadevs set first_name = ?1 where dev_email = ?2",
//            nativeQuery = true
//    )
//    int updateDevFistNameByEmail(String firstName, String email);

}
