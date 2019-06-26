/*
 * MekBuilder - unit design companion of MegaMek
 * Copyright (C) 2017 The MegaMek Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package megameklab.com.ui.view;

import megamek.common.*;
import megamek.common.util.EncodeControl;
import megameklab.com.ui.view.listeners.SVBuildListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Panel for adding crew seating and optional quarters
 */
public class SVCrewView extends BuildView implements ChangeListener {

    private final List<SVBuildListener> listeners = new CopyOnWriteArrayList<>();

    public void addListener(SVBuildListener l) {
        listeners.add(l);
    }

    public void removeListener(SVBuildListener l) {
        listeners.remove(l);
    }

    private final JLabel txtReqBaseCrew = new JLabel();
    private final JLabel txtReqGunners = new JLabel();
    private final JLabel txtReqOther = new JLabel();
    private final JLabel txtReqOfficers = new JLabel();
    private final JLabel txtTotalMinCrew = new JLabel();

    private final JSpinner spnStandardSeats = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtStdSeatWeight = new JLabel();
    private final JSpinner spnPillionSeats = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtPillionWeight = new JLabel();
    private final JSpinner spnEjectionSeats = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtEjectionWeight = new JLabel();

    private final JSpinner spnFirstClass = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtFirstClassWeight = new JLabel();
    private final JLabel txtFirstClassSlots = new JLabel();
    private final JSpinner spnSecondClass = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtSecondClassWeight = new JLabel();
    private final JLabel txtSecondClassSlots = new JLabel();
    private final JSpinner spnCrewQuarters = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtCrewQuartersWeight = new JLabel();
    private final JLabel txtCrewQuartersSlots = new JLabel();
    private final JSpinner spnSteerage = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
    private final JLabel txtSteerageWeight = new JLabel();
    private final JLabel txtSteerageSlots = new JLabel();

    public SVCrewView() {
        initUi();
    }

