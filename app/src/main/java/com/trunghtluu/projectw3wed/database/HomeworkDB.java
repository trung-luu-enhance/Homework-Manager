package com.trunghtluu.projectw3wed.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {HomeworkEntity.class}, version = 1)
public abstract class HomeworkDB extends RoomDatabase {
    public abstract HomeworkDAO homeworkDao();
}
