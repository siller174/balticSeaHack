package com.baltichack.view.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class BaseController {

    //redirect to external URL
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://www.yahoo.com");
        return redirectView;
    }
}
