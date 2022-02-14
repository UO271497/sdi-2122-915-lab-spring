package com.uniovi.notaneitor.services;

import com.uniovi.notaneitor.entities.Professor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {

    private List<Professor> professorList = new LinkedList<>();
    @PostConstruct
    public void init() {
        professorList.add(new Professor(1L, "DNI1","nombre1","apellidos1","categoria1"));
        professorList.add(new Professor(2L, "DNI2","nombre2","apellidos2","categoria2"));
    }

    public List<Professor> getProfessors() {
        return professorList;
    }
    public Professor getProfessor(Long id) {
        return professorList.stream()
                .filter(professor -> professor.getId().equals(id)).findFirst().get();
    }
    public void addProfessor(Professor professor) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        if (professor.getId() == null) {
            professor.setId(professorList.get(professorList.size() - 1).getId() + 1);
        }
        professorList.add(professor);
    }
    public void deleteMark(Long id) {
        professorList.removeIf(mark -> mark.getId().equals(id));
    }



}
