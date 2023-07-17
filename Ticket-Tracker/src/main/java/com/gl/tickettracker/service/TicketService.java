package com.gl.tickettracker.service;

import java.util.List;

import com.gl.tickettracker.model.Ticket;

public interface TicketService {
	
	List<Ticket> getAllTickets();
	
	Ticket getTicketById(Long id);

	Ticket addTicket(Ticket ticket);

	Ticket updateTicket(Ticket ticket);

	void deleteTicketById(Long id);

	public List<Ticket> findByKeyword(String keyword);
	
}

