package com.trunghtluu.projectw3wed.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trunghtluu.projectw3wed.R;
import com.trunghtluu.projectw3wed.database.HomeworkEntity;

import java.util.Collections;
import java.util.List;

public class HomeworkRecyclerViewAdapter extends RecyclerView.Adapter<HomeworkRecyclerViewAdapter.ViewHolder> {
    private HomeworkAdapterDelegate homeworkAdapterDelegate;


    public interface HomeworkAdapterDelegate{
        void homeworkSelected(HomeworkEntity selected);
    }

    private List<HomeworkEntity> list
            = Collections.emptyList();

    public HomeworkRecyclerViewAdapter(List<HomeworkEntity> list, HomeworkAdapterDelegate homeworkAdapterDelegate) {
        this.list = list;
        this.homeworkAdapterDelegate = homeworkAdapterDelegate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homework_card, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getIdTextView()
                .setText("ID: " + Integer.toString(list.get(position).id));
        holder.getWeekTextView()
                .setText("WEEK: " + Integer.toString(list.get(position).week));
        holder.getDayTextView()
                .setText("DAY: " + Integer.toString(list.get(position).day));
        holder.getSubjectTextView()
                .setText("SUBJECT: " + list.get(position).subject);
        holder.getCompleteTextView()
                .setText("COMPLETE: " + Boolean.toString(list.get(position).complete));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idTextView;
        TextView weekTextView;
        TextView dayTextView;
        TextView subjectTextView;
        TextView completeTextView;

        public ViewHolder(@NonNull View view) {
            super(view);

            this.idTextView = view.findViewById(R.id.id_card_textView);
            this.weekTextView = view.findViewById(R.id.week_card_textView);
            this.dayTextView = view.findViewById(R.id.day_card_textView);
            this.subjectTextView = view.findViewById(R.id.sub_card_textView);
            this.completeTextView = view.findViewById(R.id.complete_card_textView);
        }

        public TextView getIdTextView() {
            return idTextView;
        }

        public TextView getWeekTextView() {
            return weekTextView;
        }

        public TextView getDayTextView() {
            return dayTextView;
        }

        public TextView getSubjectTextView() {
            return subjectTextView;
        }

        public TextView getCompleteTextView() {return completeTextView; }
    }
}
