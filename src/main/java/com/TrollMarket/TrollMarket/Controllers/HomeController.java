package com.TrollMarket.TrollMarket.Controllers;

import com.TrollMarket.TrollMarket.Dto.ProfileAddBalanceDto;
import com.TrollMarket.TrollMarket.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/index")
    public String homePages(Model model) {
        ProfileAddBalanceDto dto = new ProfileAddBalanceDto();
        dto.setId(profileService.getProfileUserLogin().getUserId());
        model.addAttribute("addBalance", dto);
        model.addAttribute("profile", profileService.getProfileUserLogin());
        return "home/home-index";
    }
}
