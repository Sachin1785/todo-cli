import java.util.*;
public class todo {
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        Vector<String> tasks = new Vector<>();
        System.out.println("Welcome Back");
        if (tasks.isEmpty())
            System.out.println("No tasks");
        else
            System.out.println(tasks);
            int t=1;
        while(t>0)
        {
            String choice=sc.nextLine();
            switch (choice) {
                case "/add":
                                {   
                                    System.out.println("enter task to be added");
                                    String task=sc.nextLine();
                                    tasks.add(task);
                                    System.out.println("Task added");
                                }
                    
                    break;
                
                case "/delete":
                                {
                                    System.out.println("Enter task to delete");
                                    System.out.println(tasks);
                                    int index=sc.nextInt();
                                    sc.nextLine();
                                    tasks.remove(index-1);
                                    System.out.println("Task deleted");
                                }
                    break;
                case "/show":
                                {
                                    System.out.println(tasks);
                                }   
                    break;
                case "/done":
                                {
                                    System.out.println("Enter task to mark as done");
                                    System.out.println(tasks);
                                    int index=sc.nextInt();
                                    sc.nextLine();
                                    tasks.set(index-1,tasks.get(index-1)+"-done");
                                    System.out.println("Task marked as done");
                                }
                    break;
                case "/clear":
                                {
                                        System.out.print("\033[H\033[2J");  
                                        System.out.flush();
                                }
                    
                    break;
                case "/exit":
                                {
                                    t=0;
                                }
                    break;
                case "/help":
                                {
                                    System.out.println("Enter /add to add a task");
                                    System.out.println("Enter /delete to delete a task");
                                    System.out.println("Enter /show to show all the tasks");
                                    System.out.println("Enter /done to mark a task as done");
                                    System.out.println("Enter /clear to clear the screen");
                                    System.out.println("Enter /exit to exit the application");
                                    System.out.println("Enter /help to display this help");
                                }
                            
                    break;
                default:
                                System.out.println("Da fuck??");
                    break;
            }
        }
        sc.close();
    }
}