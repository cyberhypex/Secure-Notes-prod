package com.securenotes.Securing_notes.repositories;

import com.securenotes.Securing_notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import  java.util.*;

public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByOwnerUsername(String ownerUsername);


}
