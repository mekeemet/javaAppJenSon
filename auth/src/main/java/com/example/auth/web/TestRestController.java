package com.example.auth.web;

import com.example.auth.dao.*;
import com.example.auth.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TestRestController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private  AppUserRepository appUserRepository;
    @Autowired
    private  SpeakerRepository speakerRepository;
    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private ProgrammeRepository programmeRepository;

    //@GetMapping("/tasks")
    @RequestMapping(value = "/tasks",method = RequestMethod.GET)
    public List<Task> ListTask(){
        return taskRepository.findAll();
    }
    @PostMapping("/task")
    public Task save(@RequestBody Task task) {
        return taskRepository.save(task);
    }
    @GetMapping("/task/{id}")
    public Optional<Task> getTask(@PathVariable Long id) {
        return taskRepository.findById(id);
    }
    //THEME
    @GetMapping("/themes")
    public List<Theme> getTheme(){return themeRepository.findAll();}
    @PostMapping("/theme")
    public Theme saveTheme(@RequestBody Theme theme){return themeRepository.save(theme);}
    @GetMapping("/theme/{id}")
    public Theme getTheme(@PathVariable Long id){return themeRepository.findById(id).get();}
    @PutMapping("/theme")
    public Theme updateTheme(@PathVariable Long id,@RequestBody Theme theme){ theme.setId(id);return themeRepository.save(theme); }
    @DeleteMapping("/theme")
    public boolean deleteTheme(@PathVariable Long id){ themeRepository.deleteById(id);return true; }
    //SPEAKER
    @GetMapping("/speakers")
    public List<Speaker> ListSpeaker(){ return speakerRepository.findAll(); }
    @PostMapping("/speaker")
    public Speaker saveSpeaker(@RequestBody Speaker speaker){ return speakerRepository.save(speaker);}
    @RequestMapping(value = "/speaker/{id}",method = RequestMethod.GET)
    public Speaker getSpeaker(@PathVariable Long id){return  speakerRepository.findById(id).get();}
    @RequestMapping(value = "/speaker/{id}",method = RequestMethod.DELETE)
    public boolean deleteSpeaker(@PathVariable Long id){ speakerRepository.deleteById(id);return true; }
    @RequestMapping(value = "/speaker/{id}",method = RequestMethod.PUT)
    public Speaker updateSpeaker(@PathVariable Long id,@RequestBody Speaker s){ s.setId(id); return speakerRepository.save(s); }
    //Programme
    @GetMapping("/programmes")
    public List<Programme> ListProgramme(){return programmeRepository.findAll();}
    @GetMapping("programme/{id}")
    public Programme getProgramme(@PathVariable Long id){return programmeRepository.findById(id).get();}
    @PostMapping ("programme")
    public Programme saveProgramme(@RequestBody Programme programme){ return programmeRepository.save(programme); }
    @PutMapping("programme/{id}")
    public Programme updateProgramme(@PathVariable Long id,@RequestBody Programme programme){ programme.setId(id);return programmeRepository.save(programme); }
    @DeleteMapping("programme/{id}")
    public boolean deleteProgramme(@PathVariable Long id){programmeRepository.deleteById(id); return true;}

    @GetMapping("/user/{id}")
    public Optional<Task> getUserById(@PathVariable Long id) {
        return taskRepository.findById(id);
    }
}
