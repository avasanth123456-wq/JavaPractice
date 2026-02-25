package Collections;

import java.util.Stack;

public class StackIf {
    public static void main(String[] args) {

        Stack<String> browserHistory = new Stack<>();


        browserHistory.push("Google");
        browserHistory.push("YouTube");
        browserHistory.push("Gmail");


        if (!browserHistory.isEmpty()) {
            System.out.println("Current Page: " + browserHistory.peek());
        } else {
            System.out.println("Stack is empty, no page to show");
        }

        if (!browserHistory.isEmpty()) {
            System.out.println("Back Page: " + browserHistory.pop());
        } else {
            System.out.println("Stack is empty, nothing to remove");
        }

        System.out.println("Total Pages: " + browserHistory.size());
    }
}



