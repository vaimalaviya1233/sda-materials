/*
 * Copyright (c) 2021 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.android.contentprovidertodoclient.view

import android.content.ContentValues
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.contentprovidertodoclient.controller.ToDoAdapter
import com.raywenderlich.android.contentprovidertodoclient.controller.provider.ToDoContract.CONTENT_URI
import com.raywenderlich.android.contentprovidertodoclient.controller.provider.ToDoContract.ToDoTable.Columns.KEY_TODO_NAME
import com.raywenderlich.android.contentprovidertodoclient.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_to_do_item.view.*


/**
 * Main Screen
 */
class MainActivity : AppCompatActivity() {
  private var layoutManager: RecyclerView.LayoutManager? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    layoutManager = LinearLayoutManager(this)
    recyclerView.layoutManager = layoutManager
    recyclerView.adapter = ToDoAdapter(this)


    fab.setOnClickListener {
      val dialog = AlertDialog.Builder(this)
      dialog.setTitle("Add To Do Item")
      val view = layoutInflater.inflate(R.layout.dialog_to_do_item, null)
      dialog.setView(view)
      dialog.setPositiveButton("Add") { _: DialogInterface, _: Int ->
        if (view.edtToDoName.text.isNotEmpty()) {
          var values = ContentValues()
          values.put(KEY_TODO_NAME, view.edtToDoName.text.toString())
          this.contentResolver.insert(CONTENT_URI, values)
        }
      }
      dialog.setNegativeButton("Cancel") { _: DialogInterface, _: Int ->
      }
      dialog.show()
    }
  }
}
