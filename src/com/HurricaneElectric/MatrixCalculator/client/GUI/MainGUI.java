package com.HurricaneElectric.MatrixCalculator.client.GUI;

import com.HurricaneElectric.MatrixCalculator.client.service.LUServiceClientImplementation;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainGUI extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	// This text area will always be visible so let's not move it to another file.
	private TextArea textArea;
	private Button submit;
	protected LUServiceClientImplementation clientImp;
	
	public MainGUI(LUServiceClientImplementation clientImp) {
		com.google.gwt.dom.client.Element matrixDiv = Document.get().getElementById("matrixInput");
		
		this.clientImp = clientImp;
		
		// Text Area for Matrix input.
		String clientWidth = Math.floor(matrixDiv.getClientWidth() - 20) + "px";
		String clientHeight = Math.floor((matrixDiv.getClientWidth() - 20) * .5) + "px";
		textArea = new TextArea();
		textArea.setWidth(clientWidth);
		textArea.setHeight(clientHeight);  
		textArea.setStylePrimaryName("resize:none;");
		
		// Create and Add the button
		submit = new Button("Calculate");
		submit.addClickHandler(new CalculateHandler());
		
		
		// Add The Text Area to the Vertical Panel
		vPanel.add(textArea);
		vPanel.add(submit);
		
		initWidget(vPanel);
	}
	
	public void setTextArea(String text) { textArea.setText(text); }
	public void clearTextArea() { textArea.setText(""); }
	public String getTextArea() { return textArea.getText(); }
	
	private class CalculateHandler implements ClickHandler {

		public void onClick(ClickEvent event) {	
			 clientImp.luFactor(textArea.getText());
		}	
	}
	
	public void updateLU(double L[][], double U[][]) {
		
		String formattedMatrices = new String("");
		
		for(int i = 0; i < L.length; i++) {
			for(int j = 0; j < L.length; j++) {
				formattedMatrices += L[i][j] + " ";
			}
			
			formattedMatrices += "      ";
			
			for(int k = 0; k < U.length; k++) {
				formattedMatrices += U[i][k] + " ";
			}
			
			formattedMatrices += "\n";
		}
		
		clearTextArea();
		setTextArea(formattedMatrices);
		
	}
	
}
