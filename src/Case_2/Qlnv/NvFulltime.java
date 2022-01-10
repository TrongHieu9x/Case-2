package Case_2.Qlnv;

public class NvFulltime extends Nvien {

    public NvFulltime() {
    }

    public NvFulltime(String id, String name, int age, String phone, String email, String status, double luong) {
        super(id, name, age, phone, email, status, luong);
    }
    @Override
    public double doanhThu() {
        return super.getLuong()*8;
    }
    // cái này đang là override này
}
