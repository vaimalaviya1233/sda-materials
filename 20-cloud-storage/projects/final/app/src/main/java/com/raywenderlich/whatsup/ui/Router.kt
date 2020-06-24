/*
 * Copyright (c) 2019 Razeware LLC
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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.whatsup.ui

import android.app.Activity
import android.content.Intent
import com.raywenderlich.whatsup.R
import com.raywenderlich.whatsup.ui.home.HomeActivity
import com.raywenderlich.whatsup.ui.login.LoginActivity

class Router {

  companion object {
    private const val IMAGE_TYPE = "image/jpeg"
  }

  fun startHomeScreen(activity: Activity) {
    val intent = HomeActivity.createIntent(activity)
    activity.startActivity(intent)
  }

  fun startLoginScreen(activity: Activity) {
    val intent = LoginActivity.createIntent(activity)
    activity.startActivity(intent)
  }

  fun showImagePicker(activity: Activity) {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.type = IMAGE_TYPE
    intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true)
    activity.startActivityForResult(Intent.createChooser(intent, activity.getString(R.string.image_chooser_title)), HomeActivity.CHOOSE_IMAGE_REQUEST_CODE)
  }
}