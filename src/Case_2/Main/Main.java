package Case_2.Main;

import Case_2.QuanLi.Qltk;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Qltk qltk = new Qltk();

    public static void main(String[] args) throws Exception {
        subMenu();
    }

    public static void subMenu() throws Exception {
        while (true) {
            System.out.println("     ==========         =========          ==========          ====  ");
            System.out.println("=====          =========         ==========          ==========  // ");
            System.out.println("                                 **                             //  ");
            System.out.println("                              **    **                         //   ");
            System.out.println("                            **        **                      ||    ");
            System.out.println("                          **            **                     ||   ");
            System.out.println("           ** ** ** ** **                  ** ** ** ** **       ||  ");
            System.out.println("             **        - QUẢN LÝ NHÂN VIÊN -         **         //  ");
            System.out.println(".              **                                  **          //   ");
            System.out.println("   >> 1 <<       **         Đăng nhập            **           ||    ");
            System.out.println("   >> 2 <<         **        Đăng kí           **             ||    ");
            System.out.println("   >> 3 <<        **    Hiển thị tài khoản      **             ||   ");
            System.out.println("   >> 4 <<       **       Xóa tài khoản          **             ||  ");
            System.out.println("   >> 0 <<      **             E xít              **           //   ");
            System.out.println("               **           **        **           **         //    ");
            System.out.println("              **        **                **        **       ||     ");
            System.out.println("             **     **                        **     **       ||    ");
            System.out.println(".-.-.-.-.-..-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-||   ");
            System.out.println("Enter your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Đăng nhập");
                    qltk.logIn();
                    break;
                case 2:
                    qltk.createTk();
                    break;
                case 3:
                    qltk.display();
                    break;
                case 4:
                    qltk.deleteTk();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại");
                    break;
            }
        }
    }
}
