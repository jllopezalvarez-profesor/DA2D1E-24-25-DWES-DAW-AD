package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    @Transactional
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> findByInitial(String letra) {
//        return teacherRepository
//                .findAll()
//                .stream()
//                .filter(teacher ->teacher.getFirstName().startsWith(letra)
//        ).toList();
        return teacherRepository.findByFirstNameStartingWithOrLastNameStartingWith (letra,letra);
    }
}
