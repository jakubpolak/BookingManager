package com.restclient.listener;

import com.restclient.client.HotelClient;
import com.restclient.model.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class GetHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private JTextField getHotelIdField;
    private JTextPane hotelResponsePanel;

    public GetHotelListener(HotelClient hotelClient, JTextField getHotelIdField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.getHotelIdField = getHotelIdField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getHotelIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Long hotelId = Long.parseLong(getHotelIdField.getText());
            Hotel hotel = hotelClient.getHotel(hotelId);
            if (hotel == null) {
                hotelResponsePanel.setText("Hotel does not exist.");
            } else {
                hotelResponsePanel.setText("ID: " + hotel.getId() + ", NAME: " + hotel.getName());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
