package TodoApp;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TodoApp {
    private static final Path STORAGE = Paths.get("todos.txt");
    private final List<Todo> todos = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        new TodoApp().run();
    }

    private void run() {
        load();
        printHeader();
        boolean running = true;
        while (running) {
            printMenu();
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1" -> addTodo();
                case "2" -> listTodos();
                case "3" -> toggleComplete();
                case "4" -> removeTodo();
                case "5" -> saveAndExit();
                default -> System.out.println("Invalid choice. Try 1-5.");
            }
        }
    }

    private void printHeader() {
        System.out.println("=== Simple Todo App ===");
        System.out.println("Stored file: " + STORAGE.toAbsolutePath());
        System.out.println();
    }

    private void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1) Add todo");
        System.out.println("2) List todos");
        System.out.println("3) Toggle complete");
        System.out.println("4) Remove todo");
        System.out.println("5) Save & Exit");
        System.out.print("Choose: ");
    }

    private void addTodo() {
        System.out.print("Enter todo text: ");
        String text = in.nextLine().trim();
        if (text.isEmpty()) {
            System.out.println("Empty — cancelled.");
            return;
        }
        int id = nextId();
        todos.add(new Todo(id, text, false));
        System.out.println("Added: #" + id);
        save(); // auto-save after change
    }

    private void listTodos() {
        if (todos.isEmpty()) {
            System.out.println("No todos.");
            return;
        }
        System.out.println("\nYour todos:");
        for (Todo t : todos) {
            System.out.printf("%d) [%s] %s%n", t.id, t.done ? "x" : " ", t.text);
        }
    }

    private void toggleComplete() {
        System.out.print("Enter ID to toggle: ");
        String s = in.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            Todo t = findById(id);
            if (t == null) {
                System.out.println("Not found: " + id);
            } else {
                t.done = !t.done;
                System.out.println("Updated: " + id + " -> " + (t.done ? "done" : "not done"));
                save();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    private void removeTodo() {
        System.out.print("Enter ID to remove: ");
        String s = in.nextLine().trim();
        try {
            int id = Integer.parseInt(s);
            Todo t = findById(id);
            if (t == null) {
                System.out.println("Not found: " + id);
            } else {
                todos.remove(t);
                System.out.println("Removed: " + id);
                save();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    private void saveAndExit() {
        save();
        System.out.println("Saved. Goodbye!");
        System.exit(0);
    }

    private int nextId() {
        return todos.stream().mapToInt(t -> t.id).max().orElse(0) + 1;
    }

    private Todo findById(int id) {
        for (Todo t : todos) if (t.id == id) return t;
        return null;
    }

    // Persistence format: each line "id|done|text"
    private void load() {
        if (!Files.exists(STORAGE)) return;
        try (BufferedReader r = Files.newBufferedReader(STORAGE)) {
            String line;
            while ((line = r.readLine()) != null) {
                String[] parts = line.split("\\|", 3);
                if (parts.length < 3) continue;
                int id = Integer.parseInt(parts[0]);
                boolean done = "1".equals(parts[1]);
                String text = parts[2];
                todos.add(new Todo(id, text, done));
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Warning: could not load todos (" + e.getMessage() + ")");
        }
    }

    private void save() {
        try (BufferedWriter w = Files.newBufferedWriter(STORAGE)) {
            for (Todo t : todos) {
                String line = String.format("%d|%s|%s", t.id, t.done ? "1" : "0", t.text);
                w.write(line);
                w.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving todos: " + e.getMessage());
        }
    }

    private static class Todo {
        final int id;
        String text;
        boolean done;

        Todo(int id, String text, boolean done) {
            this.id = id;
            this.text = text;
            this.done = done;
        }
    }
}

