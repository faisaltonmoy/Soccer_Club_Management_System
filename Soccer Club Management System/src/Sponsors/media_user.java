/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sponsors;

public class media_user {
    private int mId;
    private String mType;
    private int contractYear;
    private String revenue;
    private String mTitle;
    
    
    public media_user(int mId,String mType,int contractYear,String revenue ,String mTitle){
        this.mId=mId;
        this.mType=mType;
        this.contractYear=contractYear;
        this.revenue=revenue;
        this.mTitle=mTitle;
        
        
    }
    
     public int getmId() {
        return mId ;
    }

    public String getmType() {
        return mType;
    }

    public int getcontractYear() {
        return contractYear;
    }

    public String getrevenue() {
        return revenue; 
    }
    public String getmTitle(){
        return mTitle;
    }
}

