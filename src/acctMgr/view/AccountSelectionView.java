package acctMgr.view;

import acctMgr.controller.AbstractController;
import acctMgr.controller.Controller;
import acctMgr.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountSelectionView extends JFrameView {

    /**
     * Constructor for JFrameView
     *
     * @param model      - model to be set to view.
     * @param controller controller to be set to view.
     */
    public AccountSelectionView(Model model, Controller controller) {
        super(model, controller);
        GridBagLayout layout = new GridBagLayout();
        this.getContentPane().setLayout(layout);

        AccountList ac = new AccountList();
        ac.addAccount(new AccountModel(BigInteger.valueOf(1), "Mark Sanders", BigDecimal.valueOf(17L)));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        JComboBox<AccountModel> accountSelector = new JComboBox<>();
        for (AccountModel account : ac.getAccounts()) {
            accountSelector.addItem(account);
        }
        this.getContentPane().add(accountSelector, constraints);
        accountSelector.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                AccountModel model = accountSelector.getItemAt(accountSelector.getSelectedIndex());
                AccountView view = new AccountView(model, new AbstractController() {
                    @Override
                    public void setModel(Model model) {
                        super.setModel(model);
                    }
                });
                view.setVisible(true);
            }
        });
        this.pack();
    }

    @Override
    public void modelChanged(ModelEvent me) {

    }
}