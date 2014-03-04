package be.optis.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("VIEW")
public class ComicsController {

    @RequestMapping
    public ModelAndView getComics() {
        return new ModelAndView("detailList", "type", "comics");
    }
}