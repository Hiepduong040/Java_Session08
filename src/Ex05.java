import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int[] arr = new int[0];

        int choice;
        do {
            System.out.println("\n*************** MENU ****************");
            System.out.println("1. Nhập n, số phần tử trong mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí của phần tử có giá trị bằng k");
            System.out.println("5. Tính số lượng phần tử là số nguyên tố trong mảng");
            System.out.println("6. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số phần tử của mảng: ");
                    n = scanner.nextInt();
                    arr = new int[n];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        arr[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    if (n == 0) {
                        System.out.println("Mảng chưa được nhập!");
                    } else {
                        System.out.println("Các phần tử trong mảng:");
                        for (int i = 0; i < n; i++) {
                            System.out.print(arr[i] + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    if (n == 0) {
                        System.out.println("Mảng chưa được nhập!");
                    } else {
                        int sum = 0, count = 0;
                        for (int i = 0; i < n; i++) {
                            if (arr[i] > 0) {
                                sum += arr[i];
                                count++;
                            }
                        }
                        if (count == 0) {
                            System.out.println("Không có số dương nào trong mảng.");
                        } else {
                            System.out.println("Trung bình cộng các số dương: " + (double) sum / count);
                        }
                    }
                    break;
                case 4:
                    if (n == 0) {
                        System.out.println("Mảng chưa được nhập!");
                    } else {
                        System.out.print("Nhập giá trị k: ");
                        int k = scanner.nextInt();
                        boolean found = false;
                        System.out.print("Vị trí của k trong mảng: ");
                        for (int i = 0; i < n; i++) {
                            if (arr[i] == k) {
                                System.out.print(i + " ");
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy k trong mảng.");
                        }
                    }
                    break;

                case 5:
                    if (n == 0) {
                        System.out.println("Mảng chưa được nhập!");
                    } else {
                        int primeCount = 0;
                        for (int i = 0; i < n; i++) {
                            boolean isPrime = true;
                            if (arr[i] < 2) {
                                isPrime = false;
                            } else {
                                for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                                    if (arr[i] % j == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }
                            if (isPrime) {
                                primeCount++;
                            }
                        }
                        System.out.println("Số lượng số nguyên tố trong mảng: " + primeCount);
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice != 6);

        scanner.close();
    }
}