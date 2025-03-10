import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        int currentIndex = 0;
        do {
            System.out.println("Menu");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng (k nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            int choice;
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    int n = Integer.parseInt(sc.nextLine());
                    if(currentIndex + n > arr.length) {
                        System.out.println("Tràn mảng, không thể thêm.");
                        break;
                    }
                    for (int i = currentIndex; i < n; i++) {
                        System.out.print("arr[" + currentIndex + "] = ");
                        arr[currentIndex] = Integer.parseInt(sc.nextLine());
                    }
                    break;
                case 2:
                    System.out.print("Các giá trị có trong mảng là:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    break;
                case 3:
                    if(currentIndex == 0){
                        System.out.println("Mảng rỗng");
                        break;
                    }
                    int sumPositiveNumber = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if(arr[i] > 0){
                            sumPositiveNumber += arr[i];
                        }
                    }
                    int avg = sumPositiveNumber / currentIndex;
                    System.out.println("Trung bình các phần tử dương: " + avg);
                    break;
                case 4:
                    int k = Integer.parseInt(sc.nextLine());
                    int index = -1;
                    for(int i = 0; i < currentIndex; i++) {
                        if(arr[i] == k){
                            index = i;
                            break;
                        }
                    }
                    System.out.println(index != - 1? "Giá trị " + k + " nằm ở vị trí " + index : "Không tồn tại giá trị " + k + " trong mảng");
                    break;
                case 5:
                    if(currentIndex == 0){
                        System.out.println("Mảng rỗng");
                        break;
                    }
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for(int j = i + 1; j < currentIndex; j++) {
                            if(arr[i] > arr[j]){
                                int key = arr[i];
                                arr[i] = arr[j];
                                arr[j] = key;
                            }
                        }
                    }
                    break;
                case 6:
                    if(currentIndex == 0){
                        System.out.println("Mảng rỗng");
                        break;
                    }
                    int countPrimeInArr = 0;
                    for(int i = 0; i < currentIndex; i++) {
                        boolean isPrime = true;
                        if(arr[i] < 2){
                            continue;
                        }
                        for(int j = 2; j < Math.sqrt(arr[i]); j++) {
                            if(arr[i] % j == 0){
                                isPrime = false;
                                break;
                            }
                        }
                        if(isPrime){
                            countPrimeInArr++;
                        }
                        System.out.println("Số lượng số nguyên tố trong mảng: " + countPrimeInArr);
                    }
                    break;
                case 7:
                    if(currentIndex == 0){
                        System.out.println("Mảng rỗng");
                        break;
                    }
                    int countEvenDiv3 = 0, countOddDiv3 = 0, countOthers = 0;
                    for(int i = 0; i < currentIndex; i++) {
                        if(arr[i] % 2 == 0 && arr[i] % 3 == 0){
                            countEvenDiv3++;
                        }else if(arr[i] % 3 == 0 && arr[i] % 2 != 0){
                            countOddDiv3++;
                        }else {
                            countOthers++;
                        }
                    }
                    int[] evenDiv3 = new int[countEvenDiv3];
                    int[] oddDiv3 = new int[countOddDiv3];
                    int[] others = new int[countOthers];

                    int evenIndex = 0, oddIndex = 0, otherIndex = 0;
                    for(int i = 0; i < currentIndex; i++) {
                        if(arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            evenDiv3[evenIndex++] = arr[i];
                        } else if(arr[i] % 3 == 0 && arr[i] % 2 != 0) {
                            oddDiv3[oddIndex++] = arr[i];
                        } else {
                            others[otherIndex++] = arr[i];
                        }
                    }
                    bubbleAscSort(evenDiv3);
                    bubbleAscSort(others);
                    bubbleDescSort(oddDiv3);

                    int index2 = 0;
                    for(int i = 0; i < countOddDiv3; i++){
                        arr[index2++] = evenDiv3[i];
                    }
                    for(int i = 0; i < countEvenDiv3; i++){
                        arr[index2++] = oddDiv3[i];
                    }
                    for(int i = 0; i < countEvenDiv3; i++){
                        arr[index2++] = oddDiv3[i];
                    }
                    break;
                case 8:
                    if(currentIndex == 0){
                        System.out.println("Mảng rỗng");
                        break;
                    }
                    bubbleDescSort(arr);
                    int insertValue = Integer.parseInt(sc.nextLine());
                    int i;
                    for (i = currentIndex; i >= 0 && arr[i] < insertValue; i--){
                        arr[i + 1] = arr[i];
                    }
                    arr[i + 1] = arr[insertValue];
                    break;
                case 9:
                    System.out.println("Hẹn gặp lại.");
                    System.exit(0);
                default:
                    System.out.println("Vui lòng chọn từ 1 - 9.");
            }
        }while (true);
    }

    public static int[] bubbleAscSort(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int key = arr[i];
                    arr[i] = arr[j];
                    arr[j] = key;
                }
            }
        }
        return newArr;
    }

    public static int[] bubbleDescSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    int key = arr[i];
                    arr[i] = arr[j];
                    arr[j] = key;
                }
            }
        }
        return arr;
    }
}