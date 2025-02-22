package com.Alpha.teachflow

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RegisterOperation(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onConfigure(db: SQLiteDatabase) {
        super.onConfigure(db)
        db.setForeignKeyConstraintsEnabled(true) // Ensure foreign keys are enabled
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Tables are already created in dbHelper.kt, so we don't need to create them here.
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS School")
        db.execSQL("DROP TABLE IF EXISTS mediums")
        db.execSQL("DROP TABLE IF EXISTS standards")
        db.execSQL("DROP TABLE IF EXISTS divisions")
        db.execSQL("DROP TABLE IF EXISTS subjects")
        db.execSQL("DROP TABLE IF EXISTS teachers")
        onCreate(db)
    }

    // ✅ Insert School
    fun insertSchool(
        schoolName: String,
        schoolCode: String,
        address: String,
        city: String,
        state: String,
        pincode: String,
        email: String,
        phone: String,
        altPhone: String?,
        principalName: String,
        adminEmail: String,
        adminPhone: String,
        proofDocument: String,
        username: String,
        password: String
    ): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("school_name", schoolName)
            put("school_code", schoolCode)
            put("address", address)
            put("city", city)
            put("state", state)
            put("pincode", pincode)
            put("email", email)
            put("phone", phone)
            put("alt_phone", altPhone)
            put("principal_name", principalName)
            put("admin_email", adminEmail)
            put("admin_phone", adminPhone)
            put("proof_document", proofDocument)
            put("username", username)
            put("password", password)
        }

        val result = db.insert("School", null, values)
        db.close()
        return result != -1L
    }

    // ✅ Insert Medium (Requires school_id)
    fun insertMedium(name: String, schoolId: Int): Boolean {
        return insertData("mediums", ContentValues().apply {
            put("name", name)
            put("school_id", schoolId)
        })
    }

    // ✅ Insert Standard (Requires school_id, medium_id)
    fun insertStandard(std: Int, schoolId: Int, mediumId: Int): Boolean {
        return insertData("standards", ContentValues().apply {
            put("std", std)
            put("school_id", schoolId)
            put("medium_id", mediumId)
        })
    }

    // ✅ Insert Division (Requires school_id, standard_id)
    fun insertDivision(name: String, schoolId: Int, standardId: Int): Boolean {
        return insertData("divisions", ContentValues().apply {
            put("name", name)
            put("school_id", schoolId)
            put("standard_id", standardId)
        })
    }

    // ✅ Insert Subject (Requires school_id)
    fun insertSubject(name: String, schoolId: Int): Boolean {
        return insertData("subjects", ContentValues().apply {
            put("name", name)
            put("school_id", schoolId)
        })
    }

    // ✅ Insert Teacher (Requires school_id)
    fun insertTeacher(name: String, qualification: String, contact: String, schoolId: Int): Boolean {
        return insertData("teachers", ContentValues().apply {
            put("name", name)
            put("qualification", qualification)
            put("contact", contact)
            put("school_id", schoolId)
        })
    }

    // ✅ Generic function to insert data
    private fun insertData(tableName: String, values: ContentValues): Boolean {
        val db = this.writableDatabase
        val result = db.insert(tableName, null, values)
        db.close()
        return result != -1L
    }

    companion object {
        private const val DATABASE_NAME = "TeachFlow.db"
        private const val DATABASE_VERSION = 1
    }
}
