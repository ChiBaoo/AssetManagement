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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MngList {
    private ArrayList<Asset> assetList = new ArrayList();
    private ArrayList<Employee> empList = new ArrayList();
    private ArrayList<Request> resquestList = new ArrayList();

    /*public MngList() {
        super();
    }*/
    
    public void loadAssetFromFile(String fName){
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            try (FileReader fr = new FileReader(f); BufferedReader bf = new BufferedReader(fr)) {
                String details;
                while ((details = bf.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(details,",");
                    String iDTmp = stk.nextToken();
                    String assetName = stk.nextToken();
                    String color = stk.nextToken();
                    int price = Integer.parseInt(stk.nextToken());
                    double weight = Double.parseDouble(stk.nextToken());
                    int quantity = Integer.parseInt(stk.nextToken());
                    int curQty = Integer.parseInt(stk.nextToken());
                    assetList.add(new Asset(iDTmp, assetName, color, price, weight, quantity, curQty));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        } 
    }
    
    public void searchAssetByName () {
        ArrayList<Asset> assetListTmp = new ArrayList();
        String assetName = Inputter.inputString("Enter asset name: ");
        for (Asset asset : assetList) {
            if(asset.getAssetName().contains(assetName)) {
                assetListTmp.add(asset);
            }
        }
        if (assetListTmp.isEmpty()) {
            System.out.println("Asset does not existed.");
            return;
        }
        if (assetListTmp.size() == 1) {
            System.out.println(assetListTmp.get(0));
            return;
        }
        Collections.sort(assetListTmp);
        for (Asset asset : assetListTmp) {
            System.out.println(asset);
        }
    }
    
    public boolean checkAssetIdDuplicate (String id) {
        for (Asset asset : assetList) {
            if(asset.getAssetID().equals(id))
                return true;
        }
        return false;
    }
    
    private Asset inputAssetInfor (boolean checkCurQty) {
        String assetID;
        String assetName;
        String color;
        int price, quantity;
        double weight;
        while (true) {            
            assetID = Inputter.inputWithCondition("Enter asset ID (A000): ", "A\\d{3}");
            if (!checkAssetIdDuplicate(assetID))
                break;
            else System.out.println("ID duplicated! Enter again.");
        }
        assetName = Inputter.inputString("Enter asset name: ");
        color = Inputter.inputString("Enter color: ");
        price = Inputter.inputInt("Enter price: ");
        weight = Inputter.inputDouble("Enter weight: ");
        if (!checkCurQty) {
            quantity = Inputter.inputInt("Enter quantity: ");
            return new Asset(assetID, assetName, color, price, weight, quantity);
        } else {
            int curQty;
            while (true) {
                quantity = Inputter.inputInt("Input original quantity: ");                
                curQty = Inputter.inputInt("Enter current quantity: ");
                if(quantity >= curQty)
                    break;
                System.out.println("current quantity is must less than or equal to original quantity.");
            }
            return new Asset(assetID, assetName, color, price, weight, quantity, curQty);
        }
    }
    
    public void addNewAsset ()  {
        assetList.add(inputAssetInfor(false));
        System.out.println("Added successfully!");
        if(Inputter.inputWithCondition("Do you want to continue (Y/N)?: ", "(?i)(Y|N)").equalsIgnoreCase("Y"))
            addNewAsset();
    }
    
    private int searchAssetPosByID (String id) {
        for(int i = 0; i < assetList.size(); i++) {
            if(assetList.get(i).getAssetID().equals(id))
                return i;
        }
        return -1;
    }
    
    public Asset updateAsset () {
        String assetID = Inputter.inputWithCondition("Enter asset Id you want to update (A000): ", "A\\d{3}");
        int pos = searchAssetPosByID(assetID);
        if (pos >= 0) {
            assetList.get(pos).setAssetID("\0");
            assetList.set(pos, inputAssetInfor(true));
            return assetList.get(pos);
        } 
        return null;
    }
    
    
    
    public void saveAssetToFile (String fName) {
        try{
            File f = new File(fName);
            try (FileWriter fw = new FileWriter(f); 
                    PrintWriter pw = new PrintWriter(fw)) {
                assetList.forEach((x) -> {
                    pw.println(x.getAssetID() + "," + x.getAssetName() + "," + x.getColor() + "," + x.getWeight() + "," + x.getQuantity() + "," + x.getCurQty());
                });
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void showAssetList () {
        if (assetList.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        for (Asset asset : assetList) {
            System.out.println(asset);
        }
    }
    
    public void loadEmpFromFile(String fName){
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            try (FileReader fr = new FileReader(f);
                    BufferedReader bf = new BufferedReader(fr)) {
                String details;
                while ((details = bf.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(details,",");
                    String empId = stk.nextToken();
                    String empName = stk.nextToken();
                    String date = stk.nextToken();
                    LocalDate bDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
                    String role = stk.nextToken();
                    String sex = stk.nextToken();
                    String pwd = stk.nextToken();
                    empList.add(new Employee(empId, empName, bDate, role, sex, pwd));
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } 
    }
    
    public void saveEmpToFile (String fName) {
        try {
            File f = new File(fName);
            try (FileWriter fw = new FileWriter(f); 
                    PrintWriter pw = new PrintWriter(fw)) {
                for (Employee x : empList) {
                    pw.println(x.getEmpID() + "," + x.getEmpName() + "," + x.getbDate() + "," + x.getRole() + "," + x.getSex() + "," + x.getPwd());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    private Employee searchEmpByID (String id) {
        for (Employee emp : empList) {
            if(emp.getEmpID().equals(id))
                return emp;
        }
        return null;
    }
    
    public void checkLogin() {
        Employee emp = new Employee();
        System.out.println("Login for using.");
        do{            
            String empID = Inputter.inputWithCondition("Enter employee ID (E000000): ", "E\\d{6}");
            emp = searchEmpByID(empID);
            if (emp != null) {
                break;
            }
            System.out.println("Incorrect ID. Enter again.");
        }while (true);
        do{            
            String pwd = Inputter.inputString("Enter password: ");
            Encryption en = new Encryption(40);
            pwd = en.encode(pwd);
            if (emp.getPwd().equals(pwd)) {
                break;
            }
            System.out.println("Incorrect password. Enter again.");    
        }while (true);
        System.out.println("Successfully!");
    }
    
    public void showEmpList() {
        if (empList.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        for (Employee x : empList) {
            System.out.println(x);
        }
        System.out.println(empList.size());
    }
    
    public void loadRequestFromFile(String fName){
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            try (FileReader fr = new FileReader(f); 
                    BufferedReader bf = new BufferedReader(fr)) {
                String details;
                while ((details = bf.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(details,",");
                    String resID = stk.nextToken();
                    String empID = stk.nextToken();
                    String assetID = stk.nextToken();
                    int qty = Integer.parseInt(stk.nextToken());
                    String date = stk.nextToken();
                    LocalDate rDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);                    
                    date = stk.nextToken();
                    LocalDate bDate;
                    if (date.equals("null"))
                        bDate = null;
                    else bDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
                    date = stk.nextToken();
                    LocalDate returnDate;
                    if (date.equals("null"))
                        returnDate = null;
                    else returnDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
                    resquestList.add(new Request(resID , searchEmpByID(empID), searchAssetByID(assetID), qty, rDate, bDate, returnDate));
                    
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        } 
    }
    
    private Asset searchAssetByID (String id) {
        for (Asset asset : assetList) {
            if (asset.getAssetID().equals(id))
                return asset;
        }
        return null;
    }
    
    public void saveRequestToFile (String fName) {
        try {
            File f = new File(fName);
            try (FileWriter fw = new FileWriter(f); 
                    PrintWriter pw = new PrintWriter(fw)) {
                showBorrowAssetList();
                for (Request x : resquestList) {
                    pw.println(x.getRbID() + "," + x.getEmp().getEmpID() + "," + x.getAsset().getAssetID() + "," + x.getQty() + "," + x.getrDate() + "," + x.getbDate() + "," + x.getReturnDate());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public void showBorrowAssetList () {
        if(resquestList.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        for (Request request : resquestList) {
            System.out.println(request);
        }
    }
    
    private int searchRequest (String id) {
        for (int i = 0; i < resquestList.size(); i++) {
            if(resquestList.get(i).getRbID().equals(id))
                return i;
        }
        return -1;
    }
    
    private boolean isValidDate(String date) {
        try {
            //ResolverStyle.STRICT for checking 30, 31 days, and also leap year.
            LocalDate.parse(date,DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
    public void approveRequest () {
        showBorrowAssetList();
        String idTmp = Inputter.inputWithCondition("Enter approved request: ", "RB\\d{3}");
        int pos = searchRequest(idTmp);
        if (pos < 0) {
            System.out.println("Request does not exist.");
            return;
        }
        Request rqs = resquestList.get(pos);
        if (rqs.getbDate() == null) {
            String accept = Inputter.inputWithCondition("Do you want to accept borrowed request (Y/N)?", "(?i)(Y|N)");
            if (accept.equalsIgnoreCase("N"))
                return;
            if (rqs.getQty() > rqs.getAsset().getCurQty()) {
                System.out.println("Not having enough quantity.");
                return;
            }
            String date;
            LocalDate bDate = null;
            boolean check;
            do {
                check = true;
                date = Inputter.inputNonBlankStr("Borrowed date (yyyy-mm-dd): ");
                if (!isValidDate(date)) {
                    System.out.println("Invalid Date");
                    check = false;
                } else {
                    bDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
                    if (bDate.isBefore(rqs.getrDate())) {
                        System.out.println("Borrowed date is must after request date.");
                        check = false;
                    }
                }
            } while (!check);
            rqs.setbDate(bDate);
            resquestList.set(pos, rqs);
            resquestList.get(pos).getAsset().setCurQty(rqs.getAsset().getCurQty() - rqs.getQty());  
        } else if (rqs.getbDate() != null && rqs.getReturnDate() == null) {
            String accept = Inputter.inputWithCondition("Do you want to accept returned request (Y/N)?", "(?i)(Y|N)");
            if (accept.equalsIgnoreCase("N"))
                return;
            String date;
            LocalDate returnDate = null;
            boolean check;
            do {
                check = true;
                date = Inputter.inputNonBlankStr("Returned date (yyyy-mm-dd): ");
                if (!isValidDate(date)) {
                    System.out.println("Invalid date");
                    check = false;
                } else {
                    returnDate = LocalDate.parse(date,DateTimeFormatter.ISO_LOCAL_DATE);
                    if (returnDate.isBefore(rqs.getbDate())) {
                        System.out.println("Returned date is must after borrowed date.");
                        check = false;
                    }
                }
            } while (!check);
            rqs.setReturnDate(returnDate);
            resquestList.set(pos, rqs);
            resquestList.get(pos).getAsset().setCurQty(rqs.getAsset().getCurQty() + rqs.getQty());
        }
    }
    
}
