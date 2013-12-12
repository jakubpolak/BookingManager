package com.restclient.listener;

import com.restclient.client.UserClient;
import com.restclient.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class GetAllUsersListener implements ActionListener {

    private UserClient userClient;
    private JTextPane userResponsePanel;

    public GetAllUsersListener(UserClient userClient, JTextPane userResponsePanel) {
        this.userClient = userClient;
        this.userResponsePanel = userResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String output = "";
            for (User user: userClient.getUsers()) {
                output += "ID: " + user.getId() + ", NAME: " + user.getEmail() + ", ROLE: " + user.getRoleByRoleId().getName() + "\n";
            }
            userResponsePanel.setText(output);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error." + "\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
