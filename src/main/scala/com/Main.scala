package com

import org.joda.time.DateTime
import net.liftweb.json.JsonAST._
import net.liftweb.json.Extraction._
import net.liftweb.json.Printer._   


object Main {
	
	implicit val formats = net.liftweb.json.DefaultFormats + com.RedshiftDateTimeSerializer

	case class Event(date: DateTime) {}

	def main(args: Array[String]) = {
		val e = Event(new DateTime)
		println(pretty(render(decompose(e))))
	}
}