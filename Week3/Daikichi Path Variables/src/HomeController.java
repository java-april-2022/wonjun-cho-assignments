package com.codingdojo.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {
    @RequestMapping("/travel/{city}")
    public String travel (@PathVariable("city") String city) {
        return "Congratulations! You will soon travel to " + city;
    }
    @RequestMapping("/lotto/{number}")
    public String lotto (@PathVariable("number") String number) {
        int lottoNum = Integer.parseInt(number);
        if (lottoNum % 2 == 0) {
            return "You will take a grand journey in the near future, but be weary of tempting offers";
        } else {
            return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
        }
    }
}
