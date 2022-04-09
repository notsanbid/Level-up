class CoinChangePermutation_SIN_SUB {
    public static int coinChangePermutation_Sin_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (coins[idx] > 0 && tar - coins[idx] >= 0) {
            int val = coins[idx];
            coins[idx] = -1;
            count += coinChangePermutation_Sin_Sub(coins, tar - val, 0, psf + val + " ");
            coins[idx] = val;
        }
        count += coinChangePermutation_Sin_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangePermutation_Sin_Sub(coins, tar, 0, ""));
    }
}
