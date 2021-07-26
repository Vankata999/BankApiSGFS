package internShip.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import internShip.ERequest;
import internShip.EResponse;
import internShip.EResponse.ResponseStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service

public class EpServisePost {

	public int getRandomInteger(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	public LocalDate getrandomData() {
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}

	/*
	 * public EResponse getRandomResponse( EResponse resp) { int random =
	 * getRandomInteger(1, 10); log.debug("random status : " + random); if(random ==
	 * 1) { return resp.getStatus().DOUBLE_MESSAGE;
	 * 
	 * } else if(random == 0) { return ResponseStatus.INVALID_CODE; } else if(random
	 * == 2) { return ResponseStatus.lOCKED_CARD; } else { return resp.; } }
	 */

	/*
	 * public EResponse checkBill(ERequest request) {
	 * 
	 * 
	 * log.info("Here start checkBill function" ); log.debug("getSubscrNumber->" +
	 * request.getSubscrNumber()); log.debug("getMerchantId->" +
	 * request.getMerchantId()); return getRandomResponse(new
	 * EResponse(ResponseStatus.SUCCESS, getRandomInteger(1, 400),
	 * getRandomInteger(1, 200), getRandomInteger(1, 600), new Date(),
	 * null,null,null)); }
	 */

	public EResponse checkBillBlocked(ERequest request) {
		log.info("Here start checkBillBlocked method");
		log.debug("getTransactionId->" + request.getTransactionId());
		log.debug("getMerchantId->" + request.getMerchantId());
		log.debug("getDt->" + request.getDt());
		log.debug("getSubscrNumber->" + request.getSubscrNumber());

		int amount = getRandomInteger(1, 200);
		
		int fee = getRandomInteger(1, 200);
		
		int total = amount + fee;
		// return getRandomResponse(new EResponse(status(),amount,fee,total,new
		// Date(),null,null,null));
		EResponse newResponse = new EResponse(ResponseStatus.SUCCESS, amount, fee, total, getrandomData(), null, null,
				null);
		return newResponse;

	}

	/*
	 * public EResponse payBill(ERequest request) {
	 * 
	 * }
	 */

}
