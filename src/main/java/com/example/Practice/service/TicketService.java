package com.example.Practice.service;

import com.example.Practice.dto.TicketRequestDto;
import com.example.Practice.dto.TicketResponseDto;

import java.util.List;

public interface TicketService
{
   TicketResponseDto createTicket(TicketRequestDto dto);
   List<TicketResponseDto> getAllTickets();
   TicketResponseDto getTicketById(Long id);
   TicketResponseDto updateTicket(Long id, TicketRequestDto dto);
   void deleteTicket(Long id);
}
