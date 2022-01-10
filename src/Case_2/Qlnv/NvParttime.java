package Case_2.Qlnv;

public class NvParttime extends Nvien {
    private double time;

    public NvParttime() {
    }

    public NvParttime(String id, String name, int age, String phone, String email, String status, double luong, double time) {
        super(id, name, age, phone, email, status, luong);
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    @Override
    public double doanhThu() {
        return getLuong()*time;
    }
}
