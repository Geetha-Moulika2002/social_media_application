package view;

import java.util.*;

public class socialmediaview {

    Scanner sc = new Scanner(System.in);

    public int showMainMenu() {
        System.out.println("\n1 Signup");
        System.out.println("2 Login");
        System.out.println("3 Exit");
        return sc.nextInt();
    }

    public int showUserMenu(String name) {
        System.out.println("\nWelcome " + name);
        System.out.println("1 Suggest Friends");
        System.out.println("2 Send Friend Request");
        System.out.println("3 Handle Requests");
        System.out.println("4 Create Post");
        System.out.println("5 View Feed");
        System.out.println("6 Notifications");
        System.out.println("7 View Friends");
        System.out.println("8 Logout");
        return sc.nextInt();
    }

    public String getInput(String msg) {
        System.out.print(msg);
        sc.nextLine();
        return sc.nextLine();
    }

    public void display(String msg) {
        System.out.println(msg);
    }
}