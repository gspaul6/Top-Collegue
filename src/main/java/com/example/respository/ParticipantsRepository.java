package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entite.Participants;

public interface ParticipantsRepository extends JpaRepository<Participants, String> {

}
