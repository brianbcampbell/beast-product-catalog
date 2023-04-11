package beast.cart.user;

import beast.cart.models.UserDetails;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static generated.Tables.USERS;

@Service
class UserRepository {

    private final DSLContext jooq;

    @Autowired
    public UserRepository(DSLContext context) {
        this.jooq = context;
    }

    UserDetails findByUsername(String username) {
        return jooq
                .select()
                .from(USERS)
                .where(USERS.USERNAME.eq(username))
                .fetchAnyInto(UserDetails.class);
    }

    boolean existsByUsername(String username) {
        return jooq.fetchExists(
                jooq.select().where(USERS.USERNAME.eq(username))
        );
    }

    Boolean existsByEmail(String email) {
        return jooq.fetchExists(
                jooq.select().where(USERS.EMAIL.eq(email))
        );
    }

    void save(UserDetails userDetails) throws Exception {

    }
}
