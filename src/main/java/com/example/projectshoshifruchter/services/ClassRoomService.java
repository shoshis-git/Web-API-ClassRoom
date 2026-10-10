package com.example.projectshoshifruchter.services;

import com.example.projectshoshifruchter.dto.ClassRoomMapper;
import com.example.projectshoshifruchter.dto.ClassRoomRequestDTO;
import com.example.projectshoshifruchter.dto.ClassRoomResponseDTO;
import com.example.projectshoshifruchter.entities.ClassRoom;
import com.example.projectshoshifruchter.exceptions.ResourceNotFoundException;
import com.example.projectshoshifruchter.repository.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClassRoomService implements ClassRoomServiceInterface {

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Override
    public List<ClassRoomResponseDTO> getClassRooms() {
        return StreamSupport
                .stream(classRoomRepository.findAll().spliterator(), false)
                .map(ClassRoomMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClassRoomResponseDTO getClassRoomById(int id) {
        ClassRoom classRoom = classRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ClassRoom with room number " + id + " was not found"));
        return ClassRoomMapper.toResponseDTO(classRoom);
    }

    @Override
    public ClassRoomResponseDTO getClassRoomByClassNumber(char classNumber) {
        ClassRoom classRoom = classRoomRepository.findByClassNumber(classNumber);
        if (classRoom == null) {
            throw new ResourceNotFoundException(
                    "ClassRoom with class number '" + classNumber + "' was not found");
        }
        return ClassRoomMapper.toResponseDTO(classRoom);
    }

    @Override
    public void addClass(ClassRoomRequestDTO dto) {
        // ממיר DTO → Entity ושומר ב-DB
        classRoomRepository.save(ClassRoomMapper.toEntity(dto));
    }

    @Override
    @Transactional
    public void updateClassRoom(int id, ClassRoomRequestDTO dto) {
        // מוצא את ה-Entity הקיימת ומעדכן אותה — לא מוחק ויוצר מחדש
        ClassRoom existing = classRoomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "ClassRoom with room number " + id + " was not found"));
        ClassRoomMapper.updateEntityFromDTO(dto, existing);
        classRoomRepository.save(existing);
    }

    @Override
    public void deleteClassRoom(int id) {
        if (!classRoomRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    "ClassRoom with room number " + id + " was not found");
        }
        classRoomRepository.deleteById(id);
    }
}
