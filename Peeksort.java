import java.util.Arrays;

public class Peeksort {
    public static void peeksort(int[] A) {
        int r = A.length - 1;
        peekSort(A, 0, r, 0, r);
    }

    public static void peekSort(int[] A, int l, int r, int e, int s) {
        // Implementasi algoritma Peeksort
        if (r - l <= 0) {
            return;
        }
        if ((e == r) || (s == l)) {
            return;
        }

        int m = l + ((r - l) >> 1);

        if (m <= e) {
            peekSort(A, e + 1, r, e + 1, s);
            merge(A, l, e + 1, r);
        } else if (m >= s) {
            peekSort(A, l, s - 1, e, s - 1);
            merge(A, l, s, r);
        } else {
            int[] runBoundary = extendRun(A, l, m, r);
            int i = runBoundary[0];
            int j = runBoundary[1];

            if (i == l && j == r) {
                return;
            }

            if (m - 1 < j - m) {
                peekSort(A, l, i - 1, e, i - 1);
                peekSort(A, i, r, j, s);
                merge(A, l, i, r);
            } else {
                peekSort(A, l, j, e, i);
                peekSort(A, j + 1, r, j + 1, s);
                merge(A, l, j + 1, r);
            }
        }
    }

    public static void merge(int[] A, int e, int i, int s) {
        // Implementasi penggabungan dua bagian array yang sudah diurutkan
        int n1 = i - e;
        int n2 = s - i + 1;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int j = 0; j < n1; j++) {
            L[j] = A[e + j];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = A[i + j];
        }

        int k = e;

        int j = 0;

        int l = 0;

        while (j < n1 && l < n2) {
            if (L[j] <= R[l]) {
                A[k] = L[j];
                j++;
            } else {
                A[k] = R[l];
                l++;
            }
            k++;
        }

        while (j < n1) {
            A[k] = L[j];
            j++;
            k++;
        }

        while (l < n2) {
            A[k] = R[l];
            l++;
            k++;
        }
    }

    public static int[] extendRun(int[] A, int l, int m, int r) {
        // Implementasi untuk menemukan run yang mencakup posisi m dalam array
        int i = m;
        int j = m;
        while (i > l && A[i] >= A[i - 1]) {
            --i;
        }

        while (j < r && A[j] <= A[j + 1]) {
            ++j;
        }

        return new int[] { i, j };

    }

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int l = 1000;
        int[] arr1000 = new int[l];
        for (int i = 0; i < l; i++) {
            arr1000[i] = (int) (Math.random() * 1000);
        }
        // generate array of int 10000
        int m = 10000;
        int[] arr10000 = new int[m];
        for (int i = 0; i < m; i++) {
            arr10000[i] = (int) (Math.random() * 10000);
        }
        // generate array of int 100000
        int n = 100000;
        int[] arr100000 = new int[n];
        for (int i = 0; i < n; i++) {
            arr100000[i] = (int) (Math.random() * 100000);
        }
        // generate random sorted array of int 1000
        int[] arr1000s = new int[l];
        for (int i = 0; i < l; i++) {
            arr1000s[i] = (int) (Math.random() * 1000);
        }
        Arrays.sort(arr1000s);
        // generate random sorted array of int 10000
        int[] arr10000s = new int[m];
        for (int i = 0; i < m; i++) {
            arr10000s[i] = (int) (Math.random() * 10000);
        }
        Arrays.sort(arr10000s);
        // generate random sorted array of int 100000
        int[] arr100000s = new int[n];
        for (int i = 0; i < n; i++) {
            arr100000s[i] = (int) (Math.random() * 100000);
        }
        Arrays.sort(arr100000s);
        // generate random reverse sorted array of int 1000
        int[] arr1000r = new int[l];
        for (int i = 0; i < l; i++) {
            arr1000r[i] = (int) (Math.random() * 1000);
        }
        Arrays.sort(arr1000r);
        for (int i = 0; i < l / 2; i++) {
            int temp = arr1000r[i];
            arr1000r[i] = arr1000r[l - i - 1];
            arr1000r[l - i - 1] = temp;
        }
        // generate random reverse sorted array of int 10000
        int[] arr10000r = new int[m];
        for (int i = 0; i < m; i++) {
            arr10000r[i] = (int) (Math.random() * 10000);
        }
        Arrays.sort(arr10000r);
        for (int i = 0; i < m / 2; i++) {
            int temp = arr10000r[i];
            arr10000r[i] = arr10000r[m - i - 1];
            arr10000r[m - i - 1] = temp;
        }
        // generate random reverse sorted array of int 100000
        int[] arr100000r = new int[n];
        for (int i = 0; i < n; i++) {
            arr100000r[i] = (int) (Math.random() * 100000);
        }
        Arrays.sort(arr100000r);
        for (int i = 0; i < n / 2; i++) {
            int temp = arr100000r[i];
            arr100000r[i] = arr100000r[n - i - 1];
            arr100000r[n - i - 1] = temp;
        }

        System.gc();
        long beforeUsedMemory = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.currentTimeMillis();
        // peeksort(arr1000);
        // peeksort(arr10000);
        // peeksort(arr100000);
        // peeksort(arr1000s);
        // peeksort(arr10000s);
        // peeksort(arr100000s);
        // peeksort(arr1000r);
        // peeksort(arr10000r);
        // peeksort(arr100000r);
        long endTime = System.currentTimeMillis();
        long afterUsedMemory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println("Memory used: " + (afterUsedMemory - beforeUsedMemory));
        System.out.println("Time used: " + (endTime - startTime));
    }
}
