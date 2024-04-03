import java.io.*;
import java.util.*;

public class SimpleTaskListApplication {
    private static ArrayList<String> tasks = new ArrayList<String>();

    public static void main(String[] args) {
    	System.out.println("****The Simple Task List Application****");
        Scanner in = new Scanner(System.in);
        int choice;

        while (true) {
        	System.out.println("The Tasks are");
            System.out.println("1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. View task");
            System.out.println("4. Edit tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = in.nextInt();

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                    	 viewTasks();
                        break;
                    case 4:
                    	editTask();
                        break;
                    case 5:
                        exit();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                in.nextLine();
            }
        }
    }
private static void addTask() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter task: ");
        tasks.add(in.nextLine());
        System.out.println();
    }
private static void removeTask() {
    Scanner in = new Scanner(System.in);
    System.out.print("Enter task: ");
    tasks.remove(in.nextLine());
    System.out.println();
}

private static void viewTasks() {
	if (tasks.isEmpty()) {
            System.out.println("No tasks to display");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
    
    private static void editTask() {
        Scanner in = new Scanner(System.in);
        int taskNum;
        String newTask;

        viewTasks();
        System.out.print("Enter task number to edit: ");
        try {
            taskNum = in.nextInt();
            if (taskNum <= 0 || taskNum > tasks.size()) {
                throw new IndexOutOfBoundsException();
            }
            System.out.print("Enter new task description:");
            newTask = in.nextLine();
            tasks.set(taskNum-1, newTask);
          
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            in.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid task number. Please try again.");
        }
    }
    private static void exit() {
        System.out.println("Exiting program");
        System.exit(0);
    }
}

