package com.example.agripoc.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.agripoc.database.converter.DateConverter;
import com.example.agripoc.database.dao.AppDAO;
import com.example.agripoc.database.entity.LogInTable;


@Database(entities = {LogInTable.class}, version = 1, exportSchema = true )

@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile AppDatabase INSTANCE;

    // --- DAO ---
    public abstract AppDAO bootStrapDAO();
}
