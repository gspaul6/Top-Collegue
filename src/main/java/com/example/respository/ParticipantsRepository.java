package com.example.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entite.Participants;

public interface ParticipantsRepository extends JpaRepository<Participants, String> {

	@Query("Select p from Participants p where p.email=:email")
	Optional<Participants> findParticipantByTheirEmail(@Param("email") String email);

	@Query("Select p from Participants p order by score desc")
	List<Participants> sortAllParticipantDesc();
}
