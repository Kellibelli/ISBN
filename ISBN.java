package ISBN;

import java.util.Scanner;
public class ISBN
{
    public static void main(String[] args) {
        ISBNVerifier verifier = new ISBNVerifier();
        verifier.calculate10digit();
    }

    public static class ISBNVerifier{

        public int[] digits;
        public Scanner input;
        public int  inputLength;
        public final int ISBN_LENGTH = 10;

        //Constructor
        public ISBNVerifier(){
            digits = new int[9];
            input = new Scanner(System.in);
            inputLength = 0;
        }

        void calculate10digit() {
            int digitTen = 0;
            int finalnumber = 0;
            int UserInput;
            boolean leadingZero = false;

            System.out.print("Enter the ISBN number: ");
            UserInput = input.nextInt();

            leadingZero = checkForZero(UserInput);
            parseDigits(UserInput);
            finalnumber = CheckSum(UserInput);
            digitTen = calcDigit10();

            //Print the final number with digit 10
            System.out.print("The ISBN-10 number is: ");
            if (leadingZero == true){
                System.out.print(0);
            }
            System.out.print(finalnumber);

            if (digitTen == 10){
                System.out.print("X");
            }
            else {
                System.out.print(digitTen);
            }
        }

        private void parseDigits (int UserInput){
            for ( int i = 0; i < ISBN_LENGTH - 1 ; i++) {
                digits[i] = UserInput % 10;
                UserInput = UserInput / 10;
            }
        }

        private int CheckSum(int UserInput) {
            int finalnumber = 0;
            for ( int i = 0; i < ISBN_LENGTH - 1 ; i++) {
                digits[i] = UserInput % 10;
                UserInput = UserInput / 10;
                finalnumber += digits[i] * Math.pow(10, i);

            }
            return finalnumber;
        }

        private boolean checkForZero(int UserInput) {
            if (UserInput < 99999999){
                inputLength = 8;
                digits[0] = 0;
                return true;
            }
            return false;
        }

        private int calcDigit10(){
            int digitTen = 0;
            for ( int i = 1; i < ISBN_LENGTH -1; i++) {
                digitTen += digits[i-1] *(ISBN_LENGTH-i);
            }
            digitTen = digitTen % 11;
            return digitTen;
        }
    }
}

