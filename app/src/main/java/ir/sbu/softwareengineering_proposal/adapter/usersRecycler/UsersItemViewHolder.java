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

        itemView.setOnClickListener(v -> {
            interaction.onItemClickedListener(getAdapterPosition());
        });
    }

    public void bind(User item) {
        userNameTextView.setText(item.getFirstName().concat(" ").concat(item.getLastName()));
        if (item.getRoleId() == 1) {
            roleTextView.setText("ادمین");
        } else if (item.getRoleId() == 2) {
            roleTextView.setText("دانشجو");
        } else if (item.getRoleId() == 3) {
            roleTextView.setText("مدیرگروه");
        } else {
            roleTextView.setText("استاد");
        }
        if (item.getCompleteProfileStatus()){
            userStatusTextView.setText("تکمیل شده");
            userStatusTextView.setTextColor(
                    itemView.getContext()
                            .getResources().getColor(R.color.successColor));
        }else {
            userStatusTextView.setText("تکمیل نشده");
            userStatusTextView.setTextColor(
                    itemView.getContext()
                            .getResources().getColor(R.color.errorColor));
        }
    }
}
