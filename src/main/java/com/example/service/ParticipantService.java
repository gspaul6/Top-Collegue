package com.example.service;

import java.util.ArrayList;
import java.util.List;

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

	public Participants saveParticipants(CollegueDTO collegue) {
		return this.participantsRepository.save(DtoUtils.ToParticipants(collegue));
	}

	public Participants findByEmail(String email) {
		Participants currentParticipant = this.participantsRepository.findParticipantByTheirEmail(email);
		return currentParticipant;
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
