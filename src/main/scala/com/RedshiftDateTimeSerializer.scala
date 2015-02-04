package com

import org.joda.time._
import org.joda.time.format._
import net.liftweb.json._
import net.liftweb.util.ControlHelpers.tryo


// credit to http://stackoverflow.com/a/15996934/409976 for help
case object RedshiftDateTimeSerializer extends CustomSerializer[DateTime](format => (
	{
		case JString(s) => tryo(new DateTime(s)).openOr(throw new MappingException("Invalid date format " + s))
	    case JNull => null
    },
    {
	    case d: DateTime => {
	    	val fmt: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-mm-dd HH:mm:ss.SSS")
	    	JString(fmt.print(d.toLocalDateTime))
    	} 
	}
  ))