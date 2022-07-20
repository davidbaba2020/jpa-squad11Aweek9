package davacom.decagonprogram.dto;

import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DevGuarator {
    private String firstName;
    private String lastName;
    private String emailId;
    private STACK stack;
    private String guarantor_fullName;
    private String guarantor_email;
    private String guarantor_phoneNumber;
}
