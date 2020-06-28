package com.fatec.anime.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NamedStoredProcedureQueries(@NamedStoredProcedureQuery(name="firstProcedure",procedureName="top_list",resultClasses = Anime.class))
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
	
	private LocalDate datalanc;

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyyy")
//	private Date datalanc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEpisodes() {
		return episodes;
	}

	public void setEpisodes(int episodes) {
		this.episodes = episodes;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate getDatalanc() {
		return datalanc;
	}

	public void setDatalanc(LocalDate datalanc) {
		this.datalanc = datalanc;
	}

}
