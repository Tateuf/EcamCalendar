package com.ecam.Calendar.db;

import com.ecam.Calendar.model.Lecture;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class dbLectureTest {

    @Test
    void create() {
        ArrayList<String> teachers = new ArrayList<>();
        teachers.add("HSL");
        teachers.add("J3L");
        assertTrue(dbLecture.create(LocalDate.parse("2020-12-11"),
                                    "test-T1",teachers,"1D01",
                                    Time.valueOf("08:30:00"),Time.valueOf("12:00:00"),
                                    1));
        assertTrue((dbLecture.deleteLecture("test-T1")));
    }

    @Test
    void read() {
        ArrayList<String> teachers = new ArrayList<>();
        teachers.add("HSL");
        teachers.add("J3L");
        assertTrue(dbLecture.create(LocalDate.parse("2020-12-11"),
                "test-T1",teachers,"1D01",
                Time.valueOf("08:30:00"),Time.valueOf("12:00:00"),
                1));
        assertEquals(dbLecture.read("test-T1").get(0).getDay(),LocalDate.parse("2020-12-11"));
        assertTrue((dbLecture.deleteLecture("test-T1")));
    }

    @Test
    void deleteSession() {
        ArrayList<String> teachers = new ArrayList<>();
        teachers.add("HSL");
        teachers.add("J3L");
        assertTrue(dbLecture.create(LocalDate.parse("2020-12-11"),
                "test-T1",teachers,"1D01",
                Time.valueOf("08:30:00"),Time.valueOf("12:00:00"),
                3));
        assertTrue(dbLecture.deleteSession("test-T1",3));
    }

    @Test
    void deleteLecture() {
        ArrayList<String> teachers = new ArrayList<>();
        teachers.add("HSL");
        teachers.add("J3L");
        assertTrue(dbLecture.create(LocalDate.parse("2020-12-11"),
                "test-T1",teachers,"1D01",
                Time.valueOf("08:30:00"),Time.valueOf("12:00:00"),
                1));
        assertTrue(dbLecture.create(LocalDate.parse("2020-12-12"),
                "test-T1",teachers,"1D01",
                Time.valueOf("08:30:00"),Time.valueOf("12:00:00"),
                2));
        assertTrue((dbLecture.deleteLecture("test-T1")));
    }

    @Test
    void finalVerification(){
        ArrayList<Lecture> lectures = new ArrayList<>();
        assertEquals(dbLecture.read("test-T1"),lectures);
    }
}