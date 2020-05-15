package ir.sbu.softwareengineering_proposal.adapter.proposalRecycler;

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
import ir.sbu.softwareengineering_proposal.model.Proposal;

public class ProposalViewHolder extends RecyclerViewHolder<Proposal> {
    private TextView proposalNameTextView;
    private TextView studentNameProposalTextView;
    private TextView hasSupervisorTextView;
    private RecyclerView fieldOfStudyRecyclerView2;
    private FieldOfStudyRecyclerAdapter adapter;

    public ProposalViewHolder(@NotNull View itemView, @Nullable RecyclerViewInteraction interaction) {
        super(itemView, interaction);
        proposalNameTextView = itemView.findViewById(R.id.ProposalNameTextView);
        studentNameProposalTextView = itemView.findViewById(R.id.studentNameProposalTextView);
        fieldOfStudyRecyclerView2 = itemView.findViewById(R.id.fieldOfStudyRecyclerView2);
        hasSupervisorTextView = itemView.findViewById(R.id.hasSupervisorTextView);
    }

    @Override
    public void bind(Proposal item) {
        proposalNameTextView.setText(item.getPersianTitle());
        studentNameProposalTextView.setText(
                item.getOwner().getFirstName().concat(" ").concat(item.getOwner().getLastName()));
        if (adapter == null) {
            adapter = new FieldOfStudyRecyclerAdapter(item.getFieldsOfStudy());
        }
        if (item.getSupervisor() == null){
            hasSupervisorTextView.setVisibility(View.VISIBLE);
        }else {
            hasSupervisorTextView.setVisibility(View.GONE);
        }
        fieldOfStudyRecyclerView2.setAdapter(adapter);
        fieldOfStudyRecyclerView2.addItemDecoration(new HorizontalSpacingItemDecoration(3));
    }

}
