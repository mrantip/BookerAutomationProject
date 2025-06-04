package core.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bookingdates{
	private String checkin;
	private String checkout;

	@JsonCreator
	public Bookingdates(@JsonProperty("checkin") String checkin, @JsonProperty("checkout") String checkout) {
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public String getCheckin(){
		return checkin;
	}

	public String getCheckout(){
		return checkout;
	}
}
