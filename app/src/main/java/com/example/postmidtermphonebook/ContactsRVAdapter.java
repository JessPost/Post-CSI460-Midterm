package com.example.postmidtermphonebook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsRVAdapter extends RecyclerView.Adapter<ContactsRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<ContactModal> contactsModalArrayList;
    private Context context;

    // constructor
    public ContactsRVAdapter(ArrayList<ContactModal> coontactsModalArrayList, Context context) {
        this.contactsModalArrayList = coontactsModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        ContactModal modal = contactsModalArrayList.get(position);
        holder.fName.setText(modal.getFirstName());
        holder.lName.setText(modal.getLastName());
        holder.phone.setText(modal.getPhoneNumber());
        holder.address.setText(modal.getAddress());

        // below line is to add on click listener for our recycler view item.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are calling an intent.
                Intent i = new Intent(context, UpdateContactActivity.class);

                // below we are passing all our values.
                i.putExtra("fname", modal.getFirstName());
                i.putExtra("lname", modal.getLastName());
                i.putExtra("phone", modal.getPhoneNumber());
                i.putExtra("address", modal.getAddress());

                // starting our activity.
                context.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        // returning the size of our array list
        return contactsModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView fName, lName, phone, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            fName = itemView.findViewById(R.id.idTVFirstName);
            lName = itemView.findViewById(R.id.idTVLastName);
            phone = itemView.findViewById(R.id.idTVPhoneNumber);
            address = itemView.findViewById(R.id.idTVAddress);
        }
    }
}
