package com.company;
import javax.xml.stream.FactoryConfigurationError;
import java.util.Scanner;
public class Main {
    static boolean exit = false;
    public static void main(String[] args) {
	// write your code here
        intro();
        Scanner input = new Scanner(System.in);
        while( exit != true) {
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
            System.out.print("Please enter an operation ( +, -, /, *, = or Q to quit.) : ");
            String operator = input.nextLine();
            operator = getOperation(operator);
            if (operator.equals("Q") || operator.equals("q")) {
                exit = true;
                break;
            }
            int flag;
            if (operator.equals("+")) {
                flag = 1;
            }
            else if (operator.equals("-")) {
                flag = 2;
            }
            else if (operator.equals("/")) {
                flag = 3;
            }
            else if (operator.equals("*")) {
                flag = 4;
            }
            else {
                flag = 5;
            }
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String fr1 = input.nextLine();
            Fraction f1 = getFraaction(fr1);
            System.out.print("Please enter a fraction (a/b) or integer (a): ");
            String fr2 = input.nextLine();
            Fraction f2 = getFraaction(fr2);
            Fraction fr3;
            switch (flag) {
                case 1: {
                    fr3 = f1.add(f2);
                    System.out.println(fr1.toString() + " " + operator + " " + fr2.toString() + " = " + fr3.toString());
                    break;
                }
                case 2: {
                    fr3 = f1.subtract(f2);
                    System.out.println(fr1.toString() + " " + operator + " " + fr2.toString() + " = " + fr3.toString());
                    break;
                }
                case 3: {
                    fr3 = f1.divide(f2);
                    System.out.println(fr1.toString() + " " + operator + " " + fr2.toString() + " = " + fr3.toString());
                    break;
                }
                case 4: {
                    fr3 = f1.multiply(f2);
                    System.out.println(fr1.toString() + " " + operator + " " + fr2.toString() + " = " + fr3.toString());
                    break;
                }
                case 5: {
                    boolean bol = f1.equals(f2);
                    System.out.println(fr1.toString() + " " + operator + " " + fr2.toString() + " is " + bol);
                    break;
                }
            }
        }

    }

    public static Fraction getFraaction(String fr1) {
        Scanner input = new Scanner(System.in);
        boolean valid = validFraction(fr1);
        if (!valid) {
            while(true) {
                System.out.print("Invalid fraction, Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
                fr1 = input.nextLine();
                valid = validFraction(fr1);
                if (valid == true) {
                    break;
                }
            }
        }
        Fraction frctn = getNumbers(fr1);
        return frctn;
    }

    public static Fraction getNumbers(String fr) {
        boolean div = fr.contains("/");
        int len = fr.length();
        if (div) {
            int i = fr.indexOf("/");
            String num = fr.substring(0,i);
            String den = fr.substring(i+1, len);
            int x = Integer.parseInt(num);
            int y = Integer.parseInt(den);
            return new Fraction(x, y);
        }
        else {
            int x = Integer.parseInt(fr);
            int y = 1;
            return new Fraction(x, y);
        }
    }

    public static String getOperation(String operator) {
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("=") || operator.equals("Q") || operator.equals("q")) {
            return operator;
        }
        else {
            while (true) {
                System.out.print("Invalid input ( +, -, *, /, = or Q to quit.) : ");
                Scanner sc = new Scanner(System.in);
                operator = sc.nextLine();
                if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("=") || operator.equals("Q") || operator.equals("q")) {
                    break;
                }
            }
            return operator;
        }
    }

    public static boolean isNumber(String frac) {
        int ttl = frac.length();
        int count = 0;
        for (int i = 0 ; i < ttl ; i ++) {
            if(frac.substring(i).contains("1") || frac.substring(i).contains("2") || frac.substring(i).contains("3") || frac.substring(i).contains("4") || frac.substring(i).contains("5") || frac.substring(i).contains("6") || frac.substring(i).contains("7") || frac.substring(i).contains("8") || frac.substring(i).contains("9") || frac.substring(i).contains("0")) {
                count = count+1;
            }
        }
        if (ttl == count) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean validFraction (String str) {
        boolean vld = false;
        if (str.contains("-")) {
            vld = true;
            int i = str.indexOf("-");
            if (i != 0) {
                return false;
            }
        }
        boolean div = str.contains("/");
        if (div) {
            int id = str.indexOf("/");
            int len = str.length();
            String num = str.substring(0, id);
            boolean isNum = isNumber(num);
            String den = str.substring(id+1, len);
            int checkZero = Integer.parseInt(den);
            if (checkZero == 0) {
                return false;
            }
            boolean isDen = isNumber(den);
            if (isNum && isDen) {
                vld = true;
                return vld;
            }
            else {
                vld = false;
                return vld;
            }
        }
        else {
            vld = isNumber(str);
            return vld;
        }
    }

    public static void intro () {
        System.out.println("This program is a fraction Calculator");
        System.out.println("It will add, subtract, multiply and divide fractions unitl you type Q to quit.");
        System.out.println("Pleae enter your fractions in the form a/b, where a and b are integers.");
    }
}

