package Case_2.QuanLi;

import Case_2.Main.Main;
import Case_2.Qlnv.NvFulltime;
import Case_2.Qlnv.NvParttime;
import Case_2.Qlnv.Nvien;
import Case_2.Qlnv.Regex;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Qlnv {
    static Scanner scanner = new Scanner(System.in);
    static File nvien = new File("nhanVien.txt");
    static ArrayList<Nvien> list = readFile();

    public static Regex valideId;
    public static Regex valide;
    public static Regex valideSDT;
    public static Regex valideEmail;


    public void add() throws IOException {
        System.out.println("1. Thêm nhân viên Fulltime");
        System.out.println("2. Thêm nhân viên Parttime");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            Nvien nv = createNv("full");
            list.add(nv);
        } else {
            Nvien nv = createNv("part");
            list.add(nv);
        }
        writeFile(list);
    }

//=================================================================
    public void search() {
        System.out.println("Nhập tên nhân viên bro cần tìm");
        String name = scanner.nextLine();
        for (Nvien nv : list) {
            if (nv.getName().equals(name)) {
                System.out.println(nv);
            }
        }
    }

//==========================================================
    public void update() throws IOException {
        System.out.println("Nhập id nhân viên bro muốn thay đổi");
        String id = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                if (list.get(i) instanceof NvFulltime) {
                    list.set(i, createNv("full"));
                } else {
                    list.set(i, createNv("part"));
                }
            }
        }
        writeFile(list);
    }

//===================================================================
    public void checkStatus() {
        System.out.println("Nhập tên nhân viên bro muốn kiểm tra trạng thái");
        String name = scanner.nextLine();
        for (Nvien nv : list) {
            if (nv.getName().equals(name)) {
                System.out.println("Trạng thái: " + nv.getStatus());
            }
        }
    }

//=====================================================================
    public void updateStatus() throws IOException {
        System.out.println("Nhập tên nhân viên bro muốn thay đổi trạng thái");
        String name = scanner.nextLine();
        for (Nvien nv : list) {
            if (nv.getName().equals(name)) {
                nv.setStatus(nv.getStatus());
                System.out.println(nv);
            }
        }
        writeFile(list);
    }
//    public static void updateStatus() throws Exception {
//        System.out.println("Nhập id bạn muốn thay đổi");
//        String id =scanner.nextLine();
//        int index = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                index = i;
//                if (Nvien.getStatus() != true) {
//                    list.get(i).setStatus(String.valueOf(true));
//                    System.out.println("Nhân viên có id" + id + " đang làm việc.");
//                } else {
//                    list.get(i).setStatus(String.valueOf(false));
//                    System.out.println("Nhân viên có id " + id + "đang nghỉ.");
//                }
//                System.out.println("Đã thay đổi thành công !!!");
//            }
//        }
//        if (index == -1) {
//            System.out.println("Không tồn tại id này!!!");
//        }
//        writeFile(list);
//    }

//============================================================
//    public void deleteNv() throws Exception {
//        System.out.println("Nhập id nhân viên bro muốn trục xuất");
//        String id = scanner.nextLine();
//        int index = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getId() == id) {
//                index = i;
//                list.remove(i);
//                i--;
//            }
//        }
//        if (index == -1) {
//            System.out.println("Id này không tồn tại. Mong bro hãy nghiêm túc và nhập cho đúng");
//        }
//    }
    public void deleteNv() throws Exception {
        try {
            System.out.println("Nhập tên nhân viên bro muốn trục xuất");
            String name = scanner.nextLine();
            for (Nvien nv : list) {
                if (nv.getName().equals(name)) {
                    list.remove(getId());
                    System.out.println(nv);
                }
            }
        }catch (Exception e) {
            System.err.println("Vui lòng bro nhập cho chuẩn");
            e.printStackTrace();
        }
        writeFile(list);
    }
//============================================================
    public void chekNvStatus() {
        System.out.println("Nhập trạng thái bro muốn xem");
        String status = scanner.nextLine();
        for (Nvien nv : list) {
            if (nv.getStatus().equals(status)) {
                System.out.println(nv.write());
            }
        }
    }
    //==============================================================
    public void checkLuong() {
        System.out.println("Nhập tên nhân viên bro muốn hiển thị lương");
        String name = scanner.nextLine();
        for (Nvien nv : list) {
            if (nv.getName().equals(name)) {
                System.out.print("Lương của nhân viên là : ");
                System. out.println(nv.doanhThu());
            }
        }
    }
//===================================================================
    public void displayTk() throws Exception {
        Qltk.display();
    }

//=========================================================
    public void show() {
        for (Nvien nv : list) {
            System.out.println(nv);
        }
    }

