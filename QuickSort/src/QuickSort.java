import java.util.Arrays;
import java.util.Random;

/**
 * Quick Sort.
 * Created by Answer on 2015-09-30.
 */
public class QuickSort {

    public static void _QuickSort(int[] array, int low, int high)
    {
        int pivotIndex;

        if(low < high)
        {
            pivotIndex = _Partition(array, low, high);
            _QuickSort(array, low, pivotIndex);
            _QuickSort(array, pivotIndex+1, high);
        }
    }

    public static int _Partition(int[] array, int low, int high)
    {
        int i, j, pivot, temp;

        pivot = array[low];
        j = low + 1;

        for (i = low + 1; i < high; i++) {
            if (array[i] < pivot) {
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j++;
            }
        }


        int pivotPoint = j - 1;

        temp = array[low];
        array[low] = array[pivotPoint];
        array[pivotPoint] = temp;

        return pivotPoint;
    }

    public static void main(String args[])
    {
        int size = 1<<20;
        int[] array = new int[size];
        boolean[] check = new boolean[size];
        long startTime, endTime, runningTime;

        Random random = new Random();

        int i = 0;
        int temp;

        for(int k = 0; k < size; k++)
            check[k] = false;

        while(i < size)
        {
            temp = random.nextInt(size);

            if(!check[temp])
            {
                check[temp] = true;
                array[i] = temp;
                i++;
            }
        }

        System.out.println("<<<<<<<<<<<<<<<<  Quick Sort  >>>>>>>>>>>>>>>>");

        //System.out.println("Before Sorting : " + Arrays.toString(array));

        startTime = System.currentTimeMillis();

        _QuickSort(array, 0, array.length);

        endTime = System.currentTimeMillis();

        //System.out.println("After Sorting : " + Arrays.toString(array));

        runningTime = endTime - startTime;

        System.out.println("\nRunning Time for Sorting : " + runningTime + "ms");
    }
}
