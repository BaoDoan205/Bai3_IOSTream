package Bai2;

import java.io.File;
import java.util.Scanner;

public class DeleteFileApp {
    public static void main(String[] args) {
        // Sử dụng lớp Scanner để nhập đường dẫn thư mục hoặc file từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn thư mục hoặc file: ");
        String path = scanner.nextLine();

        // Tạo đối tượng File từ đường dẫn
        File file = new File(path);

        // Kiểm tra xem thư mục hoặc file có tồn tại không
        if (file.exists()) {
            // Xác nhận từ người dùng trước khi xoá
            System.out.print("Bạn có chắc chắn muốn xoá thư mục hoặc file này? (Y/N): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                // Gọi phương thức xoá tương ứng với thư mục hoặc file
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    deleteFile(file);
                }
            } else {
                System.out.println("Hủy xoá.");
            }
        } else {
            System.out.println("Thư mục hoặc file không tồn tại.");
        }

        // Đóng Scanner sau khi sử dụng
        scanner.close();
    }

    // Phương thức xoá thư mục
    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    deleteFile(file);
                }
            }
        }

        // Xoá thư mục sau khi xoá hết các tệp tin và thư mục con
        if (directory.delete()) {
            System.out.println("Xoá thư mục thành công.");
        } else {
            System.out.println("Xoá thư mục không thành công.");
        }
    }

    // Phương thức xoá file
    private static void deleteFile(File file) {
        if (file.delete()) {
            System.out.println("Xoá file thành công.");
        } else {
            System.out.println("Xoá file không thành công.");
        }
    }
}
