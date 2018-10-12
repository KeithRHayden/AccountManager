package acctMgr.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple container for holding customer accounts.
 */
public class AccountList {
    private List<AccountModel> accounts;

    public AccountList() {
        accounts = new ArrayList<AccountModel>();
    }

    public void addAccount(AccountModel account) {
        this.accounts.add(account);
    }

    /**
     * Read the contents of a file and load them in to an AccountList
     * class instance.
     *
     * @param path The file which contains all the account information.
     * @return Instance of AccountList with all accounts from the file.
     * @throws IOException
     */
    public static AccountList load (String path) throws IOException {
        AccountList list = new AccountList();

        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        // Iterate over each line in the file
        String line;
        while ((line = br.readLine()) != null) {
            list.addAccount(AccountModel.fromLine(line));
        }
        reader.close();
        return list;
    }

    /**
     * Save all the accounts contained in the AccountList
     * to a given file path.
     *
     * @param path The absolute path to the output file.
     * @throws IOException
     */
    public void save(String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        BufferedWriter writer = new BufferedWriter(fw);
        StringBuilder builder = new StringBuilder();
        // Create CSV line for each account and add it
        // to the string builder which will be written
        // to the file.
        for (AccountModel account : this.accounts) {
            builder.append(account.toString());
            // Add new line to the end of the line
            builder.append("\n");
        }
        // Write all lines to the file.
        writer.write(builder.toString());
        writer.close();
    }

    public List<AccountModel> getAccounts () {
        return this.accounts;
    }
}
