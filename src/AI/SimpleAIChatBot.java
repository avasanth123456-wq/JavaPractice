package AI;

import java.util.Scanner;

public class SimpleAIChatBot{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("🤖 Hi! I’m your AI Assistant. Type 'bye' to exit.");
        while (true){
            System.out.println("You:");
            String userInput = sc.nextLine().toLowerCase();

            if (userInput.contains("hi")|| userInput.contains("hello")){
                System.out.println("AI: Hello there!How can I help you?");
            }else if (userInput.contains("How are you")){
                System.out.println("AI: i'm just a program, but I'm doing great");

            } else if (userInput.contains("your name")) {
                System.out.println("AI: I'm a simple Java AI Chatbot created by you!");
            } else if (userInput.contains("weather")) {
                System.out.println("AI: I can't check real weather yet, but it’s always sunny in code world! ☀️");
            } else if (userInput.contains("bye")) {
                System.out.println("AI: Goodbye! Have a nice day 👋");
                break;
            } else {
                System.out.println("AI: Hmm... I didn’t understand that. Can you rephrase?");
            }
        }

        sc.close();
    }
}

