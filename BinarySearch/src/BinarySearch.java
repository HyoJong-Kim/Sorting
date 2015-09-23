import java.util.Random;

/**
 * Binary Search
 *
 * Created by HyoJong on 2015-09-23.
 */
public class BinarySearch {

    static int count = 0;

    public static int _BinarySearch(int[] array, int target, int start, int end)
    {
        int mid = (start + end) / 2;



        if(end < start)
            return -1;
        else
        {
            count++;

            if (array[mid] == target)
                return mid;
            else if (target > array[mid])
                return _BinarySearch(array, target, mid + 1, end);
            else
                return _BinarySearch(array, target, start, mid - 1);

        }

    }

    public static void main(String args[])
    {
        Random random = new Random();

        int size = 1 << 20;
        int index;
        int target = random.nextInt(size);
        int[] array = new int[size];


        for(int i = 0; i < size; i++)
        {
            array[i] = i;
        }


        if((index = _BinarySearch(array, target, 0, array.length - 1)) != -1)
            System.out.println(array[index] + " is " + (index+1) + "th element.");
        else
            System.out.println("Target is not exist");

        System.out.println("It spent " + count + " times");

    }
}
