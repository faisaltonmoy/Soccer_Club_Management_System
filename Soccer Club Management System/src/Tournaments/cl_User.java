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
public class cl_User {

    private int mDay, win, loss, draw;
    private String mDate, Oppo;

    public cl_User(int mDay, String mDate, String Oppo, int win, int loss, int draw) {
        this.mDay = mDay;
        this.mDate = mDate;
        this.Oppo = Oppo;
        this.win = win;
        this.loss = loss;
        this.draw = draw;
    }

    public int getmDay() {
        return mDay;
    }

    public int getWin() {
        return win;
    }

    public int getLoss() {
        return loss;
    }

    public int getDraw() {
        return draw;
    }

    public String getmDate() {
        return mDate;
    }

    public String getOppo() {
        return Oppo;
    }

}
