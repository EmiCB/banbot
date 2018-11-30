package com.github.emicb;

import com.github.emicb.commands.PurgeCommand;
import com.github.emicb.commands.TriggerWords;
import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String args[]) {
        // put discord bot token here
        String token = "NTA2NDkzMTk0NzkyNDY4NTA4.Dri_mw.u0qwn17avImB-HMA3XG8tS06nEo";

        // check token
        if(token.length() < 1) {
            System.err.println("Missing token! Stopping program...");
            return;
        }

        // Logs in bot
        org.javacord.api.DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

        // Add commands
        api.addMessageCreateListener(new TriggerWords());
        api.addMessageCreateListener(new PurgeCommand());

        // Print the invite url
        System.out.println("You can invite BanBot by using the following url: " + api.createBotInvite());
    }
}
