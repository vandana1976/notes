package com.notesapp.demo.Service;

import com.notesapp.demo.Model.Note;
import com.notesapp.demo.Repository.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepo noteRepo;

//    public Collection<Note> getAllNotes(){
//        return (Collection<Note>) noteRepo.findAll();
//    }

    public List<Note> findAll(){
     return(List<Note>) noteRepo.findAll();
    }

    public  Note getNoteById(Long id){
        return noteRepo.findById(id).get();
    }

    public void removeNoteByID(Long id) {
        noteRepo.deleteById(id);

    }

    public void save(Note note) {
        noteRepo.save(note);
    }

}
