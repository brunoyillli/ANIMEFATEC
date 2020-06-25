package com.fatec.anime.api.controller;

import com.fatec.anime.api.dao.AnimeDao;
import com.fatec.anime.api.model.Anime;
import com.fatec.anime.api.repository.AnimeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnimeController {
	@Autowired
	private AnimeDao service;
	
	private AnimeRepository animeRepository;

	@RequestMapping("/")
	public String index(){
		return "index";
	}

//	@RequestMapping(value = "/new", method = RequestMethod.GET)
//	public String showNewProductPage(Model model) {
//	    Anime anime = new Anime();
//	    model.addAttribute("anime", anime);
//	    return "new";
//	}
	
	@GetMapping(value = "/new")
	public ModelAndView showNewAnimePage(Model model) {
		ModelAndView mv = new ModelAndView("new");
		Anime anime = new Anime();
		mv.addObject("animeAtual",anime);
	    return mv;
	}
	
	@PostMapping(value = "/new")
	public ModelAndView processaAnime(@ModelAttribute("animeAtual") Anime a, 
			@RequestParam("cmd") String cmd) {
		ModelAndView mv = new ModelAndView("new");
		String msg = null;
		mv.addObject("animeAtual", new Anime());
		service.salvar(a);
		msg = String.format("O Anime %s foi adicionado com sucesso", a.getName());
		mv.addObject("MSG", msg);
		return mv;
	}
	
	@GetMapping(path = "/anime/{id}")
	public ModelAndView showAnimePage(@PathVariable(name="id")Long id) {
		ModelAndView mv = new ModelAndView("anime");
		Anime anime = service.get(id);
		mv.addObject("anime",anime);
		
		return mv;
	}
} 	
