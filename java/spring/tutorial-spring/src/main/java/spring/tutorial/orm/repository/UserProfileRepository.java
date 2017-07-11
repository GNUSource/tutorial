package spring.tutorial.orm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.tutorial.orm.domain.UserProfile;

import java.util.Date;
import java.util.List;

@Repository
@SuppressWarnings("unused")
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    List<UserProfile> findByLastAccessTimeGreaterThanAndPreferredContactMode(Date date, String perferredContactMode);
}
