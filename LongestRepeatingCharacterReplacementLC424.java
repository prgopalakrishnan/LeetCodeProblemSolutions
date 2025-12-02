class LongestRepeatingCharacterReplacementLC424 {
    public int characterReplacement(String s, int k) {
        if(s == null) {
            return 0;
        }
        int maxLength = 0; int curLength = 0;
        int leftPtr = 0; int rightPtr = 0;
        Map<Character, Integer> charCountMap = new HashMap();
        int maxFreq = 0;
        while(rightPtr < s.length()) {
            charCountMap.put(s.charAt(rightPtr), charCountMap.getOrDefault(s.charAt(rightPtr), 0)+1);
            maxFreq = getMaxFreq(charCountMap);
            if(((rightPtr - leftPtr+1)-maxFreq) <= k) {
                curLength = rightPtr - leftPtr+1;
                maxLength = (maxLength < curLength) ? curLength : maxLength;
            } else {
                charCountMap.put(s.charAt(leftPtr),charCountMap.get(s.charAt(leftPtr))-1);
                leftPtr++;
            }
            rightPtr++;
        }
        return maxLength;
    }

    public int getMaxFreq(Map<Character, Integer> charCountMap) {
        int maxFreq = 0;
        for(Character c : charCountMap.keySet()) {
            maxFreq = (maxFreq < charCountMap.get(c)) ? charCountMap.get(c) : maxFreq;
        }
        return maxFreq;
    }

    
}
