package be.optis.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("HELP")
public class HelpController {

    @RequestMapping
    public String getHelp() {
        return "help";
    }
}
