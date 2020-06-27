package com.fatec.anime.api.controller;

import com.fatec.anime.api.dao.AnimeDao;
import com.fatec.anime.api.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @Autowired
    private AnimeDao service;

    private AnimeRepository animeRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
