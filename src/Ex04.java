public class Ex04 {
    public static void main(String[] args) {
        String chuoiBanDau = "abcdefghij".repeat(100000);

        System.out.println("🔹 Kiểm tra với StringBuilder...");
        long timeStart = System.nanoTime();
        kiemTraStringBuilder(chuoiBanDau);
        long timeEnd = System.nanoTime();
        System.out.println("⏳ Thời gian thực thi của StringBuilder: " + (timeEnd - timeStart) / 1_000_000 + " ms\n");

        System.out.println("🔹 Kiểm tra với StringBuffer...");
        timeStart = System.nanoTime();
        kiemTraStringBuffer(chuoiBanDau);
        timeEnd = System.nanoTime();
        System.out.println("⏳ Thời gian thực thi của StringBuffer: " + (timeEnd - timeStart) / 1_000_000 + " ms");
    }

    private static void kiemTraStringBuilder(String str) {
        StringBuilder sb = new StringBuilder(str);

        sb.reverse();

        sb.insert(sb.length() / 2, "CHEN_CHUOI");

        sb.delete(sb.length() / 4, sb.length() / 3);

        sb.replace(sb.length() / 5, sb.length() / 4, "THAY_THE");
    }

    private static void kiemTraStringBuffer(String str) {
        StringBuffer sb = new StringBuffer(str);

        sb.reverse();

        sb.insert(sb.length() / 2, "CHEN_CHUOI");

        sb.delete(sb.length() / 4, sb.length() / 3);

        sb.replace(sb.length() / 5, sb.length() / 4, "THAY_THE");
    }
        // ================== KẾT LUẬN ==================
        /*
         *  StringBuilder:
         *  Đặc điểm: Không an toàn khi dùng cùng lúc bởi nhiều luồng (không đồng bộ).
         *  Ưu điểm: Nhanh hơn vì không phải tốn tài nguyên để quản lý đồng bộ.
         *  Khi dùng: Phù hợp khi bạn làm việc với chuỗi lớn (như nối, chỉnh sửa chuỗi) trong một ứng dụng chỉ chạy một luồng (single-thread), không cần lo xung đột dữ liệu.
         *  Ví dụ: Xây dựng một chuỗi dài trong một hàm đơn giản, như tạo báo cáo hay log.
         *  StringBuffer:
         *  Đặc điểm: An toàn khi nhiều luồng cùng dùng (đồng bộ).
         *  Ưu điểm: Đảm bảo không bị lỗi dữ liệu khi nhiều luồng cùng chỉnh sửa chuỗi.
         *  Nhược điểm: Chậm hơn StringBuilder vì phải kiểm soát đồng bộ.
         *  Khi dùng: Dùng trong ứng dụng đa luồng (multi-thread), nơi nhiều tiến trình cùng thao tác trên chuỗi, ví dụ như hệ thống chat hoặc xử lý dữ liệu thời gian thực.
         *  Kết luận:
         *  Tốc độ nhanh và không lo đa luồng → Chọn StringBuilder.
         *  An toàn trong môi trường đa luồng → Chọn StringBuffer.
         */
}
