package internShip.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import internShip.MerchantList;
import internShip.errormessages.ErrorMessage;
import internShip.ERequest;
import internShip.EResponse;
import internShip.EResponse.ResponseStatus;
import internShip.service.EasyPayService;
import internShip.service.EpServisePost;


@RestController
//getMerchantDate
public class EasyPayController {
	@Autowired
	private EasyPayService service;
	//@Autowired
	
	@GetMapping(value = "/merchant")
	public MerchantList merch()
	{

		return service.getMerchant();
	}
	

	
			
//checkBill	
	
	@Autowired
	private EpServisePost postRequest ;
	//private ErrorMessage mess;
	
	@PostMapping(value = "/bills",consumes = "application/json", produces = "application/json")
	public EResponse checkBill(@RequestBody ERequest request)
	{
		
		
		return postRequest.checkBillBlocked(request);
		
		
		
	/*	if( postRequest.checkBill(request).getStatus() == ResponseStatus.SUCCESS)
		{
			return postRequest.checkBill(request);
		}
		else
		{
			return mess.
		}*/
		
		
		
		
	}
}
	

	

