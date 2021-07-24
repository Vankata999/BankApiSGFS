package internShip.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.List;

import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Service;

import internShip.ResponseParam;

import internShip.Merchant;
import internShip.MerchantList;


@Service
public class EasyPayService {

	
	LocalDate today = LocalDate.now();
	String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyyddMM"));
	
	// private Merchant[] merchants = new Merchant[5];
	private Merchant merchant = new Merchant("00000001", "Ivan Petrov", "Ivan Petrov", "vankata1", "P", true, 2,
			"windows seller", 1, true, false, "Sell windows", "His shop sell the best windows in the market", "556868",
			"Klientski nomer 556868");

	private Merchant merchant1 = new Merchant("00000002", "Stanimir Nikolov", "Stanimir Nikolov", "stambata", "SN",
			true, 20, "sell car", 1, true, false, "Sell car", "His sell extingt car", "556228",
			"Klientski nomer 556228");

	private Merchant merchant2 = new Merchant("00000003", "Maria Ivanova", "Maria Ivanova", "MmI", "M", true, 27,
			"sell book", 1, true, false, "Sell book", "His shop sell the most interesting book in the market", "556788",
			"Klientski nomer 556788");

	private ArrayList<Merchant> merch = new ArrayList<Merchant>();

	{

		merch.add(merchant);
		merch.add(merchant1);
		merch.add(merchant2);
	}

	public MerchantList getMerchant() {
		MerchantList d = new MerchantList(merch.size(), merch);
		return d;
	}

	
	// checkBill
	
	
/*	private static List<Bill> bills = new ArrayList<>();
	private Bill bill = new Bill("5555", Status.getRandomStatus(), formattedDate, 55000, " ", " ", "sdad");

	private Bill bill1 = new Bill("5555", Status.getRandomStatus(), formattedDate, 3000, " ", " ", "ffff");

	private Bill bill2 = new Bill("5557", Status.getRandomStatus(), formattedDate, 115000, " ", " ",
			"aaaa");
	{
		bills.add(bill);
		bills.add(bill1);
		bills.add(bill2);
	}

	public List<Bill> getBill(String subscNumber) {

		// problem with subscNumber not yet
		JSONObject obj = new JSONObject(subscNumber);
		List<Bill> bb = (List<Bill>) bills.stream()
				.filter(b -> b.getSubscNumber().equals(obj.get("subscNumber")))
				.collect(Collectors.toList());

		return bb;

	}

*/
}
