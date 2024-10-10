package tasks.first_ds_lecture.merge_sorted_array;

public class MergeSortedArray {
    /**
     * start filling nums1 end with the maximum between the largest elements in each array (descending)
     *  why using the end and not the start? using the start might need some shifting for elements.
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        m--;
        n--;
        while(m >= 0 && n >= 0)
            nums1[k--] = nums1[m] > nums2[n] ? nums1[m--]: nums2[n--];
        /*
         1- If both m & n < 0 --> done.
         2- else if m > 0 (all nums2 elements have been put at the end of nums1) and nums1[0:m]
                                                      elements are already in place --> done.
         3- else (n > 0, all nums1[0:m] elements have been put at the end of nums1) --> fill the rest with nums2
        */
        while (n >= 0)
            nums1[k--] = nums2[n--];
    }
}
