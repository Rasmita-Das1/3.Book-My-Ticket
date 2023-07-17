package com.gl.tickettracker.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Table @Data
public class Ticket {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@Column
	private String ticketTitle;

	
	@Column
	private String ticketDescription;

	
	@Column
	private String content;

	
	@Column
	private LocalDate ticketCreationDate = LocalDate.now();
	

}
