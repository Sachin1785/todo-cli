import java.util.*;

public class todo {
    // ANSI color codes
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
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
                    tasks.add(task);
                    System.out.println(ANSI_GREEN + "Task added" + ANSI_RESET);
                }
                break;

                case "/delete": {
                    System.out.println(ANSI_RED + "Enter task index to delete" + ANSI_RESET);
                    displayTasksWithIndex(tasks);
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index > 0 && index <= tasks.size()) {
                        tasks.remove(index - 1);
                        System.out.println(ANSI_RED + "Task deleted" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Invalid task index" + ANSI_RESET);
                    }
                }
                break;
                case "/show": {
                    displayTasksWithIndex(tasks);
                }
                break;
                case "/done": {
                    System.out.println(ANSI_BLUE + "Enter task index to mark as done" + ANSI_RESET);
                    displayTasksWithIndex(tasks);
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index > 0 && index <= tasks.size()) {
                        tasks.set(index - 1, tasks.get(index - 1) + "-done");
                        System.out.println(ANSI_GREEN + "Task marked as done" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Invalid task index" + ANSI_RESET);
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

    // display tasks with their indices
    public static void displayTasksWithIndex(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println(ANSI_YELLOW + "No tasks" + ANSI_RESET);

        } else {
            System.out.println(ANSI_CYAN + "Tasks:" + ANSI_RESET);
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " +ANSI_PURPLE+ tasks.get(i)+ ANSI_RESET);
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

