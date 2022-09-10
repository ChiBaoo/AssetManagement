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

public class AssetMng {
    public static void main(String[] args) {
        MngList list = new MngList();
        list.loadEmpFromFile("employee.txt");
        list.loadAssetFromFile("asset.txt");
        list.loadRequestFromFile("request.txt");
        list.checkLogin();
        Menu menu = new Menu("ASSET MANAGEMENT");
        menu.addMenuItem("Search asset by name.");
        menu.addMenuItem("Create new asset.");
        menu.addMenuItem("Updating asset's information.");
        menu.addMenuItem("Approve the request of employee.");
        menu.addMenuItem("Show list of borrow asset.");
        menu.addMenuItem("Quit.");
        do{
            System.out.println();
            int choice = menu.getUserChoice();
            switch(choice) {
                case 1: list.searchAssetByName(); break;
                case 2: list.checkLogin(); list.addNewAsset(); break;
                case 3: {
                    list.checkLogin();
                    Asset asset = list.updateAsset();
                    if (asset != null)
                        System.out.println(asset);
                    else System.out.println("Asset does not exist.");
                    break;
                } 
                case 4: list.checkLogin(); list.approveRequest(); break;
                case 5: list.checkLogin(); list.showBorrowAssetList(); break;
                case 6: {
                    String check = Inputter.inputWithCondition("Do you want to save all (Y/N): ", "(?i)(Y|N)");
                    if (check.equalsIgnoreCase("Y")) {
                        list.saveEmpToFile("employee.txt");
                        list.saveAssetToFile("asset.txt");
                        list.saveRequestToFile("request.txt");
                    }
                    System.out.println("See you again.");
                    return;
                }
            }
        }while(true);
    }
}

