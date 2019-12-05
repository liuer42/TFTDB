package hibernate.controller;

import hibernate.entity.Champion;
import hibernate.service.championService;
import hibernate.service.classService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/champions")
public class championController {
    @Autowired
    private championService champService;

    @Autowired
    private classService classService;

    @RequestMapping("/list")
    public String listChampions(Model theModel) {
        List<Champion> champList = champService.getChampions();

        theModel.addAttribute("Champions", champList);

        return "list-champions";
    }

    @GetMapping("/AddChampion")
    public String addChampion(Model theModel) {
        Champion newChampion = new Champion();

        theModel.addAttribute("aChampion", newChampion);

        theModel.addAttribute("classes", classService.getClasses());

        return "add-champion-form";
    }

    @PostMapping("/saveChampion")
    public String saveChampion(@Valid @ModelAttribute(name="aChampion") Champion theChampion,
                               BindingResult bindingResult,
                               Model theModel,
                               HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            theModel.addAttribute("classes", classService.getClasses());
            return "add-champion-form";
        }
        System.out.println(theChampion.getChampName());
        champService.saveChampion(theChampion);

        return "redirect:/champions/list";
    }

    @RequestMapping("/updateChampion")
    public String updateChampion(@RequestParam("champId") int champId,
                                 Model theModel){
        Champion theChampion = champService.getChampion(champId);

        theModel.addAttribute("aChampion", theChampion);

        theModel.addAttribute("classes", classService.getClasses());

        return "edit-champion";
    }

    @GetMapping("/delete")
    public String deleteChampion(@RequestParam("champId") int champId){
        champService.deleteChampion(champId);

        return "redirect:/champions/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchTerm") String theSearchTerm,
                         Model theModel) {
        List<Champion> list = champService.getChampionByName(theSearchTerm);

        theModel.addAttribute("Champions", list);

        return "list-champions";
    }
}
