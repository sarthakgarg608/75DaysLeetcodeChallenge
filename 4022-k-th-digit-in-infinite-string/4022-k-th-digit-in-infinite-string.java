class Solution {
    public int kthDigit(long k) {
        long digit = 2;
        long first = 1, last = 9;
        if (k <= 9) return (int) k ;
        k -= 9;

        while (((last - first + 1) * 10 * digit) < k) {
            k -= (last - first + 1) * 10 * digit;
            first *= 10;
            last = last * 10 + 9;
            digit++;
        }

        // long lo = first , hi = last ;
        // long num = 0;
        // while(lo < hi){
        //     long mid = lo + (hi-lo)/2;
        //     long total = (mid-lo)*10*digit;
        //     if(total > k){
        //         hi = mid-1;
        //         num = hi;  
        //     }
        //     else if(total < k){
        //         k -= total;
        //         lo = mid;
        //     }  
        // }

        long lo = first, hi = last;
long num = 0;

while(lo <= hi){
    long mid = lo + (hi - lo) / 2;
    long total = (mid - first) * 10 * digit;

    if(total < k){
        num = mid;
        lo = mid + 1;
    }
    else{
        hi = mid - 1;
    }
}

k -= (num - first) * 10 * digit;
        long rem = (k/digit);
        long modulo = (k%digit);
        if(num %2 == 0){
            if(modulo == 0) {
                long b = ((num*10) + (rem-1));
                String s = String.valueOf(b);
                return (s.charAt(s.length()-1)-'0');

            }else{
                long b = (num *10 + (rem) );
                String s = String.valueOf(b);
                return (s.charAt((int)modulo-1)-'0');

            }
        }else {
            if(modulo == 0) {
                long b = ((num*10+9) - (rem-1));
                String s = String.valueOf(b);
                return (s.charAt(s.length()-1)-'0');

            }else{
                long b = ((num *10)+9 - rem );
                String s = String.valueOf(b);
                return (s.charAt((int)modulo-1)-'0');

            }
        }
    }
}