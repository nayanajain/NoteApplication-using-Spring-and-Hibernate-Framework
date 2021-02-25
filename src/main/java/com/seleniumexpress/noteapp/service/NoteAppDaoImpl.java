package com.seleniumexpress.noteapp.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.seleniumexpress.noteapp.dao.NoteAppdao;
import com.seleniumexpress.noteapp.model.Note;

@Service
//@Transactional
public class NoteAppDaoImpl implements NoteAppdao {

	@Autowired
	private SessionFactory sessionFactory;

	// @SuppressWarnings("unchecked")
	public Note getAllNotes() {
		// TODO Auto-generated method stub

		// open session
		Session session = sessionFactory.openSession();
		// begin transaction
//		session.beginTransaction();
		// fetch data
		Note n = session.get(Note.class, 1);
		// commit transaction

		return n;
	}

	public List<Note> getNotes() {
		// TODO Auto-generated method stub

		// open session
		Session session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// fetch data
		//@SuppressWarnings("unchecked")
		List<Note> n = session.createQuery("from Note").getResultList();
		// commit transaction
		session.getTransaction().commit();

		return n;
	}

	public void insertnote(Note note) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// fetch data
		session.save(note);
		// commit transaction
		session.getTransaction().commit();
		System.out.println("inside insert");
		session.close();

	}

	public void update(Note note) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// fetch data
		Query q=session.createQuery("UPDATE Note set title=:t, content=:c where id= :id");
		q.setParameter("t", note.getTitle());
     	q.setParameter("c", note.getContent());
//			
		q.setParameter("id", note.getId());
			q.executeUpdate();
//			
		//session.update(note);
		// commit transaction
		session.getTransaction().commit();

		session.close();
		
		
			}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		// begin transaction
		session.beginTransaction();
		// fetch data
		// session.delete(id);
		session.createQuery("delete Note where id= " + id).executeUpdate();

		System.out.println("deleted");
		// commit transaction
		session.getTransaction().commit();

		session.close();

	}

	public Note get(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Note n=session.get(Note.class, id);
		
		return n;
		
		
		 
		
	}

}
