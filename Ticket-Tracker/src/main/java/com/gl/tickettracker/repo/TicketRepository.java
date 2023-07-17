package com.gl.tickettracker.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gl.tickettracker.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

	@Query(value = "SELECT * FROM Ticket ticket WHERE CONCAT(ticket.ticketTitle,' ', ticket.ticketDescription) LIKE %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);

}