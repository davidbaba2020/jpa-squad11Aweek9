package davacom.decagonprogram.dto;

import davacom.decagonprogram.enums.STACK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StackLeadDto {
    private String fullName;
    private String email;
    private STACK stack;
}
