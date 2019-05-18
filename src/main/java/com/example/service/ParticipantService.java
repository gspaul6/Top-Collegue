package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entite.CollegueDTO;
import com.example.entite.Participants;
import com.example.entite.ScoreCard;
import com.example.exception.CollegueNonTrouveException;
import com.example.respository.ParticipantsRepository;
import com.example.utls.DtoUtils;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantsRepository participantsRepository;

	/**
	 * @param collegueRepository
	 *            the collegueRepository to set
	 */
	public void setparticipantsRepository(ParticipantsRepository participantsRepository) {
		this.participantsRepository = participantsRepository;
	}

	public List<Participants> findByMatricule(String matriculeRecherche) throws CollegueNonTrouveException {
		Participants participant = this.participantsRepository.findById(matriculeRecherche)
				.orElseThrow(CollegueNonTrouveException::new);
		List<Participants> participantsList = new ArrayList<>();
		participantsList.add(new Participants(participant.getMatricule(), participant.getNom(), participant.getPrenom(),
				participant.getEmail(), participant.getPhotoUrl()));
		return participantsList;
	}

	public List<Participants> findEveryOne() {
		List<Participants> participantsList = new ArrayList<>();
		participantsList = this.participantsRepository.findAll();
		return participantsList;
	}

	public void saveParticipants(CollegueDTO collegue) {
		
		Optional<Participants> participant=this.findByEmail(collegue.getEmail());
		if(!participant.isPresent()){
			this.participantsRepository.save(DtoUtils.ToParticipants(collegue));
		}
		 
	}

	public Optional<Participants> findByEmail(String email) {
		return this.participantsRepository.findParticipantByTheirEmail(email);
		
	}

	@Transactional
	public Participants addLikes(String matricule, Integer like) {
		Participants participant = this.participantsRepository.findById(matricule)
				.orElseThrow(CollegueNonTrouveException::new);
		if (participant.getScoreCard() == null) {
			participant.setScoreCard(new ScoreCard());
			participant.getScoreCard().setLikes(participant.getScoreCard().getLikes() + like);
			participant.getScoreCard()
					.setScore((participant.getScoreCard().getLikes() - participant.getScoreCard().getDisLikes()));
		} else {
			participant.getScoreCard().setLikes(participant.getScoreCard().getLikes() + like);
			participant.getScoreCard()
					.setScore((participant.getScoreCard().getLikes() - participant.getScoreCard().getDisLikes()));
		}

		return participant;
	}

	@Transactional
	public Participants addDislikes(String matricule, Integer dislike) {
		Participants participant = this.participantsRepository.findById(matricule)
				.orElseThrow(CollegueNonTrouveException::new);
		if (participant.getScoreCard() == null) {
			participant.setScoreCard(new ScoreCard());
			participant.getScoreCard().setDisLikes(participant.getScoreCard().getDisLikes() + dislike);
			participant.getScoreCard()
					.setScore((participant.getScoreCard().getLikes() - participant.getScoreCard().getDisLikes()));
		} else {
			participant.getScoreCard().setDisLikes(participant.getScoreCard().getDisLikes() + dislike);
			participant.getScoreCard()
					.setScore((participant.getScoreCard().getLikes() - participant.getScoreCard().getDisLikes()));
		}

		return participant;
	}

	public List<Participants> sortingParticipants() {
		return this.participantsRepository.sortAllParticipantDesc();
	}
}
