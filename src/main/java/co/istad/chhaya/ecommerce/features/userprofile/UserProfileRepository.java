package co.istad.chhaya.ecommerce.features.userprofile;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository
extends JpaRepository<UserProfile, String> {
}
