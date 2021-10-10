package com.example.serviceclients;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Samarth Narula
 *
 */

@Service
public class MessagingServiceClient {

	@Autowired
	RestTemplate restTemplate;

	@Async
	public void publishMessage(String subject, String messageBody) {
		String url = "http://localhost:8081/sendNotification?messageBody="+messageBody+"&subject="+subject;
		try {
			String responseFromMessenger = restTemplate.getForObject(url, String.class);
			CompletableFuture.completedFuture(responseFromMessenger);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
