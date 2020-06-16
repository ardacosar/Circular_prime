import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number;
        number = input.nextInt();
        for (int i = 1; i < number; i++)
        {
            if(circularPrimeControl(i))
            {System.out.println(i);}
        }

    }
    public static boolean circularPrimeControl(int num){
        int number_of_digits;
        number_of_digits = digitFinder(num);

        int[] digits = new int[number_of_digits];
        digits = digitSeparator(digits, num);

        for(int i = 0; i < digits.length; i++)
        {
            num = digitJoiner(digits);
            if(!primeControl(num))
            {return false;}
            digits = slider(digits);

        }
        return true;

    }
    public static int digitFinder(int num){

        int digit=0;
        for(int i=1; i <= num; i *= 10)
        {
            if(num / i != 0)
            {
                digit++;
            }
        }
        return digit;
    }

    public static int[] digitSeparator(int[] digits, int num){
        for(int i = digits.length - 1; i >= 0; i--)
        {
            digits[i] = num % 10;
            num = num / 10;
        }
        return digits;
    }

    public static int digitJoiner(int[] digits){
        int number=0;
        for(int i = 0; i < digits.length ; i++)
        {
            number += digits[i] * Math.pow(10,digits.length - i - 1);
        }
        return number;
    }

    public static boolean primeControl(int num){
        if(num!=1)
        {
            for(int i = num-1; i > 1; i--)
            {
                if(num % i == 0)
                {return  false;}
            }
            return true;
        }
        return false;
    }
    
    public static int[] slider(int[] digits){
        int[] slippedDigits = new int[digits.length];
        for(int i = 0; i < digits.length - 1; i++)
        {
            slippedDigits[i] = digits[i+1];
        }
        slippedDigits[digits.length - 1] = digits[0];
        return slippedDigits;
    }


}
