package com.fatec.anime.api.controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.anime.api.dao.ProfileDao;
import com.fatec.anime.api.model.Profile;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private ProfileDao service;
	
	public void NewProfile(String username, Long id) {
		
		Profile profile = new Profile();
				
		profile.setUsername(username);
		
		profile.setProfileId(id);
		
		Date date = new Date(System.currentTimeMillis());
		profile.setJoined(date);
		
		
		service.save(profile);		
	}

	@GetMapping(path = "/{id}")
	public ModelAndView showProfile(@PathVariable(name = "id")Long id) {
		ModelAndView mv = new ModelAndView("profile");
		Profile profile = service.get(id);
		mv.addObject("profile", profile);
		return mv;
	}
				

}
