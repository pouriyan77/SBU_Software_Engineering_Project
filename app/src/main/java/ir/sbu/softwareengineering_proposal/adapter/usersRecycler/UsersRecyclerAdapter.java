package ir.sbu.softwareengineering_proposal.adapter.usersRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.sbu.softwareengineering_proposal.R;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction;
import ir.sbu.softwareengineering_proposal.model.User;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder<User>> {

    private List<User> userList;
    private RecyclerViewInteraction recyclerViewInteraction;

    public UsersRecyclerAdapter(List<User> userList, RecyclerViewInteraction recyclerViewInteraction) {
        this.userList = userList;
        this.recyclerViewInteraction = recyclerViewInteraction;
    }

    @NonNull
    @Override
    public RecyclerViewHolder<User> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycler_user_item_layout, parent, false
        );
        return new UsersItemViewHolder(view, recyclerViewInteraction);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder<User> holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
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
