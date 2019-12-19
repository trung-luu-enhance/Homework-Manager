package com.trunghtluu.projectw3wed.database;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HomeworkDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertHomeworks(HomeworkEntity homeworks);

    @Query("SELECT * FROM homeworks")
    public List<HomeworkEntity> loadHomeworks();
}
