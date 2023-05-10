package ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ibf2022.tfip.paf.day23workshopnorthwindSQLSearch.models.Order;


@Service
public class OrderRestTemplateService {
    RestTemplate restTemplate = new RestTemplate();

    private static final String GET_ORDER_BY_ID_ENDPOINT_URL="https://localhost:8080/api/orders/{order-id}";

    public List<Order> findOrderById(Integer orderId) {
        ResponseEntity<List<Order>> resp = restTemplate.exchange(GET_ORDER_BY_ID_ENDPOINT_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>(){}, orderId);

        return resp.getBody();
    }
}
