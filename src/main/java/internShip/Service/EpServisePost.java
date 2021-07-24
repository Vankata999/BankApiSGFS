package internShip.Service;


import java.time.LocalDate;
import java.util.Random;

import internShip.RequestParam;
import internShip.ResponseParam;
import internShip.ResponseParam.ResponseStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EpServisePost {

	public int getRandomInteger(int min,int max)
	{
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public LocalDate getrandomData()
	{
		Random random = new Random();
		int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		 LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		 return randomDate;
	}
	
	public ResponseParam getRandomResponse(  ResponseParam.ResponseStatus status,Integer amount,Integer fee,Integer total ,LocalDate validTo,String shortDesc,String londDesc,String secondId)
	{
		return  new ResponseParam(status,amount,fee,total,validTo,shortDesc,londDesc,secondId);
	}
	
	
	
	/*public ResponseParam checkBill(RequestParam request)
	{
	log.info("Here start checkBill function" );
	log.debug("getSubscrNumber->" + request.getSubscrNumber());
	log.debug("getMerchantId->" + request.getMerchantId());
		return getRandomResponse(new ResponseParam(ResponseStatus.SUCCESS,getRandomInteger(1, 400),getRandomInteger(1, 200),getRandomInteger(1, 600),getrandomData(),null,null,null,null));
	}*/
	
	public ResponseParam checkBillBlocked(RequestParam request)
	{
	log.info("Here start checkBill function" );
	log.debug("getSubscrNumber->" + request.getSubscrNumber());
	log.debug("getMerchantId->" + request.getMerchantId());
	int amount = getRandomInteger(1, 200);
	int fee = getRandomInteger(1, 200);
	int total = amount + fee;
		return getRandomResponse(new ResponseParam(ResponseStatus.SUCCESS,amount,fee,total,null,null));
	}
}
