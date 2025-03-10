import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringVar = "";
        int numVar = 0;
        int choice, subChoice;

        do {
            System.out.println("============ menu chinh ==========");
            System.out.println("1 Xu ly chuoi");
            System.out.println("2 Xu ly so nguyen");
            System.out.println("3 Thoat chuong trinh");
            System.out.print("Chon chuc nang 1-3 ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("=========== menu xu ly chuoi ============");
                        System.out.println("1 Nhap chuoi");
                        System.out.println("2 Dem khoang trang trong chuoi");
                        System.out.println("3 Dem so lan xuat hien cua tu khoa");
                        System.out.println("4 Chuan hoa chuoi viet hoa chu cai dau");
                        System.out.println("5 Quay lai menu chinh");
                        System.out.print("Chon chuc nang 1-5 ");
                        subChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (subChoice) {
                            case 1:
                                System.out.print("Nhap chuoi ");
                                stringVar = scanner.nextLine();
                                break;
                            case 2:
                                int countSpaces = 0;
                                for (int i = 0; i < stringVar.length(); i++) {
                                    if (stringVar.charAt(i) == ' ') {
                                        countSpaces++;
                                    }
                                }
                                System.out.println("So khoang trang " + countSpaces);
                                break;
                            case 3:
                                System.out.print("Nhap tu khoa can dem ");
                                String keyword = scanner.nextLine();
                                int countKeywords = 0;
                                String[] words = stringVar.split(" ");
                                for (int i = 0; i < words.length; i++) {
                                    if (words[i].equalsIgnoreCase(keyword)) {
                                        countKeywords++;
                                    }
                                }
                                System.out.println("So lan xuat hien cua " + keyword + " " + countKeywords);
                                break;
                            case 4:
                                char[] charArray = stringVar.toCharArray();
                                boolean capitalize = true;
                                for (int i = 0; i < charArray.length; i++) {
                                    if (Character.isLetter(charArray[i])) {
                                        if (capitalize) {
                                            charArray[i] = Character.toUpperCase(charArray[i]);
                                            capitalize = false;
                                        } else {
                                            charArray[i] = Character.toLowerCase(charArray[i]);
                                        }
                                    } else {
                                        capitalize = true;
                                    }
                                }
                                System.out.println("Chuoi sau khi chuan hoa " + new String(charArray));
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                        }
                    } while (subChoice != 5);
                    break;
                case 2:
                    do {
                        System.out.println("============== menu xu ly mang so nguyen =============");
                        System.out.println("1 Nhap so nguyen");
                        System.out.println("2 Tinh tong cac chu so");
                        System.out.println("3 Kiem tra so nguyen to");
                        System.out.println("4 Tim phan tu lon nhat trong mang");
                        System.out.println("5 Quay lai menu chinh");
                        System.out.print("Chon chuc nang 1-5 ");
                        subChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (subChoice) {
                            case 1:
                                System.out.print("Nhap so nguyen ");
                                numVar = scanner.nextInt();
                                break;
                            case 2:
                                int sum = 0, temp = numVar;
                                while (temp != 0) {
                                    sum += temp % 10;
                                    temp /= 10;
                                }
                                System.out.println("Tong cac chu so " + sum);
                                break;
                            case 3:
                                boolean isPrime = numVar > 1;
                                for (int i = 2; i < numVar; i++) {
                                    if (numVar % i == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                                System.out.println(numVar + (isPrime ? " la so nguyen to" : " khong phai so nguyen to"));
                                break;
                            case 4:
                                System.out.print("Nhap so phan tu cua mang ");
                                int size = scanner.nextInt();
                                int[] arr = new int[size];
                                System.out.println("Nhap cac phan tu cua mang ");
                                for (int i = 0; i < size; i++) {
                                    arr[i] = scanner.nextInt();
                                }
                                int max = arr[0];
                                for (int i = 1; i < size; i++) {
                                    if (arr[i] > max) {
                                        max = arr[i];
                                    }
                                }
                                System.out.println("Phan tu lon nhat trong mang " + max);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Lua chon khong hop le");
                        }
                    } while (subChoice != 5);
                    break;
                case 3:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        } while (choice != 3);
    }
}