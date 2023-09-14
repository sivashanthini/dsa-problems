package bitmanipulation.medium;

public class CountTotalSetBits {
    //O(n*k)
    public int solve(int A) {
        int i = 0, ans = 0;
        //check the number A is greater than 2^i
        while ((1 << i) <= A) {
            int change = 1 << i; //iterator from 2^i to 1
            boolean k = false;
            //loop from 0 to n for every bit position
            for (int j = 0; j <= A; j++) {
                if (k == true)
                    ans++;

                if (change == 1) {
                    k = !k;
                    change = 1 << i;
                } else {
                    change--;
                }

            }
            i++;
        }
        return ans;
    }

    //O(logA)
    public int solveTwo(int A) {
        long num = A + 1; //add 1 to the number in order to compensate 0. As the binary number system starts from 0. So now A = A + 1.
        int i = 1; //to trach power of 2
        long count = A/2; //in the vertical sequence last column set bits, that is 2^0 bits
        long groupCount = 0; //group count of 0's and 1's in a column
        long setBitGroupCount = 0; //group count of 1's in a column
        long setBitCount = 0; //count of 1's in each setBitGroupCount
        long mod = 1000000007;

        while ((1 << i) < num) {
            groupCount = num / (1 << i);
            setBitGroupCount = groupCount / 2;
            setBitCount = setBitGroupCount * (1 << i);
            count += setBitCount;
            if ((groupCount & 1) == 1) {
                count += num % (1 << i);
            }
            i++;
        }
        return (int)(count % mod);
    }
}
