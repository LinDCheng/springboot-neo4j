package repository;

import domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Administrator on 2017/9/18.
 */
public interface PersonRepository extends GraphRepository<Person>{
    Person findByName(String name);
}
