package behavioral;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    public static void main(String[] args) {
        TextChat chat = new TextChat();

        ServerUser admin = new Admin(chat, "Kenny");
        ServerUser user1 = new SimpleUser(chat, "Kate");
        ServerUser user2 = new SimpleUser(chat, "Bob");
        ServerUser user3 = new SimpleUser(chat, "Sasha");

        chat.setAdmin(admin);
        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);
        user1.sendMessage("Hello!");
        admin.sendMessage("Hi");
    }
}

//Client
abstract class ServerUser {
    String name;
    Chat chat;
    boolean isEnable = true;
    public boolean isEnable() { return isEnable; }
    public void setEnable(boolean isEnable) {this.isEnable = isEnable; }
    public ServerUser(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }
    public String getName() { return name; }
     public void sendMessage(String message) {chat.sendMessage(message, this); }
    abstract void getMessage(String message);
}
//Mediator interface

interface Chat {
    void sendMessage(String message, ServerUser user);
}

//Concrete Client
class Admin extends ServerUser {
    public Admin(Chat chat, String name) { super(chat, name); }
    public void getMessage(String message) {
        System.out.println("Admin " + getName() + " getting message: " + message);
        }
    }

//Concrete Client
class SimpleUser extends ServerUser {
    public SimpleUser(Chat chat, String name ) { super(chat, name);}
    public void getMessage(String message) {
        System.out.println("User " + getName() +" getting message: " + message);
    }
}

//Concrete Mediator
class TextChat implements Chat {
    ServerUser admin;
    List<ServerUser> users = new ArrayList<>();

    public void setAdmin(ServerUser admin) {
        if (admin != null && admin instanceof Admin) {
            this.admin = admin;
        } else {
            throw new RuntimeException("Nor enough rights");
        }
    }

    public void addUser(ServerUser u) {
        if (admin == null) {
            throw new RuntimeException("Admin is not in chat");
        }
        if (u instanceof SimpleUser) { users.add(u); }
    }
    @Override
    public void sendMessage(String message, ServerUser user) {
        if (user instanceof Admin) {
            for (ServerUser u : users) {
                u.getMessage(user.getName() + ": " + message);
            }
        }
        if (user instanceof SimpleUser) {
            for (ServerUser u : users) {
                if (u != user && u.isEnable())
                    u.getMessage(user.getName() + ":" + message);
            }
            if (admin.isEnable())
                admin.getMessage(user.getName() + ": " + message);
        }
    }
}