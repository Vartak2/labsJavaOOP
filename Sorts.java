public class Main {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) 
            return;
        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }


    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
    
    
	public static void main(String[] args) {
		int[] arr1 = {5, 2, 9, 1, 15, 6};
        for (int i = 0; i < arr1.length; i++) {
            int key = arr1[i];
            int j = i - 1;
            while (j >= 0 && arr1[j] > key) {
                arr1[j + 1] = arr1[j];
                j--;
            }
            arr1[j + 1] = key;
        }
		for (int i = 0; i < arr1.length; i++) {
		    System.out.println(arr1[i]);
		}
		
        System.out.println();
				
		int[] arr2 = {5, 2, 9, 188, 15, 6};
		mergeSort(arr2);
        
		for (int i = 0; i < arr2.length; i++) {
		    System.out.println(arr2[i]);
		}
		
	}
}