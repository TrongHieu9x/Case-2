package Case_2.Main;

import Case_2.QuanLi.Qlnv;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static Qlnv qlnv = new Qlnv();
    public static void Menu() throws Exception {
        while (true) {
            System.out.println(" ||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||");
            System.out.println("*****     *****     *****   ***** MENU *****   *****     *****     *****  ");
            System.out.println("      => 1                   Thêm nhân viên                                ");
            System.out.println("      => 2                  Tìm kiếm nhân viên                             ");
            System.out.println("      => 3            Kiểm ttra trang thái nhân viên                       ");
            System.out.println("      => 4             Thay đổi thông tin nhân viên                        ");
            System.out.println("      => 5            Thay đổi trang thái nhân viên                        ");
            System.out.println("      => 6                Thông tin tài khoản                             ");
            System.out.println("      => 7                 Hiển thị nhân viên                             ");
            System.out.println("      => 8                   Xoá nhân viên                                ");
            System.out.println("      => 9          Hiển thị nhân viên theo trang thái                     ");
            System.out.println("      => 10           Hiển thị lương của nhân viên                         ");
            System.out.println("      => 0                     Đăng xuất                                   ");
            System.out.println("                                                                          ");
            System.out.println("              (^-^) (@_@) (-.-) (^_^) (~_~) (>_<) (>.<) (*_*) (#_#)        ");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    qlnv.add();
                    break;
                case 2:
                    qlnv.search();
                    break;
                case 3:
                    qlnv.checkStatus();
                    break;
                case 4:
                    qlnv.update();
                    break;
                case 5:
                    qlnv.updateStatus();
                    break;
                case 6:
                    qlnv.displayTk();
                    break;
                case 7:
                    qlnv.show();
                    break;
                case 8:
                    qlnv.deleteNv();
                    break;
                case 9:
                    qlnv.chekNvStatus();
                    break;
                case 10:
                    qlnv.checkLuong();
                    break;
                case 0:
                    qlnv.logOut();
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }

        }
    }
}
