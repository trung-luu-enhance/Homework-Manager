package com.trunghtluu.projectw3wed.presenter;

import android.database.Cursor;

import com.trunghtluu.projectw3wed.adapter.HomeworkRecyclerViewAdapter;
import com.trunghtluu.projectw3wed.database.HomeworkEntity;

import java.util.List;

public interface HomeworkContract {

    interface Presenter {
        void insertHomework(HomeworkEntity homework);
        HomeworkRecyclerViewAdapter loadHomework();
    }

    interface BaseView {

    }

    interface ViewMain extends BaseView {
        void displayAllHomework();
    }

    interface ViewAdd extends BaseView {
        void insertHomework();
    }
}
