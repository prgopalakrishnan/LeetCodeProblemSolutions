import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		Map<String, List<List<String>>> map = new HashMap();
		List strList = new ArrayList();
		strList.add(s.substring(s.length() - 1));
		List partitionList = new ArrayList();
		partitionList.add(strList);
		map.put(s.substring(s.length() - 1), partitionList);

		int n = s.length();
		for (int i = n - 2; i >= 0; i--) {
			String curStr = s.substring(i);
			List tmpPartitionList = new ArrayList();
			for (int j = 0; j < curStr.length(); j++) {

				if (isPalindrome(curStr.substring(0, j + 1)) && j + 1 <= curStr.length()) {
					if (map.containsKey(curStr.substring(j + 1))) {
						List<List<String>> list = map.get(curStr.substring(j + 1));

						List tmpSubstringList = null;
						if (list != null && list.size() > 0) {
							for (List substringList : list) {
								tmpSubstringList = new ArrayList();
								tmpSubstringList.addAll(substringList);
								tmpSubstringList.add(curStr.substring(0, j + 1));
								tmpPartitionList.add(tmpSubstringList);
							}
						}

					}
				}
			}
			map.put(curStr, tmpPartitionList);
		}
		if (isPalindrome(s)) {
			List wholeStringList = new ArrayList();
			wholeStringList.add(s);
			map.get(s).addAll(wholeStringList);
		}
		return map.get(s);
	}

	boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}

	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("bb"));
	}
}
