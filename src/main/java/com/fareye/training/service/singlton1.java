package com.fareye.training.service;

public class singlton1 {
  private static singlton1 instance=null;
  private singlton1(){}
  //  private String data = "Data is visible";
  public static singlton1 getInstance(){
      if(instance==null){
          instance = new singlton1();
      }
      return instance;
  }
}
