package com.trunghtluu.projectw3wed.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trunghtluu.projectw3wed.R;
import com.trunghtluu.projectw3wed.database.HomeworkEntity;
import com.trunghtluu.projectw3wed.presenter.HomeworkContract;
import com.trunghtluu.projectw3wed.presenter.HomeworkPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFragment extends Fragment implements HomeworkContract.ViewAdd {

    @BindView(R.id.week_add_editText)
    EditText weekEditText;

    @BindView(R.id.day_add_editText)
    EditText dayEditText;

    @BindView(R.id.sub_add_editText)
    EditText subjectEditText;

    @BindView(R.id.add_add_button)
    Button addButton;

    HomeworkPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_hw_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter = new HomeworkPresenter(this, view.getContext());

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertHomework();
                getActivity().getSupportFragmentManager().popBackStack();
                ((MainActivity) getActivity()).onResume();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("TAG_X", "Attach");
    }

    @Override
    public void insertHomework() {
        int week = Integer.parseInt(weekEditText.getText().toString());
        int day = Integer.parseInt(dayEditText.getText().toString());
        String subject = subjectEditText.getText().toString();
        presenter.insertHomework(new HomeworkEntity(week, day, subject));
    }
}
