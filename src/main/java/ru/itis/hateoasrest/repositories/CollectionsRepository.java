package ru.itis.hateoasrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.hateoasrest.models.Collection;

@Repository
public interface CollectionsRepository extends JpaRepository<Collection, Long> {
}
