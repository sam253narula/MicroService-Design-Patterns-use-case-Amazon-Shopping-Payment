package com.example.serviceclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Samarth Narula
 *
 */

@Service
public class PaymentServiceClient {

	@Autowired
	private RestTemplate template;
	
	public String invokePaymentService(int price) {
		String url = "http://localhost:8888/payment-provider/payNow/" + price;
		return template.getForObject(url, String.class);
	}
	
}
