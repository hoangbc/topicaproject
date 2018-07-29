package com.itlab.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlab.model.Google;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class GoogleService {

	@Autowired
	private Environment env;

	public String getToken(final String code) throws ClientProtocolException, IOException {
		String link = env.getProperty("google.link.get.token");

		String response = Request.Post(link)
				.bodyForm(Form.form().add("client_id", env.getProperty("google.client.id"))
						.add("client_secret", env.getProperty("google.client.secret"))
						.add("redirect_uri", env.getProperty("google.redirect.uri")).add("code", code)
						.add("grant_type", "authorization_code").build())
				.execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(response).get("access_token");
		return node.textValue();
	}

	public Google getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = env.getProperty("google.link.get.user_info") + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();
		ObjectMapper mapper = new ObjectMapper();
		Google google = mapper.readValue(response, Google.class);
		log.info(google.toString());
		return google;
	}
}
