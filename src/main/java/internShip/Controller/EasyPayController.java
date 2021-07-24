package internShip.Controller;




import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import internShip.ResponseParam;

import internShip.MerchantList;

import internShip.Service.EasyPayService;


@RestController
//getMerchantDate
public class EasyPayController {
	@Autowired
	private EasyPayService service;
	//@Autowired
	//private EasyPayService serviceBill;
	@GetMapping(value = "/merchant")
	public MerchantList merch()
	{

		return service.getMerchant();
	}
	


			
//checkBill	
	//@PostMapping(value = "/bills",consumes = "application/json", produces = "application/json");
	
	
}
	

