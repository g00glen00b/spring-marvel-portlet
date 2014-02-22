package be.g00glen00b.portal.controllers;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import be.g00glen00b.portal.model.ApiKeys;
import be.g00glen00b.portal.service.MarvelService;

@Controller
@RequestMapping("VIEW")
public class CharactersController {

    @Autowired
    private MarvelService service;

    private static final int PAGE_SIZE = 20;

    @RequestMapping
    public ModelAndView getCharacters(PortletPreferences prefs) {
        boolean isConfigured = prefs.getMap().containsKey(SettingsController.API_PRIVATE_KEY)
                && prefs.getMap().containsKey(SettingsController.API_PUBLIC_KEY);
        return new ModelAndView("list", "isConfigured", isConfigured);
    }

    @ResourceMapping("characters")
    public void getCharacters(@RequestParam("page") int page, ResourceResponse response, PortletPreferences prefs) {
        try {
            response.getWriter().append(service.getMarvelCharacters(getApiKeys(prefs), page * PAGE_SIZE, PAGE_SIZE));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private ApiKeys getApiKeys(PortletPreferences prefs) {
        ApiKeys keys = new ApiKeys();
        keys.setPrivateKey(prefs.getValue(SettingsController.API_PRIVATE_KEY, ""));
        keys.setPublicKey(prefs.getValue(SettingsController.API_PUBLIC_KEY, ""));
        return keys;
    }
}
