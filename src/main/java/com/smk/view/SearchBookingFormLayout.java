package com.smk.view;

import com.smk.dto.ScheduleDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;

import static java.time.ZoneId.systemDefault;

public class SearchBookingFormLayout extends FormLayout {
    private final TextField idTextField = new TextField("");
    private final TextField fromTextField = new TextField("From");
    private final TextField toTextField = new TextField("To");
    private final DatePicker departureDatePicker = new DatePicker("Departure Date");
    private final Button bookButton = new Button("Book");

    public SearchBookingFormLayout() {
        idTextField.setVisible(false);
        add(idTextField, fromTextField, toTextField, departureDatePicker, bookButton);
        configureComponents();
    }

    private void configureComponents() {
        fromTextField.setReadOnly(true);
        toTextField.setReadOnly(true);
        departureDatePicker.setReadOnly(true);

        bookButton.addClickListener(e -> {
            // Implement booking logic here
            // You can show a confirmation dialog or navigate to a booking page
            // For now, let's show a simple notification
            getUI().ifPresent(ui ->
                    ui.getPage().executeJs("alert($0)", "Booking flight with ID " + idTextField.getValue())
            );
        });
    }

    public void setScheduleDTO(ScheduleDTO scheduleDTO) {
        idTextField.setValue(String.valueOf(scheduleDTO.getId()));
        fromTextField.setValue(scheduleDTO.getDepartureLocation());
        toTextField.setValue(scheduleDTO.getArrivalLocation());
        departureDatePicker.setValue(scheduleDTO.getDepartureDate().toInstant().atZone(systemDefault()).toLocalDate());
    }
}
