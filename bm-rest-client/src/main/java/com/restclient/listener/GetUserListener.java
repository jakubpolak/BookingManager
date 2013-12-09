package com.restclient.listener;

import com.restclient.client.UserClient;
import com.restclient.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class GetUserListener implements ActionListener {

    private UserClient userClient;
    private JTextField getUserIdField;
    private JTextPane userResponsePanel;

    public GetUserListener(UserClient userClient, JTextField getUserIdField, JTextPane userResponsePanel) {
        this.userClient = userClient;
        this.getUserIdField = getUserIdField;
        this.userResponsePanel = userResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getUserIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long userId = Long.parseLong(getUserIdField.getText());
            User user = userClient.getUser(userId);
            if (user == null) {
                userResponsePanel.setText("User does not exist.");
            } else {
                userResponsePanel.setText("ID: " + user.getId() + ", NAME: " + user.getEmail() + ", ROLE: " + user.getRoleByRoleId().getName());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
