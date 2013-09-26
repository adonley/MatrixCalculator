package com.HurricaneElectric.MatrixCalculator.client.GUI;

import com.HurricaneElectric.MatrixCalculator.client.GUI.Buttons.CalculateButtons;
import com.HurricaneElectric.MatrixCalculator.client.service.ServiceController;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MainGUI extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	// This text area will always be visible so let's not move it to another file.
	private TextArea textArea;
	protected ServiceController controller;
	private AnswerBoxUI answerBox;
	private CalculateButtons buttons;
	
	public MainGUI(ServiceController serviceController) {
		
		com.google.gwt.dom.client.Element matrixDiv = Document.get().getElementById("matrixInput");
		answerBox = new AnswerBoxUI();
		
		this.controller = serviceController;
		
		// Text Area for Matrix input.
		String clientWidth = Math.floor(matrixDiv.getClientWidth() - 20) + "px";
		String clientHeight = Math.floor((matrixDiv.getClientWidth() - 20) * .5) + "px";
		textArea = new TextArea();
		textArea.setWidth(clientWidth);
		textArea.setHeight(clientHeight);  
		textArea.setStylePrimaryName("resize:none;");
		
		// Add The Text Area to the Vertical Panel
		vPanel.add(textArea);
		vPanel.add(answerBox);
		
		// This is a horrible way to do this, but I am using it for testing right now
		buttons = new CalculateButtons(controller);
		
		initWidget(vPanel);
		
	}
	
	public void setTextArea(String text) { textArea.setText(text); }
	public void clearTextArea() { textArea.setText(""); }
	public String getTextArea() { return textArea.getText(); }
	
	public String getText() { return textArea.getText(); }
	
	public void updateAnswer(double L[][], double U[][]) { 
		answerBox.updateAnswer(L, U);
	}
	
	public void updateError(String text) { 
		answerBox.updateAnswer(text);
	}
	
}
