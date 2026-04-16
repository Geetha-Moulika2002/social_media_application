package controller;

import model.*;
import view.*;

import java.util.*;

public class socialmediacontroller {

    List<user> users = new ArrayList<>();
    socialmediaview view = new socialmediaview();
    Scanner sc = new Scanner(System.in);

    public user signup() {
        String name = view.getInput("Enter Name: ");
        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        String dob = view.getInput("DOB: ");
        String loc = view.getInput("Location: ");
        String occ = view.getInput("Occupation: ");

        user u = new user(name, age, dob, loc, occ);
        users.add(u);
        return u;
    }

    public user login() {
        String name = view.getInput("Enter Name: ");

        for (user u : users) {
            if (u.name.equalsIgnoreCase(name)) return u;
        }
        view.display("User not found!");
        return null;
    }

    public void suggestFriends(user user1) {
        for (user u : users) {
            if (u == user1 || user1.friends.contains(u)) continue;

            int mutual = 0;
            for (user f : user1.friends) {
                if (u.friends.contains(f)) mutual++;
            }

            view.display(u.name + " | Mutual: " + mutual);
        }
    }

    public void sendRequest(user from) {
        String name = view.getInput("Enter name: ");

        for (user u : users) {
            if (u.name.equalsIgnoreCase(name)) {
                u.requests.add(from);
                u.notifications.add(from.name + " sent request");
                return;
            }
        }
    }

    public void handleRequests(user user1) {
        for (user u : user1.requests) {
            view.display("Request from " + u.name + " Accept? y/n");
            String ch = sc.nextLine();

            if (ch.equals("y")) {
                user1.friends.add(u);
                u.friends.add(user1);
            }
        }
        user1.requests.clear();
    }

    public void createPost(user user1) {
        String content = view.getInput("Enter post: ");
        user1.posts.add(new post(content, user1));
    }

    public void showFeed(user user1) {
        for (user f : user1.friends) {
            for (post p : f.posts) {
                view.display(p.author.name + ": " + p.content);
            }
        }
    }

    public void notifications(user user1) {
        for (String n : user1.notifications) {
            view.display(n);
        }
        user1.notifications.clear();
    }

    public void viewFriends(user user1) {
        for (user f : user1.friends) {
            view.display(f.name);
        }
    }
}