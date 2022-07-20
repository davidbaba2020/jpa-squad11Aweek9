package davacom.decagonprogram.entities;


import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(
        name = "decadevs",
        uniqueConstraints = @UniqueConstraint(
                name="emailId_unique",
                columnNames = "dev_email"
        )
)
public class Decadev extends BaseClass{
    private String firstName;
    private String lastName;
    @Column(
            name = "dev_email",
            nullable = false
    )
    private String emailId;
    @Enumerated(EnumType.STRING)
    private STACK stack;
    @Embedded
    private Guarantor guarantor;
}
