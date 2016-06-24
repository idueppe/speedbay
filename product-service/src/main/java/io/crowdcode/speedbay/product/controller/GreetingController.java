package io.crowdcode.speedbay.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Controller
public class GreetingController {

    @RequestMapping(path="/say/{vorname}/{nachname}", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@PathVariable("nachname") String nachname, @PathVariable("vorname") String vorname) {
        return "Hello Spring! "+vorname + " " + nachname;
    }

    @RequestMapping("/goodbye")
    @ResponseBody
    public String sayGoodbye() {
        return "tschüss .. tja";
    }

}
