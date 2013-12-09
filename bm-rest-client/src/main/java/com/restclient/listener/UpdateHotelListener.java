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
public class UpdateHotelListener implements ActionListener {

    private HotelClient hotelClient;
    private final JTextField updateHotelIdField;
    private final JTextField updateHotelNameField;
    private final JTextPane hotelResponsePanel;

    public UpdateHotelListener(HotelClient hotelClient, JTextField updateHotelIdField, JTextField updateHotelNameField, JTextPane hotelResponsePanel) {
        this.hotelClient = hotelClient;
        this.updateHotelIdField = updateHotelIdField;
        this.updateHotelNameField = updateHotelNameField;
        this.hotelResponsePanel = hotelResponsePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (updateHotelIdField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill ID first.", "ID required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (updateHotelNameField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "You have to fill hotel new name first.", "Hotel name required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Hotel hotel = new Hotel();
            hotel.setId(Long.parseLong(updateHotelIdField.getText()));
            hotel.setName(updateHotelNameField.getText());

            Response response = hotelClient.updateHotel(hotel);

            if (response.getStatus() == HttpStatus.SC_ACCEPTED) {
                hotelResponsePanel.setText("Hotel was updated with name \"" + hotel.getName() + "\".");
            } else {
                hotelResponsePanel.setText("Error occured when updating hotel.\nResponse: " + response.getStatus());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID has to be a number.", "Numeric ID required", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexpected error.\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
