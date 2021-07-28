package internShip.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import internShip.MerchantList;

import internShip.ERequest;
import internShip.EResponse;

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
	
	@PostMapping(value = "/checkBill",consumes = "application/json", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EResponse checkBill(@RequestBody ERequest request)
	{				
	return postRequest.checkBill(request);								
	}
	
	//checkBillBBlocked
	@PostMapping(value = "/checkBillBlocked",consumes = "application/json", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EResponse checkBillBlocked(@RequestBody ERequest request)
	{				
		return postRequest.checkBillBlocked(request);								
	}

	//payBill
	@PostMapping(value = "/payBill",consumes = "application/json",produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EResponse payBill(@RequestBody ERequest request)
	{				
		return postRequest.payBill(request);								
	}

	@PostMapping(value = "/reverseBill",consumes = "application/json", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EResponse reverseBill(@RequestBody ERequest request)
	{				
		return postRequest.reverseBill(request);								
	}
}
