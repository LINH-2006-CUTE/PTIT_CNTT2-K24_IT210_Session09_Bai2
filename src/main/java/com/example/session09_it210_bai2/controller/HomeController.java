package com.example.session09_it210_bai2.controller;

import com.example.session09_it210_bai2.modell.dto.GuestDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String homePage(
            @CookieValue(value = "guest_name", required = false) String guestName,
            Model model
    ) {
        model.addAttribute("guestDto", new GuestDTO());
        String currentName = (guestName == null || guestName.isEmpty()) ? "Khách lạ" : guestName;
        model.addAttribute("guestName", currentName);

        if (currentName.equals("Khách lạ")) {
            model.addAttribute("guest", "Chào khách lạ");
        } else {
            model.addAttribute("guest", "Chào mừng " + currentName );
        }
        return "home-page";
    }

    @PostMapping("/set-guest")
    public String setGuest(@ModelAttribute("guestDto") GuestDTO guestDto, HttpServletResponse response) {
        Cookie cookie = new Cookie("guest_name", guestDto.getName());
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/home";
    }
}
