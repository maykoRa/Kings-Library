package com.example.kingslibrary.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.kingslibrary.Adapter.SearchAdapter;
import com.example.kingslibrary.ApiService;
import com.example.kingslibrary.BookResponse;
import com.example.kingslibrary.Model.Book;
import com.example.kingslibrary.R;
import com.example.kingslibrary.RetrofitClient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    private ApiService apiService;
    private RecyclerView rv_search;
    private EditText searchBookTitle;
    private ArrayList<Book> allBooks;
    private ArrayList<Book> filteredBooks;
    private SearchAdapter searchAdapter;
    private ProgressBar loadSearch;
    Handler handler = new Handler(Looper.getMainLooper());
    Executor executor = Executors.newSingleThreadExecutor();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchBookTitle = view.findViewById(R.id.searchBookByTitle);
        loadSearch = view.findViewById(R.id.loadSearch);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        rv_search = view.findViewById(R.id.rv_searchBooks);
        rv_search.setLayoutManager(new LinearLayoutManager(getContext()));

        allBooks = new ArrayList<>();
        filteredBooks = new ArrayList<>();
        searchAdapter = new SearchAdapter(filteredBooks);
        rv_search.setAdapter(searchAdapter);

        rv_search.setVisibility(View.GONE);
        loadSearch.setVisibility(View.GONE);

        searchBookTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

        fetchBooks();

        return view;
    }

    private void fetchBooks() {
        Call<BookResponse> call = apiService.getBooks();

        call.enqueue(new Callback<BookResponse>() {
            @Override
            public void onResponse(Call<BookResponse> call, Response<BookResponse> response) {
                if (response.isSuccessful()) {
                    allBooks = new ArrayList<>(response.body().getData());
                    filteredBooks.clear();
                    filteredBooks.addAll(allBooks);
                    searchAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<BookResponse> call, Throwable t) {

            }
        });
    }

    private void filter(String text) {
        filteredBooks.clear();
        if (text.isEmpty()) {
            rv_search.setVisibility(View.GONE);
        } else {
            loadSearch.setVisibility(View.VISIBLE);
            rv_search.setVisibility(View.GONE);

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (Book book : allBooks) {
                            if (book.getTitle().toLowerCase().contains(text.toLowerCase())) {
                                filteredBooks.add(book);
                            }
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                loadSearch.setVisibility(View.GONE);
                                rv_search.setVisibility(View.VISIBLE);
                                searchAdapter.notifyDataSetChanged();
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
