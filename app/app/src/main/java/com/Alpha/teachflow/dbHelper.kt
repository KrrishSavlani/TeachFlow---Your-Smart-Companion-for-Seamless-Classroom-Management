package com.Alpha.teachflow

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("PRAGMA foreign_keys = ON;") // Enable foreign keys

        val createSchoolTable = """
            CREATE TABLE School (
                school_id INTEGER PRIMARY KEY AUTOINCREMENT,
                school_name TEXT NOT NULL,
                school_code TEXT UNIQUE,
                address TEXT NOT NULL,
                city TEXT NOT NULL,
                state TEXT NOT NULL,
                pincode TEXT NOT NULL,
                email TEXT UNIQUE NOT NULL,
                phone TEXT UNIQUE NOT NULL,
                alt_phone TEXT,
                principal_name TEXT NOT NULL,
                admin_email TEXT UNIQUE NOT NULL,
                admin_phone TEXT UNIQUE NOT NULL,
                proof_document TEXT NOT NULL, -- Store file path or URL
                username TEXT UNIQUE NOT NULL,
                password TEXT NOT NULL
            );
        """.trimIndent()

        val createMediumTable = """
            CREATE TABLE mediums (
                med_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                schoolId INTEGER NOT NULL,
                FOREIGN KEY(schoolId) REFERENCES School(school_id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createStandardTable = """
            CREATE TABLE standards (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                std INTEGER NOT NULL,
                schoolId INTEGER NOT NULL,
                mediumId INTEGER NOT NULL,
                FOREIGN KEY(schoolId) REFERENCES School(school_id) ON DELETE CASCADE,
                FOREIGN KEY(mediumId) REFERENCES mediums(med_id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createDivisionTable = """
            CREATE TABLE divisions (
                div_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                schoolId INTEGER NOT NULL,
                standardId INTEGER NOT NULL,
                FOREIGN KEY(schoolId) REFERENCES School(school_id) ON DELETE CASCADE,
                FOREIGN KEY(standardId) REFERENCES standards(id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createSubjectTable = """
            CREATE TABLE subjects (
                sub_id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                schoolId INTEGER NOT NULL,
                med_id INTEGER NOT NULL,
                FOREIGN KEY(schoolId) REFERENCES School(school_id) ON DELETE CASCADE,
                 FOREIGN KEY(med_id) REFERENCES mediums(med_id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createTeacherTable = """
            CREATE TABLE teachers (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                qualification TEXT NOT NULL,
                contact TEXT NOT NULL,
                schoolId INTEGER NOT NULL,
                FOREIGN KEY(schoolId) REFERENCES School(school_id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createSubjectTeacherTable = """
            CREATE TABLE subject_teachers (
                schoolId INTEGER NOT NULL,
                subjectId INTEGER NOT NULL,
                teacherId INTEGER NOT NULL,
                PRIMARY KEY (subjectId, teacherId),
                FOREIGN KEY(schoolId) REFERENCES School(school_id) ON DELETE CASCADE,
                FOREIGN KEY(subjectId) REFERENCES subjects(sub_id) ON DELETE CASCADE,
                FOREIGN KEY(teacherId) REFERENCES teachers(id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createStreamTable = """
            CREATE TABLE Stream (
                stream_id INTEGER PRIMARY KEY AUTOINCREMENT,
                stream_name VARCHAR(255) NOT NULL UNIQUE,
                school_id INTEGER NOT NULL,
                FOREIGN KEY (school_id) REFERENCES School(school_id) ON DELETE CASCADE
            );
        """.trimIndent()

        val createGroupTable = """
            CREATE TABLE GroupTable (
                group_id INTEGER PRIMARY KEY AUTOINCREMENT,
                group_name TEXT NOT NULL UNIQUE, -- Example: A Group, B Group
                description TEXT,
                stream_id INTEGER NOT NULL,
                FOREIGN KEY (stream_id) REFERENCES Stream(stream_id) ON DELETE CASCADE
            );
        """.trimIndent()

        // Execute table creation
        db.execSQL(createSchoolTable)
        db.execSQL(createMediumTable)
        db.execSQL(createStandardTable)
        db.execSQL(createDivisionTable)
        db.execSQL(createSubjectTable)
        db.execSQL(createTeacherTable)
        db.execSQL(createSubjectTeacherTable)
        db.execSQL(createStreamTable)
        db.execSQL(createGroupTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS GroupTable")
        db.execSQL("DROP TABLE IF EXISTS Stream")
        db.execSQL("DROP TABLE IF EXISTS subject_teachers")
        db.execSQL("DROP TABLE IF EXISTS teachers")
        db.execSQL("DROP TABLE IF EXISTS subjects")
        db.execSQL("DROP TABLE IF EXISTS divisions")
        db.execSQL("DROP TABLE IF EXISTS standards")
        db.execSQL("DROP TABLE IF EXISTS mediums")
        db.execSQL("DROP TABLE IF EXISTS School")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "TeachFlow.db"
        private const val DATABASE_VERSION = 1
    }
}
