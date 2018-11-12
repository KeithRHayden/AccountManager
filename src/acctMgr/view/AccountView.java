package acctMgr.view;

import acctMgr.controller.Controller;
import acctMgr.model.AccountModel;
import acctMgr.model.Model;
import acctMgr.model.ModelEvent;
import acctMgr.model.OverdraftException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class AccountView extends JFrameView {

    private JLabel accountBalanceLabel;

    /**
     * Constructor for JFrameView
     *
     * @param model      - model to be set to view.
     * @param controller controller to be set to view.
     */
    public AccountView(Model model, Controller controller) {
        super(model, controller);
        GridBagLayout layout = new GridBagLayout();
        this.getContentPane().setLayout(layout);

        accountBalanceLabel = new JLabel();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.getContentPane().add(new JLabel("Account Balance: "), c);

        GridBagConstraints d = new GridBagConstraints();
        d.fill = GridBagConstraints.HORIZONTAL;
        d.gridx = 1;
        d.gridy = 0;
        this.getContentPane().add(accountBalanceLabel, d);
        this.pack();

        JTextField balanceEntry = new JTextField();
        balanceEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double balance = Double.valueOf(balanceEntry.getText());
                AccountModel model = (AccountModel) AccountView.this.getModel();
                try {
                    model.withdraw(BigDecimal.valueOf(balance));
                } catch (OverdraftException ex) {
                    JOptionPane.showMessageDialog(AccountView.this, "Insufficient Funds");
                }
            }
        });

        GridBagConstraints e = new GridBagConstraints();
        e.fill = GridBagConstraints.HORIZONTAL;
        e.gridx = 0;
        e.gridy = 1;
        e.gridwidth = 2;
        this.getContentPane().add(balanceEntry, e);
    }

    @Override
    public void modelChanged(ModelEvent me) {
    }
}
