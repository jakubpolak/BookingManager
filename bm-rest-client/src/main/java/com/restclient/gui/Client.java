package com.restclient.gui;

import com.restclient.client.HotelClient;
import com.restclient.client.UserClient;
import com.restclient.listener.*;
import com.restclient.model.Role;

import javax.swing.*;
import javax.ws.rs.BadRequestException;
import java.util.List;

/**
 * @author Jan Hrubeš
 */
public class Client {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JPanel hotelPanel;
    private JPanel userPanel;
    private JTextField newHotelNameField;
    private JButton createHotelButton;
    private JTextField updateHotelIdField;
    private JTextField updateHotelNameField;
    private JButton updateHotelButton;
    private JTextField deleteHotelIdField;
    private JButton deleteHotelButton;
    private JTextField getHotelIdField;
    private JButton getHotelButton;
    private JButton getAllHotelsButton;
    private JTextPane hotelResponsePanel;
    private JTextField newUserEmailField;
    private JButton createUserButton;
    private JTextField getUserIdField;
    private JButton getUserButton;
    private JButton updateUserButton;
    private JButton deleteUserButton;
    private JTextField updateUserIdField;
    private JTextField updateUserEmailField;
    private JTextField deleteUserIdField;
    private JTextPane userResponsePanel;
    private JComboBox newUserRoleCombo;
    private JButton getAllUsersButton;
    private JComboBox updateUserRoleCombo;
    private JPasswordField newUserPasswordField;
    private JPasswordField updateUserPasswordField;

    public Client() {
        String host = "http://localhost:8080/rest";
//        String host = "http://bookingmanager.apiary.io";
        HotelClient hotelClient = new HotelClient(host);
        UserClient userClient = new UserClient(host);

        setRolesCombos(userClient);


        createHotelButton.addActionListener(new CreateHotelListener(hotelClient, newHotelNameField, hotelResponsePanel));
        getHotelButton.addActionListener(new GetHotelListener(hotelClient, getHotelIdField, hotelResponsePanel));
        getAllHotelsButton.addActionListener(new GetAllHotelsListener(hotelClient, hotelResponsePanel));
        updateHotelButton.addActionListener(new UpdateHotelListener(hotelClient, updateHotelIdField, updateHotelNameField, hotelResponsePanel));
        deleteHotelButton.addActionListener(new DeleteHotelListener(hotelClient, deleteHotelIdField, hotelResponsePanel));

        createUserButton.addActionListener(new CreateUserListener(userClient, newUserEmailField, newUserPasswordField, newUserRoleCombo, userResponsePanel));
        getUserButton.addActionListener(new GetUserListener(userClient, getUserIdField, userResponsePanel));
        getAllUsersButton.addActionListener(new GetAllUsersListener(userClient, userResponsePanel));
        updateUserButton.addActionListener(new UpdateUserListener(userClient, updateUserIdField, updateUserEmailField, updateUserPasswordField, updateUserRoleCombo, userResponsePanel));
        deleteUserButton.addActionListener(new DeleteUserListener(userClient, deleteUserIdField, userResponsePanel));
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Client");
        frame.setContentPane(new Client().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void setRolesCombos(UserClient userClient)
    {
        try {
            List<Role> roleList = userClient.getRoles();

            if (roleList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No roles obtained from server.", "No roles found", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Role role: roleList) {
                RoleItem roleItem = new RoleItem(role.getId(), role.getName());
                newUserRoleCombo.addItem(roleItem);
                updateUserRoleCombo.addItem(roleItem);
            }
        } catch (BadRequestException ex) {
            JOptionPane.showMessageDialog(null, "Host does not provide necessary data api.", "No roles found", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(-1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Could not reach server.", "No server found", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(-1);
        }

    }

    private void createUIComponents() {
        newUserRoleCombo = new JComboBox();
        updateUserRoleCombo = new JComboBox();
    }
}
