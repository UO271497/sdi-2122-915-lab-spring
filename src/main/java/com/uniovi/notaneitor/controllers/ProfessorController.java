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
       return "editando profesor"+id;
    }

    @RequestMapping(value="/professor/add")
    public String addProfessor() {
        return "Adding professor";
    }

    @RequestMapping("/professor/edit/{id}")
    public String setEdit(@PathVariable Long id) {
        return "Edit professor "+id;
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        return "Deleting professor"+id;
    }

}


