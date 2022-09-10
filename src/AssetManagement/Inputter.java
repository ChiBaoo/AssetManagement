/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssetManagement;

/**
 *
 * @author luuchibao
 */
import java.util.Scanner;

public class Inputter {
    private static Scanner scan = new Scanner(System.in);
    
    public static String inputString (String msg) {
        String data;
        do {
            System.out.print(msg);
            data = scan.nextLine();
            if (data.isEmpty())
                System.out.println("Invalid! Enter again.");
        } while (data.length() == 0);
        return data;
    }
    
    public static String inputNonBlankStr (String msg) {
	String data;
	do {
            System.out.print(msg);
            data = scan.nextLine().trim();
            if (data.isEmpty())
                System.out.println("Invalid! Enter again.");
	} while (data.length() == 0);
        return data;
    }
    
    public static String inputWithCondition (String msg, String condition) {
        String data;
        do {
            System.out.print(msg);
            data = scan.nextLine();
            if (!data.matches(condition))
                System.out.println("Invalid! Enter again.");
        } while (data.length() == 0 || !data.matches(condition));
        return data;
    }
    
    public static int inputInt (String msg) {
	int data = 0;
        boolean isValid;
	do {
            isValid = true;
            try {
                System.out.print(msg);
                data = Integer.parseInt(scan.nextLine());
                if (data < 0)
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid! Enter again.");
                isValid = false;
            }
	} while (!isValid);
	return data;
    }
    
    public static double inputDouble (String msg) {
	double data = 0;
        boolean isValid;
	do {
            isValid = true;
            try {
                System.out.print(msg);
                data = Double.parseDouble(scan.nextLine());
                if (data < 0)
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("Invalid! Enter again.");
                isValid = false;
            }
	} while (!isValid);
	return data;
    }
    
    public static boolean inputBoolean (String msg) {
        String data;
        do {
            System.out.print(msg);
            data = scan.nextLine().trim().toLowerCase();
        } while (data.compareTo("true") != 0 && data.compareTo("false") != 0);
        return data.compareTo("true") == 0;
    }
}