package com

import org.joda.time.LocalDateTime
import net.liftweb.json.JsonAST._
import net.liftweb.json.Extraction._
import net.liftweb.json.Printer._   


object Main {
	
	implicit val formats = net.liftweb.json.DefaultFormats + com.Custom.RedshiftDateTimeSerializer

	case class Event(date: LocalDateTime) {}

	def main(args: Array[String]) = {
		val e = Event(new LocalDateTime)
		println(pretty(render(decompose(e))))
	}
}