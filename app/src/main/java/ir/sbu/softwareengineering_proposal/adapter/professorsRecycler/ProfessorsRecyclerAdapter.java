package ir.sbu.softwareengineering_proposal.adapter.professorsRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.sbu.softwareengineering_proposal.R;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction;
import ir.sbu.softwareengineering_proposal.model.Professor;

public class ProfessorsRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder<Professor>> {

    private List<Professor> professorList;
    private RecyclerViewInteraction recyclerViewInteraction;

    public ProfessorsRecyclerAdapter(List<Professor> professorList, RecyclerViewInteraction recyclerViewInteraction) {
        this.professorList = professorList;
        this.recyclerViewInteraction = recyclerViewInteraction;
    }

    @NonNull
    @Override
    public RecyclerViewHolder<Professor> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_professor_item_layout, parent, false);
        return new ProfessorItemViewHolder(view, recyclerViewInteraction);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder<Professor> holder, int position) {
        holder.bind(professorList.get(position));
    }

    @Override
    public int getItemCount() {
        return professorList.size();
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
