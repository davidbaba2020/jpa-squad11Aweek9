package davacom.decagonprogram.controller;


import davacom.decagonprogram.dto.StackCourseAddDto;
import davacom.decagonprogram.dto.StackLeadDto;
import davacom.decagonprogram.entities.StackLead;
import davacom.decagonprogram.entities.pageCriterias.StackLeadPage;
import davacom.decagonprogram.service.StackLeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stack-leads")
@RequiredArgsConstructor
public class StackLeadController {

    private final StackLeadService stackLeadService;

    @PostMapping
    public ResponseEntity<String> createStackLead(@RequestBody StackLeadDto stackLeadDto) {
        return ResponseEntity.ok(stackLeadService.createNewStackLead(stackLeadDto));
    }

    @GetMapping
    public ResponseEntity<Page<StackLead>> getStackLeads(StackLeadPage stackLeadPage) {
        return ResponseEntity.ok(stackLeadService.getAllStackLeads(stackLeadPage));
    }

    @PostMapping("/add-course")
    public ResponseEntity<String> createStackLead(@RequestBody StackCourseAddDto stackCourseAddDto) {
        return ResponseEntity.ok(stackLeadService.addCourseToStackLead(stackCourseAddDto));
    }

}
