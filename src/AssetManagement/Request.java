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
import java.time.LocalDate;

public class Request {
    private String rbID;
    private Employee emp;
    private Asset asset;
    private int qty;
    private LocalDate rDate;
    private LocalDate bDate;
    private LocalDate returnDate;

    public Request(String rbID, Employee emp, Asset asset, int qty, LocalDate rDate, LocalDate bDate, LocalDate returnDate) {
        this.rbID = rbID;
        this.emp = emp;
        this.asset = asset;
        this.qty = qty;
        this.rDate = rDate;
        this.bDate = bDate;
        this.returnDate = returnDate;
    }

    public String getRbID() {
        return rbID;
    }

    public void setRbID(String rbID) {
        this.rbID = rbID;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getrDate() {
        return rDate;
    }

    public void setrDate(LocalDate rDate) {
        this.rDate = rDate;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-15s|%-15s|%5d|%-15s|%-15s|%-15s|", 
                rbID, emp.getEmpID(), asset.getAssetID(), qty, rDate, bDate, returnDate);
    }
}
