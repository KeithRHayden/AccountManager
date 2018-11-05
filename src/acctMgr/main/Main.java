package acctMgr.main;

import acctMgr.controller.AccountSelectionController;
import acctMgr.model.AccountList;
import acctMgr.model.AccountModel;
import acctMgr.model.AccountSelectionModel;
import acctMgr.view.AccountSelectionView;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AccountSelectionModel model = new AccountSelectionModel();
        AccountSelectionController controller = new AccountSelectionController();
        AccountSelectionView frame = new AccountSelectionView(model, controller);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }
}
