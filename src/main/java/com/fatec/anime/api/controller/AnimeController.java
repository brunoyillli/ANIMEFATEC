package com.fatec.anime.api.controller;

import com.fatec.anime.api.dao.AnimeDao;
import com.fatec.anime.api.model.Anime;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/anime")
public class AnimeController {
	@Autowired
	private AnimeDao service;
	

	@GetMapping(value = "/new")
	public ModelAndView showNewAnimePage(Model model) {
		ModelAndView mv = new ModelAndView("new_anime");
		Anime anime = new Anime();
		mv.addObject("animeAtual",anime);
	    return mv;
	}
	
	@PostMapping(value = "/new")
	public ModelAndView processaAnime(@ModelAttribute("animeAtual") Anime a, 
			@RequestParam("cmd") String cmd) {
		ModelAndView mv = new ModelAndView("new_anime");
		String msg = null;
		mv.addObject("animeAtual", new Anime());
		service.salvar(a);
		msg = String.format("O Anime %s foi adicionado com sucesso", a.getName());
		mv.addObject("MSG", msg);
		return mv;
	}
	
	@GetMapping(path = "/{id}")
	public ModelAndView showAnimePage(@PathVariable(name="id")Long id) {
		ModelAndView mv = new ModelAndView("anime");
		Anime anime = service.get(id);
		mv.addObject("anime",anime);
		
		return mv;
	}
	
	@RequestMapping(path = "/edit/{id}")
	public ModelAndView showEditAnime(@PathVariable(name="id")Long id) {
		ModelAndView mv = new ModelAndView("edit_anime");
		Anime anime = service.get(id);
		mv.addObject("anime", anime);
		
		return mv;
	}
	
	@PostMapping(value = "/edit")
	public ModelAndView AlteraAnime(@ModelAttribute("anime") Anime a, 
			@RequestParam("cmd") String cmd) {
		ModelAndView mv = new ModelAndView("edit_anime");
		String msg = null;
		service.salvar(a);
		msg = String.format("O Anime %s foi alterado com sucesso", a.getName());
		mv.addObject("MSG", msg);
		return mv;
	}
	
	@RequestMapping(path = "/delete/{id}")
	public ModelAndView showDeleteAnime(@PathVariable(name="id")Long id) {
		ModelAndView mv = new ModelAndView("delete_anime");
		Anime anime = service.get(id);
		mv.addObject("anime",anime);
		
		return mv;
	}
	
	@PostMapping(value = "/delete")
	public ModelAndView DeletaAnime(@ModelAttribute("anime")Anime a,
			@RequestParam("cmd") String cmd) {
		ModelAndView mv = new ModelAndView("delete_anime");
		service.delete(a.getId());
		String msg = null;
		msg = String.format("O Anime %s foi excluido com sucesso", a.getName());
		mv.addObject("MSG", msg);
		
		return mv;
	}

	@GetMapping(path = "/animes")
	public ModelAndView ListaAnime() {
		Anime anime = new Anime();
		ModelAndView mv = new ModelAndView("animes");
		Iterable<Anime> lista = service.obterTodos();
		mv.addObject("animeLista", lista);
		mv.addObject("animeAtual", anime);
		
		return mv;
	}
	
	@GetMapping(path = "/animes/{status}")
	public ModelAndView ListaAnimeStatus(@PathVariable(name="status")String status) {
		Anime anime = new Anime();
		ModelAndView mv = new ModelAndView("animes");
		Set<Anime> lista = service.findByStatus(status);
		if(lista.size()>0) {
			mv.addObject("animeLista", lista);
			mv.addObject("animeAtual", anime);
		}
		return mv;
	}
	
	@GetMapping(path = "/animes/top")
	public ModelAndView TopListaAnime() {
		Anime anime = new Anime();
		ModelAndView mv = new ModelAndView("animes");
		List<Anime> lista = service.getAnimesTop();
		System.out.println(lista.size());
		if(lista.size()>0) {
			mv.addObject("animeLista", lista);
			mv.addObject("animeAtual", anime);
		}
		return mv;
	}

	@PostMapping(value = "/animes")
	public ModelAndView processaAnimes(@ModelAttribute("animeAtual") Anime a,
			@RequestParam("cmd")String cmd) {
		ModelAndView mv = new ModelAndView("animes");
		String msg = null;
		if("pesquisar".equals(cmd)) {
			Set<Anime> lista = service.searchByNome(a.getName());
			String.format("Foram encontrados %d animes com o nome %s", lista.size(), a.getName());
			if (lista.size() > 0) { 
				mv.addObject("animeLista", lista);
			}
		}
		mv.addObject("MSG", msg);
		return mv;
		}
	}	
