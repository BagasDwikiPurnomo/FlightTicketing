package com.smk.view;

import com.smk.MainView;
import com.smk.model.Booking;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@PageTitle("Search Booking")
@Route(value = "search-booking", layout = MainView.class)
public class SearchBooking extends VerticalLayout {

    private final TextField flightNumber;
    private final DatePicker departureDate;
    private final Button searchButton;
    private final Grid<Booking> bookingGrid;
    private final Binder<Booking> binder;
    private final BookingService bookingService;

    public SearchBooking(BookingService bookingService) {
        // Initialize the UI components
        flightNumber = new TextField("Flight number");
        departureDate = new DatePicker("Departure date");
        searchButton = new Button("Search");
        bookingGrid = new Grid<>(Booking.class);
        binder = new Binder<>(Booking.class);

        // Configure the UI components
        flightNumber.setRequired(true);
        departureDate.setRequired(true);
        searchButton.addClickListener(e -> searchBooking());
        bookingGrid.setColumns("id", "passengerName", "flightNumber", "departureDate", "seatNumber");
        bookingGrid.setVisible(false);

        // Add the UI components to the layout
        add(flightNumber, departureDate, searchButton, bookingGrid);

        // Initialize the service layer through dependency injection
        this.bookingService = bookingService;
    }

    private void searchBooking() {
        // Get the input values
        String flightNumberValue = flightNumber.getValue();
        LocalDate departureDateValue = departureDate.getValue();

        // Validate the input values
        if (flightNumberValue == null || flightNumberValue.isEmpty()) {
            Notification.show("Please enter a flight number");
            return;
        }
        if (departureDateValue == null) {
            Notification.show("Please select a departure date");
            return;
        }

        // Call the service layer to find the booking
        Booking booking = bookingService.findBookingByFlightNumberAndDepartureDate(flightNumberValue, departureDateValue);

        // Display the booking details or an error message
        if (booking != null) {
            bookingGrid.setItems(booking);
            bookingGrid.setVisible(true);
            binder.setBean(booking);
        } else {
            Notification.show("No booking found for the given flight number and departure date");
            bookingGrid.setVisible(false);
        }
    }
}
