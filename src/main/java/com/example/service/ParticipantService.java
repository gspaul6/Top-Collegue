package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entite.Participants;
import com.example.exception.CollegueNonTrouveException;
import com.example.respository.ParticipantsRepository;

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

	List<Participants> findByMatricule(String matriculeRecherche) throws CollegueNonTrouveException {
		Participants participant = this.participantsRepository.findById(matriculeRecherche)
				.orElseThrow(CollegueNonTrouveException::new);
		List<Participants> participantslist = new ArrayList<>();
		participantslist.add(new Participants(participant.getMatricule(), participant.getNom(), participant.getPrenom(),
				participant.getPhotoUrl()));
		return participantslist;
	}
}
