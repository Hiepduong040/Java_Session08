import java.util.Scanner;

public class Ex01 {
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

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.printf("giá trị lớn nhất là: %d\n", max);
        System.out.printf("giá trị nhỏ nhất là: %d\n", min);
        sc.close();
    }
}