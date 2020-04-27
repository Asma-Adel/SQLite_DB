package com.example.sqlitedb;

import android.provider.BaseColumns;

public class contract {
    private contract(){}

    public static class StudentEntry implements BaseColumns{
        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_COURSE = "course";
    }
}
