package internShip;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class EResponse implements Serializable {

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
	private  String errorCode  ;

	@XmlElement(name = "error_des")
	@Setter
	private  String errorDes ;








	@JsonFormat(shape= JsonFormat.Shape.OBJECT)
	public enum ResponseStatus {

		SUCCESS("00"), NOPENDING("62"), NO_SUCH_MERCHANT("14"), INVALID_CODE("58"), lOCKED_CARD("75"),
		TEMPORARA_UNAVAILABLE("80"), G_ERROR("96"), INVALID_SUM("13"), INVALID_FORMAT("805"), DUTY_BLOCKED("70"),
		DOUBLE_MESSAGE("94"), OLD_PENDING("49"), OUT_OF_PERIOD("50"), NO_INFO_FOR_MERCHANT("52");

		private  String code;

		private ResponseStatus(String code) {

			this.setCode(code);
		}
		@JsonValue
		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		
	}
}