package ir.sbu.softwareengineering_proposal.adapter.professorsRecycler;

import android.view.View;
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

    public ProfessorItemViewHolder(@NotNull View itemView, @Nullable RecyclerViewInteraction interaction) {
        super(itemView, interaction);
        professorNameTextView = itemView.findViewById(R.id.professorNameTextView);
        facultyTextView = itemView.findViewById(R.id.facultyTextView);
        degreeTextView = itemView.findViewById(R.id.degreeTextView);
        educationalGroupTextView = itemView.findViewById(R.id.educationalGroupTextView);
        fieldOfStudyRecyclerView = itemView.findViewById(R.id.fieldOfStudyRecyclerView);
    }

    @Override
    public void bind(Professor item) {
        professorNameTextView.setText(item.getFirstName().concat(" ").concat(item.getLastName()));
        facultyTextView.setText(item.getFaculty());
        degreeTextView.setText(item.getDegree());
        educationalGroupTextView.setText(item.getGroup());
        fieldOfStudyRecyclerView.setAdapter(new FieldOfStudyRecyclerAdapter(item.getFieldsOfStudy()));
        fieldOfStudyRecyclerView.addItemDecoration(new HorizontalSpacingItemDecoration(3));
    }
}
