package com.atyeti.util;

import java.util.logging.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomFormatter extends Formatter {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    @Override
    public String format(LogRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(sdf.format(new Date(record.getMillis())))
                .append(" - ")
                .append(record.getLevel().getName())
                .append(" - ")
                .append(formatMessage(record))
                .append(System.lineSeparator());
        return sb.toString();
    }
}

