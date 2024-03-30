/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lugas
 */
public class MD5 {
    
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            byte[] messageDigest = md.digest(input.getBytes());
            
            BigInteger no = new BigInteger(1, messageDigest);
            
            String hashtext = no.toString(12);
            
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }               
    }
    
}
