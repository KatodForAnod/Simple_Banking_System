package banking;

import java.util.Scanner;

public class UserService {
    private final User user;

    public UserService(User user) {
        this.user = user;
    }

    public void userMenu() {
        while (true) {
            System.out.println("\n1. Balance");
            System.out.println("2. Log out");
            System.out.println("0. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("\nBalance: " + user.getBalance());
                    break;
                }
                case 2: {
                    return;
                }
                case 0: {
                    return;
                }
            }
        }
    }
}
