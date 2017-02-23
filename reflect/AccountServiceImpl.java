package reflect;

public class AccountServiceImpl implements AccountService{

	@Override
	public void transfer(String fromAccount, String toAccount, int amount) {
		// TODO Auto-generated method stub
		System.out.println("Transfer " + amount + " from " + fromAccount + " to " + toAccount);
	}

	@Override
	public void query(String accountId) {
		// TODO Auto-generated method stub
		System.out.println("query account id: " + accountId);
	}
	
}