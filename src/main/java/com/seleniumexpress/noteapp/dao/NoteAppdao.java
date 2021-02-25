package com.seleniumexpress.noteapp.dao;

import java.util.List;

import com.seleniumexpress.noteapp.model.Note;

public interface NoteAppdao {
	
	
	
	Note getAllNotes();
	
	public void insertnote(Note note);
	public void update(Note note);
	public void delete(Integer id);
	public List<Note> getNotes() ;

	public Note get(int id);

	

}
