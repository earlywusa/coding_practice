package reflect;

public interface AccountService {
	public void transfer(String fromAccount,
			String toAccount,
			int amount);
	public void query(String accountId);
}


