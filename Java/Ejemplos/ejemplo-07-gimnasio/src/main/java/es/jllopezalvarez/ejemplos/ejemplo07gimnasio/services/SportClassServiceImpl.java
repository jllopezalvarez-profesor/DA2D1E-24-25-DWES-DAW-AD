package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.SportClass;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories.SportClassRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SportClassServiceImpl implements SportClassService {
    private final SportClassRepository sportClassRepository;

    public SportClassServiceImpl(SportClassRepository sportClassRepository) {
        this.sportClassRepository = sportClassRepository;
    }

    @Override
    public Optional<SportClass> findById(long l) {
        return sportClassRepository.findById(l);
    }

    @Override
    public List<SportClass> findByLetterOrderedByNameDesc(String searchString) {
        return sportClassRepository
                .findAll()
                .stream()
                .filter(x -> x.getName().toLowerCase().contains(searchString.toLowerCase()))
                .sorted(Comparator.comparing(SportClass::getName).reversed())
//                .sorted((o1, o2) -> -(o1.getName().compareTo(o2.getName())))
//                .sorted((new Comparator<SportClass>() {
//                    @Override
//                    public int compare(SportClass o1, SportClass o2) {
//                        return o1.getName().compareTo(o2.getName());
//                    }
//                }).reversed())
                .toList();
    }

    @Override
    public List<SportClass> findByLetterOrderedByNameDescOptimized(String searchString) {
//        return sportClassRepository.findByNameContainingIgnoringCaseOrderByNameDesc(searchString);
        return sportClassRepository.findByNameIgnoringCaseOrderByNameDesc(searchString);
    }
}