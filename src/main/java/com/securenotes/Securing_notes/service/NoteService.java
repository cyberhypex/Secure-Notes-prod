package com.securenotes.Securing_notes.service;

import com.securenotes.Securing_notes.models.Note;

import java.util.*;

public interface NoteService {

    Note createNoteForUser(String username, String content);
    Note updateNoteForUser(Long noteId,String content,String username);
    void deleteNoteForUser(Long noteId,String username);
    List<Note> getNotesForUser(String username);
}
