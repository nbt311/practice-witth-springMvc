package com.example.studentmanagerwithspringmvc.controller;

import com.example.studentmanagerwithspringmvc.entity.Student;
import com.example.studentmanagerwithspringmvc.model.StudentDAO;
import com.example.studentmanagerwithspringmvc.model.StudentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {
    protected StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentModel();
    }

    @GetMapping("/student")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("student/list.jsp");
        List<Student> list = studentDAO.getAllStudent();
        modelAndView.addObject("list",list);
        return modelAndView;
    }
    @GetMapping("/student/{id}")
    public ModelAndView viewStudent(@PathVariable ("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("/student/view.jsp");
        Student student = studentDAO.findStudentById(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }
}
