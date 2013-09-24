package com.HurricaneElectric.MatrixCalculator.client.GUI;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AnswerBoxUI extends Composite {

	VerticalPanel vPanel = new VerticalPanel();
	FlexTable lTable,uTable;
	Label lbl;
	
	public AnswerBoxUI() {
		
		lTable = new FlexTable();
		//lTable.setStylePrimaryName("border-style:solid; border:1px;");
		uTable = new FlexTable();
		//uTable.setStylePrimaryName("border-style:solid; border:1px;");
		lbl = new Label();
		
		initWidget(vPanel);
	}
	
	public void updateAnswer(String text) {
		
		// Clear everything that might still be displayed.
		clearAnswer();
		
		// Add new label with the string
		lbl.setText(text);
		vPanel.add(lbl);

		return;
	}
	
	public void updateAnswer(double L[][], double U[][]) {
		
		clearAnswer();
		
		// Update Table Cells
		for(int i = 0; i < L.length; i++) {
			for(int j = 0; j < L.length; j++) {
				lTable.setText(i, j,new Double(L[i][j]).toString());
				uTable.setText(i, j,new Double(U[i][j]).toString());
			}
		}
		
		// Add the panels to the table
		vPanel.add(lTable);
		vPanel.add(uTable);
		
		return;
	}
	
	public void clearAnswer() {
		// Clear Everything
		lTable.clear();
		uTable.clear();
		vPanel.clear();
		lbl.setText("");
	}
	
}
