package main.hj.LTHoutai.entiy;

public class User {
    private int id;
    private String name;
    private String password;
    private String shoujihao;
    private int jueseid;

    public User(int id, String name, String password, String shoujihao, int jueseid) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.shoujihao = shoujihao;
        this.jueseid = jueseid;
    }
    public User(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShoujihao() {
        return shoujihao;
    }

    public void setShoujihao(String shoujihao) {
        this.shoujihao = shoujihao;
    }

    public int getJueseid() {
        return jueseid;
    }

    public void setJueseid(int jueseid) {
        this.jueseid = jueseid;
    }

}
