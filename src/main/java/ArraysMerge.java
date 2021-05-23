import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysMerge {
  public static void main(String[] args) {
    int lengthA = 0, lengthB = 0;
    int[] arrayA = new int[lengthA];
    int[] arrayB = new int[lengthB];

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter size of 1st array: ");
      lengthA = scanner.nextInt();
      arrayA = new int[lengthA];
      System.out.println("Enter all elements of 1st array in sorted order: ");
      for (int i = 0; i < lengthA; i++) {
        arrayA[i] = scanner.nextInt();
      }
      // Second array
      System.out.print("Enter size of 2nd array: ");
      lengthB = scanner.nextInt();
      arrayB = new int[lengthB];
      System.out.println("Enter all elements of 2st array in sorted order: ");
      for (int i = 0; i < lengthB; i++) {
        arrayB[i] = scanner.nextInt();
      }
    } catch (InputMismatchException e) {
      System.out.println("Wrong format!");
    }

    if (isSorted(arrayA, lengthA) && isSorted(arrayB, lengthB)) {
      int[] c = mergeArrays(arrayA, arrayB);
      for (int i = 0; i < (arrayA.length + arrayB.length); i++) {
        System.out.println(c[i]);
      }
    } else {
      System.out.println("Array(s) is not sorted");
    }
  }

  private static boolean isSorted(int[] a, int index) {
    if (a == null || a.length <= 1 || index == 1) {
      return true;
    }
    if (a[index - 1] < a[index - 2]) {
      return false;
    }
    return isSorted(a, index - 1);
  }

  private static int[] mergeArrays(int[] a, int[] b) {
    int[] arrayR = new int[a.length + b.length];
    int indexA = 0;
    int indexB = 0;
    int indexR = 0;
    while (indexA < a.length || indexB < b.length) {
      if ((indexA < a.length && indexB < b.length) && (a[indexA] < b[indexB])) {
        arrayR[indexR++] = a[indexA++];
      } else if (indexB < b.length) {
        arrayR[indexR++] = b[indexB++];
      }
    }
    while (indexA < a.length) {
      arrayR[indexR++] = a[indexA++];
    }
    while (indexB < b.length) {
      arrayR[indexR++] = b[indexB++];
    }

    return arrayR;
  }
}
