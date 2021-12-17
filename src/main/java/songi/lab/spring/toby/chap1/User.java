package songi.lab.spring.toby.chap1;

import songi.lab.spring.toby.chap5.Level;

public class User {
    private String id, pw;

    private Level level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Level getLevel() {
        return level;
    }
}
