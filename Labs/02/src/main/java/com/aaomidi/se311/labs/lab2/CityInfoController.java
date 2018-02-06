package com.aaomidi.se311.labs.lab2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * SE 311 Lab 2
 * <p>
 * The controller for the program.
 * </p>
 *
 * @version 1.0
 */
public class CityInfoController {
    private CityModel model;
    private CityInfoInputWindow inputView;

    /**
     * Creates new CityInfoController
     */
    public CityInfoController() {
        // intentionally empty
    }

    /**
     * @return CityModel: the model
     */
    public CityModel getModel() { // future use
        return model;
    }

    /**
     * @param model to set as the model
     */
    public void setModel(CityModel model) {
        this.model = model;
    }

    /**
     * @return the window (in case it needs to be sent messages from elsewhere)
     */
    public CityInfoInputWindow getInputWindow() { // future use
        return inputView;
    }

    /**
     * @param theView on which the listeners should be set
     */
    public void setInputWindow(CityInfoInputWindow theView) {
        inputView = theView;

        // Register listeners
        inputView.getAddCityButton().addActionListener(new AddCityListener());
        inputView.getClearCitysButton().addActionListener(new ClearCityListListener());
        inputView.getClearInputButton().addActionListener(new ClearInputFieldsListener());


        System.out.println("listeners registered in controller for input window");
    }

    /**
     * AddCityListener provides a method to create a new city. The city
     * should then be added to the city list of the model. The values for the
     * new city come from the fields of the inputView. If the model is null
     * when the method is called, it returns without taking any action.
     */
    private class AddCityListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model == null) return;
            String cityName = inputView.jtfName.getText();
            String cityPopulation = inputView.jtfPopulation.getText();
            String cityState = inputView.jtfState.getText();
            String censusYear = (String) inputView.jcbYear.getSelectedItem();

            if (cityName == null || cityPopulation == null || cityState == null || censusYear == null)
                return;

            Long cityPop = null;
            Integer census = null;
            // Make sure both of these are numbers.

            try {
                cityPop = Long.valueOf(cityPopulation);
                census = Integer.valueOf(censusYear);
            } catch (NumberFormatException ex) {
                return;
            }

            City city = new City(cityName, cityState, String.format("%,d",cityPop), String.valueOf(census));
            model.addToCitList(city);
        }
    }

    /**
     * ClearCityListListener provides a method to clear the city list of the
     * model. If the model is null when the method is called, it returns without
     * taking any action.
     */
    private class ClearCityListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (model == null) return;

            model.clearCityList();
        }


    }

    /**
     * ClearInputFieldsListener provides a method to clear the input fields of
     * the inputView.
     */
    private class ClearInputFieldsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            inputView.clearInputFields();
        }
    }
}