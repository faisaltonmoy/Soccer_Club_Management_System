package Tournaments;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faisa
 */
class tournament_User {

    private String mDate, mType, mArea, Sta, res;

    public tournament_User(String mDate, String mType, String mArea, String Sta, String res) {
        this.mDate = mDate;
        this.mType = mType;
        this.mArea = mArea;
        this.Sta = Sta;
        this.res = res;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmType() {
        return mType;
    }

    public String getmArea() {
        return mArea;
    }

    public String getSta() {
        return Sta;
    }

    public String getRes() {
        return res;
    }

}
