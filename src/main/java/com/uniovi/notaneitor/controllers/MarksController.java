package com.uniovi.notaneitor.controllers;

import com.uniovi.notaneitor.entities.*;
import com.uniovi.notaneitor.services.MarksService;
import com.uniovi.notaneitor.services.UsersService;
import com.uniovi.notaneitor.validators.AddMarksValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Controller
public class MarksController {

    @Autowired
    private HttpSession httpSession;
    @Autowired //Inyectar el servicio
    private MarksService marksService;

    @Autowired
    private AddMarksValidator addMarksValidator;

    @Autowired
    private UsersService usersService;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        Set<Mark> consultedList= (Set<Mark>) httpSession.getAttribute("consultedList");
        if ( consultedList == null ) {
            consultedList = new HashSet<Mark>();
        }
        model.addAttribute("consultedList", consultedList);
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list::tableMarks";
    }




    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }
    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id){
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }


    @RequestMapping(value="/mark/add")
    public String getMark(Model model){
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/add";
    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark,BindingResult result, @PathVariable Long id) {
        addMarksValidator.validate(mark,result);
        if(result.hasErrors()){
            return "mark/edit";
        }
        Mark originalMark = marksService.getMark(id);
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/" + id;
    }


    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(Model model,@Validated Mark mark, BindingResult result) {
        addMarksValidator.validate(mark,result);
        if(result.hasErrors()){
            model.addAttribute("usersList",usersService.getUsers());
            return "mark/add";
        }
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/add", method = RequestMethod.GET)
    public String setMark(Model model) {
        model.addAttribute("mark", new Mark());
        model.addAttribute("usersList",usersService.getUsers());
        return "mark/add";
    }

}
