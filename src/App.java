//package App;

import controller.*;
import model.*;
import view.*;

public class App {
    public static void main(String[] args) {

        socialmediacontroller controller = new socialmediacontroller();
        socialmediaview view = new socialmediaview();

        user currentUser = null;

        while (true) {
            if (currentUser == null) {
                int ch = view.showMainMenu();

                if (ch == 1) currentUser = controller.signup();
                else if (ch == 2) currentUser = controller.login();
                else return;
            } else {
                int ch = view.showUserMenu(currentUser.name);

                switch (ch) {
                    case 1 -> controller.suggestFriends(currentUser);
                    case 2 -> controller.sendRequest(currentUser);
                    case 3 -> controller.handleRequests(currentUser);
                    case 4 -> controller.createPost(currentUser);
                    case 5 -> controller.showFeed(currentUser);
                    case 6 -> controller.notifications(currentUser);
                    case 7 -> controller.viewFriends(currentUser);
                    case 8 -> currentUser = null;
                }
            }
        }
    }
}