import java.io.*;

public class CopyText {
    public static void main(String[] args) {
        // Đường dẫn đến tệp nguồn và tệp đích
        String sourceFilePath = "src/source.txt";
        String targetFilePath = "src/target.txt";

        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);

        // Kiểm tra tệp nguồn có tồn tại không
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại.");
            return;
        }

        // Kiểm tra tệp đích đã tồn tại chưa
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại.");
            return;
        }

        // Khởi tạo số ký tự đã sao chép
        int characterCount = 0;

        try (FileReader reader = new FileReader(sourceFile);
             FileWriter writer = new FileWriter(targetFile)) {

            int character;
            // Đọc ký tự từ tệp nguồn và ghi vào tệp đích
            while ((character = reader.read()) != -1) {
                writer.write(character);
                characterCount++;
            }

            System.out.println("Đã sao chép " + characterCount + " ký tự từ tệp nguồn sang tệp đích.");

        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi sao chép tệp: " + e.getMessage());
        }
    }
}