package com.team2.his.repostiris;

import com.team2.his.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository  extends JpaRepository<Account, UUID> {
    Optional<Account> findByUserName(String userName);

    Optional<Account> findByAccountId(UUID id);

    boolean existsByUserName(String userName);
}
