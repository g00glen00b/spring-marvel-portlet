package be.optis.portal.controllers;

import java.io.IOException;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import be.optis.portal.model.ApiKeys;
import be.optis.portal.service.MarvelService;

@Controller
@RequestMapping("VIEW")
public class CharactersController {

    @Autowired
    private MarvelService service;

    private static final int PAGE_SIZE = 20;

    // TODO Engage

    // TODO Engage

    private ApiKeys getApiKeys(PortletPreferences prefs) {
        ApiKeys keys = new ApiKeys();
        keys.setPrivateKey(prefs.getValue(SettingsController.API_PRIVATE_KEY, ""));
        keys.setPublicKey(prefs.getValue(SettingsController.API_PUBLIC_KEY, ""));
        return keys;
    }
}
