package com.gl.tickettracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tickettracker.repo.TicketRepository;
import com.gl.tickettracker.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	private TicketRepository ticketrepository;

	public TicketServiceImpl(TicketRepository ticketrepository) {
		this.ticketrepository = ticketrepository;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketrepository.findAll();
	}
	
	@Override
	public Ticket getTicketById(Long id) {
		return ticketrepository.findById(id).get();
	}

	@Override
	public Ticket addTicket(Ticket ticket) {
		return ticketrepository.save(ticket);
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {

		Optional<Ticket> result = ticketrepository.findById(ticket.getId());
		Ticket existing = result.get();
		existing.setTicketTitle(ticket.getTicketTitle());
		existing.setTicketDescription(ticket.getTicketDescription());
		existing.setTicketCreationDate(ticket.getTicketCreationDate());
		existing.setContent(ticket.getContent());

		return ticketrepository.save(existing);

	}

	@Override
	public void deleteTicketById(Long id) {
		ticketrepository.deleteById(id);
	}

	public List<Ticket> findByKeyword(String keyword) {
		return ticketrepository.findByKeyword(keyword);
	}

}