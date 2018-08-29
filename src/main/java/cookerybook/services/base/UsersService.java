package cookerybook.services.base;

import cookerybook.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsersService extends UserDetailsService {
    User getUserByUsername(String username);

    void create(User user);
}
