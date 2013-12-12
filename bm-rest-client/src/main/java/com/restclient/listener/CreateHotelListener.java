package com.restclient.listener;

import com.restclient.client.HotelClient;
import com.restclient.model.Hotel;
import org.apache.http.HttpStatus;

import javax.swing.*;
import javax.ws.rs.core.Response;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jan Hrubeš
 */
public class CreateHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private final JTextField newHotelNameField;
    private final JTextPane hotelResponsePanel;

    public CreateHotelListener(HotelClient hotelClient, JTextField newHotelNameField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.newHotelNameField = newHotelNameField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (newHotelNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill hotel name first.", "Hotel name required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Hotel hotel = new Hotel();
            hotel.setName(newHotelNameField.getText());

            Response response = hotelClient.createHotel(hotel);
            if (response.getStatus() == HttpStatus.SC_CREATED) {
                hotelResponsePanel.setText("Hotel with name: \"" + newHotelNameField.getText() + "\" created.");
            } else {
                hotelResponsePanel.setText("Error occurred.\nResponse: " + response.getStatus());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
