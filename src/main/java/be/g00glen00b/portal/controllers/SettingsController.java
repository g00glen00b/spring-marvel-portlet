package be.g00glen00b.portal.controllers;

import java.io.IOException;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.ValidatorException;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import be.g00glen00b.portal.model.ApiKeys;

@Controller
@RequestMapping("CONFIG")
public class SettingsController {

    public static final String API_PUBLIC_KEY = "api.public";

    public static final String API_PRIVATE_KEY = "api.private";

    @Autowired
    private ApiKeys apiKeys;

    @Autowired
    private Validator validator;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping
    public ModelAndView getSetttings(PortletPreferences prefs) {
        apiKeys.setPrivateKey(prefs.getValue(API_PRIVATE_KEY, ""));
        apiKeys.setPublicKey(prefs.getValue(API_PUBLIC_KEY, ""));
        return new ModelAndView("settings", "api", apiKeys);
    }
    
    @RenderMapping(params="action=saveSettings")
    public String renderSubmitForm(@Valid @ModelAttribute("api") ApiKeys keys, BindingResult result, RenderRequest request, ModelMap model) {
        validateForm(keys, result);
        model.addAttribute("success", request.getAttribute("success"));
        model.addAttribute("error", request.getAttribute("error"));
        return "settings";
    }

    @ActionMapping(params="action=saveSettings")
    public void submitForm(@Valid @ModelAttribute("api") ApiKeys keys, BindingResult result,
            PortletPreferences prefs, ActionRequest request, ActionResponse response) {
        validateForm(keys, result);
        if (!result.hasErrors()) {
            try {
                prefs.setValue(API_PRIVATE_KEY, keys.getPrivateKey());
                prefs.setValue(API_PUBLIC_KEY, keys.getPublicKey());
                prefs.store();
            } catch (ReadOnlyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ValidatorException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            request.setAttribute("success", true);
        } else {
            request.setAttribute("errors", "Some values were invalid. Fix these errors and try again.");
        }
        
        response.setRenderParameter("action", "saveSettings");
    }

    private void validateForm(ApiKeys keys, BindingResult result) {
        Set<ConstraintViolation<ApiKeys>> violations = validator.validate(keys);
        for(ConstraintViolation<ApiKeys> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            result.addError(new FieldError("member", propertyPath, messageSource.getMessage(message, null, message, null)));
        }
    }
}
