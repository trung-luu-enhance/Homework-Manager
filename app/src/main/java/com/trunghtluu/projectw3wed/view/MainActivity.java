package com.trunghtluu.projectw3wed.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.trunghtluu.projectw3wed.R;
import com.trunghtluu.projectw3wed.adapter.HomeworkRecyclerViewAdapter;
import com.trunghtluu.projectw3wed.database.HomeworkEntity;
import com.trunghtluu.projectw3wed.presenter.HomeworkContract;
import com.trunghtluu.projectw3wed.presenter.HomeworkPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements HomeworkContract.ViewMain,HomeworkRecyclerViewAdapter.HomeworkAdapterDelegate {

    @BindView(R.id.main_recyclerView)
    RecyclerView mainRecyclerView;

    @BindView(R.id.add_main_button)
    Button addButton;

    private AddFragment addFragment = new AddFragment();

    private HomeworkRecyclerViewAdapter homeworkRecyclerViewAdapter;

    private HomeworkPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        addButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            addFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_framelayout, addFragment)
                    .addToBackStack(addFragment.getTag())
                    .commit();
        });

        presenter = new HomeworkPresenter(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHomework();
    }

    public void loadHomework() {

        homeworkRecyclerViewAdapter = presenter.loadHomework();
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mainRecyclerView.addItemDecoration(itemDecoration);
        mainRecyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        mainRecyclerView.setAdapter(homeworkRecyclerViewAdapter);
    }

    @Override
    public void displayAllHomework() {

    }

    @Override
    public void homeworkSelected(HomeworkEntity selected) {

    }
}
