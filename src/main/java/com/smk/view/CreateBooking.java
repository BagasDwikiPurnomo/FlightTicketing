package com.smk.view;

import com.smk.MainView;
import com.smk.dao.LocationDao;
import com.smk.model.Location;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

public class CreateBooking  extends VerticalLayout {
    private LocationDao locationDao;
    public CreateBooking() {
        locationDao = new LocationDao();
        createForm();
    }

    private void createForm() {
        setAlignItems(Alignment.STRETCH);
        System.out.println(locationDao.getAll());

        ComboBox<Location> fromComboBox = new ComboBox("Dari");
        fromComboBox.setItems(locationDao.getAll());
        fromComboBox.setItemLabelGenerator(Location::getName);

        ComboBox<Location> toComboBox = new ComboBox("Ke");
        toComboBox.setItems(locationDao.getAll());
        toComboBox.setItemLabelGenerator(Location::getName);

    }
}
