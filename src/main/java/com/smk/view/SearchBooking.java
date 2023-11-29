package com.smk.view;

import com.smk.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Search Booking")
@Route(value = "search-booking", layout = MainView.class)
public class SearchBooking extends VerticalLayout {

    public SearchBooking() {
        // Header
        add(new H1("Search Flights"));

        // Form layout for search criteria
        FormLayout formLayout = new FormLayout();
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1, FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("21em", 2, FormLayout.ResponsiveStep.LabelsPosition.TOP));

        // Departure city
        TextField departureCityField = new TextField("Departure City");
        formLayout.add(departureCityField);

        // Destination city
        TextField destinationCityField = new TextField("Destination City");
        formLayout.add(destinationCityField);

        // Departure date
        DatePicker departureDateField = new DatePicker("Departure Date");
        formLayout.add(departureDateField);

        // Number of passengers
        TextField passengersField = new TextField("Passengers");
        formLayout.add(passengersField);

        // Search button
        Button searchButton = new Button("Search");
        searchButton.addClickListener(event -> searchFlights());
        searchButton.getElement().getStyle().set("width", "100%");
        formLayout.add(searchButton, 2);

        // Display search results
        Label searchResultsLabel = new Label();
        formLayout.add(searchResultsLabel, 2);

        // Add form layout to the main layout
        add(formLayout);
    }

    private void searchFlights() {

    }
}
