class LongestCommonPrefixLC14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            result = getMaxMatch(result, strs[i]);
        }
        return result;
    }

    public String getMaxMatch(String result, String actualString) {
        if(actualString == null || actualString == "") {
            return "";
        }

        int i = 0;
        while(i < result.length() && i < actualString.length()) {
            if(result.charAt(i) != actualString.charAt(i)) {
                break;
            } else {
                i++;
            }
        }

        return result.substring(0, i);
    }
}
