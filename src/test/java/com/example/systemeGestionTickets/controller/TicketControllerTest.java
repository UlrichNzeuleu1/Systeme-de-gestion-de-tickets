package com.example.systemeGestionTickets.controller;

import com.example.systemeGestionTickets.dto.TicketDto;
import com.example.systemeGestionTickets.service.interfaces.TicketService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @Test
    public void testGetAllTickets() throws Exception {
        // Arrange
        List<TicketDto> tickets = new ArrayList<>();
        TicketDto ticketDto1 = TicketDto.builder()
                .id(1L)
                .title("Test Ticket 1")
                .build();

        TicketDto ticketDto2 = TicketDto.builder()
                .id(2L)
                .title("Test Ticket 2")
                .build();

        tickets.add(ticketDto1);
        tickets.add(ticketDto2);

        // Act
        when(ticketService.findAll()).thenReturn(tickets);

        // Assert
        mockMvc.perform((RequestBuilder) get("/tickets"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
                .andExpect((ResultMatcher) jsonPath("$[0].title", is("Test Ticket 1")))
                .andExpect((ResultMatcher) jsonPath("$[1].title", is("Test Ticket 2")));
    }

   

    @Test
    void getTicketById() {
    }
}