package ir.sbu.softwareengineering_proposal.adapter.usersRecycler;

import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import ir.sbu.softwareengineering_proposal.R;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewHolder;
import ir.sbu.softwareengineering_proposal.adapter.RecyclerViewInteraction;
import ir.sbu.softwareengineering_proposal.model.User;

public class UsersItemViewHolder extends RecyclerViewHolder<User> {
    private TextView userNameTextView;
    private TextView roleTextView;
    private TextView userStatusTextView;

    public UsersItemViewHolder(@NotNull View itemView, @Nullable RecyclerViewInteraction interaction) {
        super(itemView, interaction);
        userNameTextView = itemView.findViewById(R.id.userNameTextView);
        userStatusTextView = itemView.findViewById(R.id.userStatusTextView);
        roleTextView = itemView.findViewById(R.id.roleTextView);
    }

    public void bind(User item) {
        userNameTextView.setText(item.getFirstName().concat(" ").concat(item.getLastName()));
        roleTextView.setText(item.getRoleId());
        userStatusTextView.setText("!!!!");
    }
}
