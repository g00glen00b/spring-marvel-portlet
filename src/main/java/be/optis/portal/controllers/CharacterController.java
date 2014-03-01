package be.optis.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("VIEW")
public class CharacterController {

    @RequestMapping
    public String getCharacter() {
        return "detail";
    }
}
