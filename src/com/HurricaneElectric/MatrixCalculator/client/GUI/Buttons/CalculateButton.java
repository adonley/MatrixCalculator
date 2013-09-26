package com.HurricaneElectric.MatrixCalculator.client.GUI.Buttons;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CalculateButton extends Composite {
	
	protected Button button;
	protected VerticalPanel vPanel;
	
	public CalculateButton(String name, ClickHandler handler) {
		
		vPanel = new VerticalPanel();	
		button = new Button(name);
		button.addClickHandler(handler);
		vPanel.add(button);
		initWidget(vPanel);
		
	}	

}
