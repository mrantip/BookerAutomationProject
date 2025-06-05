package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.clients.APIClient;
import core.models.Booking;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeleteBookingTest {
    private APIClient apiClient;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        apiClient = new APIClient();
        objectMapper = new ObjectMapper();
        apiClient.createToken("admin", "password123");
    }

    @Test
    public void testDeleteBooking() throws Exception {
        Response response = apiClient.getBooking();
        String responseBody = response.getBody().asString();
        List<Booking> bookings = objectMapper.readValue(responseBody, new TypeReference<List<Booking>>(){});

        Random random = new Random();

        int bookingId = bookings.get(random.nextInt(bookings.size())).getBookingid();

        Response deleteBooking = apiClient.deleteBooking(bookingId);
        assertThat(deleteBooking.statusCode()).isEqualTo(201);
        assertThat(apiClient.getBookingById(bookingId).statusCode()).isEqualTo(404);
    }
}
