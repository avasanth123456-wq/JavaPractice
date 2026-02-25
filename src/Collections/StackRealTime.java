package Collections;

import java.util.Stack;

public class StackRealTime {
    public static void main(String[] args) {

        Stack<String> browserHistory = new Stack<>();

        browserHistory.push("Google");
        browserHistory.push("YouTube");
        browserHistory.push("Gmail");

        if (!browserHistory.isEmpty()) {
            for (String page : browserHistory) {
                System.out.println("Visited Page: " + page);
            }
        } else {
            System.out.println("No browsing history");
        }
    }
}
