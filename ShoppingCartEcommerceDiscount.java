import java.util.*;

public class ShoppingCartEcommerceDiscount {
	
	
	public static int findLowestPrice(List<List<String>> pdtList, List<List<String>> discountList) {
		int result = 0;
		
		//create discntMap
		Map<String, Map<String, Integer>> discountMap = new HashMap();
		String tag = null;
		String type = null;
		int discount = 0; 
		String discntStr = null;
		
		for(int i = 0; i < discountList.size(); i++) {
			tag = discountList.get(i).get(0);
			type = discountList.get(i).get(1);
			discntStr = discountList.get(i).get(2);
			if(discntStr != null && !discntStr.isEmpty()) {
				discount = Integer.parseInt(discntStr);
			}
			
			
			if(!discountMap.containsKey(tag)) {
				Map<String, Integer> typeMap = new HashMap();
				discountMap.put(tag, typeMap);
			}
			discountMap.get(tag).put(type, discount);
		}
		
		System.out.println(discountMap);
		
		int curMinPrice = 0;
		String curTag = null;
		int minPrice = 0;
		for(int i = 0; i < pdtList.size(); i++) {
			List<String> pdt = pdtList.get(i);
			int pdtPrice = Integer.parseInt(pdt.get(0));
			minPrice = pdtPrice;
			for(int j = 1; j < pdt.size(); j++) {
				curTag =  pdt.get(j);
				if(curTag != null && !curTag.isEmpty()) {
					System.out.println("curTag = "+curTag);
					curMinPrice = getMinPrice(pdtPrice, discountMap.get(curTag));
					if(curMinPrice < minPrice) {
						minPrice = curMinPrice;
					}
				}
				
			}
			result = result + minPrice;
		}
		
		return result;
	}
	
	
	public static int getMinPrice(int pdtPrice, Map<String, Integer> typeMap) {
		int minPrice = 0;
		int curPrice = 0;
		
		for(String type: typeMap.keySet()) {
			int discntVal = typeMap.get(type);
			minPrice = pdtPrice;
			if(type.equals("0")) {
				curPrice = discntVal;
			}
			
			if(type.equals("1")) {
				curPrice = pdtPrice - ((discntVal*pdtPrice)/100);
			}
			
			if(type.equals("2")) {
				curPrice = pdtPrice - discntVal;
			}
			if(curPrice < minPrice) {
				minPrice = curPrice;
			}
		}
		return minPrice;
	}
	
	
	public static void main(String args[]) {
		List<String> pdt1 = new ArrayList();
		pdt1.add("10");
		pdt1.add("d0");
		pdt1.add("d1");
		
		List<String> pdt2 = new ArrayList();
		pdt2.add("15");
		pdt2.add(null);
		pdt2.add(null);
		
		List<String> pdt3 = new ArrayList();
		pdt3.add("20");
		pdt3.add("d1");
		pdt3.add(null);
		
		List<List<String>> pdtList = new ArrayList();
		pdtList.add(pdt1);
		pdtList.add(pdt2);
		pdtList.add(pdt3);
		
		List<List<String>> discountList = new ArrayList();
		List<String> discount1 = new ArrayList();
		List<String> discount2 = new ArrayList();
		discount1.add("d0");discount1.add("1"); discount1.add("27");
		discount2.add("d1");discount2.add("2"); discount2.add("5");
		discountList.add(discount1);
		discountList.add(discount2);
		
		
		
		System.out.println(findLowestPrice(pdtList, discountList));
	}

}
