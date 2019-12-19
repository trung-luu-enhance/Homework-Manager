package com.trunghtluu.projectw3wed.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "homeworks")
public class HomeworkEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "week")
    public int week;

    @ColumnInfo(name = "day")
    public int day;

    @ColumnInfo(name = "subject")
    public String subject;

    @ColumnInfo(name = "complete")
    public boolean complete;

    public HomeworkEntity(int week, int day, String subject) {
        this.week = week;
        this.day = day;
        this.subject = subject;
        this.complete = false;
    }
}
