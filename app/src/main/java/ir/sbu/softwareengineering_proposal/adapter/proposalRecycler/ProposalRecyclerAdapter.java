package ir.sbu.softwareengineering_proposal.adapter.proposalRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.sbu.softwareengineering_proposal.R;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction;
import ir.sbu.softwareengineering_proposal.model.Proposal;

public class ProposalRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder<Proposal>> {

    private List<Proposal> proposalList;
    private RecyclerViewInteraction recyclerViewInteraction;

    public ProposalRecyclerAdapter(List<Proposal> proposalList, RecyclerViewInteraction recyclerViewInteraction) {
        this.proposalList = proposalList;
        this.recyclerViewInteraction = recyclerViewInteraction;
    }

    @NonNull
    @Override
    public RecyclerViewHolder<Proposal> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_proposal_item_layout, parent, false);
        return new ProposalViewHolder(view, recyclerViewInteraction);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder<Proposal> holder, int position) {
        holder.bind(proposalList.get(position));
    }

    @Override
    public int getItemCount() {
        return proposalList.size();
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
