package app;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyController {
    private final PhrasesRepository phrasesRepository;

    @RequestMapping("/")
    public String redirect(Model model) {
        return "redirect:/app_title";
    }

    @RequestMapping("/app_title")
    public String index(Model model) {
        List<Phrase> phrases = (List<Phrase>) phrasesRepository.findAll();
        model.addAttribute("phrases", phrases);
        model.addAttribute("phrase", new Phrase());
        return "index";
    }

    @PostMapping("/app_title")
    public String post(@Valid Phrase phrase, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            phrase.id();
            phrasesRepository.save(phrase);
            return "redirect:/app_title";
        }
        List<Phrase> phrases = (List<Phrase>) phrasesRepository.findAll();
        model.addAttribute("phrases", phrases);
        return "index";
    }
}
