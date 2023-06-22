
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class Sort {
    public static void insertionSort(Employee[] empList , boolean asc){
        insertionSort(empList);
        if (!asc){
            Collections.reverse(Arrays.asList(empList));
        }
    }
    public static void bubleSort(Employee[] empList , boolean asc){
        bubbleSort(empList);
        if (!asc){
            Collections.reverse(Arrays.asList(empList));
        }
    }
    public static void selectionSort(Employee[] empList , boolean asc){
        selectionSort(empList);
        if (!asc){
            Collections.reverse(Arrays.asList(empList));
        }
    }
    public static void heapSort(Employee[] empList , boolean asc){
        heapSort(empList);
        if (!asc){
            Collections.reverse(Arrays.asList(empList));
        }
    }
    public static void mergeSort(Employee[] empList , boolean asc){
        mergeSort(empList, 0, empList.length);
        if (!asc){
            Collections.reverse(Arrays.asList(empList));
        }
    }
    public static void quickSort(Employee[] empList , boolean asc){
        quickSort(empList, 0, empList.length);
    }

    private static void quickSort(Employee[] empList, int l, int r) {
        int i = l, j = r;
        Employee mid = empList[(l + r) >> 1];
        while (i < j) {
            while (empList[i].compareTo(mid) < 0) {
                i++;
            }
            while (empList[j].compareTo(mid) > 0) {
                j--;
            }
            if (empList[i].compareTo(empList[j]) <= 0) {
                Employee tmp = empList[i];
                empList[i] = empList[j];
                empList[j] = tmp;
                i++;
                j--;
            }
        }
        if (l < j) {
            quickSort(empList, l, j);
        }
        if (i < r) {
            quickSort(empList, i, r);
        }
    }

    private static void insertionSort(Employee[] empList) {
        int n = empList.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && empList[i].compareTo(empList[j - 1]) < 0) {
                j--;
            }
            Employee tmp = empList[i];
            for (int k = i; k > j; k--) {
                empList[k] = empList[k - 1];
            }
            empList[j] = tmp;
        }
    }

    private static void selectionSort(Employee[] empList) {
        int n = empList.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (empList[j].compareTo(empList[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Employee tmp = empList[i];
            empList[i] = empList[minIndex];
            empList[minIndex] = tmp;
        }
    }

    private static void bubbleSort(Employee[] empList) {
        int n = empList.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (empList[i].compareTo(empList[j]) < 0) {
                    Employee tmp = empList[i];
                    empList[i] = empList[j];
                    empList[j] = tmp;
                }
            }
        }
    }

    private static void heapSort(Employee[] empList) {
        PriorityQueue<Employee> heap = new PriorityQueue<>();
        for (int i = 0; i < empList.length; i++) {
            heap.add(empList[i]);
        }
        for (int i = 0; i < empList.length; i++) {
            empList[i] = heap.poll();
        }
    }

    private static void mergeSort(Employee[] empList, int l, int r) {
        if (empList.length == 1) {
            return;
        }
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(empList, l, mid);
            mergeSort(empList, mid + 1, r);
            int i = l, j = mid + 1;
            int cur = 0 ;
            Employee a[] = new Employee[empList.length] ;
            while (i < mid || j < r){
                if (i > mid){
                    a[cur] = empList[j] ;
                    cur++ ;
                    j++ ;
                }else if(j > r){
                    a[cur] = empList[i] ;
                    cur++ ;
                    i++ ;
                }else if(empList[i].compareTo(empList[j]) < 0){
                    a[cur] = empList[i] ;
                    cur++ ;
                    i++ ;
                }else{
                    a[cur] = empList[j] ;
                    cur++ ;
                    j++ ;
                }
            }
            for(i = 0 ; i < cur ; i++){
                empList[l+i] = a[i] ;
            }
        }
    }
}
