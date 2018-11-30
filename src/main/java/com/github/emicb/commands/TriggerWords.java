package com.github.emicb.commands;

import com.github.emicb.util.UserWarnings;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.io.File;
import java.util.*;

public class TriggerWords implements MessageCreateListener {
    // put paths to files here
    private String wordsFilePath = "C:/Users/emicb/Desktop/banbot/src/main/java/com/github/emicb/textfiles/words.txt";

    // other things
    private File words = new File(wordsFilePath);
    private Scanner scan;

    private List<String> wordsList = new ArrayList<>();
    private String word;

    private List<UserWarnings> users = new ArrayList<>();
    private User author;
    private UserWarnings userPair;
    private UserWarnings newUserPair = new UserWarnings(null, 0);
    private boolean foundUser;

    private int maxWarnings = 3;

    public TriggerWords() {
        // Scanner
        try {
            scan = new Scanner(words);
        } catch(Exception exception) {
            System.err.print("File not found!");
        }

        while(scan.hasNext()) {
            wordsList.add(scan.next());
        }
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        // ignore if author of the message is the bot
        if(event.getMessage().getAuthor().isYourself()) {
            return;
        }

        // loops through list of words
        for(int i = 0; i < wordsList.size(); i++) {
            word = wordsList.get(i);
            if(event.getMessage().getContent().contains(word)) {
                author = event.getMessageAuthor().asUser().orElseGet(null);
                if(author == null) {
                    // runs this loop if user cannot be identified
                    System.err.println("User not found!");
                }
                else {
                    foundUser = false;
                    // cycle through array for users
                    for(int j = 0; i < users.size(); i++) {
                        userPair = users.get(j);

                        // if author is found in the list of users...
                        if(userPair.getUser() == author) {
                            foundUser = true;
                            // if they have fewer than the max amount of warnings...
                            if(userPair.getWarnings() < maxWarnings){
                                // deletes message
                                //event.deleteMessage();
                                // adds a warning to the user's personal count
                                userPair.setWarnings(userPair.getWarnings() + 1);
                                // sends a message to the channel
                                event.getChannel().sendMessage(author.getMentionTag() + " has " + userPair.getWarnings() + " warnings (max of " + maxWarnings + ").");
                            }
                            // if they have the max amount of warnings...
                            if(userPair.getWarnings() == maxWarnings) {
                                // kicks the user after issuing maximum warnings
                                //event.getServer().get().kickUser(author);
                                // notifies that the user was kicked
                                event.getChannel().sendMessage(author.getMentionTag() + " has been kicked from the server due to language.");
                            }
                        }
                    }
                    if(!foundUser) {
                        newUserPair.setUser(author);
                        newUserPair.setWarnings(1);
                        users.add(newUserPair);
                        event.getChannel().sendMessage(author.getMentionTag() + " has " + newUserPair.getWarnings() + " warnings (max of " + maxWarnings + ").");
                    }
                    else {
                        return;
                    }
                }
            }
        }
    }
}
