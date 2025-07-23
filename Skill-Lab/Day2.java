import java.util.*;

public class Day2 {
    static ArrayList<Integer> findPrime(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            arr.add(i+1);
        }
        
        int i = 0;

        while(i < arr.size() - 1) {
            int currNum = arr.get(i);
            if(currNum == -1) {
                i++;
                continue;
            }
            int j = i + 1;
            while(j < arr.size()) {
                if(arr.get(j) % currNum == 0) {
                    arr.set(j, -1);
                }
                j++;
            }
            i++;
        }
        return arr;
    }

    static boolean isArmstrongNum(int num) {
        int n = num;
        int result = 0;
        while(n > 0) {
            result += Math.pow(n % 10, 3);
            n /= 10;
        }
        return result == num;
    }

    static void twinPrimes(int n) {
        int i = 2;
        int j = i + 2;

        while(j < n) {
            if(isPrime(i) && isPrime(j)) {
                System.out.println(i +" " +j);
            }
            i++;
            j++;
        }
    }

    static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
 
        return true;
    }

    static void findArmstrongNumbersInRange(int start, int end) {
        for(int i = start; i <= end; i++) {
            if(isArmstrongNum(i)) {
                System.out.println(i);
            }
        }
    }

    static void diagonalSum(int arr[][]) {
        //for left sum
        int i = 0;
        int j = 0;
        int leftSum = 0;
        while(i < arr.length && j < arr[0].length) {
            leftSum += arr[i++][j++];
        }

        //for right sum
        i = 0;
        j = arr.length - 1;
        int rightSum = 0;
        while(i < arr.length && j >= 0) {
            rightSum += arr[i++][j--];
        }

        System.out.println("Left Sum: " + leftSum +" Right Sum: " + rightSum);
    }

    static void reverseWord(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split(" ");
        for(int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            result.append(' ');
        }
        System.out.println(result);
    }

    static void findAnagrams(String[] str) {
        int arr[][] = new int[str.length][2];

        for(int i = 0; i < str.length; i++) {
            int val = 0;
            for(int j = 0; j < str[i].length(); j++) {
                val += (int) str[i].charAt(j);
            }
            arr[i][0] = i;
            arr[i][1] = val;
        }

        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));

        for(int i = 0; i < arr.length; i++) {
            System.out.print(str[arr[i][0]] +", ");
        }
    }

    static class Dictionary {
        ArrayList<ArrayList<String>> dict;

        Dictionary() {
            dict = new ArrayList<>();
            for(int i = 0; i  < 26; i++) {
                dict.add(new ArrayList<>());
            }
        }

        void add(String str) {
            int i = str.charAt(0) - 'a';
            dict.get(i).add(str);
            for(ArrayList<String> a: dict) {
                a.sort(Comparator.comparingInt(String::length));
            }
        }

        void print() {
            for(ArrayList<String> s: dict) {
                if(!s.isEmpty())
                    System.out.println(s.get(0).charAt(0) +": " +s);
            }
        }
    }

    public static void main(String[] args) {
        String str[] = {"eat", "ant", "tan", "ate", "tea", "cat", "bat", "rat", "zebra", "apple", "dog", "frog", "good", "gide"};
        Dictionary d = new Dictionary();
        for(String s: str) {
            d.add(s);
        }
        d.print();
    }
}
