package com.github.emicb;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.Scanner;

public class Testing implements MessageCreateListener {

    //Scanner scan = new Scanner("words.txt");

    public void onMessageCreate(MessageCreateEvent e) {
        if(e.getMessageAuthor().isYourself()) {
            return;
        }

        // commands
        if(e.getMessage().getContent().startsWith("~")) {
            return;
        }
        /*
        else {
            // filter words
            while (scan.hasNextLine()) {
                String word = scan.nextLine();
                if (e.getMessage().getContent().contains(word)) {
                    e.getChannel().sendMessage("Cease in the name of the law!");
                }
            }
        }
        */
    }
}

// Add a listener
        /*
        api.addMessageCreateListener(event -> {
            // Tests
            if (event.getMessage().getContent().equalsIgnoreCase("test")) {
                event.deleteMessage("Used word: test");
                event.getChannel().sendMessage("Cease in the name of the law!");
            }
            if (event.getMessage().getContent().equalsIgnoreCase("kick test")) {
                User author = event.getMessageAuthor().asUser().get();
                //event.getMessageAuthor().asUser().orElseGet();
                // use or else get instead
                if (author != null) {
                    event.deleteMessage("test");
                    event.getServer().get().kickUser(author);
                    event.getChannel().sendMessage(author + " was kicked for reason: test");
                } else {
                    event.getChannel().sendMessage("No user found: no action taken");
                }
            }
        });
        */

// Print the invite url
//System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());

/*
    public static void main(String[] args) {
        String token = "NTA2NDkzMTk0NzkyNDY4NTA4.Dri_mw.u0qwn17avImB-HMA3XG8tS06nEo";

        DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
    }
    */
