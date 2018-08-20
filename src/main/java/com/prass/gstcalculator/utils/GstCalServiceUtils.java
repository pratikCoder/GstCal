package com.prass.gstcalculator.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prass.gstcalculator.rest.GstCalController;

public class GstCalServiceUtils {

	private Logger log = LoggerFactory.getLogger(GstCalController.class);

	public Double getGstAmount(Double baseAmount, Long gstPercentage) {
		log.debug("getGstAmountOnBaseAmount() :: baseAmount : gstPercentage : ", baseAmount, gstPercentage);
		log.debug("getGstAmountOnBaseAmount() :: baseAmount * (gstPercentage / 100) : ",
				baseAmount * (gstPercentage / 100));

		return baseAmount * (gstPercentage / 100);
	}

	public Double getTotalAmount(Double baseAmount, Double gstAmount) {
		log.debug("getGstAmountOnBaseAmount() :: baseAmount : gstAmount : ", baseAmount, gstAmount);
		log.debug("getGstAmountOnBaseAmount() :: baseAmount + gstAmount : ", baseAmount + gstAmount);
		return baseAmount + gstAmount;
	}

	public Long gstPercentageValidate(Long gstPercentage) throws Exception {
		log.debug("gstPercentageValidate() :: gstPercentage : ", gstPercentage);
		if (gstPercentage > 0) {
			if (!(gstPercentage == 5 || gstPercentage == 12 || gstPercentage == 18 || gstPercentage == 28)) {
				log.error("gstPercentageValidate() :: \"Invalid GST percentages\"");
				throw new Exception("Invalid GST percentages");
			}
		} else if (gstPercentage < 0) {
			if (!(gstPercentage == -5 || gstPercentage == -12 || gstPercentage == -18 || gstPercentage == -28)) {
				log.error("gstPercentageValidate ():: \"Invalid GST percentages\"");
				throw new Exception("Invalid GST percentages");
			} else {
				gstPercentage = Math.abs(gstPercentage);
			}
		} else {
			log.error("gstPercentageValidate() :: \"GST percentage is not be zero\"");
			throw new Exception("GST percentage is not be zero");
		}
		log.debug("gstPercentageValidate() :: gstPercentage : ", gstPercentage);
		return gstPercentage;
	}

	public void amountValidate(Double baseAmount) throws Exception {
		log.debug("amountValidate() :: baseAmount : ", baseAmount);
		if (baseAmount <= 0) {
			log.error("amountValidate() :: \"Invalid Amount\"");
			throw new Exception("Invalid Amount");
		}
	}

	public Double getBaseAmount(Double totalAmount, Double gstAmount) {
		log.debug("getBaseAmount() :: totalAmount : gstAmount : ", totalAmount, gstAmount);

		log.debug("getBaseAmount() :: totalAmount - gstAmount : {} ", totalAmount - gstAmount);
		return totalAmount - gstAmount;
	}
}
