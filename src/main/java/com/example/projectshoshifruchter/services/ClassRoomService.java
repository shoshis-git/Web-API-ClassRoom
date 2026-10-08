package com.example.projectshoshifruchter.services;

import com.example.projectshoshifruchter.entities.ClassRoom;
import com.example.projectshoshifruchter.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClassRoomService implements ClassRoomServiceInterface {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoom> getClassRooms() {
        return (List<ClassRoom>) classRoomRepository.findAll();
    }

    @Override
    public ClassRoom getClassRoomById(int id) {
        return classRoomRepository.findById(id).orElse(null);
    }

    @Override
    public ClassRoom getClassRoomByClassNumber(char classNumber) {
        return classRoomRepository.findByClassNumber(classNumber);
    }

    @Override
    public void addClass(ClassRoom classRoom) {
        classRoomRepository.save(classRoom);
    }

    @Override
    @Transactional
    public void updateClassRoom(int id, ClassRoom classRoom) {
        // save() עושה upsert לפי ה-ID — אין צורך למחוק קודם
        classRoom.setRoomNumber(id);
        classRoomRepository.save(classRoom);
    }

    @Override
    public void deleteClassRoom(int id) {
        classRoomRepository.deleteById(id);
    }
}
