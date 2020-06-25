package com.fatec.anime.api.controller;

import com.fatec.anime.api.dao.AnimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnimeController {
	@Autowired
	private AnimeDao service;

	@RequestMapping("/")
	public String index(){
		return "index";
	}


}
