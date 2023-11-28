package com.smk.dao;

import com.helger.commons.location.ILocation;
import com.smk.model.Location;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class CreateBooking  extends VerticalLayout {
    private LocationDao locationDao;
    public CreateBooking() {
        locationDao = new LocationDao();
        createForm();
    }

    private void createForm() {
        setAlignItems(Alignment.STRETCH);

        ComboBox<Location> fromComboBox = new ComboBox("Dari");
        fromComboBox.setItems(locationDao.getAll());
        fromComboBox.setItemLabelGenerator(Location::getName);

        ComboBox<Location> toComboBox = new ComboBox("Ke");
        toComboBox.setItems(locationDao.getAll());
        toComboBox.setItemLabelGenerator(Location::getName);

    }
}
