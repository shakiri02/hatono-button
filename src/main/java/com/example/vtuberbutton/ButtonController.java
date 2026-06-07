package com.example.vtuberbutton;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ButtonController {

    @GetMapping("/")
    public String getAudioPage() {
        return "button.html";
    }

    @GetMapping("/link")
    public String getLink() {
        return "link.html";
    }

    @GetMapping("/predict")
    public String getPredict() {
        return "predict.html";
    }
}
