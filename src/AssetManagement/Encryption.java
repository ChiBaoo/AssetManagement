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
// ma hoa doi xung
public class Encryption {
    
    private static final int TABLE_SIZE = 65536;
    private int nPosition;

    public Encryption(int nPosition) {
        this.nPosition = nPosition;
    }
    
    private char shift(char c, int nPos) {
        int charCode = (int)c + nPos;
        if (charCode < 0) charCode += TABLE_SIZE;
        return (char)(charCode%TABLE_SIZE);
    }
    
    public String encode(String src) {
        String result = "";
        for(int i = 0; i < src.length(); i++) {
            result += shift(src.charAt(i), nPosition);
        }
        return result;
    }
    
    public String decode(String encodedStr) {
        String src = "";
        for(int i = 0; i < encodedStr.length(); i++) {
            src += shift(encodedStr.charAt(i), -nPosition);
        }
        return src;
    }
}
    


