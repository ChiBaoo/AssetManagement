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
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends ArrayList<String>{
    private String menuName;
    
    public Menu() { super(); }

    public Menu(String menuName) {
        this.menuName = menuName;
    }
    
    public void addMenuItem(String S) { this.add(S); }
    
    public int getUserChoice(){
        System.out.println(menuName);
        for(int i = 0; i < this.size(); i++){
            System.out.println(i + 1 + ". " + this.get(i));
        }
        System.out.println("------------------------------------");
        System.out.print("Choose 1..." + this.size() + ": ");
	Scanner scan = new Scanner(System.in);
	return Integer.parseInt(scan.nextLine());
    }
    
    public void printMenu(){
        for(int i = 0; i < this.size(); i++){
            System.out.println(i + 1 + ". " + this.get(i));
        }
    }
}

