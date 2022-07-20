package davacom.decagonprogram.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
//@Table(name = "guarator")
//public class Guarantor extends BaseClass{
@Embeddable
public class Guarantor {
    private String fullName;
    private String guarantor_email;
    private String guarantor_phoneNumber;
}
