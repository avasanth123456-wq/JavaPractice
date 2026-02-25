package Collections;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {

        Stack<String> browserHistory = new Stack<>();


        browserHistory.push("Google");
        browserHistory.push("YouTube");
        browserHistory.push("Gmail");

        System.out.println("Stack: " + browserHistory);

        System.out.println("Current Page: " + browserHistory.peek());


        System.out.println("Back Page: " + browserHistory.pop());


        System.out.println("Total Pages: " + browserHistory.size());


        System.out.println("Is stack empty? " + browserHistory.isEmpty());
    }
}

