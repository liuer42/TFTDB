package hibernate.controller;

import hibernate.service.classService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class classController {
    @Autowired
    private classService classService;

    @RequestMapping("/list")
    public String listClasses(Model theModel) {
        List<hibernate.entity.Class> classList = classService.getClasses();

        theModel.addAttribute("Classes", classList);

        return "list-classes";
    }

    @PostMapping("/saveNewClass")
    public String saveClass(@ModelAttribute(name="Class") hibernate.entity.Class aClass) {
        classService.saveClass(aClass);

        return "redirect:/classes/list";
    }
}