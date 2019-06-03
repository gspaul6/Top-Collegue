package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entite.Participants;
import com.example.entite.PetitDto;
import com.example.service.ParticipantService;

@RestController
// Ici cette classe va répondre aux requêtes `/exemples`
@RequestMapping("/participants")
@CrossOrigin
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;

	@GetMapping
	public List<Participants> searchAll() {

		return this.participantService.findEveryOne();
	}

	@PatchMapping(value = "/upvote")
	@Secured("ROLE_USER")
	public ResponseEntity<Object> modifierLike(@RequestBody PetitDto petit) {
		Participants participant = this.participantService.addLikes(petit.getMatricule(), petit.getLike());

		return ResponseEntity.status(HttpStatus.OK).body(participant);
	}

	@PatchMapping(value = "/downvote")
	@Secured("ROLE_USER")
	public ResponseEntity<Object> modifierdislike(@RequestBody PetitDto petit) {
		Participants participant = this.participantService.addDislikes(petit.getMatricule(), petit.getLike());

		return ResponseEntity.status(HttpStatus.OK).body(participant);

	}

	@GetMapping(value = "/score")
	public List<Participants> sortAll() {

		return this.participantService.sortingParticipants();
	}
}
