package com.test

import java.text.SimpleDateFormat
import java.util.Date

object Constant {
  def time():String = {
    val time = new SimpleDateFormat("HH:mm:ss").format(new Date)
    s"[${time}]"
  }
}
