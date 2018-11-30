package com.github.emicb.util;

import org.javacord.api.entity.user.User;

public class UserWarnings {
    private User user;
    private int warnings;

    public UserWarnings(User user, int warnings) {
        this.user = user;
        this.warnings = warnings;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getWarnings() {
        return warnings;
    }
    public void setWarnings(int warnings) {
        this.warnings = warnings;
    }
}