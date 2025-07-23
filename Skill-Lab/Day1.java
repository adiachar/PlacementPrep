import java.util.Scanner;

class Day1 {
    static void reverseNum() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int newNum = 0;

        boolean isNegative = num < 0;

        if(isNegative) {
            num = -num;
        }

        while(num > 0) {
            newNum = (newNum * 10) + (num % 10);
            num /= 10;
        }

        if(isNegative) {
            System.out.println(-newNum);
        } else {
            System.out.println(newNum);
        }
    }

    static int digitalRoot(int digit) {
        if(digit < 10) {
            return digit;
        }

        int currRoot = 0;

        while(digit > 0) {
            currRoot += digit % 10;
            digit /= 10;
        }

        return digitalRoot(currRoot);
    }

    static int simpleInterest(int principal, int rate, int time) {
        return (principal * rate * time) / 100;
    }

    static double compoundInterest(int principal, int rate, int time, int nc) {
        float compoundRate = 1 + ((float) rate / (100 * nc));
        float finalAmount = (float) (principal * Math.pow(compoundRate, nc * time));
        return finalAmount - principal;
    }

    static void guessNum() {
        int random = (int) (Math.random() * 100);
        int userChoice = -1;
        Scanner sc = new Scanner(System.in);
        int i = 1;
        while(userChoice != random && i <= 5) {
            System.out.print("Your Guess (-1 for exit): ");
            userChoice = sc.nextInt();
            if(userChoice < 0) {
                return;
            }
            i++;
        }
        if(userChoice == random) {
            System.out.println("You Guessed it right!");
        } else {
            System.out.println("Wrong Guesses!");
        }
    }

    static boolean isAritmaticOrGeometirc(int arr[]) {
        if(arr.length == 1) {
            return true;
        }
        return isArithmatic(arr) || isGeometric(arr);
    }

    static boolean isArithmatic(int arr[]) {
        int d = arr[1] - arr[0];
        for(int i = 1; i < arr.length; i++) {
            if((arr[i] - arr[i - 1]) != d) {
                return false;
            }
        }
        return true;
    }

    static boolean isGeometric(int arr[]) {

        int pArr[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            pArr[i] = Math.abs(arr[i]);
        }

        int r = pArr[1]/pArr[0];
        
        for(int i = 1; i < pArr.length; i++) {
            if(pArr[i]/pArr[i - 1] != r) {
                return false;
            }
        }

        return true;
    }

    static boolean pythagoreanTriplets(int arr[]) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(isFound(arr, (int)(Math.pow(arr[i], 2) + Math.pow(arr[j], 2))))  {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean isFound(int arr[], int key) {
        for(int i = 0; i < arr.length; i++) {
            if(Math.pow(arr[i], 2) == key) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 6, 7};
        System.out.println(pythagoreanTriplets(arr));
    }
}