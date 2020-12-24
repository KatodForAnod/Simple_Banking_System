package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private List<User> data = new ArrayList<>();


    public void menu() {
        while (true) {
            System.out.println("\n1. Create an account");
            System.out.println("2. Log into account");
            System.out.println("0. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    createAnAccount();
                    System.out.println("\nYour card has been created");
                    System.out.println("Your card number:\n" + data.get(data.size() - 1).getNumberFfCard());
                    System.out.println("Your card PIN:\n" + data.get(data.size() - 1).getPassword());
                    break;
                }
                case 2: {
                    System.out.println("\nEnter your card number:");
                    String cardNumber = scanner.next();

                    System.out.println("Enter your PIN:");
                    String password = scanner.next();

                    User user = logIntoAccount(password, cardNumber);
                    if (user != null) {
                        System.out.println("\nYou have successfully logged in!");
                        UserService userService = new UserService(user);
                        userService.userMenu();

                        System.out.println("\nYou have successfully logged out!");
                    } else {
                        System.out.println("\nWrong card number or PIN!");
                    }

                    break;
                }
                case 0: {
                    return;
                }
            }
        }
    }

    public void createAnAccount() {
        StringBuilder number16x = new StringBuilder();

        number16x.append("400000");
        for (int i = number16x.length(); i < 15; i++) {
            number16x.append((int) (Math.random() * 9));
        }
        number16x.append(luhnAlgo(number16x.toString()));


        StringBuilder password4x = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            password4x.append((int) (Math.random() * 9));
        }

        data.add(new User(password4x.toString(), number16x.toString()));
    }

    public String luhnAlgo(String number) {
        int sum1 = 0;
        int sum2 = 0;
        final int nDigits = number.length();
        for (int i = nDigits; i > 0; i--) {
            int digit = Character.getNumericValue(number.charAt(i - 1));
            int z = digit;
            int y = digit;
            if (i % 2 != 0) {
                z *= 2;
                if (z > 9) {
                    z -= 9;
                }
                sum1 += z;
            } else sum2 += y;
        }
        int sum = sum1 + sum2;

        for (int i = 0; i < 10; i++) {
            if ((sum + i) % 10 == 0) {
                return Integer.toString(i);
            }
        }

        return "";
    }

    public User logIntoAccount(String password, String cardNumber) {

        for (User i : data) {
            if (i.getNumberFfCard().equals(cardNumber) &&
                    i.getPassword().equals(password)) {
                return i;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}