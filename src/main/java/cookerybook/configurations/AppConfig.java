package cookerybook.configurations;

import cookerybook.entities.Category;
import cookerybook.entities.Receipt;
import cookerybook.entities.User;
import cookerybook.repositories.HibernateRepository;
import cookerybook.repositories.base.GenericRepository;
import cookerybook.services.CategoriesServiceImpl;
import cookerybook.services.ReceiptsServiceImpl;
import cookerybook.services.UsersServiceImpl;
import cookerybook.services.base.CategoriesService;
import cookerybook.services.base.ReceiptsService;
import cookerybook.services.base.UsersService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    @Autowired
    GenericRepository<Receipt> receiptGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<Receipt> repository = new HibernateRepository<>(sessionFactory);
        repository.setEntityClass(Receipt.class);
        return repository;
    }

    @Bean
    @Autowired
    GenericRepository<Category> categoryGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<Category> repository = new HibernateRepository<>(sessionFactory);
        repository.setEntityClass(Category.class);
        return repository;
    }

    @Bean
    @Autowired
    GenericRepository<User> userGenericRepository(SessionFactory sessionFactory) {
        HibernateRepository<User> repository = new HibernateRepository<>(sessionFactory);
        repository.setEntityClass(User.class);
        return repository;
    }

    @Bean
    @Autowired
    ReceiptsService receiptsService(GenericRepository<Receipt> genericRepository) {
        return new ReceiptsServiceImpl(genericRepository);
    }

    @Bean
    @Autowired
    CategoriesService categoriesService(GenericRepository<Category> genericRepository) {
        return new CategoriesServiceImpl(genericRepository);
    }

    @Bean
    @Autowired
    UsersService usersService(GenericRepository<User> usersRepository, PasswordEncoder passwordEncoder) {
        return new UsersServiceImpl(usersRepository, passwordEncoder);
    }

    @Bean
    SessionFactory provideSessionFactory() {
        return HibernateUtils.getSessionFactory();
    }
}
