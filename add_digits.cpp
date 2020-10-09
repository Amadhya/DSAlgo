class Solution {
public:
    int addDigits(int num) {
       long long int sum = 0;
        
        while(num){
            int r = num % 10;
            sum += r;
            num /= 10;
            
            if(!num && sum >= 10){
                num = sum;
                sum = 0;
            }
        }
        
        return sum;
    }
};