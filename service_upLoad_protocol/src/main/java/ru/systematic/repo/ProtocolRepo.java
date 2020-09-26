package ru.systematic.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.systematic.model.Protocol;

@Repository
public interface ProtocolRepo extends CrudRepository<Protocol,Integer> {
}
