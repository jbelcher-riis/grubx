package com.grubx.core.components;

import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

@Converter
public class TimestampConverter implements AttributeConverter<DateTime, Date> {

    /**
     * Converts DateTime to Database Date
     * 
     * @author jbelcher
     */
    @Override
    public Date convertToDatabaseColumn(final DateTime dateTime) {
	if (dateTime == null) {
	    return null;
	}
	return dateTime.toDate();
    }

    /**
     * Convert Database date to Java DateTime
     * 
     * @author jbelcher
     * 
     */
    @Override
    public DateTime convertToEntityAttribute(final Date dbDate) {
	if (dbDate == null) {
	    return null;
	}
	return new DateTime(dbDate);
    }

}
