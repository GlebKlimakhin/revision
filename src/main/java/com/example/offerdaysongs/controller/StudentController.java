package com.example.offerdaysongs.controller;

import com.example.offerdaysongs.models.Student;
import com.example.offerdaysongs.repo.StudentRepository;
import com.example.offerdaysongs.requests.StudentUpdateRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @SneakyThrows
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Student student) {
        Student saved = repository.save(student);
        URI uri = new URI("http://localhost:8189/api/v1/" + saved.getId()).normalize();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody StudentUpdateRequest updRequest) {
        Optional<Student> student = repository.findById(updRequest.getId());
        if(student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Student updated = student.get();
        updated.setName(updRequest.getName());
        updated.setAge(updRequest.getAge());
        repository.save(updated);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
