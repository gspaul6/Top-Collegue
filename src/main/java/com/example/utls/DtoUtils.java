package com.example.utls;

import com.example.entite.CollegueAuth;
import com.example.entite.CollegueDTO;
import com.example.entite.InfoParticipants;
import com.example.entite.Participants;

public interface DtoUtils {
	// public static CollegueDTO ToCollegueDTO(Participants col) {
	//
	// return new CollegueDTO(col.getMatricule(), col.getNom(),
	// col.getPrenoms(), col.getDateDeNaissance(),
	// col.getEmail(), col.getPhotoUrl());
	// }

	public static Participants ToParticipants(CollegueDTO col) {
		return new Participants(col.getMatricule(), col.getNom(), col.getPrenoms(), col.getPhotoUrl());
	}

	public static CollegueAuth toCollegueAuth(InfoParticipants info) {
		return new CollegueAuth(info.getNom(), info.getMotPass());
	}
}