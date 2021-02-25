package com.seleniumexpress.noteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.seleniumexpress.noteapp.dao.NoteAppdao;
import com.seleniumexpress.noteapp.model.Note;

@Controller
public class NoteAppController {
	
	@Autowired
	private NoteAppdao noteAppDao;
	
	@RequestMapping("/ind")
	public String home()
	{
		return "index";
	}

	@GetMapping("/")
	public String showANotes(Model model)
	{
		Note note=new Note();
		
	List<Note> n= noteAppDao.getNotes();	
		model.addAttribute("listofrecords",n );
		return "all_notes";
		
	}
	
	
	@RequestMapping("/save")
	public String saveNotes(@ModelAttribute Note note)
	{
		if(note.getId()==0)
		{
		noteAppDao.insertnote(note);
		}
		else
		{
			noteAppDao.update(note);
		}
		return "redirect:/";
		
	}
	
	
	@RequestMapping("/new")
	public String insertNotes(Model model)
	{
		Note nn=new Note();
		model.addAttribute("listofrecords", nn);
		
		
		return "add_notes";
		
	}
	
	@GetMapping("/update")
	public String EditContact(@RequestParam("id")int id, Model model)
	{
	//	noteAppDao.upd
		Note nn= noteAppDao.get(id);
		model.addAttribute("listofrecords", nn);
		return "add_notes";
		
	}
	
	
	@RequestMapping("/delete")
	public String deleteNotes(@RequestParam Integer id)
	{
		noteAppDao.delete(id);
		return "redirect:/";
		
	}
	
	
	

}
