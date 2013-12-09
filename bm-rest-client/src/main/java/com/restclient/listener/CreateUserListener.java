package com.restclient.listener;

import com.restclient.client.UserClient;
import com.restclient.gui.RoleItem;
import com.restclient.model.Role;
import com.restclient.model.User;
import org.apache.http.HttpStatus;

import javax.swing.*;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class CreateUserListener implements ActionListener {

    private UserClient userClient;
    private final JTextField newUserEmailField;
    private final JTextField newUserPasswordField;
    private JComboBox<RoleItem> newUserRoleCombo;
    private final JTextPane userResponsePanel;

    public CreateUserListener(UserClient userClient,
                              JTextField newUserEmailField,
                              JTextField newUserPasswordField,
                              JComboBox<RoleItem> newUserRoleCombo,
                              JTextPane userResponsePanel)
    {
        this.userClient = userClient;
        this.newUserEmailField = newUserEmailField;
        this.newUserPasswordField = newUserPasswordField;
        this.newUserRoleCombo = newUserRoleCombo;
        this.userResponsePanel = userResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (newUserEmailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill user name first.", "User name required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            User user = new User();
            user.setEmail(newUserEmailField.getText());
            user.setPassword(newUserPasswordField.getText());

            RoleItem roleItem = (RoleItem) newUserRoleCombo.getSelectedItem();
            Role role = new Role();
            role.setId(roleItem.getKey());
            role.setName(roleItem.getLabel());

            user.setRoleByRoleId(role);

            Response response = userClient.createUser(user);

            if (response.getStatus() == HttpStatus.SC_CREATED) {
                userResponsePanel.setText("User \"" + user.getEmail() + "\" created.");
            } else {
                userResponsePanel.setText("Error occurred when creating user.\nResponse: " + response.getStatus());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
