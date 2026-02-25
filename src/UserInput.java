import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Welcome " + name + " RK Coding");
        System.out.print("Please enter number one : ");
        int firstNumber = input.nextInt();
        System.out.print("Please enter number Two : ");
        int secondNumber = input.nextInt();
        System.out.print("Total: " + (firstNumber + secondNumber));

    }
}
