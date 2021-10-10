package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

/**
 * @author Samarth Narula
 *
 */

@RestController
public class MessagingController {

	@Autowired
	private AmazonSNSClient snsClient;

    @Value("${aws.sns.arn}")
	private String TOPIC_ARN;

	@GetMapping("/addSubscription/{email}")
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm the subscription, check your email : " + email;
	}

	@GetMapping("/sendNotification")
	public String publishMessageToTopic(String subject, String messageBody) {
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, messageBody,
				subject);
		snsClient.publish(publishRequest);
		return "Notification send successfully !!";
	}

}
