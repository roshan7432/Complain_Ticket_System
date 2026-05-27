package com.example.Practice.service;

import com.example.Practice.dto.TicketRequestDto;
import com.example.Practice.dto.TicketResponseDto;
import com.example.Practice.entiity.Ticket;
import com.example.Practice.repository.TicketRepository;
import com.example.Practice.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService
{
private final TicketRepository ticketRepository;
 public TicketServiceImpl (TicketRepository ticketRepository)
 {
     this.ticketRepository=ticketRepository;
 }

    @Override
    public TicketResponseDto createTicket(TicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(dto.getStatus());

        Ticket savedTicket= ticketRepository.save(ticket);

        return new TicketResponseDto(
                savedTicket.getId(),
                savedTicket.getTitle(),
                savedTicket.getDescription(),
                savedTicket.getStatus()
        );
    }

    @Override
    public List<TicketResponseDto> getAllTickets() {

        return ticketRepository.findAll()
                .stream()
                .map(ticket -> new TicketResponseDto(
                        ticket.getId(),
                        ticket.getTitle(),
                        ticket.getDescription(),
                        ticket.getStatus()
                ))
                .toList();
    }

    @Override
    public TicketResponseDto getTicketById(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket not found with id: " + id
                        )
                );

        return new TicketResponseDto(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus()
        );
    }

    @Override
    public TicketResponseDto updateTicket(Long id,
                                          TicketRequestDto dto) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket not found with id: " + id
                        )
                );

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setStatus(dto.getStatus());

        Ticket updatedTicket = ticketRepository.save(ticket);

        return new TicketResponseDto(
                updatedTicket.getId(),
                updatedTicket.getTitle(),
                updatedTicket.getDescription(),
                updatedTicket.getStatus()
        );
    }

    @Override
    public void deleteTicket(Long id) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket not found with id: " + id
                        )
                );

        ticketRepository.delete(ticket);
    }
}
