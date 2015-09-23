import java.util.Arrays;
import java.util.Random;

/**
 * Merge Sort
 *
 * Created by HyoJong on 2015-09-23.
 */
public class MergeSort {

    public static void _MergeSort(int[] array)
    {
        int size = array.length;

        if(size > 1)
        {
            int mid = size / 2;
            int rest = size - mid;

            int[] leftArray = new int[mid];
            int[] rightArray = new int[rest];

            for(int i = 0; i < mid; i++)
                leftArray[i] = array[i];
            for(int i = 0; i < rest; i++)
                rightArray[i] = array[rest + i];

            _MergeSort(leftArray);
            _MergeSort(rightArray);

            _Merge(leftArray, rightArray, array);
        }
    }

    public static void _Merge(int[] leftArray, int[] rightArray, int[] baseArray)
    {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;

        int leftIndex = 0, rightIndex = 0;
        int count = 0;

        //System.out.println(Arrays.toString(leftArray) + " " + Arrays.toString(rightArray));

        while(leftIndex < leftSize && rightIndex < rightSize)
        {
            if(leftArray[leftIndex] < rightArray[rightIndex])
            {
                baseArray[count] = leftArray[leftIndex];
                leftIndex++;
            }
            else
            {
                baseArray[count] = rightArray[rightIndex];
                rightIndex++;
            }

            count++;
        }

        if(leftIndex >= leftSize) {
            for(int i = rightIndex; i < rightSize; i++)
            {
                baseArray[count++] = rightArray[i];
            }
        }
        else
        {
            for(int i = leftIndex; i < leftSize; i++)
            {
                baseArray[count++] = leftArray[i];
            }
        }
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

        startTime = System.currentTimeMillis();

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

        endTime = System.currentTimeMillis();

        runningTime = endTime - startTime;

        System.out.println("\nRunning Time for Making Array : " + runningTime + "ms");

        System.out.println("<<<<<<<<<<<<<<<<  Merge Sort  >>>>>>>>>>>>>>>>");

        //System.out.println("Before Sorting : " + Arrays.toString(array));

        startTime = System.currentTimeMillis();

        _MergeSort(array);

        endTime = System.currentTimeMillis();

        //System.out.println("After Sorting : " + Arrays.toString(array));

        runningTime = endTime - startTime;

        System.out.println("\nRunning Time for Sorting : " + runningTime + "ms");

    }

}
