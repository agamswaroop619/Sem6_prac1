import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bubble {
    public static void main(String[] args) {
        String filePath = "random_numbers.txt";
        int[] arr = readNumbersFromFile(filePath);
        long startTime = System.currentTimeMillis();
        if (arr != null) {
            System.out.println("Original Array:");
            printArray(arr);
            bubbleSort(arr);
            System.out.println("\nSorted Array:");
            printArray(arr);
        } else {
            System.out.println("Error reading numbers from file.");
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] readNumbersFromFile(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            int count = 0;

            while (line != null) {
                count++;
                line = reader.readLine();
            }
            int[] arr = new int[count];

            reader.close();
            reader = new BufferedReader(new FileReader(filePath));

            for (int i = 0; i < count; i++) {
                line = reader.readLine();
                arr[i] = Integer.parseInt(line);
            }

            reader.close();
            return arr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
