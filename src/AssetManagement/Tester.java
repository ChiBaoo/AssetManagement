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
public class Tester {
    public static void main(String[] args) {
        MngList list = new MngList();
        list.loadAssetFromFile("asset.txt");
        list.loadEmpFromFile("employee.txt");       
        list.loadRequestFromFile("request.txt");
        list.showBorrowAssetList();
        list.showAssetList();
        System.out.println("-------------------------------------------------------");
        list.approveRequest();
        list.showBorrowAssetList();
        list.showAssetList();
        list.saveRequestToFile("request.txt");
        
    }
}
//RB001,E140449,A001,1,2021-12-23,2022-02-13,null
//RB002,E160001,A002,1,2021-12-24,2022-01-03,null
//RB003,E160798,A001,1,2021-12-23,2022-01-27,null
//RB007,E160240,A002,1,2021-12-24,null,null
//String pwd = "123!@#";
//String pwd = "234#@!";
//String pwd = "@$%456";
//String pwd = "567/*+";
//String pwd = "123456";
