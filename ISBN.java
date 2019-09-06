import java.util.Scanner;
public class ISBN {
    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                int[] numbers = new int[9];

                System.out.print("Enter the ISBN number: ");

                for (int i = 0; i < numbers.length; i++) {
                    for (int j = 1; j < 10; j++) {
                        numbers[i] = input.nextInt() * j;
                    }
                }
                int checksum = 0;
                for (int a = 0; a < 10; a++) {
                    checksum += numbers[a];
                }
                int d10 = (checksum % 11);
                System.out.println(d10);

                if (d10 == 10) {
                    System.out.println("The ISBN's 10 number is " + numbers + "X");
                } else {
                    System.out.println("The ISBN'S 10 number is " + numbers);
                }
            }
        }
