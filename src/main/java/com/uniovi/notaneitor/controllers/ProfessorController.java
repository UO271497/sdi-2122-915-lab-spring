package com.uniovi.notaneitor.controllers;


import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/professor/details/{id}")
    public String getDetails(@PathVariable Long id) {
       return professorService.getProfessor(id).toString();
    }

    @RequestMapping("/professor/add")
    public String addProfessor() {
        return "Adding professor";
    }

    @RequestMapping("/professor/edit/{id}")
    public String setEdit(@PathVariable Long id) {
        return "Edit professor "+professorService.getProfessor(id).getName();
    }

    @RequestMapping("/professor/delete")
    public String deleteProfessor() {
        return "Deleting professor";
    }

}


