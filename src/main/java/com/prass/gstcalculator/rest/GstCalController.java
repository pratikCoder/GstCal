package com.prass.gstcalculator.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prass.gstcalculator.model.GstCalModel;
import com.prass.gstcalculator.service.GstCalService;

@RestController
@RequestMapping(value = "", produces = { "application/JSON" })
public class GstCalController {

	private Logger log = LoggerFactory.getLogger(GstCalController.class);

	@Autowired
	GstCalService gstCalService;

	@GetMapping(value = "")
	public ResponseEntity<GstCalModel> getGstAmountOnBaseAmount(@RequestParam Double baseAmount,
			@RequestParam Long gstPercentage) throws Exception {
		log.debug("getGstAmountOnBaseAmount() :: baseAmount : gstPercentage : ", baseAmount, gstPercentage);

		GstCalModel gstCalModel;

		try {
			gstCalModel = gstCalService.getGstAmountOnBaseAmount(baseAmount, gstPercentage);
			log.debug("getGstAmountOnBaseAmount() :: gstCalModel : {}", gstCalModel);
		} catch (Exception e) {
			log.error("getGstAmountOnBaseAmount() :: Exception : {}", e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<GstCalModel>(gstCalModel, HttpStatus.OK);
	}

	@GetMapping(value = "")
	public ResponseEntity<GstCalModel> getBaseAmountOntotalAmount(@RequestParam Double totalAmount,
			@RequestParam Long gstPercentage) throws Exception {
		log.debug("getGstAmountOnBaseAmount() :: totalAmount : gstPercentage : ", totalAmount, gstPercentage);

		GstCalModel gstCalModel;

		try {
			gstCalModel = gstCalService.getBaseAmountOntotalAmount(totalAmount, gstPercentage);
			log.debug("getGstAmountOnBaseAmount() :: gstCalModel : {}", gstCalModel);
		} catch (Exception e) {
			log.error("getGstAmountOnBaseAmount() :: Exception : {}", e);
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<GstCalModel>(gstCalModel, HttpStatus.OK);
	}
}
