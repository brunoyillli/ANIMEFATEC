package com.fatec.anime.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Setter
@Getter
public class Anime {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Double score;
	
	private String image;
	
	private String name;
	
	private int episodes;
	
	private String synopsis;
	
	private String status;
	
	private String studio;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyyy")
	private Date datalanc;

}
