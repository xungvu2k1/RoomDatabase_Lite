//package com.example.roomdatabase_lite
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.TextUtils
//import android.util.Log
//import android.widget.Toast
//import androidx.room.Room
//import com.example.roomdatabase_lite.databinding.ActivityMainBinding
//import kotlinx.coroutines.DelicateCoroutinesApi
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var db: UserDatabase
//
//    private lateinit var mActivityMainBinding: ActivityMainBinding
////    @OptIn(DelicateCoroutinesApi::class)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        mActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(mActivityMainBinding.root)
//        Log.e("checkabc", "a")
//
//        db = Room.databaseBuilder(
//            applicationContext,
//            UserDatabase::class.java, "user_database"
//        ).build()
//
//        mActivityMainBinding.btnAddUser.setOnClickListener {
////            val firstname = mActivityMainBinding.edtFirstName.text.toString()
////            val lastname = mActivityMainBinding.edtLastName.text.toString()
//            val firstname = "xung"
//            val lastname = "vu"
//            Log.e("checkabc", "b")
//
//            val userTmp = UserEntity(firstname, lastname)
//            Log.e("checkabc", "c")
//            GlobalScope.launch(Dispatchers.IO) {
//                db.userDao().insertUser(userTmp)
//            }
//            Toast.makeText(this, "Add user succesfully", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
package com.example.roomdatabase_lite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.roomdatabase_lite.databinding.ActivityMainBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var mActivityMainBinding: ActivityMainBinding
    private lateinit var userList : List<UserEntity>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mActivityMainBinding.root)

        mActivityMainBinding.btnAddUser.setOnClickListener {
            val firstname = mActivityMainBinding.edtFirstName.text.toString()
            val lastname = mActivityMainBinding.edtLastName.text.toString()

            val userTmp = UserEntity(firstname, lastname)
            GlobalScope.launch(Dispatchers.IO) {
                UserDatabase.getInstance(applicationContext).userDao().insertUser(userTmp)
            }
            Toast.makeText(this, "Add user", Toast.LENGTH_SHORT).show()
        }

        mActivityMainBinding.btnDeleteUser.setOnClickListener {
            val firstname = mActivityMainBinding.edtFirstName.text.toString()
            val lastname = mActivityMainBinding.edtLastName.text.toString()

            val userTmp = UserEntity(firstname, lastname)
            GlobalScope.launch(Dispatchers.IO) {
                UserDatabase.getInstance(applicationContext).userDao().delete(userTmp)
            }
            Toast.makeText(this, "Delete user", Toast.LENGTH_SHORT).show()
        }


//        val recycleView = mActivityMainBinding.rcvUser
//        recycleView.layoutManager = LinearLayoutManager(this)
//        userList = UserDatabase.getInstance(applicationContext).userDao().getAll()
//        GlobalScope.launch(Dispatchers.Main){
//            val adapter = UserAdapter(userList)
//            recycleView.adapter = adapter
//        }
    }

}