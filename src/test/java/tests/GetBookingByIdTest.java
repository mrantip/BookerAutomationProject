package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import core.clients.APIClient;
import core.models.Booking;
import core.models.BookingById;
import core.models.Bookingdates;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingByIdTest {
    private APIClient apiClient;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        apiClient = new APIClient();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testBookingById() throws Exception {
        Response response = apiClient.getBookingById(1);

        assertThat(response.getStatusCode()).isEqualTo(200);
        String responseBody = response.getBody().asString();

        BookingById bookingById = objectMapper.readValue(responseBody, BookingById.class);

        assertThat(bookingById.getFirstname()).isEqualTo("Mark");
        assertThat(bookingById.getTotalprice()).isEqualTo(246);
        assertThat(bookingById.getBookingdates().getCheckin()).isEqualTo("2024-05-30");

    }
}
