package com.example.projectshoshifruchter.services;

import com.example.projectshoshifruchter.entities.ClassRoom;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClassRoomServiceInterface {
    List<ClassRoom> getClassRooms();
    ClassRoom getClasRoomById(int id);
    ClassRoom getClasRoomByName(char classNumber );

    void addClass(ClassRoom classRoom);
    void updateClassRoom(int id,ClassRoom classRoom);
    void deleteClassRoom(int id);
}