//=========================================================
    public String getName() {
        while (true) {
            try {
                System.out.println("Nhập tên");
                String name = scanner.nextLine();
                if (name.equals("")) {
                    throw new Exception();
                }
                return name;
            } catch (Exception e) {
                System.err.println("Tên nhân viên không hợp lệ. Vui lòng bro nhập chính xác!\n" +
                        "Tên nhân viên chỉ có các ký tự A-Z,a-z!!!");
                e.printStackTrace();
            }
        }
    }

//=============================================================================
    public String getId() {
        while (true) {
            System.out.println("Nhập mã nhân viên:(CGxxx) ");
            String id = scanner.nextLine();
            boolean exist = false;
            boolean isValid = Regex.validateId(id);
            if (!isValid) {
                System.err.println("Mã nhân viên không hợp lệ. Vui lòng bro nhập chính xác!\n" +
                        "Mã nhân viên phải bắt đầu bằng CG + số!!");
                exist = true;
            }
            if (!exist) {
                return id;
            }
        }
    }

//===========================================================================
    public String getPhone() {
        while (true) {
            System.out.println("Nhập số điện thoại (9 số hoặc 10 số): ");
            String phone = scanner.nextLine();
            boolean exist = false;
            boolean isValid = Regex.validateSDT(phone);
            if (!isValid) {
                System.err.println("Số điện thoại không hợp lệ. Vui lòng bro nhập chính xác!\n" +
                        "Số điện thoại phải là số và bắt đầu bằng 0!!");
                exist = true;
            }
            if (!exist) {
                return phone;
            }
        }
    }

//============================================================================
    private String getEmail() {
        while (true) {
            System.out.println("Nhập địa chỉ email: (VD:abc@gmail.com)");
            String email = scanner.nextLine();
            boolean exist = false;
            boolean isValid = Regex.validateEmail(email);
            if (!isValid) {
                System.err.println("Định dạng email không hợp lệ. Vui lòng bro nhập chính xác!");
                exist = true;
            }
            if (!exist) {
                return email;
            }
        }
    }

//===========================================================================
    private String getStatus() {
        while (true) {
            try {
                System.out.println("Nhập trạng thái");
                String status = scanner.nextLine();
                if (status.equals("fulltime")||status.equals("parttime")) {
                    return status;
                } else throw new Exception();
            } catch (Exception e) {
                System.err.println("trang thái là fulltime hoặc parttime. vui lòng bro ko nhập linh tinh");
            }
        }
    }

//======================================================================
    public int age() {
        while (true) {
            try {
                System.out.println("Nhập tuổi");
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 18) {
                    throw new Exception();
                } else {
                    return age;
                }
            } catch (Exception e) {
                System.err.println("Tuổi của bro chưa đủ để lao động");
            }
        }
    }

//==================================================
    public double luong() {
        while (true) {
            try {
                System.out.println("Nhập lương nhân viên bro muốn cho");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Nhập số");
            }
        }
    }



//==============================================================
    public static void writeFile(ArrayList<Nvien> list) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter("nhanVien.csv");
            bufferedWriter = new BufferedWriter(fileWriter);
//            list = readFile();
            for (Nvien nv : list) {
                bufferedWriter.write(nv.write());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }

//===========================================================
    public static ArrayList<Nvien> readFile() {
        ArrayList<Nvien> list1 = new ArrayList<>();
        File file = new File("nhanVien.csv");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(", ");
                if (str.length == 7) {
                    //String id, String name, int age, String phone, String email, String status, double luong
                    list1.add(new NvFulltime(  str[0],   str[1],   Integer.parseInt(str[2]),   str[3],   str[4],   str[5],    Double.parseDouble(str[6])));
                } else if (str.length == 8) {
                    //String id, String name, int age, String phone, String email, String status, double luong, int time
                    list1.add(new NvParttime(  str[0],   str[1],   Integer.parseInt(str[2]),   str[3],   str[4],   str[5],    Double.parseDouble(str[6]),  Double.parseDouble(str[7])));
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list1;
    }

//=============================================================================
    public Nvien createNv(String typeNv) {
        if (typeNv.equals("full")) {
            return new NvFulltime(getId(), getName(), age(), getPhone(), getEmail(), getStatus(), luong());
        } else {
            return new NvParttime(getId(), getName(), age(), getPhone(), getEmail(), getStatus(), luong(), getTime());
        }
    }

//================================================================================
    private double getTime() {
        while (true) {
            try {
                System.out.println("Nhập số giờ");
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("nhập điêu àk bro");
            }
        }
    }

//====================================================================
    public void logOut() throws Exception {
        Qltk.logOut();
        Main.subMenu();
    }


}
