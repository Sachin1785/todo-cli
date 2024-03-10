import java.util.*;

public class todo {
    // ANSI color codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Boolean> tasks = new HashMap<>();
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(ANSI_GREEN + "Welcome Back" + ANSI_RESET);
        displayTasksWithIndex(tasks);
        int t = 1;
        while (t > 0) {
            String choice = sc.nextLine();
            switch (choice) {
                case "/add": {
                    System.out.println(ANSI_BLUE + "Enter task to be added" + ANSI_RESET);
                    String task = sc.nextLine();
                    if (!tasks.containsKey(task)) {
                        tasks.put(task, false);
                        System.out.println(ANSI_GREEN + "Task added" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Task already exists" + ANSI_RESET);
                    }
                }
                break;

                case "/delete": {
                    System.out.println(ANSI_RED + "Enter task to delete" + ANSI_RESET);
                    displayTasksWithIndex(tasks);
                    String taskToDelete = sc.nextLine();
                    if (tasks.containsKey(taskToDelete)) {
                        tasks.remove(taskToDelete);
                        System.out.println(ANSI_RED + "Task deleted" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Task not found" + ANSI_RESET);
                    }
                }
                break;
                case "/show": {
                    displayTasksWithIndex(tasks);
                }
                break;
                case "/done": {
                    System.out.println(ANSI_BLUE + "Enter task to mark as done" + ANSI_RESET);
                    displayTasksWithIndex(tasks);
                    String taskToMarkDone = sc.nextLine();
                    if (tasks.containsKey(taskToMarkDone)) {
                        tasks.put(taskToMarkDone, true);
                        System.out.println(ANSI_GREEN + "Task marked as done" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Task not found" + ANSI_RESET);
                    }
                }
                break;
                case "/clear": {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
                break;
                case "/exit": {
                    t = 0;
                }
                break;
                case "/help": {
                    displayHelp();
                }
                break;
                default:
                    System.out.println(ANSI_RED + "Invalid command" + ANSI_RESET);
                    break;
            }
        }
        sc.close();
    }

    // Method to display tasks with their indices and completion status
    public static void displayTasksWithIndex(Map<String, Boolean> tasks) {
        if (tasks.isEmpty()) {
            System.out.println(ANSI_YELLOW + "No tasks" + ANSI_RESET);
        } else {
            System.out.println(ANSI_YELLOW + "Tasks:" + ANSI_RESET);
            int index = 1;
            for (Map.Entry<String, Boolean> entry : tasks.entrySet()) {
                String task = entry.getKey();
                boolean isDone = entry.getValue();
                String status = isDone ? ANSI_GREEN + "Done" + ANSI_RESET : ANSI_RED + "Not Done" + ANSI_RESET;
                System.out.println(index + ". " + task + " - " + status);
                index++;
            }
        }
    }

    // display help
    public static void displayHelp() {
        System.out.println(ANSI_YELLOW + "Enter /add to add a task" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter /delete to delete a task" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter /show to show all the tasks" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter /done to mark a task as done" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter /clear to clear the screen" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter /exit to exit the application" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Enter /help to display this help" + ANSI_RESET);
    }
}
