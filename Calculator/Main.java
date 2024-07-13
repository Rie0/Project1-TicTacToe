import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input;
        int num1=0;
        int num2=0;
        int result=0;
        ArrayList<Integer> resultList = new ArrayList<>();

        try {
            do {
                System.out.println(
                        """

                                Pick an operation:
                                Enter 1 to addition the numbers
                                Enter 2 to subtraction the numbers
                                Enter 3 to multiplication the numbers
                                Enter 4 to division the numbers
                                Enter 5 to modulus the numbers
                                Enter 6 to find minimum number
                                Enter 7 to find maximum number
                                Enter 8 to find the average of numbers
                                Enter 9 to print the last result in calculator
                                Enter 10 to print the list of all results in calculator
                                Enter any other number to exit.
                                """);
                input = sc.nextInt();

                if (input >= 1 && input <= 5) {
                    System.out.println("Enter the first numbers:");
                    num1 = sc.nextInt();
                    System.out.println("Enter the second numbers:");
                    num2 = sc.nextInt();
                }
                if (input == 1) {
                    result = addition(num1, num2);
                    System.out.println("Result = " + result);
                } else if (input == 2) {
                    result = subtraction(num1, num2);
                    System.out.println("Result = " + result);
                } else if (input == 3) {
                    result = multiplication(num1, num2);
                    System.out.println("Result = " + result);
                } else if (input == 4) {
                    result = division(num1, num2);
                    System.out.println("Result = " + result);
                } else if (input == 5) {
                    result = modulus(num1, num2);
                    System.out.println("Result = " + result);
                } else if (input == 6) {
                    result = minimum(resultList);
                    System.out.println("Result = " + result);
                } else if (input == 7) {
                    result = maximum(resultList);
                    System.out.println("Result = " + result);
                } else if (input == 8) {
                    System.out.println(average(resultList));
                } else if (input == 9) {
                    System.out.println("Last result = " + resultList.getLast());
                } else if (input == 10) {
                    System.out.println("Results list:" + resultList);
                }

                if (input >= 1 && input <= 5){
                    resultList.add(result);
                }

            } while (input > 0 && input < 11);
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static int addition (int num1, int num2){
        int result = num1+num2;
        return result;
    }

    public static int subtraction (int num1, int num2){
        int result = num1-num2;
        return result;
    }

    public static int multiplication (int num1, int num2){
        int result = num1*num2;
        return result;
    }

    public static int division (int num1, int num2){
        int result = num1/num2;
        return result;
    }

    public static int modulus (int num1, int num2){
        int result = num1%num2;
        return result;
    }

    public static int minimum (ArrayList<Integer> resultList){
        int smallest = resultList.getFirst();
        for (int result:resultList){
            if(result<smallest){
                smallest=result;
            }
        }
        return smallest;
    }

    public static int maximum (ArrayList<Integer> resultList){
        int largest = resultList.getFirst();
        for (int result:resultList){
            if(result>largest){
                largest=result;
            }
        }
        return largest;
    }

    public static int average (ArrayList<Integer> resultList){
        int average = 0;
        for (int result:resultList){
            average+=result;
        }
        average = average/resultList.size();
        return average;
    }


}