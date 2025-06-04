package core.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingById {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private Bookingdates bookingdates;
    private String additionalneeds;

    @JsonCreator
    public BookingById(@JsonProperty("firstname") String firstname,
                       @JsonProperty("lastname") String lastname,
                       @JsonProperty("totalprice") int totalprice,
                       @JsonProperty("depositpaid") boolean depositpaid,
                       @JsonProperty("bookingdates") Bookingdates bookingdates,
                       @JsonProperty("additionalneeds") String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalneeds = additionalneeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public String getLastname() {
        return lastname;
    }
}
