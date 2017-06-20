package com.company;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by tnkhang on 6/20/2017.
 */
public class MergerSortedArray {
    public static void main(String[] args) {
        int[] A = new int[10];
        A[0]=3;
        A[1]=4;
        A[2]=5;
        A[3]=6;
        A[4]=7;
        int[] B = {1,2,3,4,5};
        int sizeA = 5;
        int sizeB = 5;
        merge(A,sizeA,B,sizeB);
        for(int i = 0 ; i < A.length ;i++) {
            System.out.println(A[i]);
        }
    }

    public static void merge(int A[], int m, int B[], int n) {
        while(m > 0 && n > 0) {
            if(A[m-1] < B[n-1]) {
                A[m+n-1] = B[n-1];
                n--;
            } else {
                A[m+n-1] = A[m-1];
                m--;
            }
        }
        while(m > 0) {
            A[m+n-1] = A[m-1];
            m--;
        }
        while(n > 0) {
            A[m+n-1] = B[n-1];
            n--;
        }

    }
}
