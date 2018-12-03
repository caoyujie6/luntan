package main.hj.LTHoutai.entiy;

public class GlTz {
    private int id;
    private String biaoti;
    private int dianji;
    private String fatiezhe;
    private String shijian;
    private int dianzan;
    private int pinglun;
    public GlTz(){

    }
    public GlTz(int id, String biaoti, String fatiezhe, String shijian, int dianzan, int pinglun) {
        this.id = id;
        this.biaoti = biaoti;
        this.fatiezhe = fatiezhe;
        this.shijian = shijian;
        this.dianzan = dianzan;
        this.pinglun = pinglun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public int getDianji() {
        return dianji;
    }

    public void setDianji(int dianji) {
        this.dianji = dianji;
    }

    public String getFatiezhe() {
        return fatiezhe;
    }

    public void setFatiezhe(String fatiezhe) {
        this.fatiezhe = fatiezhe;
    }

    public String getShijian() {
        return shijian;
    }

    public void setShijian(String shijian) {
        this.shijian = shijian;
    }

    public int getDianzan() {
        return dianzan;
    }

    public void setDianzan(int dianzan) {
        this.dianzan = dianzan;
    }

    public int getPinglun() {
        return pinglun;
    }

    public void setPinglun(int pinglun) {
        this.pinglun = pinglun;
    }
}
