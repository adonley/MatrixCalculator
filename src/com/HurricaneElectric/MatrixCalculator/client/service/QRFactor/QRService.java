package com.HurricaneElectric.MatrixCalculator.client.service.QRFactor;

import com.HurricaneElectric.MatrixCalculator.shared.QRMatricesAndAnswer;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("qrservice")
public interface QRService extends RemoteService {
	
	QRMatricesAndAnswer qrFactor(String matrixString);

}
