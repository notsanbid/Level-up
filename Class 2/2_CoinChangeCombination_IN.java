// Target = 10
// Ways : 22222
//         2233
//          253
//           37  
//           55
// Example 2 : 
// Given 'abcde', 'abce' is a Combination. Letters are always moving forward.
// (Summation of nCr method)
class CoinChangeCombination_IN {
    
    public static int coinChangeCombination_IN(int coins[], int tar, int idx, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar-coins[i] >= 0)
                count += coinChangeCombination_IN(coins, tar-coins[i], i, psf + coins[i] + " ");
        }
        return count;
    }
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangeCombination_IN(coins, tar,0, ""));
    }
}
