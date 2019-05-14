package com.example.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entite.CollegueAuth;
import com.example.entite.CollegueDTO;
import com.example.entite.InfoParticipants;
import com.example.entite.Participants;
import com.example.service.ParticipantService;
import com.example.utls.DtoUtils;

@RestController
@CrossOrigin
public class AuthentificationCtrl {
	@Value("${jwt.expires_in}")
	private Integer EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Value("${jwt.secret}")
	private String SECRET;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private ParticipantService serviceOfParticipants;

	@Autowired
	private RestTemplate rt;

	@PostMapping(value = "/auth")

	public ResponseEntity<Object> authenticate(@RequestBody InfoParticipants authenticationRequest,
			HttpServletResponse response) throws URISyntaxException {

		HttpEntity<CollegueAuth> requestEntity = new HttpEntity<CollegueAuth>(
				DtoUtils.toCollegueAuth(authenticationRequest));

		ResponseEntity<String> responseFromApi = rt.exchange("http://localhost:8080/auth", HttpMethod.POST,
				requestEntity, String.class);
		// https://Paul-collegues-api.herokuapp.com/auth
		String responseHeader = responseFromApi.getHeaders().getFirst("Set-Cookie");

		String body = responseFromApi.getBody();

		String[] cookie = responseHeader.split(";");

		String[] cookie2 = cookie[0].split("=");

		String token = cookie2[1];

		Participants participants = this.serviceOfParticipants.findByEmail(authenticationRequest.getNom());
		CollegueDTO collegue;
		//// step to check if he exists in participants
		if (participants != null) {
			System.out.println("participant exist");
		}
		/// step :to send email and get the collegue
		else {

			if (!responseHeader.isEmpty() && responseHeader != null) {
				RequestEntity<?> requireEntity = RequestEntity.get(new URI("http://localhost:8080/collegues/emails"))
						// https://Paul-collegues-api.herokuapp.com/collegues/emails
						.header("Cookie", responseFromApi.getHeaders().getFirst("Set-Cookie")).build();
				ResponseEntity<CollegueDTO> rep2 = rt.exchange(requireEntity, CollegueDTO.class);
				collegue = rep2.getBody();

				collegue.setPhotoUrl(authenticationRequest.getPhotoUrl());

				participants = this.serviceOfParticipants.saveParticipants(collegue);

			}

		}
		// System.out.println(responseHeader + "\n" + body + "\n");

		Cookie authCookie = new Cookie(TOKEN_COOKIE, token);

		authCookie.setHttpOnly(true);

		authCookie.setMaxAge(EXPIRES_IN * 1000);

		authCookie.setPath("/");

		response.addCookie(authCookie);
		return ResponseEntity.status(HttpStatus.OK).body(participants);

	}

	// @GetMapping(value = "/me")
	// public ResponseEntity<Object> getUtilisateur() {
	// CollegueUtilisateur collegueUtilisateur = this.serviceOfParticipants
	// .loadUserByname(SecurityContextHolder.getContext().getAuthentication().getName());
	// return ResponseEntity.status(HttpStatus.OK).body(collegueUtilisateur);
	//
	// }
}
