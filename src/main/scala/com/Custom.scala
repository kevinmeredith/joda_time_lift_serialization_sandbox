package com

import org.joda.time._
import org.joda.time.format._
import net.liftweb.json._
import net.liftweb.util.ControlHelpers.tryo


object Custom {

	val fmt: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-mm-dd HH:mm:ss.SSS")

	// credit to http://stackoverflow.com/a/15996934/409976 for help
	case object RedshiftDateTimeSerializer extends CustomSerializer[LocalDateTime](format => (
		{
			case JString(s) => tryo(fmt.parseLocalDateTime(s)).openOr(throw new MappingException("Invalid date format " + s))
		    case JNull => null
	    },
	    {
		    case d: LocalDateTime => JString(fmt.print(d))
		}
	  ))
}