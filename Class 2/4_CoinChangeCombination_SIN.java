class CoinChangeCombination_SIN {
    public static int coinChangeCombination_Sin(int coins[], int tar, int idx, String psf){
        if(tar == 0){
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < coins.length; i++){
            if(tar-coins[i] >= 0)
                count += coinChangeCombination_Sin(coins, tar-coins[i], i+1, psf + coins[i] + " ");
        }
        return count;
    }
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangeCombination_Sin(coins, tar, 0, ""));
    }
}
