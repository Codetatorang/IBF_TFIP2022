package ibf2022.tfip.ssf.day16workshopRedisJSON.controller;

import java.io.Reader;
import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.ssf.day16workshopRedisJSON.model.Order;
import ibf2022.tfip.ssf.day16workshopRedisJSON.model.OrderResponse;
import ibf2022.tfip.ssf.day16workshopRedisJSON.service.OrderService;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path = "/api/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {
    @Autowired
    private OrderService orderSvc;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postOrder(@RequestBody String payload) {
        //json is the wired format
        //convert from string to json object
        Reader reader = new StringReader(payload);
        JsonReader Jreader = Json.createReader(reader);
        JsonObject jsonObj = Jreader.readObject();

        //convert json to entity model
        Order order = Order.create(jsonObj);

        //Perform business operations
        String orderId = orderSvc.createNewOrder(order);

        //Construct response
        OrderResponse resp = new OrderResponse();
        resp.setOrderId(orderId);
        resp.setMessage("order created successfully");

        jsonObj = resp.toJson();

        //send response back to client
        return ResponseEntity.status(201).body(jsonObj.toString());
    }
}
