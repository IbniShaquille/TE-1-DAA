import java.util.Arrays;
// import java.io.PrintWriter;
// import java.io.UnsupportedEncodingException;

class Radix {

	// A utility function to get maximum value in arr[]
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 0; i < n; i++) {
			if (arr[i] > mx)
				mx = arr[i];
		}
		return mx;
	}

	// A function to do counting sort of arr[] according to
	// the digit represented by exp.
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n]; // output array
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);

		// Store count of occurrences in count[]
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;

		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];

		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		// Copy the output array to arr[], so that arr[] now
		// contains sorted numbers according to current
		// digit
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	// The main function to that sorts arr[] of
	// size n using Radix Sort
	static void radixsort(int arr[], int n) {
		// Find the maximum number to know number of digits
		int m = getMax(arr, n);

		// Do counting sort for every digit. Note that
		// instead of passing digit number, exp is passed.
		// exp is 10^i where i is current digit number
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	// A utility function to print an array
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Main driver method
	public static void main(String[] args) {
		// generate array of int 1000
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
		// radixsort(arr1000, l);
		// radixsort(arr10000, m);
		// radixsort(arr100000, n);
		// radixsort(arr1000s, l);
		// radixsort(arr10000s, m);
		// radixsort(arr100000s, n);
		// radixsort(arr1000r, l);
		// radixsort(arr10000r, m);
		// radixsort(arr100000r, n);
		long endTime = System.currentTimeMillis();
		long afterUsedMemory = runtime.totalMemory() - runtime.freeMemory();

		System.out.println("Time taken for 1000 random: " + (endTime - startTime) + " miliseconds");
		System.out.println("Memory used for 1000 random: " + (afterUsedMemory - beforeUsedMemory) + " bytes");
	}
}
