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
public class player_User {

    private int pId;
    private String pName, pPos;
    private int pAge;
    private String pSex;
    private int pWeight, pHeight;
    private String pNation;
    private int pRating;
    private String pMIssue;
    private byte[] pImg;

    public player_User(int pId, String pName, String pPos, int pAge, String pSex, int pWeight, int pHeight, String pNation, int pRating, String pMIssue, byte[] pImg) {
        this.pId = pId;
        this.pName = pName;
        this.pPos = pPos;
        this.pAge = pAge;
        this.pSex = pSex;
        this.pWeight = pWeight;
        this.pHeight = pHeight;
        this.pNation = pNation;
        this.pRating = pRating;
        this.pMIssue = pMIssue;
        this.pImg = pImg;
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public String getpPos() {
        return pPos;
    }

    public int getpAge() {
        return pAge;
    }

    public String getpSex() {
        return pSex;
    }

    public int getpWeight() {
        return pWeight;
    }

    public int getpHeight() {
        return pHeight;
    }

    public String getpNation() {
        return pNation;
    }

    public int getpRating() {
        return pRating;
    }

    public String getpMIssue() {
        return pMIssue;
    }

    public byte[] getpImg() {
        return pImg;
    }

}
