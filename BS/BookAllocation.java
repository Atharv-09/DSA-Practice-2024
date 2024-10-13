package BS;
/*Given an integer array ‘A’ of size ‘N’ and an integer ‘K'. Split the array ‘A’ into ‘K’ non-empty subarrays such that the largest sum of any subarray is minimized. Your task is to return the minimized largest sum of the split.
A subarray is a contiguous part of the array. */
public class BookAllocation {
    
    // LINEAR SEARCH
    // TC : O(sum-max)*N

    static int allocateBook(int[] arr,int n,int students){

        if(students > n) return -1; // if the books are less then student count

        int maxPages = Integer.MIN_VALUE; //LOW we can take maxPages to student is the maximum value of pages such that we can assign 1 book to 1 student
        int totalPagesInBooks = 0; //HIGH and maxPages coz if we hve only 1 student then we have to asssigne all books to that 1 student

        for(int i=0;i<n;i++){
            maxPages = Math.max(maxPages,arr[i]);
            totalPagesInBooks += arr[i];
        }
        for(int pages=maxPages;pages<=totalPagesInBooks;pages++){

            if(check(arr,n,students,pages)){
                return pages;
            }
        }
        return -1;
    }
    private static boolean check(int[] arr, int n, int students,int maxPages) {
        
        int booksAllocatedToStudent = 1;
        int prev = 0;

        for(int i=0;i<n;i++){
            int noOfPages = prev+arr[i];
            if(noOfPages > maxPages){ // if the noOfpages count is greater then the limit then we can say the student cannot hold that book as its pages are exceeding the limit
                prev = arr[i]; // if noOfPgaes count is more then limit then we will assign that book to new student
                booksAllocatedToStudent++;
            }else{
                prev += arr[i];
            }
        }
        // if we can allocated the books to the exactly allowed students
        if(booksAllocatedToStudent <= students) return true;
        return false;
    }

    // BINARY SEARCH
    // INSTEAD of going from low(maxPages) to High(totalPages)
    // we can check in mid is that giving the ans if not we will eliminate accordingly

    static int allocateBook1(int[] arr,int n,int students){

        if(students > n) return -1; // if the books are less then student count

        int maxPages = Integer.MIN_VALUE; //LOW we can take maxPages to student is the maximum value of pages such that we can assign 1 book to 1 student
        int totalPagesInBooks = 0; //HIGH and maxPages coz if we hve only 1 student then we have to asssigne all books to that 1 student

        for(int i=0;i<n;i++){
            maxPages = Math.max(maxPages,arr[i]);
            totalPagesInBooks += arr[i];
        }
        
        int low = maxPages,high=totalPagesInBooks;

        // bin search
        while (low <= high){

            int mid = (low+high)/2;
            // 10 15 8 18 m = 3 
            // [10 | 15 | 8 18 ] maxP = 26
            // [10 | 15 8 | 18] maxP = 23
            // [10 15 | 8 | 18] maxP = 25
            // min of above max pages = 23 

            // here in bin search we will go from 18 to 51 mid = 69/2 =34
            // is the 34 as maxPages satisfying the condition ? check 1. if we took 1,2,3 book thier pages sum 33 < 34 assigned to 1student
            // 18 pages book assigned to 2nd student, but what about 3rd student ?
            // so we will decrease the maxPages
            // low = 18 , high = 33 , mid = 51/2 = 25
            // [10,15| 8 | 18 ] as this mid=25 giving right ans but we want min values so we will eliminate the right half, high = mid-1;
            if(check(arr, n, students, mid)){
                // as its giving the ans we want minimum value eliminate right
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high+1; // polartiy when the low goes to min side and high goes to max side
    }
    public static void main(String[] args) {
        
        int[] arr = new int[]{25,46,28,49,24};

        int ans = allocateBook1(arr,arr.length,4);
        System.out.println(ans);
    }
}
