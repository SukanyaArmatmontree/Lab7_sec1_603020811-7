package com.example.Lab7DialogRV_Sec1_603020811_7
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab7.R
import com.myweb.lab7dialogrv.Student
import com.myweb.lab7dialogrv.StudentsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*

class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdapter(this.studentList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun addStudent(v: View) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)

        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener{
            studentList.add(Student(mDialogView.edt_id.text.toString(), mDialogView.edt_name.text.toString(),
                mDialogView.edt_age.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext, "The student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btnCancel.setOnClickListener () {
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData() {
        studentList.add(Student ("603020811-7", "Sukanya", 21))
        studentList.add(Student ("603021035-0", "Kanokon", 21))
    }
}