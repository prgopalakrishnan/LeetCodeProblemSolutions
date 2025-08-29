//
///**
//You have a messaging system with N accounts, numbered from 1 to N. Each account can send messages to others, but it's possible 
//that messages only go one way (for example, account 1 can message account 2, but account 2 doesn't have to message account 1).
//
//Recently, the IT department noticed unusual spam behavior and defined a "spammer" account very specifically:
//
//- The account sends messages to every other account (except itself).
//- No other account sends a message back to this account.
//
//You have access to the following function:
//
//`hasMessaged(A, B)`
//
//This function returns `true` if account A has sent a message to account B, and `false` if not.
//
//Using this function, your goal is to find all accounts that meet the exact definition of a spammer.
//
//
//Spammer is Outbound account -> send to all except itself and not receive message back
//
//
//Account A Qualified to be a Spammer account 
//
//B = all accounts except the account we are checking if its a spammer.
//1. Account A == hasMessaged(A, B) T but hasMessaged(B, A) == False
//
//1==N
//Src Dst hasMessaged(Src, Dst) = T hasMessaged(Dst, Src) = F
//
//
//*/
//
//import java.util.*;
//
//
//public class HSTest {
//	
//	public int getSpammerAccounts(int n) {
//		
//		int spammerAccount = 0;
//		
//		//base conditions
//		if(n <= 0) {
//			return spammerAccount;
//		}
//		
//		Set<Integer> nonSpammerAccount = new HashSet<Integer>();
//		for(int i = 2; i <= n; i++) {
//			if(hasMessaged(1, i)) {
//				nonSpammerAccount.add(i);
//			} else {
//				nonSpammerAccount.add(1);
//			}
//
//		}
//		
//		
//		
//		
//		return spammerAccount;
//		
//	}
//	
//	
//	public boolean hasNotRecdMsg(int i, int n) {
//		for(int j = 1; j <= n; j++) {
//			if(hasMessaged(j, i) || !hasMessaged(i,j)) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
//	
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
