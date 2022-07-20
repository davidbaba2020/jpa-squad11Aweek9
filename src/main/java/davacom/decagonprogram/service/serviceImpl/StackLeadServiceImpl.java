package davacom.decagonprogram.service.serviceImpl;

import davacom.decagonprogram.dto.StackCourseAddDto;
import davacom.decagonprogram.dto.StackLeadDto;
import davacom.decagonprogram.entities.StackCourse;
import davacom.decagonprogram.entities.StackLead;
import davacom.decagonprogram.entities.pageCriterias.StackLeadPage;
import davacom.decagonprogram.exceptions.CourseWithIdNotFound;
import davacom.decagonprogram.exceptions.LeadWithIdNotFound;
import davacom.decagonprogram.repositories.StackCourseRepository;
import davacom.decagonprogram.repositories.StackLeadRepository;
import davacom.decagonprogram.service.StackLeadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StackLeadServiceImpl implements StackLeadService {
    private final StackLeadRepository stackLeadRepository;
    private final StackCourseRepository stackCourseRepository;

    @Override
    public String createNewStackLead(StackLeadDto stackLeadDto) {
        String msg = "";
        try {
            StackLead stackLead = new StackLead();
            BeanUtils.copyProperties(stackLeadDto, stackLead);
            stackLeadRepository.save(stackLead);
            msg = "Stack Lead Created Successfully";
            return msg;
        } catch (Exception e) {
            msg = "Error occurred while creating stackLead";
            throw new RuntimeException(msg);
        }
    }

    @Override
    public Page<StackLead> getAllStackLeads(StackLeadPage stackLeadPage) {
        Sort sort = Sort.by(stackLeadPage.getSortDirection(), stackLeadPage.getSortBy());
        Pageable pageable = PageRequest.of(stackLeadPage.getPageNumber(), stackLeadPage.getPageSize(), sort);
        Page<StackLead> leads = stackLeadRepository.findAll(pageable);
        return leads;
    }

    @Override
    public String addCourseToStackLead(StackCourseAddDto stackCourseAddDto) {
        String msg = "Course added successfully";
        StackLead lead = stackLeadRepository.findById(stackCourseAddDto.getStackLeadId()).orElseThrow(()->
                new LeadWithIdNotFound("Stack Lead with id: " +stackCourseAddDto.getStackLeadId()+  " was not found"));
        StackCourse course = stackCourseRepository.findById(stackCourseAddDto.getCourseId()).orElseThrow(()->
                new CourseWithIdNotFound("Course with id: " +stackCourseAddDto.getCourseId()+ " was not found"));
        List<StackCourse> courses = new ArrayList<>();
        if(lead.getCourses().isEmpty()){
            courses.add(course);
        } else {
            courses = lead.getCourses();
            courses.add(course);
        }
        lead.setCourses(courses);
        stackLeadRepository.save(lead);

        return msg;
    }
}
