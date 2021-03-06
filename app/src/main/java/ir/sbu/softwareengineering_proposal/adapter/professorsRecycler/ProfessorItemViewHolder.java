package ir.sbu.softwareengineering_proposal.adapter.professorsRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ir.sbu.softwareengineering_proposal.R;
import ir.sbu.softwareengineering_proposal.adapter.HorizontalSpacingItemDecoration;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction;
import ir.sbu.softwareengineering_proposal.adapter.fieldOfStudyRecycler.FieldOfStudyRecyclerAdapter;
import ir.sbu.softwareengineering_proposal.model.Professor;

public class ProfessorItemViewHolder extends RecyclerViewHolder<Professor> {
    private TextView professorNameTextView;
    private TextView facultyTextView;
    private TextView degreeTextView;
    private TextView educationalGroupTextView;
    private RecyclerView fieldOfStudyRecyclerView;
    private FieldOfStudyRecyclerAdapter adapter;
    private ImageView selectedIcon;

    public ProfessorItemViewHolder(@NotNull View itemView, @Nullable RecyclerViewInteraction interaction) {
        super(itemView, interaction);
        professorNameTextView = itemView.findViewById(R.id.professorNameTextView);
        facultyTextView = itemView.findViewById(R.id.facultyTextView);
        degreeTextView = itemView.findViewById(R.id.degreeTextView);
        educationalGroupTextView = itemView.findViewById(R.id.educationalGroupTextView);
        fieldOfStudyRecyclerView = itemView.findViewById(R.id.fieldOfStudyRecyclerView);
        selectedIcon = itemView.findViewById(R.id.selectedIcon);
    }

    @Override
    public void bind(Professor item) {
        professorNameTextView.setText(item.getFirstName().concat(" ").concat(item.getLastName()));
//        facultyTextView.setText(item.getFaculty());
        degreeTextView.setText(item.getDegree());
        if (item.getMajor() != null) {
            educationalGroupTextView.setText(item.getMajor().getTitle());
        }else {
            educationalGroupTextView.setText("مشخص نشده");
        }
        if (adapter == null){
            adapter = new FieldOfStudyRecyclerAdapter(item.getFieldsOfStudy());
        }
        fieldOfStudyRecyclerView.setAdapter(adapter);
        fieldOfStudyRecyclerView.addItemDecoration(new HorizontalSpacingItemDecoration(3));
        selectedIcon.setVisibility(item.getSelected() ? View.VISIBLE : View.GONE);
    }
}
