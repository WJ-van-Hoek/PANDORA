package com.science.earth.biogeochemistry.freshwaters.pandora.controllers.calculations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalculationsServiceController {
    @GetMapping("calculations-index.html")
    public String calculationService() {
      return "/calculations/calculations-index.html"; // this returns the template name to be rendered from resources/templates. You don't need to provide the extension.
    }
}
