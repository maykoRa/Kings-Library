package com.example.kingslibrary.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kingslibrary.Adapter.BookmarkAdapter;
import com.example.kingslibrary.Adapter.bookAdapter;
import com.example.kingslibrary.DatabaseHelper;
import com.example.kingslibrary.Model.Book;
import com.example.kingslibrary.R;

import java.util.ArrayList;
import java.util.HashSet;

public class BookmarkFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        DatabaseHelper dbHelper = new DatabaseHelper(getContext());

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(new BookmarkAdapter(dbHelper.getBookmarked(), getContext()));

        return view;
    }
}