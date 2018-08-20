package com.prass.gstcalculator.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prass.gstcalculator.model.GstCalModel;
import com.prass.gstcalculator.rest.GstCalController;
import com.prass.gstcalculator.service.GstCalService;
import com.prass.gstcalculator.utils.GstCalServiceUtils;

@Service
public class GstCalServiceImpl implements GstCalService {

	private Logger log = LoggerFactory.getLogger(GstCalController.class);

	@Autowired
	GstCalModel gstCalModel;

	@Autowired
	GstCalServiceUtils gstCalServiceUtils;

	@Override
	public GstCalModel getGstAmountOnBaseAmount(Double baseAmount, Long gstPercentage) throws Exception {

		log.debug("getGstAmountOnBaseAmount() :: baseAmount : gstPercentage : ", baseAmount, gstPercentage);

		gstPercentage = gstCalServiceUtils.gstPercentageValidate(gstPercentage);
		gstCalServiceUtils.amountValidate(baseAmount);

		Double gstAmount = gstCalServiceUtils.getGstAmount(baseAmount, gstPercentage);
		gstCalModel.setBaseAmount(baseAmount);
		gstCalModel.setGstAmount(gstAmount);
		gstCalModel.setGstPercentage(gstPercentage);

		Double totalAmount = gstCalServiceUtils.getTotalAmount(baseAmount, gstAmount);
		gstCalModel.setTotalAmount(totalAmount);
		log.debug("getGstAmountOnBaseAmount() :: gstCalModel : {} : ", gstCalModel);

		return gstCalModel;
	}

	@Override
	public GstCalModel getBaseAmountOntotalAmount(Double totalAmount, Long gstPercentage) throws Exception {
		log.debug("getBaseAmountOntotalAmount() :: totalAmount : gstPercentage : ", totalAmount, gstPercentage);

		gstPercentage = gstCalServiceUtils.gstPercentageValidate(gstPercentage);
		gstCalServiceUtils.amountValidate(totalAmount);

		Double gstAmount = gstCalServiceUtils.getGstAmount(totalAmount, gstPercentage);
		gstCalModel.setTotalAmount(totalAmount);
		gstCalModel.setGstAmount(gstAmount);
		gstCalModel.setGstPercentage(gstPercentage);

		Double baseAmount = gstCalServiceUtils.getBaseAmount(totalAmount, gstAmount);
		gstCalModel.setBaseAmount(baseAmount);
		log.debug("getBaseAmountOntotalAmount() :: gstCalModel : {} : ", gstCalModel);

		return gstCalModel;
	}
}
