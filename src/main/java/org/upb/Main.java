package org.upb;

import jakarta.xml.ws.Endpoint;

public class Main {
	public static void main(String[] args) {
		String url = "http://localhost:8085/";
		// Endpoint.publish(url, new CalculateurService());
		System.out.println("Service Bien déployé");
		System.out.println("Hello world!");
	}
}