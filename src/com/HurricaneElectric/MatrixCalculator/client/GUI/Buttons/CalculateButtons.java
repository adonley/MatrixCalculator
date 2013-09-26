package com.HurricaneElectric.MatrixCalculator.client.GUI.Buttons;

import com.HurricaneElectric.MatrixCalculator.client.service.ServiceController;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.RootPanel;

public class CalculateButtons {

	private CalculateButton QR;
	private CalculateButton LU;
	private CalculateButton inversion;
	
	public CalculateButtons(final ServiceController controller) {
		
		setQR(new CalculateButton("QR Factorization", new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.qrFactor(controller.getGUI().getTextArea());
			}	
		}));
		
		setLU(new CalculateButton("LU Factorization", new ClickHandler() {
			public void onClick(ClickEvent event) {
				controller.luFactor(controller.getGUI().getTextArea());
			}	
		}));
		
		setInversion(new CalculateButton("Invert Matrix", new ClickHandler() {
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub	
			}	
		}));
		
		addButtons();
		
	}

	public CalculateButton getQR() {
		return QR;
	}

	public void setQR(CalculateButton qR) {
		QR = qR;
	}

	public CalculateButton getLU() {
		return LU;
	}

	public void setLU(CalculateButton lU) {
		LU = lU;
	}

	public CalculateButton getInversion() {
		return inversion;
	}

	public void setInversion(CalculateButton inversion) {
		this.inversion = inversion;
	}
	
	private void addButtons() {
		RootPanel.get("LU").add(this.getLU());
		RootPanel.get("QR").add(this.getQR());
		RootPanel.get("Invert").add(this.getInversion());
	}
	
	
}
