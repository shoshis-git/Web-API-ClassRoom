package com.example.projectshoshifruchter.repository;

import com.example.projectshoshifruchter.entities.ClassRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Integer> {

    ClassRoom findByClassNumber(char classNumber);
}
