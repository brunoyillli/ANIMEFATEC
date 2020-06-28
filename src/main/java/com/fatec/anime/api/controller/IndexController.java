package com.fatec.anime.api.controller;

import com.fatec.anime.api.dao.AnimeDao;
import com.fatec.anime.api.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping({"/","/login"})
    public String index() {
        return "index";
    }
    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

}
