class CoinChangePermutation_SIN {
    public static int coinChangePermutation_Sin(int coins[], int tar, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] > 0 && tar-coins[i] >= 0){
                int val = coins[i];
                coins[i] = -1;
                count += coinChangePermutation_Sin(coins, tar-val, psf + val + " ");
                coins[i] = val;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangePermutation_Sin(coins, tar, ""));
    }
}  
