import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Nhập số lượng phần tử của mảng: ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Nhập lại!");
            }
        } while (n <= 0);

        int[] arr = new int[n];
        System.out.println("Nhập các giá trị cho mảng:  ");
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = \n", i);
            arr[i] = sc.nextInt();
        }

        int count = 0;
        int sum = 0;
        for (int num : arr) {
            if (num % 3 == 0) {
                sum += num;
                count++;
            }
        }

        if (count > 0) {
            System.out.printf("Tổng các số chia hết cho 3 trong mảng là: %d \n", sum);
        } else {
            System.out.println("Không có số nào chia hết cho 3");
        }

        sc.close();
    }
}