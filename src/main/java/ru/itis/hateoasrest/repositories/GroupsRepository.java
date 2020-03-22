package ru.itis.hateoasrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.hateoasrest.models.Group;

@Repository
public interface GroupsRepository extends JpaRepository<Group, Long> {
}
