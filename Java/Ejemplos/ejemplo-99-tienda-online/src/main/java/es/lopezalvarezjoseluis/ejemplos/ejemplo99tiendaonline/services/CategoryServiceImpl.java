package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Category;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.exceptions.AlreadyExistsException;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
}

    @Override
    public Optional<Category> findById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public void create(String name, String description) {
        if (categoryRepository.existsCategoryByNameIgnoreCase(name)){
            throw new AlreadyExistsException(String.format("Ya existe una categoría con el nombre %s", name));
        }
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAll(Integer pageNumber, Integer pageSize, String orderBy, String orderDir) {
        Sort.Direction direction = orderDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageRequest = PageRequest.of(pageNumber - 1, pageSize, Sort.by(direction, orderBy));

        return categoryRepository.findAll(pageRequest);
    }
}
