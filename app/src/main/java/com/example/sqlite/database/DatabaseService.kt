package com.example.sqlite.database

import com.example.sqlite.models.Student

interface DatabaseService {
    fun addStudent(student: Student)

    fun listStudents(): List<Student>

    fun editStudent(student: Student)

    fun deleteStudent(student: Student)

    fun getStudentsCount(): Int

//    fun getStudentsById(id: Int): Student


}