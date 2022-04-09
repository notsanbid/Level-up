// Target = 10
// Ways : 22222 -> 5!/5! : 1 way
//         2233 -> 4!/(2!*2!) : 6 way
//          253 -> 3! : 6 way
//           37 -> 2! : 2 way
//           55 -> 2!/2! : 1 way
// Example 2 : 
// Given 'abcde', 'abed' is a Permutation. Letters can go forward and come backwards

class CoinChangePermutation_IN {

    public static int coinChangePermutation_in(int coins[], int tar, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            if(tar-coins[i] >= 0)
                count += coinChangePermutation_in(coins, tar-coins[i], psf + coins[i] + " ");
        }
        return count;
    }
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangePermutation_in(coins, tar, ""));
    }
}