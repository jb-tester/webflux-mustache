package com.mytests.spring.webflux.webfluxmustache.controllers;

import com.mytests.spring.webflux.webfluxmustache.repositories.StudentReactiveRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

/**
 * *******************************
 * Created by irina on 3/9/2020.
 * Project: webflux-mustache
 * *******************************
 */
@Controller
public class StudentController {

    @Autowired
    private StudentReactiveRepo repo;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("home_attr1", "home_attr1");
        return "home";
    }

    @GetMapping("/all")
    public Rendering getAll(){
        return Rendering.view("all")
                .modelAttribute("students",repo.getAllStudents())
                .build();
    }
    @RequestMapping("/byGroup/{group}")
    public String byGroup(Model model, @PathVariable String group) {
        model.addAttribute("group_number",group);
        model.addAttribute("studentsByGroup", repo.getAllStudentsInGroup(Integer.parseInt(group)));
        return "group";
    }
    
}
