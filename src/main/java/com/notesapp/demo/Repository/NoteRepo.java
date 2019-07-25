package com.notesapp.demo.Repository;

import com.notesapp.demo.Model.Note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public interface NoteRepo extends CrudRepository<Note, Long> {

}
