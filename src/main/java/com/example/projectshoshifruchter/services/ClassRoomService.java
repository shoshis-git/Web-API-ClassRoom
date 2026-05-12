package com.example.projectshoshifruchter.services;

import com.example.projectshoshifruchter.entities.ClassRoom;
import com.example.projectshoshifruchter.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassRoomService implements ClassRoomServiceInterface {

@Autowired
    ClassRoomRepository classRoomRepository;
    @Override
    public List<ClassRoom> getClassRooms() {
        return (List<ClassRoom>) classRoomRepository.findAll();
    }

    @Override
    public ClassRoom getClasRoomById(int id) {
        return classRoomRepository.findById(id).orElse(null);
    }

    @Override
    public ClassRoom getClasRoomByName(char classNumber) {
        return classRoomRepository.findByName(classNumber);
    }




    @Override
    public void addClass(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    public void updateClassRoom(int id, ClassRoom classRoom) {
        classRoomRepository.deleteById(id);
        classRoomRepository.save(classRoom);
    }

    @Override
    public void deleteClassRoom(int id) {
        classRoomRepository.deleteById(id);

    }
}
