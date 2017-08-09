package me.soulyana.demo.controllers;

import me.soulyana.demo.models.TvShow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {
    @GetMapping("/tvform")
    public String addTvShow(Model model)
    {
        model.addAttribute("tvshow", new TvShow());
        return "tvform";
    }

    @PostMapping("/tvform")
    public String showTvShow(@Valid @ModelAttribute("tvshow")TvShow tvShow, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "tvform";
        }
        return "tvshowconfirm";
    }
}
