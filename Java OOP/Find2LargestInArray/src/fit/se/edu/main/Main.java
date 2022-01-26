package fit.se.edu.main;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 35, 1, 10, 34, 1};
        int n = arr.length;
		usingSortArray(arr, n);
		usingArrayTraversalTwice(arr, n);
		usingArrayTraversalOnce(arr, n);
	}

	/**
	 * The first way: Sort
	 */
	static void usingSortArray(int arr[], int arr_size) {
		int i;
		if (arr_size < 2) {
            System.out.printf("Khong ton tai phan tu lon thu 2");
            return;
        }
		
		// Sort
        Arrays.sort(arr);
        for (i = arr_size - 2; i >= 0; i--) {
            if (arr[i] != arr[arr_size - 1]) {
                System.out.println("Phan tu lon thu 2: " + arr[i]);
                return;
            }
        }
        System.out.println("Khong ton tai phan tu lon thu 2");
	}
	
	/**
	 * Iterates the array twice - Duyệt mảng 2 lần
	 */
	static void usingArrayTraversalTwice(int arr[], int arr_size) {
		int i, second;
        if (arr_size < 2) {
            System.out.printf(" Khong hop le");
            return;
        }
        
        int largest = second = Integer.MIN_VALUE;
        // Tìm phần tử lớn nhất
        for (i = 0; i < arr_size; i++) {
            largest = Math.max(largest, arr[i]);
        }
        // Tìm phần tử lớn nhất trong các phần tử còn lại, loại trừ largest
        for (i = 0; i < arr_size; i++) {
            if (arr[i] != largest)
                second = Math.max(second, arr[i]);
        }
        
        if (second == Integer.MIN_VALUE)
            System.out.println("Khong ton tai phan tu lon thu 2");
        else
            System.out.println("Phan tu lon thu 2: " + second);
	}
	
	/**
	 * Browse the array once - Duyệt mảng 1 lần
	 */
	static void usingArrayTraversalOnce(int arr[], int arr_size) {
		int i, first, second;
        if (arr_size < 2) {
            System.out.println(" Khong hop le ");
            return;
        }
        first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }
            if (arr[i] < first && arr[i] > second) {
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE)
            System.out.println("Khong ton tai phan tu lon thu 2 ");
        else
            System.out.println("Phan tu lon thu 2: " + second);
	}
}
