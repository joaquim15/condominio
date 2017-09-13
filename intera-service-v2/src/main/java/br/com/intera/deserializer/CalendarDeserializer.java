package br.com.intera.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Custom serialization for Calendar
 * 
 * @author vagner
 *
 */
public class CalendarDeserializer extends JsonDeserializer<Calendar> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm");

	@Override
	public Calendar deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException, JsonProcessingException {

		String dateAsString = jsonParser.getText();

		if (StringUtils.isNotEmpty(dateAsString)) {
			try {
				Date date = dateFormat.parse(dateAsString);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				return calendar;
			} catch (ParseException e) {
				throw new IOException(e);
			}
		}

		return null;
	}

}
