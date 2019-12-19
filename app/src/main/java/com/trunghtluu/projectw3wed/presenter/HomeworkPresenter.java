package com.trunghtluu.projectw3wed.presenter;

import android.content.Context;

import androidx.room.Room;

import com.trunghtluu.projectw3wed.adapter.HomeworkRecyclerViewAdapter;
import com.trunghtluu.projectw3wed.database.HomeworkDB;
import com.trunghtluu.projectw3wed.database.HomeworkEntity;

public class HomeworkPresenter implements HomeworkContract.Presenter, HomeworkRecyclerViewAdapter.HomeworkAdapterDelegate {

    private HomeworkDB homeworkDB;

    private HomeworkContract.BaseView view;

    public HomeworkPresenter(HomeworkContract.BaseView view, Context context) {
        this.view = view;
        homeworkDB = Room.databaseBuilder(context, HomeworkDB.class, "homeworks.db")
                .allowMainThreadQueries()
                .build();
    }

    @Override
    public void insertHomework(HomeworkEntity homework) {
        homeworkDB.homeworkDao().insertHomeworks(homework);
    }

    @Override
    public HomeworkRecyclerViewAdapter loadHomework() {
        return new HomeworkRecyclerViewAdapter(homeworkDB.homeworkDao().loadHomeworks(), this);
    }

    @Override
    public void homeworkSelected(HomeworkEntity selected) {

    }
}
