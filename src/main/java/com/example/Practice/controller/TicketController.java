package com.example.Practice.controller;

import com.example.Practice.dto.TicketRequestDto;
import com.example.Practice.dto.TicketResponseDto;
import com.example.Practice.entiity.Ticket;
import com.example.Practice.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
public class TicketController
{
    private final TicketService ticketService;

    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

   @PostMapping
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketRequestDto dto)
   {
       return ResponseEntity.ok(ticketService.createTicket(dto));
   }

   @GetMapping
    public ResponseEntity<List<TicketResponseDto>> getAllTickets()
   {
       return ResponseEntity.ok(ticketService.getAllTickets());
   }

   @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable Long id)
   {
      return ResponseEntity.ok(ticketService.getTicketById(id));
   }

   @PutMapping("/{id}")
    public ResponseEntity<TicketResponseDto> updateTicket(@PathVariable Long id, @RequestBody TicketRequestDto dto)
   {
       return ResponseEntity.ok(ticketService.updateTicket(id,dto));
   }
   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id)
   {
       ticketService.deleteTicket(id);
       return ResponseEntity.ok("Ticket Deleted Successfully");
   }
}
