package main.hj.luntan.entity;

public class HuiFuLianBiao {

    private String name;
    private String time;
    private String neirong;

    public HuiFuLianBiao(){

    }
    public HuiFuLianBiao(String name, String time, String neirong) {
        this.name = name;
        this.time = time;
        this.neirong = neirong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNeirong() {
        return neirong;
    }

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }


}
