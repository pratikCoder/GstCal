package com.prass.gstcalculator.service;

import com.prass.gstcalculator.model.GstCalModel;

public interface GstCalService {

	public GstCalModel getGstAmountOnBaseAmount(Double baseAmount, Long gstPercentage) throws Exception;

	public GstCalModel getBaseAmountOntotalAmount(Double baseAmount, Long gstPercentage) throws Exception;
}
