package com.fareye.training.utility;

public class EncryptionDecryptionUsingHash {

    private Integer key=10;
    private String newPassword = "";

    private String decrptPass = "";
    public String encrypt(String pass){
        for(int i=0;i<pass.length();i++){
            newPassword+=(char)(pass.charAt(i)-key-i);
           // System.out.println((char)(pass.charAt(i)-key));
        }
        System.out.println("Hash Value = " + newPassword);
        return newPassword;
    }

    public String decrypt(String pass){
        for(int i=0;i<newPassword.length();i++){
            decrptPass+=(char)(newPassword.charAt(i)+key+i);
        }
        System.out.println("Hash Value decryption = " + decrptPass);
        return decrptPass;
    }



}
