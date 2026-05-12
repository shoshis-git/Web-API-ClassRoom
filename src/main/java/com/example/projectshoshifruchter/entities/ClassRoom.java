package com.example.projectshoshifruchter.entities;

import java.util.Objects;

public class ClassRoom {

    int roomNumber;
    char classNumber;
    String teacher;
    int amountPupil;


    public ClassRoom(int roomNumber, char classNumber, String teacher, int amountPupil) {
        this.roomNumber = roomNumber;
        this.classNumber = classNumber;
        this.teacher = teacher;
        this.amountPupil = amountPupil;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public char getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(char classNumber) {
        this.classNumber = classNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getAmountPupil() {
        return amountPupil;
    }

    public void setAmountPupil(int amountPupil) {
        this.amountPupil = amountPupil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return roomNumber == classRoom.roomNumber && classNumber == classRoom.classNumber && amountPupil == classRoom.amountPupil && Objects.equals(teacher, classRoom.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, classNumber, teacher, amountPupil);
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "roomNumber=" + roomNumber +
                ", classNumber=" + classNumber +
                ", teacher='" + teacher + '\'' +
                ", amountPupil=" + amountPupil +
                '}';
    }
}
