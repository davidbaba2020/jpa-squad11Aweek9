package davacom.decagonprogram.controller;


import davacom.decagonprogram.dto.DevGuarator;
import davacom.decagonprogram.entities.Decadev;
import davacom.decagonprogram.enums.STACK;
import davacom.decagonprogram.service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/devs")
@RequiredArgsConstructor
public class DevsController {
    private final DevService devService;

    @PostMapping("/save")
    public DevGuarator saveDev(@RequestBody DevGuarator devdto) {
        return devService.saveNewDev(devdto);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<?> getDev(@PathVariable Long id) {
        return devService.getDev(id);
    }

    @GetMapping
    public List<Decadev> getDevs() {
        return devService.fetchDecadevs();
    }

    @GetMapping ("/search")
    public ResponseEntity<?> searchDev (@RequestParam("query") String query) {
        List<Decadev> devs = devService.searchForDevs(query);
        if(devs.isEmpty()){
            return new ResponseEntity<>("No such devs with name: "+ query +" dev where found.", NOT_FOUND);
        }
        return ResponseEntity.ok(devs);
    }

    @GetMapping ("/stack")
    public ResponseEntity<?> getDevsByStack (@RequestParam("stack") STACK stack) {
        List<Decadev> devs = devService.getDevByStack(stack);
        if(devs.isEmpty()){
            return new ResponseEntity<>("No such devs with name: "+ stack +" dev where found.", NOT_FOUND);
        }
        return ResponseEntity.ok(devs);
    }


    @GetMapping ("/gname")
    public ResponseEntity<?> getDevsByGuarantorName (@RequestParam("gname") String gname) {
        List<Decadev> devs = devService.findDevByGuarantorName(gname);
        if(devs.isEmpty()){
            return new ResponseEntity<>("No such devs with name: "+ gname +" dev where found.", NOT_FOUND);
        }
        return ResponseEntity.ok(devs);
    }

    @GetMapping ("/gmail")
    public ResponseEntity<?> getDevsByGuarantorEmail (@RequestParam("gmail") String gmail) {
        Decadev dev = devService.findDevByGuarantorEmail(gmail);
        if(dev==null){
            return new ResponseEntity<>("No dev with email: "+ gmail +" dev where found.", NOT_FOUND);
        }
        return ResponseEntity.ok(dev);
    }

}
