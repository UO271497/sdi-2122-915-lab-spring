package com.uniovi.notaneitor.controllers;


import com.uniovi.notaneitor.entities.Professor;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor/list")
    public String getList() {
        return professorService.getProfessors().toString();
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetails(@PathVariable Long id) {
       return professorService.getProfessor(id).toString();
    }

    @RequestMapping(value="/professor/add",method= RequestMethod.POST)
    public String addProfessor(@ModelAttribute Professor professor) {
        professorService.addProfessor(professor);
        return "Adding professor";
    }

    @RequestMapping("/professor/edit/{id}")
    public String setEdit(@PathVariable Long id) {
        return "Edit professor "+professorService.getProfessor(id).getName();
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorService.deleteMark(id);
        return "Deleting professor";
    }

}


