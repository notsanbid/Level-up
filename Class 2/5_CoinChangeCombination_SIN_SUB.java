// Subsequence Method : Each has option whether to come or not
// Terminates - Jab sabne apni choices express kar di or Target gets 0.
// If there would have been a coin of value 0, target == 0 tarmination would not be valid

class CoinChangeCombination_SIN_SUB {
    public static int coinChangeCombination_Sin_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (tar - coins[idx] >= 0) {
            count += coinChangeCombination_Sin_Sub(coins, tar - coins[idx], idx + 1, psf + coins[idx] + " ");
        }
        count += coinChangeCombination_Sin_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;
        System.out.println(coinChangeCombination_Sin_Sub(coins, tar, 0, ""));
    }

}
