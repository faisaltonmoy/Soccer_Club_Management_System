/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

/**
 *
 * @author faisa
 */
public class staff_user {

    private String sName, sType, sSex, sMIssue;
    private int sAge, sId;
     private byte[] sImg;

    public staff_user(int sId, String sName, String sType, int sAge, String sSex, String sMIssue,byte[]sImg) {
        this.sId = sId;
        this.sName = sName;
        this.sType = sType;
        this.sAge = sAge;
        this.sSex = sSex;
        this.sMIssue = sMIssue;
        this.sImg=sImg;
    }

    public String getsName() {
        return sName;
    }

    public String getsType() {
        return sType;
    }

    public String getsSex() {
        return sSex;
    }

    public String getsMIssue() {
        return sMIssue;
    }

    public int getsAge() {
        return sAge;
    }

    public int getsId() {
        return sId;
    }
    public byte[] getsImg() {
        return sImg;
    }

}
