package com.example.projectshoshifruchter.controllers;

import com.example.projectshoshifruchter.dto.ClassRoomRequestDTO;
import com.example.projectshoshifruchter.dto.ClassRoomResponseDTO;
import com.example.projectshoshifruchter.services.ClassRoomServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
@Tag(name = "ClassRoom", description = "ניהול כיתות בית ספר")
public class ClassRoomController {

    @Autowired
    private ClassRoomServiceInterface classRoomService;

    @Operation(summary = "קבלת כל הכיתות", description = "מחזיר רשימה של כל הכיתות הקיימות במערכת")
    @ApiResponse(responseCode = "200", description = "הרשימה הוחזרה בהצלחה")
    @GetMapping
    public ResponseEntity<List<ClassRoomResponseDTO>> getClassRooms() {
        return ResponseEntity.ok(classRoomService.getClassRooms());
    }

    @Operation(summary = "קבלת כיתה לפי מספר חדר", description = "מחזיר כיתה בודדת לפי מספר החדר")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "הכיתה נמצאה והוחזרה"),
            @ApiResponse(responseCode = "404", description = "כיתה עם המספר שצוין לא קיימת")
    })
    @GetMapping("/{roomNumber}")
    public ResponseEntity<ClassRoomResponseDTO> getClassByRoomNumber(
            @Parameter(description = "מספר החדר לחיפוש", example = "101")
            @PathVariable int roomNumber) {
        return ResponseEntity.ok(classRoomService.getClassRoomById(roomNumber));
    }

    @Operation(summary = "הוספת כיתה חדשה", description = "יוצר רשומת כיתה חדשה במערכת")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "הכיתה נוצרה בהצלחה"),
            @ApiResponse(responseCode = "400", description = "הנתונים שנשלחו אינם תקינים")
    })
    @PostMapping
    public ResponseEntity<Void> addClass(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "פרטי הכיתה החדשה")
            @Valid @RequestBody ClassRoomRequestDTO dto) {
        classRoomService.addClass(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "עדכון כיתה קיימת", description = "מעדכן את פרטי הכיתה לפי מספר החדר")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "הכיתה עודכנה בהצלחה"),
            @ApiResponse(responseCode = "400", description = "הנתונים שנשלחו אינם תקינים"),
            @ApiResponse(responseCode = "404", description = "כיתה עם המספר שצוין לא קיימת")
    })
    @PutMapping("/{roomNumber}")
    public ResponseEntity<Void> updateClass(
            @Parameter(description = "מספר החדר לעדכון", example = "101")
            @PathVariable int roomNumber,
            @Valid @RequestBody ClassRoomRequestDTO dto) {
        classRoomService.updateClassRoom(roomNumber, dto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "מחיקת כיתה", description = "מוחק כיתה קיימת לפי מספר החדר")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "הכיתה נמחקה בהצלחה"),
            @ApiResponse(responseCode = "404", description = "כיתה עם המספר שצוין לא קיימת")
    })
    @DeleteMapping("/{roomNumber}")
    public ResponseEntity<Void> deleteClass(
            @Parameter(description = "מספר החדר למחיקה", example = "101")
            @PathVariable int roomNumber) {
        classRoomService.deleteClassRoom(roomNumber);
        return ResponseEntity.noContent().build();
    }
}
