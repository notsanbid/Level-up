class CoinChangeCombination_IN_SUB {
    public static int coinChangeCombination_in_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (tar - coins[idx] >= 0) {
            count += coinChangeCombination_in_Sub(coins, tar - coins[idx], idx, psf + coins[idx] + " ");
        }
        count += coinChangeCombination_in_Sub(coins, tar, idx + 1, psf);

        return count;
    }
        
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangeCombination_in_Sub(coins, tar, 0, ""));
    }
}
