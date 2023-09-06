package org.upb;

import jakarta.xml.ws.Endpoint;
import org.upb.services.CMUService;

public class Main {
	public static void main(String[] args) {
		String url = "http://localhost:8085/";
		Endpoint.publish(url, new CMUService());
		System.out.println("Service Bien déployé");
	}
}