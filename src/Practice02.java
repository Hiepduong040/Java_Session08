import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;

        // Nhập kích thước mảng
        System.out.print("Nhap so hang n: ");
        n = scanner.nextInt();
        System.out.print("Nhap so cot m: ");
        m = scanner.nextInt();

        int[][] arr = new int[n][m];

        while (true) {
            System.out.println("************************MENU**************************");
            System.out.println("1. Nhap gia tri cac phan tu cua mang");
            System.out.println("2. In gia tri cac phan tu trong mang theo ma tran");
            System.out.println("3. Tinh so luong cac phan tu chia het cho 2 va 3");
            System.out.println("4. In cac phan tu va tong tren duong bien, cheo chinh, cheo phu");
            System.out.println("5. Sap xep tang dan theo cot (Selection Sort)");
            System.out.println("6. In ra cac phan tu la so nguyen to");
            System.out.println("7. Sap xep giam dan tren duong cheo chinh (Insertion Sort)");
            System.out.println("8. Chen mang 1 chieu vao dong cua mang 2 chieu");
            System.out.println("9. Thoat");
            System.out.print("Chon chuc nang 1-9: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print("arr[" + i + "][" + j + "] = ");
                            arr[i][j] = scanner.nextInt();
                        }
                    }
                    break;

                case 2:
                    System.out.println("Mang theo ma tran:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (arr[i][j] % 2 == 0 && arr[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("So luong phan tu chia het cho 2 va 3: " + count);
                    break;

                case 4:
                    int borderSum = 0, mainDiagSum = 0, subDiagSum = 0;
                    System.out.println("Duong bien:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                                System.out.print(arr[i][j] + " ");
                                borderSum += arr[i][j];
                            }
                        }
                    }
                    System.out.println("\nTong duong bien: " + borderSum);

                    if (n == m) {
                        System.out.println("Duong cheo chinh:");
                        for (int i = 0; i < n; i++) {
                            System.out.print(arr[i][i] + " ");
                            mainDiagSum += arr[i][i];
                        }
                        System.out.println("\nTong duong cheo chinh: " + mainDiagSum);

                        System.out.println("Duong cheo phu:");
                        for (int i = 0; i < n; i++) {
                            System.out.print(arr[i][n-1-i] + " ");
                            subDiagSum += arr[i][n-1-i];
                        }
                        System.out.println("\nTong duong cheo phu: " + subDiagSum);
                    }
                    break;

                case 5:
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n-1; i++) {
                            int minIdx = i;
                            for (int k = i+1; k < n; k++) {
                                if (arr[k][j] < arr[minIdx][j]) {
                                    minIdx = k;
                                }
                            }
                            int temp = arr[i][j];
                            arr[i][j] = arr[minIdx][j];
                            arr[minIdx][j] = temp;
                        }
                    }
                    System.out.println("Mang sau khi sap xep tang dan theo cot:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 6:
                    System.out.println("Cac so nguyen to trong mang:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            boolean isPrime = true;
                            if (arr[i][j] < 2) isPrime = false;
                            for (int k = 2; k <= Math.sqrt(arr[i][j]); k++) {
                                if (arr[i][j] % k == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) System.out.print(arr[i][j] + " ");
                        }
                    }
                    System.out.println();
                    break;

                case 7:
                    if (n == m) {
                        int[] diag = new int[n];
                        for (int i = 0; i < n; i++) {
                            diag[i] = arr[i][i];
                        }

                        // Insertion Sort giảm dần
                        for (int i = 1; i < n; i++) {
                            int key = diag[i];
                            int j = i - 1;
                            while (j >= 0 && diag[j] < key) {
                                diag[j + 1] = diag[j];
                                j--;
                            }
                            diag[j + 1] = key;
                        }

                        for (int i = 0; i < n; i++) {
                            arr[i][i] = diag[i];
                        }

                        System.out.println("Mang sau khi sap xep giam dan tren duong cheo chinh:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.print(arr[i][j] + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Khong phai ma tran vuong, khong co duong cheo chinh!");
                    }
                    break;

                case 8:
                    System.out.print("Nhap " + m + " phan tu cho mang 1 chieu: ");
                    int[] tempArr = new int[m];
                    for (int i = 0; i < m; i++) {
                        tempArr[i] = scanner.nextInt();
                    }
                    System.out.print("Nhap chi so dong can chen (0-" + (n-1) + "): ");
                    int row = scanner.nextInt();

                    if (row >= 0 && row < n) {
                        for (int j = 0; j < m; j++) {
                            arr[row][j] = tempArr[j];
                        }
                        System.out.println("Mang sau khi chen:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.print(arr[i][j] + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Chi so dong khong hop le!");
                    }
                    break;

                case 9:
                    System.out.println("Thoat chuong trinh");
                    System.exit(0);

                default:
                    System.out.println("Vui long chon tu 1-9");
            }
        }
    }
}