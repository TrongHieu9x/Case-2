package Case_2.Qlnv;

import java.io.Serializable;

public abstract class Nvien implements Serializable {
    private String id;
    private String name;
    private int age;
    private String phone;
    private String email;
    private static String status;
    private double luong;

    public Nvien() {
    }

    public Nvien(String id, String name, int age, String phone, String email, String status, double luong) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.luong = luong;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public static String getStatus() {
        return status;
    }

    public double getLuong() {
        return luong;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "Nvien{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", luong=" + luong +
                '}';
    }

    public String write() {
        return id + "," + name + "," + age + "," + phone + "," + email + "," + status + "," + luong;
    }

    public abstract double doanhThu();
}
