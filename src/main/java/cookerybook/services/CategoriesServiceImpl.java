package cookerybook.services;

import cookerybook.entities.Category;
import cookerybook.repositories.base.GenericRepository;
import cookerybook.services.base.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class CategoriesServiceImpl implements CategoriesService {

    private final GenericRepository categoriesRepository;

    @Autowired
    public CategoriesServiceImpl(GenericRepository<Category> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoriesRepository.getAll();
    }
}
