import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class activity1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get user input for the array size.
            System.out.print("Enter the number of values (N): ");
            int N = scanner.nextInt();

            // Validate that N falls inside the provided range.
            if (N < 1 || N > 100) {
                System.out.println("Please enter a value between 1 and 100 for N.");
                return;
            }

            // Create a random array with values between 10 and 100.
            int[] array = generateRandomArray(N);

            // Show the original array.
            System.out.println("Original array: " + Arrays.toString(array));

            // Check for duplicate values and show their locations.
            Set<Integer> uniqueSet = new HashSet<>();
            Set<Integer> duplicateSet = new HashSet<>();

            for (int i = 0; i < array.length; i++) {
                if (!uniqueSet.add(array[i])) {
                    duplicateSet.add(array[i]);
                }
            }

            if (!duplicateSet.isEmpty()) {
                System.out.println("Duplicate values found at locations: " + duplicateSet);
            } else {
                System.out.println("No duplicate values found.");
            }

            // Remove duplicate values
            int[] uniqueArray = removeDuplicates(array);

            // Sort the array after removing duplicates
            Arrays.sort(uniqueArray);

            // Show the array after deleting duplicates and sorting in ascending order.
            System.out.println("Array after removing duplicates and sorting: " + Arrays.toString(uniqueArray));
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        // Generate random numbers between 10 and 100.
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(91) + 10;
        }

        return array;
    }

    private static int[] removeDuplicates(int[] array) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int value : array) {
            uniqueSet.add(value);
        }

        int[] uniqueArray = new int[uniqueSet.size()];
        int index = 0;
        for (int value : uniqueSet) {
            uniqueArray[index++] = value;
        }

        return uniqueArray;
    }
}
