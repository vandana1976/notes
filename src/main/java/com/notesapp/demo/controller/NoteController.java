package com.notesapp.demo.controller;

import com.notesapp.demo.Model.Note;
import com.notesapp.demo.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping(value = {"/", "/notes"})
    public String homepage(Model model){
        clearEdit();
        List<Note> noteList = noteService.findAll();
        model.addAttribute("notes", noteList);
        return "home";
    }

    @GetMapping(value = "/new")
    public String createNotes(Model model){
        clearEdit();
        model.addAttribute("note", new Note());
        return "newNote";
    }

    @PostMapping(value = "/new")
    public String postNotes(Note note){
        noteService.save(note);
        return "redirect:/";
    }

    @GetMapping(value = "/{id}")
    public String editNote(@PathVariable Long id, Model model){
        clearEdit();
        List<Note> noteList = noteService.findAll();
        model.addAttribute("notes", noteList);
        Note note = noteService.getNoteById(id);
        note.setEdit(true);
        noteService.save(note);
        model.addAttribute("editNote", note);
        return "home";
    }

    @PostMapping(value = "/{id}")
    public  String saveEdit(Note note){
        note.setEdit(false);
        noteService.save(note);
        return "redirect:/";
    }

    @DeleteMapping(value= "/{id}")
    public String deleteNote(@PathVariable Long  id){
        clearEdit();
        noteService.removeNoteByID(id);
        return "redirect:/";
    }

    private void clearEdit(){
        List<Note> notes = noteService.findAll();
        for (Note note : notes){
            note.setEdit(false);
            noteService.save(note);
        }
    }

}
