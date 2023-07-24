package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sqlite.database.MyDbHelper
import com.example.sqlite.databinding.ActivityMainBinding
import com.example.sqlite.models.Student

class MainActivity : AppCompatActivity() {

    lateinit var myDbHelper: MyDbHelper
    private lateinit var binding: ActivityMainBinding
    private  lateinit var studentList : MutableList<Student>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(this)


        studentList = ArrayList(myDbHelper.listStudents())

        myDbHelper.listStudents().forEach {
            Log.d("dbHelper", "$it")
        }

        binding.apply {
            saveBtn.setOnClickListener {
                val name = nameEt.text.toString()
                val age = ageEt.text.toString().toInt()
                val phone = phoneEt.text.toString()

                val student = Student(name = name, age = age, phoneNumber = phone)
                myDbHelper.addStudent(student)
                studentList.add(student)

            }
        }

    }
}