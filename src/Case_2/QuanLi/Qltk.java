package Case_2.QuanLi;

import Case_2.LogIn.TaiKhoan;
import Case_2.Main.Menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Qltk {
    static Menu menu = new Menu();
    static Scanner scanner = new Scanner(System.in);
    static File file = new File("Account.csv");
    static ArrayList<TaiKhoan> list = readFile();

    public static String getTk() {
        try {
            System.out.println("Nhập tên dăng nhập");
            String tk = scanner.nextLine();
            for (TaiKhoan t : list) {
                if (t.getTk().equals(tk)) {
                    throw new Exception();
                }
            }
            if (tk.equals("")) {
                throw new Exception();
            }
            return tk;
        } catch (Exception e) {
            System.out.println("Không được để trống hoặc bị trùng");
        }
        return null;
    }

    public static String getMk() {
            try {
                System.out.println("Nhập mật khẩu");
                String mk = scanner.nextLine();
                if (mk.equals("")) {
                    throw new Exception();
                }
                return mk;
            } catch (Exception e) {
                System.out.println("Không được để trống");
            }
        return null;
    }

    public static void logIn() throws Exception {
            try {
                System.out.println("Nhập tài khoản");
                String tk = scanner.nextLine();
                System.out.println("Nhập mật khẩu");
                String mk = scanner.nextLine();
                boolean check = true;
//                list = readFile();
                for (TaiKhoan t: list) {
                    if (t.getTk().equals(tk) && t.getMk().equals(mk)) {
                        check = false;
                        list.add(new TaiKhoan(tk,mk));
                        writeFile(list);
                        menu.Menu();
                        break;
                    }
                }
                if (check) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai đăng nhập");
            }
        return;
    }

    public static void logOut() {
        list.remove(0);
    }

    public static void display() {
        try {
            list = readFile();
            for (TaiKhoan t : list) {
                System.out.println("Tài khoản: " + t.getTk());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTk() {
        list.add(new TaiKhoan(getTk(), getMk()));
        writeFile(list);
    }

    public static void deleteTk() {
        System.out.println("Nhập tên tài khoản");
        String tk = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTk().equals(tk)) {
                list.remove(i);
            }
        }
        writeFile(list);
    }

    public static void writeFile(ArrayList<TaiKhoan> tk) {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tk);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<TaiKhoan> readFile() {
        ArrayList<TaiKhoan> t = new ArrayList<>();
        try {
            if (!file.exists())
                file.createNewFile();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            t = (ArrayList<TaiKhoan>) ois.readObject();
            ois.close();
        } catch (Exception ex) {
            System.out.println("Chưa có tài khoản được tạo");
        }
        return t;
    }
}
