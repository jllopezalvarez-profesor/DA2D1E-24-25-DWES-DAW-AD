package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Student;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

}
