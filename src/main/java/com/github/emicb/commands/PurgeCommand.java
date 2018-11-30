package com.github.emicb.commands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class PurgeCommand implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        // ignore if author of message is the bot
        if(event.getMessage().getAuthor().isYourself()) {
            return;
        }
        if(event.getMessage().getContent().contains("~purge")) {
            event.getChannel().sendMessage("test");
        }
    }
}
