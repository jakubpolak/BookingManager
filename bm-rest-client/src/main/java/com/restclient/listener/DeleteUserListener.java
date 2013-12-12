package com.restclient.listener;

import com.restclient.client.UserClient;
import org.apache.http.HttpStatus;

import javax.swing.*;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class DeleteUserListener implements ActionListener {

    private UserClient userClient;
    private final JTextField deleteUserIdField;
    private final JTextPane userResponsePanel;

    public DeleteUserListener(UserClient userClient, JTextField deleteUserIdField, JTextPane userResponsePanel) {
        this.userClient = userClient;
        this.deleteUserIdField = deleteUserIdField;
        this.userResponsePanel = userResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (deleteUserIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long userId = Long.parseLong(deleteUserIdField.getText());
            Response response = userClient.deleteUser(userId);

            if (response.getStatus() == HttpStatus.SC_NO_CONTENT) {
                userResponsePanel.setText("User was deleted.");
            } else {
                userResponsePanel.setText("Error occurred when deleting user.\nResponse: " + response.getStatus());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
