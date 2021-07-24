package internShip;

import java.util.List;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MerchantList {

	private final Integer merchantCount;
	private final List<Merchant> mer ;
	
	
}
