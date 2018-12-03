package main.hj.luntan.entity;

public class Shouyanzheng {
    private String shoujihao;
    private long kaishishijian;
    private String yanzhengma;

    public Shouyanzheng() {
    }

    public Shouyanzheng(String shoujihao, long kaishishijian, String yanzhengma) {
        this.shoujihao = shoujihao;
        this.kaishishijian = kaishishijian;
        this.yanzhengma = yanzhengma;
    }

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao;
    }

    public long getKaishishijian() {
        return kaishishijian;
    }

    public void setKaishishijian(long kaishishijian) {
        this.kaishishijian = kaishishijian;
    }

    public String getYanzhengma() {
        return yanzhengma;
    }

    public void setYanzhengma(String yanzhengma) {
        this.yanzhengma = yanzhengma;
    }
}
