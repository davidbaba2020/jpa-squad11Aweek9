package davacom.decagonprogram.entities;

import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "stack_lead")
public class StackLead extends BaseClass{
    private String fullName;
    private String email;
    @Enumerated(EnumType.STRING)
    private STACK stack;
    @OneToMany
    private List<SA> stackAssociates;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
           name = "teacher_id",
           referencedColumnName = "id"
    )
    private List<StackCourse> courses;
}
