package domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/9/18.
 */
@NodeEntity
public class Person {

    @GraphId
    private Long id;

    private String name;

    public Person() {
        // Empty constructor required as of Neo4j API 2.0.5 从Neo4j API 2.0.5起需要空构造函数
    }

    public Person(String name) {
        this.name = name;
    }

    @Relationship(type = "TEAMMATE",direction = Relationship.UNDIRECTED)
    public Set<Person> teammates;

    public void worksWith(Person person) {
        if(teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    public String toString() {
        return this.name + "'s teammates => "
                + Optional.ofNullable(this.teammates).orElse(
                Collections.emptySet()).stream().map(
                person -> person.getName()).collect(Collectors.toList());
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
