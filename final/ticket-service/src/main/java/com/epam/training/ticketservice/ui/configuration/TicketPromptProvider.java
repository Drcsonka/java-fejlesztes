package com.epam.training.ticketservice.ui.configuration;

import org.jline.utils.AttributedString;
import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

@Component
public class TicketPromptProvider implements org.springframework.shell.jline.PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("Ticket service>");
    }
}
