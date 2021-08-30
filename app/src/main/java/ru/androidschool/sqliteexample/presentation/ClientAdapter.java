package ru.androidschool.sqliteexample.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import ru.androidschool.sqliteexample.R;
import ru.androidschool.sqliteexample.domain.model.Book;
import ru.androidschool.sqliteexample.domain.model.Client;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientViewHolder> {

    private final List<Client> mClientList;

    public ClientAdapter(List<Client> clientList) {
        mClientList = clientList;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        return new ClientViewHolder(inflater.inflate(R.layout.layout_client_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder clientViewHolder, int position) {
        clientViewHolder.bind(mClientList.get(position));
    }

    @Override
    public int getItemCount() {
        return mClientList.size();
    }

    public static class ClientViewHolder extends RecyclerView.ViewHolder {

        private final TextView mNameView;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameView = itemView.findViewById(R.id.clientName);
        }

        void bind(@NonNull Client client) {
            mNameView.setText(client.name);
        }
    }
}
