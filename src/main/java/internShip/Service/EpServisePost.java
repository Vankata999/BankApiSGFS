package internShip.service;

import java.time.LocalDate;

import java.util.Random;

import org.springframework.stereotype.Service;

import internShip.ERequest;
import internShip.EResponse;
import internShip.EResponse.ResponseStatus;
import internShip.errormessages.ErrorMessage;

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

	
	 public EResponse getRandomResponse( EResponse successResp) 
	 {
		 int random = getRandomInteger(1, 50);
		 switch (random) {
		case 1:
			throw new	ErrorMessage(ResponseStatus.DOUBLE_MESSAGE);
		case 2:
			throw new	ErrorMessage(ResponseStatus.DUTY_BLOCKED);
		case 3:
			throw new	ErrorMessage(ResponseStatus.G_ERROR);
		case 4:
			throw new	ErrorMessage(ResponseStatus.INVALID_CODE);
		case 5:
			throw new	ErrorMessage(ResponseStatus.INVALID_FORMAT);
		case 6:
			throw new	ErrorMessage(ResponseStatus.INVALID_SUM);
		case 7:
			throw new	ErrorMessage(ResponseStatus.lOCKED_CARD);
		case 8:
			throw new	ErrorMessage(ResponseStatus.NO_INFO_FOR_MERCHANT);
		case 9:
			throw new	ErrorMessage(ResponseStatus.NO_SUCH_MERCHANT);
		case 10:
			throw new	ErrorMessage(ResponseStatus.NOPENDING);
		case 11:
			throw new	ErrorMessage(ResponseStatus.OLD_PENDING);
		case 12:
			throw new	ErrorMessage(ResponseStatus.OUT_OF_PERIOD);
		case 13:
			throw new	ErrorMessage(ResponseStatus.TEMPORARA_UNAVAILABLE);
		default:
			log.debug("SuccessFull end");
			return successResp;
		}
		 
	 }

	
	  public EResponse checkBill(ERequest request) {
	  
	 
	 log.info("Here start checkBill function" ); 
	 log.debug("getSubscrNumber->" + request.getSubscrNumber());
	 log.debug("getMerchantId->" +
	  request.getMerchantId());
	   return getRandomResponse(new EResponse (ResponseStatus.SUCCESS,getRandomInteger(1, 220),getRandomInteger(0, 400),getRandomInteger(0, 400),getrandomData(),null,null,null));
	   }
	 

	public EResponse checkBillBlocked(ERequest request) {
		log.info("Here start checkBillBlocked method");
		log.debug("getTransactionId->" + request.getTransactionId());
		log.debug("getMerchantId->" + request.getMerchantId());
		log.debug("getDt->" + request.getDt());
		log.debug("getSubscrNumber->" + request.getSubscrNumber());

		int amount = getRandomInteger(1, 200);
		
		int fee = getRandomInteger(1, 200);
		
		int total = amount + fee;
		
		return getRandomResponse(new EResponse(ResponseStatus.SUCCESS, amount, fee, total, getrandomData(), null, null,
				null));
		

	}

	
	  public EResponse payBill(ERequest request) {
		  log.info("Here start payBill method");
			log.debug("getTransactionId->" + request.getTransactionId());
			log.debug("getMerchantId->" + request.getMerchantId());
			log.debug("getAmount->" + request.getAmount());
			log.debug("getDt->" + request.getDt());
			log.debug("getSubscrNumber->" + request.getSubscrNumber());
			return getRandomResponse(new EResponse(ResponseStatus.SUCCESS, null, null, null, null, null, null,
					null));
	  }
	 
	  public EResponse  reverseBill(ERequest request) {
		  log.info("Here start payBill method");
			log.debug("getTransactionId->" + request.getTransactionId());
			log.debug("getMerchantId->" + request.getMerchantId());
			log.debug("getAmount->" + request.getAmount());
			log.debug("getDt->" + request.getDt());
			log.debug("getSubscrNumber->" + request.getSubscrNumber());
			return getRandomResponse(new EResponse(ResponseStatus.SUCCESS, null, null, null,null, null, null,
					null));
	  }
}
