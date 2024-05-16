package Bai1;

import java.io.File;
import java.util.Scanner;

public class FileSizeApp {
    public static void main(String[] args) {
        // Sử dụng lớp Scanner để nhập đường dẫn file từ bàn phím
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file: ");
        String filePath = scanner.nextLine();

        // Tạo đối tượng File
        File file = new File(filePath);

        // Kiểm tra xem file có tồn tại không
        if (file.exists()) {
            // Lấy kích thước file
            long fileSize = file.length();

            // Chuyển kích thước file thành đơn vị KB hoặc MB nếu cần thiết
            String sizeString;
            if (fileSize < 1024) {
                sizeString = fileSize + " bytes";
            } else if (fileSize < 1024 * 1024) {
                sizeString = fileSize / 1024 + " KB";
            } else {
                sizeString = fileSize / (1024 * 1024) + " MB";
            }

            // Xuất kích thước file ra màn hình
            System.out.println("Kích thước của file là: " + sizeString);
        } else {
            System.out.println("File không tồn tại.");
        }

        // Đóng Scanner sau khi sử dụng
        scanner.close();
    }
}
