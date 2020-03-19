import java.util.Scanner;

public class TaxCalculator {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your income for this year> ");
        double input = sc.nextDouble();
        double[] taxBracket = {20000.00, 10000.00, 10000.00, 40000.00, 40000.00, 40000.00, 40000.00, 40000.00, 40000.00, 40000.00};
        double[] taxPercentage = {0.000, 0.02, 0.035, 0.07, 0.115, 0.15, 0.18, 0.19, 0.195, 0.20};
        double taxableAmount = 0.0;
        int i = 0;
        boolean stillHaveMoney = true;
        while (stillHaveMoney) {
            if (input < 320000.00) {
                double deductable = taxBracket[i];
                if (input - deductable > 0) {
                    input -= deductable;
                    taxableAmount += taxPercentage[i] * deductable;
                    i += 1;
                } else {
                    taxableAmount += input * taxPercentage[i];
                    stillHaveMoney = false;
                }
            } else {
                taxableAmount = 44550.00 + (input - 320000) * 0.22;
                stillHaveMoney = false;
            }
        }

        System.out.println("You have to pay $" + taxableAmount + " in taxes! :(");
    }
}