package test;

import src.RadixSort;

public class testRadixSort {

    public static void main(String[] args) {
        testRadix();
    }

    public static void testRadix(){
        RadixSort radixSort = new RadixSort();

        System.out.println("\nFirst test");
        radixSort.sortLSD(new int[]{17, 54, 242, 23, 24, 9, 811, 367, 45}, 3);

        System.out.println("\nSecond test");
        radixSort.sortLSD(new int[]{3, 2, 8}, 1);

        System.out.println("\nThird test");
        radixSort.sortLSD(new int[]{17455, 54, 2462, 23, 254478, 4, 8115, 367, 45, 1093, 562343, 1672}, 6);
    }
}
