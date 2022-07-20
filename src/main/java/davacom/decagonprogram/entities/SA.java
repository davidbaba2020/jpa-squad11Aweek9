package davacom.decagonprogram.entities;

import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "stack_associate")
public class SA extends BaseClass{
    private String fullName;
    private String email;
    @Enumerated(EnumType.STRING)
    private STACK stack;
    @ManyToMany
    private Set<Decadev> podMembers;
}