    private void initUi() {
        setLayout(new GridBagLayout());
        ResourceBundle resourceMap = ResourceBundle.getBundle("megameklab.resources.Views", new EncodeControl()); //$NON-NLS-1$
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        add(createLabel(resourceMap.getString("SVCrewView.lbMinimumCrew.text"), labelSize), gbc); //$NON-NLS-1$

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.txtReqBaseCrew.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        setFieldSize(txtReqBaseCrew, spinnerSize);
        add(txtReqBaseCrew, gbc);
        txtReqBaseCrew.setToolTipText(resourceMap.getString("SVCrewView.txtReqBaseCrew.tooltip"));

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.txtReqGunners.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        setFieldSize(txtReqGunners, spinnerSize);
        add(txtReqGunners, gbc);
        txtReqGunners.setToolTipText(resourceMap.getString("SVCrewView.txtReqGunners.tooltip"));

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.txtReqOther.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        setFieldSize(txtReqOther, spinnerSize);
        add(txtReqOther, gbc);
        txtReqOther.setToolTipText(resourceMap.getString("SVCrewView.txtReqOther.tooltip"));

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.txtReqOfficers.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        setFieldSize(txtReqOfficers, spinnerSize);
        add(txtReqOfficers, gbc);
        txtReqOfficers.setToolTipText(resourceMap.getString("SVCrewView.txtReqOfficers.tooltip"));

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.txtTotalMinCrew.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        setFieldSize(txtTotalMinCrew, spinnerSize);
        add(txtTotalMinCrew, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.lblSeating.text"), labelSizeLg), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        add(createLabel(resourceMap.getString("SVCrewView.lblSeatingWeight.text"), labelSize), gbc); //$NON-NLS-1$

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnStandardSeats.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnStandardSeats, spinnerSize);
        spnStandardSeats.setToolTipText(resourceMap.getString("SVCrewView.spnStandardSeats.tooltip")); //$NON-NLS-1$
        add(spnStandardSeats, gbc);
        spnStandardSeats.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtStdSeatWeight, spinnerSize);
        add(txtStdSeatWeight, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnPillionSeats.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnPillionSeats, spinnerSize);
        spnPillionSeats.setToolTipText(resourceMap.getString("SVCrewView.spnPillionSeats.tooltip")); //$NON-NLS-1$
        add(spnPillionSeats, gbc);
        spnPillionSeats.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtPillionWeight, spinnerSize);
        add(txtPillionWeight, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnEjectionSeats.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnEjectionSeats, spinnerSize);
        spnEjectionSeats.setToolTipText(resourceMap.getString("SVCrewView.spnEjectionSeats.tooltip")); //$NON-NLS-1$
        add(spnEjectionSeats, gbc);
        spnEjectionSeats.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtEjectionWeight, spinnerSize);
        add(txtEjectionWeight, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabel(resourceMap.getString("SVCrewView.lblQuarters.text"), labelSizeLg), gbc); //$NON-NLS-1$
        gbc.gridwidth = 1;
        gbc.gridx = 2;
        add(createLabel(resourceMap.getString("SVCrewView.lblQuartersWeight.text"), labelSize), gbc); //$NON-NLS-1$
        gbc.gridx = 3;
        add(createLabel(resourceMap.getString("SVCrewView.lblQuartersSlots.text"), labelSize), gbc); //$NON-NLS-1$

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnFirstClass.text"), labelSizeLg), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnFirstClass, spinnerSize);
        spnFirstClass.setToolTipText(resourceMap.getString("SVCrewView.spnFirstClass.tooltip")); //$NON-NLS-1$
        add(spnFirstClass, gbc);
        spnFirstClass.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtFirstClassWeight, spinnerSize);
        add(txtFirstClassWeight, gbc);
        gbc.gridx = 3;
        setFieldSize(txtFirstClassSlots, spinnerSize);
        add(txtFirstClassSlots, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnSecondClass.text"), labelSizeLg), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnSecondClass, spinnerSize);
        spnSecondClass.setToolTipText(resourceMap.getString("SVCrewView.spnSecondClass.tooltip")); //$NON-NLS-1$
        add(spnSecondClass, gbc);
        spnSecondClass.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtSecondClassWeight, spinnerSize);
        add(txtSecondClassWeight, gbc);
        gbc.gridx = 3;
        setFieldSize(txtSecondClassSlots, spinnerSize);
        add(txtSecondClassSlots, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnCrewQuarters.text"), labelSizeLg), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnCrewQuarters, spinnerSize);
        spnCrewQuarters.setToolTipText(resourceMap.getString("SVCrewView.spnCrewQuarters.tooltip")); //$NON-NLS-1$
        add(spnCrewQuarters, gbc);
        spnCrewQuarters.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtCrewQuartersWeight, spinnerSize);
        add(txtCrewQuartersWeight, gbc);
        gbc.gridx = 3;
        setFieldSize(txtCrewQuartersSlots, spinnerSize);
        add(txtCrewQuartersSlots, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createLabel(resourceMap.getString("SVCrewView.spnSteerage.text"), labelSizeLg), gbc); //$NON-NLS-1$
        gbc.gridx = 1;
        setFieldSize(spnSteerage, spinnerSize);
        spnSteerage.setToolTipText(resourceMap.getString("SVCrewView.spnSteerage.tooltip")); //$NON-NLS-1$
        add(spnSteerage, gbc);
        spnSteerage.addChangeListener(this);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        setFieldSize(txtSteerageWeight, spinnerSize);
        add(txtSteerageWeight, gbc);
        gbc.gridx = 3;
        setFieldSize(txtSteerageSlots, spinnerSize);
        add(txtSteerageSlots, gbc);
    }

    public void setFromEntity(Entity entity) {
        final int total = Compute.getFullCrewSize(entity);
        final int base = Compute.getSVBaseCrewNeeds(entity);
        final int gunners = Compute.getSupportVehicleGunnerNeeds(entity);
        final int other = Compute.getAdditionalNonGunner(entity);
        txtReqBaseCrew.setText(String.valueOf(base));
        txtReqGunners.setText(String.valueOf(gunners));
        txtReqOther.setText(String.valueOf(other));
        txtReqOfficers.setText(String.valueOf(total - base - gunners - other));
        txtTotalMinCrew.setText(String.valueOf(total));

        int stdSeats = 0;
        int pillion = 0;
        int ejection = 0;
        int firstClass = 0;
        int secondClass = 0;
        int crewQuarters = 0;
        int steerage = 0;
        double firstClassWeight = 0.0;
        double secondClassWeight = 0.0;
        double crewQuartersWeight = 0.0;
        double steerageWeight = 0.0;
        for (Transporter t : entity.getTransports()) {
            if (t instanceof PillionSeatCargoBay) {
                pillion += ((Bay) t).getCapacity();
            } else if (t instanceof EjectionSeatCargoBay) {
                ejection += ((Bay) t).getCapacity();
            } else if (t instanceof StandardSeatCargoBay) {
                stdSeats += ((Bay) t).getCapacity();
            } else if (t instanceof FirstClassQuartersCargoBay) {
                firstClass += ((Bay) t).getCapacity();
                firstClassWeight += ((Bay) t).getWeight();
            } else if (t instanceof SecondClassQuartersCargoBay) {
                secondClass += ((Bay) t).getCapacity();
                secondClassWeight += ((Bay) t).getWeight();
            } else if (t instanceof CrewQuartersCargoBay) {
                crewQuarters += ((Bay) t).getCapacity();
                crewQuartersWeight += ((Bay) t).getWeight();
            } else if (t instanceof SteerageQuartersCargoBay) {
                steerage += ((Bay) t).getCapacity();
                steerageWeight += ((Bay) t).getWeight();
            }
        }
        if ((entity.getWeightClass() == EntityWeightClass.WEIGHT_SMALL_SUPPORT)
                || (entity.getMovementMode().equals(EntityMovementMode.VTOL))
                || (entity.isAero())) {
            spnEjectionSeats.setEnabled(true);
        } else {
            ejection = 0;
            spnEjectionSeats.setEnabled(false);
        }
        spnStandardSeats.removeChangeListener(this);
        spnPillionSeats.removeChangeListener(this);
        spnEjectionSeats.removeChangeListener(this);
        spnFirstClass.removeChangeListener(this);
        spnSecondClass.removeChangeListener(this);
        spnCrewQuarters.removeChangeListener(this);
        spnSteerage.removeChangeListener(this);
        spnStandardSeats.setValue(stdSeats);
        spnPillionSeats.setValue(pillion);
        spnEjectionSeats.setValue(ejection);
        spnFirstClass.setValue(firstClass);
        spnSecondClass.setValue(secondClass);
        spnCrewQuarters.setValue(crewQuarters);
        spnSteerage.setValue(steerage);
        spnStandardSeats.addChangeListener(this);
        spnPillionSeats.addChangeListener(this);
        spnEjectionSeats.addChangeListener(this);
        spnFirstClass.addChangeListener(this);
        spnSecondClass.addChangeListener(this);
        spnCrewQuarters.addChangeListener(this);
        spnSteerage.addChangeListener(this);
        // If the current seating is not enough to meet minimum crew requirements, add standard combat seats
        if (stdSeats + pillion + ejection < total) {
            stdSeats  = total - pillion - ejection;
            spnStandardSeats.setValue(stdSeats);
        }

        int stdWeight = 0;
        int pillionWeight = 0;

        if (entity.getWeightClass() == EntityWeightClass.WEIGHT_SMALL_SUPPORT) {
            // small support vehicles must account for the weight of all seating
            stdWeight = stdSeats;
            pillionWeight = pillion;
        } else if (stdSeats + pillion + ejection > total) {
            // med and lg need only account for extra seating. We'll charge the extra to the ejection seats
            // first, since we always pay for their weight
            int extra = stdSeats + pillion + ejection - total;
            extra = Math.max(0, extra - ejection);
            pillionWeight = Math.min(pillion, extra);
            extra -= pillionWeight;
            stdWeight = Math.min(stdSeats, extra);
        }
        txtStdSeatWeight.setText(String.valueOf(stdWeight * 75));
        txtPillionWeight.setText(String.valueOf(pillionWeight * 25));
        txtEjectionWeight.setText(String.valueOf(ejection * 100));
        txtFirstClassWeight.setText(String.valueOf(firstClassWeight));
        txtSecondClassWeight.setText(String.valueOf(secondClassWeight));
        txtCrewQuartersWeight.setText(String.valueOf(crewQuartersWeight));
        txtSteerageWeight.setText(String.valueOf(steerageWeight));
        txtFirstClassSlots.setText(String.valueOf((int) Math.ceil(firstClass / 5.0)));
        txtSecondClassSlots.setText(String.valueOf((int) Math.ceil(secondClass / 20.0)));
        txtCrewQuartersSlots.setText(String.valueOf((int) Math.ceil(crewQuarters / 20.0)));
        txtSteerageSlots.setText(String.valueOf((int) Math.ceil(steerage / 50.0)));
    }

    /**
     * Convenience method to get the value of a spinner for integers which returns 0 if the value
     * is null.
     *
     * @param spinner A spinner for integer values
     * @return        The spinner's value, or 0 if the value is null.
     * @throws ClassCastException If the spinner's value is not an {@link Integer}
     */
    private int getSpinnerValue(JSpinner spinner) {
        Integer val = (Integer) spinner.getValue();
        if (null != val) {
            return val;
        } else {
            return 0;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if ((e.getSource() == spnStandardSeats)
                || (e.getSource() == spnPillionSeats)
                || (e.getSource() == spnEjectionSeats)) {
            listeners.forEach(l -> l.setSeating(getSpinnerValue(spnStandardSeats),
                    getSpinnerValue(spnPillionSeats), getSpinnerValue(spnEjectionSeats)));
        } else if ((e.getSource() == spnFirstClass)
                || (e.getSource() == spnSecondClass)
                || (e.getSource() == spnCrewQuarters)
                || (e.getSource() == spnSteerage)) {
            listeners.forEach(l -> l.setQuarters(getSpinnerValue(spnFirstClass),
                    getSpinnerValue(spnSecondClass), getSpinnerValue(spnCrewQuarters),
                    getSpinnerValue(spnSteerage)));
        }
    }
}