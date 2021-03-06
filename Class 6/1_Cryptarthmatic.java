class CryptarthMatic {
    static String str1 = "send", str2 = "more", str3 = "money";
    static boolean[] isNumUsed = new boolean[10];
    static int[] mapping = new int[26];

    public static void crypto() {
        String str = str1 + str2 + str3;
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        str = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                str += (char) (i + 'a');
        }

        if (str.length() > 10)
            return;

        System.out.println(crypto(str, 0));
    }

    public static int crypto(String str, int idx) {
        if (idx == str.length()) {
            if (isValidMapping()) {
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    System.out.print(ch + "=" + mapping[ch - 'a'] + ", ");
                }
                System.out.println();
                return 1;
            }

            return 0;
        }

        int count = 0;
        char ch = str.charAt(idx);
        for (int num = 0; num <= 9; num++) {
            if (!isNumUsed[num]) {
                isNumUsed[num] = true;
                mapping[ch - 'a'] = num;

                count += crypto(str, idx + 1);

                mapping[ch - 'a'] = 0;
                isNumUsed[num] = false;
            }

        }

        return count;
    }

    private static int stringToNumber(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            res = res * 10 + mapping[ch - 'a'];
        }

        return res;
    }

    private static boolean isValidMapping() {
        if (mapping[str1.charAt(0) - 'a'] == 0 || mapping[str2.charAt(0) - 'a'] == 0
                || mapping[str3.charAt(0) - 'a'] == 0)
            return false;

        int num1 = stringToNumber(str1);
        int num2 = stringToNumber(str2);
        int num3 = stringToNumber(str3);

        return num1 + num2 == num3;
    }

    public static void main(String... args) {
        crypto();
    }
}