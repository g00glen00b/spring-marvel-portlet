package be.optis.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
@RequestMapping("VIEW")
public class SeriesController {

    @RequestMapping
    public ModelAndView getSeries() {
        return new ModelAndView("detailList", "type", "series");
    }
}
