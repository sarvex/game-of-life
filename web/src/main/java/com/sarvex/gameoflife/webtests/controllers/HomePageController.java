package com.sarvex.gameoflife.webtests.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

 /**
 * HomePageController.java
 * Controller to navigate to the main page
 */
@Controller
public class HomePageController {
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("home");
    }

	// Clicking the "home" text loads the main page
    @RequestMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }
}
