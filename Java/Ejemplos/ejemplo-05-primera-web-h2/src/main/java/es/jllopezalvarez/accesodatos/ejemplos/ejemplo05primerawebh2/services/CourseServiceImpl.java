package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Course;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course save(Course student){
        return courseRepository.save(student);
    }

    @Override
    public Optional<Course> findById(Long id){
        return courseRepository.findById(id);
    }

}
