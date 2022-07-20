package davacom.decagonprogram.service;

import davacom.decagonprogram.dto.StackCourseAddDto;
import davacom.decagonprogram.dto.StackLeadDto;
import davacom.decagonprogram.entities.StackLead;
import davacom.decagonprogram.entities.pageCriterias.StackLeadPage;
import org.springframework.data.domain.Page;

public interface StackLeadService {

    String createNewStackLead(StackLeadDto stackLeadDto);

    Page<StackLead> getAllStackLeads(StackLeadPage stacLeadPage);

    String addCourseToStackLead(StackCourseAddDto stackCourseAddDto);
}
