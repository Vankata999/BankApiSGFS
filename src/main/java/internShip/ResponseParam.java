package internShip;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.stream.events.XMLEvent;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseParam implements Serializable {

	@JsonFormat()
	@NonNull

	private static final long serialVersionUID = 1L;

	private final ResponseStatus status;

	private final Integer amount;
	private final Integer fee;
	private final Integer total;

	@JsonFormat(pattern = "yyyyMMdd")
	@XmlElement(name = "valid_to")
	private final LocalDate validto;
	@XmlElement(name = "short_desc")
	private final String shortDesc;
	@XmlElement(name = "long_desc")
	private final String longDesc;
	@XmlElement(name = "second_Id")
	private final String secondId;

	@XmlElement(name = "error_code")
	@Setter
	private  String errorCode;

	@XmlElement(name = "error_des")
	@Setter
	private  String errorDes;

	Random rand = new Random();
	public ResponseParam(ResponseStatus status, Integer amount, Integer fee, Integer total, LocalDate validto,
			String shortDesc, String longDesc, String secondId, String errorCode, String errorDes) {
		super();
		this.status = status;
		this.amount = rand.nextInt();
		this.fee = rand.nextInt();
		this.total = amount + fee;
		this.validto = validto;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.secondId = secondId;
		this.errorCode = errorCode;
		this.errorDes = errorDes;
	}

	public ResponseParam(status, int amount, int fee, int total, String shortDesc, String longDesc) {
		// TODO Auto-generated constructor stub
		this.status = status;
		this.amount = amount;
		this.fee = fee;
		this.total = total;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}

	public enum ResponseStatus {

		SUCCESS("00"), NOPENDING("62"), NO_SUCH_MERCHANT("14"), INVALID_CODE("58"), lOCKED_CARD("75"),
		TEMPORARA_UNAVAILABLE("80"), G_ERROR("96"), INVALID_SUM("13"), INVALID_FORMAT("805"), DUTY_BLOCKED("70"),
		DOUBLE_MESSAGE("94"), OLD_PENDING("49"), OUT_OF_PERIOD("50"), NO_INFO_FOR_MERCHANT("52");

		private final String code;

		private ResponseStatus(String code) {

			this.code = code;
		}

		
	}
}