package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {
List<Grade> studentsGrade = new ArrayList<>();
   
  @GetMapping("/form")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = getGradeIndex(id);
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : studentsGrade.get(index));
        return "form";
    }

        public int getGradeIndex(String id) {
        for (int i = 0; i < studentsGrade.size(); i++) {
            if (studentsGrade.get(i).getId().equals(id)) return i;
        }
        return Constants.NOT_FOUND;
    }

     @PostMapping("/handleSubmit")
     public String submitForm(Grade grade)
     {
        int index = getGradeIndex(grade.getId());
        if(index==Constants.NOT_FOUND)
            studentsGrade.add(grade);
        else
            studentsGrade.set(index, grade);

        return "redirect:/grades";
     }
     
      @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentsGrade);
        return "grades";
    }
}
