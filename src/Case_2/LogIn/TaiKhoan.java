package Case_2.LogIn;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String tk;
    private String mk;

    public TaiKhoan() {
    }

    public TaiKhoan(String tk, String mk) {
        this.tk = tk;
        this.mk = mk;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    @Override
    public String toString() {
        return "Account{" +
                "tk='" + tk + '\'' +
                ", mk='" + mk + '\'' +
                '}';
    }
}
