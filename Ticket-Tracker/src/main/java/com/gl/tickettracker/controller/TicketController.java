package com.gl.tickettracker.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gl.tickettracker.model.Ticket;
import com.gl.tickettracker.service.TicketService;

@Controller
//@RequestMapping("/admin")
public class TicketController {
	
	@Autowired
	TicketService service;
	
	//display all tickets
	@GetMapping("/admin/tickets")
	public String getAllTickets(Model model, String keyword) {
		List<Ticket> tickets = service.getAllTickets();
		if (keyword != null) {
			model.addAttribute("tickets", service.findByKeyword(keyword));
		} else {
			model.addAttribute("tickets", tickets);
		}
		return "Ticket-List";
	}
	
	//Create a new ticket
	@GetMapping("/admin/tickets/newTicket")
	public String createNewTicket(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "Ticket-Form";
	}

	@RequestMapping(value = "/admin/tickets/addTicket", method = RequestMethod.POST)
	public String addTicket(@ModelAttribute("ticket") Ticket ticket) {
		service.addTicket(ticket);
		return "redirect:/admin/tickets";
	}
	
	//edit existing ticket
	@GetMapping("/admin/tickets/update/{id}")
	public String ticketUpdatePage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticket", service.getTicketById(id));
		return "Ticket-Update-Page";
	}
	
	@RequestMapping("/admin/tickets/updateTicket")
	public String updateTicket (Ticket ticket) {
	service.updateTicket(ticket);
	return "redirect:/admin/tickets";
	}
	
	//delete existing ticket
	@GetMapping("/admin/tickets/delete/{id}")
	public String deleteEmployee(@PathVariable (value = "id") Long id) {
		this.service.deleteTicketById(id);
		return "redirect:/admin/tickets";
	}
	
	//view existing ticket
	@GetMapping("/admin/tickets/view/{id}")
	public String ticketViewPage(Model model, @PathVariable("id") Long id) {
		model.addAttribute("ticket", service.getTicketById(id));
		return "View-Ticket";
	}

}
