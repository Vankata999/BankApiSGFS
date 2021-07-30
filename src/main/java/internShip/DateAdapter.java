package internShip;

import java.util.Date;
import java.text.SimpleDateFormat;


import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	
	@Override
	public String marshal(Date m) throws Exception
	{
		synchronized (dateFormat) {
			return dateFormat.format(m);
			
		}
	}

	@Override
	public Date unmarshal(String i) throws Exception
	{
		synchronized (dateFormat) {
		
			return dateFormat.parse(i);
		}
	}
}
