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

public class Asset implements Comparable{
    private String assetID;
    private String assetName;
    private String color;
    private int price;
    private double weight;
    private int quantity;
    private int curQty;

    public Asset(String assetID, String assetName, String color, int price, double weight, int quantity, int curQty) {
        this.assetID = assetID;
        this.assetName = assetName;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.curQty = curQty;
    }

    public Asset(String assetID, String assetName, String color, int price, double weight, int quantity) {
        this.assetID = assetID;
        this.assetName = assetName;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = curQty = quantity;
    }


    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurQty() {
        return curQty;
    }

    public void setCurQty(int curQty) {
        this.curQty = curQty;
    }

    @Override
    public int compareTo(Object asset) {
        return this.getAssetID().compareTo(((Asset)asset).getAssetID());
    }

    @Override
    public String toString() {
        return String.format("|%-15s|%-25s|%-15s|%5d|%5.2f|%5d|%5d|", 
                assetID, assetName, color, price, weight, quantity, curQty);
    }
    
}
