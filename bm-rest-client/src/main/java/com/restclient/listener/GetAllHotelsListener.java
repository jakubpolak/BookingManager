package com.restclient.listener;

import com.restclient.client.HotelClient;
import com.restclient.model.Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class GetAllHotelsListener implements ActionListener {

    private HotelClient hotelClient;
    private JTextPane hotelResponsePanel;

    public GetAllHotelsListener(HotelClient hotelClient, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String output = "";
            for (Hotel hotel: hotelClient.getHotels()) {
                output += "ID: " + hotel.getId() + ", NAME: " + hotel.getName() + "\n";
            }
            hotelResponsePanel.setText(output);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + "\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
