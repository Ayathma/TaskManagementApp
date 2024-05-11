package com.example.taskmanagementsystem

import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.madlab4.utils.setupDialog
import com.example.taskmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   private val mainBinding: ActivityMainBinding by lazy {
       ActivityMainBinding.inflate(layoutInflater)
   }
    private val addTaskDialog : Dialog by lazy {
        Dialog(this).apply {
            setupDialog(R.layout.add_task_dialog)
        }
    }
    private val updateTaskDialog : Dialog by lazy {
        Dialog(this).apply {
            setupDialog(R.layout.update_task_dialog)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

    }
}