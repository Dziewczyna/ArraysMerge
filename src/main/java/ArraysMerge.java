import java.util.InputMismatchException;
import java.util.Scanner;

public class ArraysMerge {
  public static void main(String[] args) {
    int n = 0, m = 0;
    int[] A = new int[n];
    int[] B = new int[m];

    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter size of arrays: ");
      n = scanner.nextInt();
      A = new int[n];
      System.out.println("Enter all elements of 1st array in sorted order: ");
      for (int i = 0; i < n; i++) {
        A[i] = scanner.nextInt();
      }
      // Second array
      m = n;
      B = new int[m];
      System.out.println("Enter all elements of 2st array in sorted order: ");
      for (int i = 0; i < m; i++) {
        B[i] = scanner.nextInt();
      }
    } catch (InputMismatchException e) {
      System.out.println("Wrong format!");
    }

    if (isSorted(A, n) & isSorted(B, m)) {
      int[] c = mergeArrays(A, B);
      for (int i = 0; i < (A.length + B.length); i++) {
        System.out.println(c[i]);
      }
    } else System.out.println("Array(s) is not sorted");
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
    int[] c = new int[a.length + b.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        c[k] = a[i];
        k++;
        i++;
      } else {
        c[k] = b[j];
        k++;
        j++;
      }
    }
    while (i < a.length) {
      c[k] = a[i];
      k++;
      i++;
    }
    while (j < b.length) {
      c[k] = b[j];
      k++;
      j++;
    }

    return c;
  }
}
