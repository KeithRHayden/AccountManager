package acctMgr.model;

import java.io.IOException;

public class MainJunk {
    public static void main(String[] args) throws IOException {
        
        // Save account list
        AccountModel model = AccountModel.fromLine("1,mark,1888.88");
        AccountList list = new AccountList();
        list.addAccount(model);
        list.save("./account-list.csv");

        // Read account list
        AccountList l = AccountList.load("./account-list.csv");
        for (AccountModel account : l.getAccounts()) {
            System.out.println(account);
        }
    }
}
