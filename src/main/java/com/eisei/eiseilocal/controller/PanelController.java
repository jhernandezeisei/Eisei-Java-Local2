/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.eisei.eiseilocal.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jose.garcia
 */
@Controller
@ComponentScan(basePackages = {"com.eisei.eiseilocal"})
public class PanelController {
    @RequestMapping(value = "/panel", method = RequestMethod.GET)
    public ModelAndView panel() throws Exception {
        ModelAndView indexModel = new ModelAndView("inicio", "command", new Object());
        return indexModel;
    }
}
