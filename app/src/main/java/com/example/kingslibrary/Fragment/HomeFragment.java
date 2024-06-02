package com.example.kingslibrary.Fragment;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kingslibrary.ApiService;
import com.example.kingslibrary.Model.Book;
import com.example.kingslibrary.BookResponse;
import com.example.kingslibrary.R;
import com.example.kingslibrary.RetrofitClient;
import com.example.kingslibrary.Adapter.bookAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private ApiService apiService;
    private RecyclerView recyclerView;
    private com.example.kingslibrary.Adapter.bookAdapter bookAdapter;
    private List<Book> allBooks = new ArrayList<>();
    private String currentPublisher = null;
    private CardView selectedCardView = null;
    private TextView doubleDayText, signetBooksText, vikingPressText, grantText, vikingText, landOfEnchantmentText, philtrumPressText, nalText, putnamText, duttonText, scribnerText, randomHouseText, hardCaseCrimeText, cemetaryDanceText;
    private CardView doubleday, signetBooks, vikingPress, grant, viking, landOfEnchantment, philtrumPress, nal, putnam, dutton, scribner, randomHouse, hardCaseCrime, cemetaryDancePublications;
    Handler handler = new Handler(Looper.getMainLooper());
    Executor executor = Executors.newSingleThreadExecutor();
    private ProgressBar loadHome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        loadHome = view.findViewById(R.id.loadHome);

        doubleday = view.findViewById(R.id.doubleday);
        doubleDayText = view.findViewById(R.id.doubleday_text);
        signetBooks = view.findViewById(R.id.signet_books);
        signetBooksText = view.findViewById(R.id.signet_books_text);
        vikingPress = view.findViewById(R.id.viking_press);
        vikingPressText = view.findViewById(R.id.viking_press_text);
        grant = view.findViewById(R.id.grant);
        grantText = view.findViewById(R.id.grant_text);
        viking = view.findViewById(R.id.viking);
        vikingText = view.findViewById(R.id.viking_text);
        landOfEnchantment = view.findViewById(R.id.land_of_enchantment);
        landOfEnchantmentText = view.findViewById(R.id.land_of_enchantment_text);
        philtrumPress = view.findViewById(R.id.philtrum_press);
        philtrumPressText = view.findViewById(R.id.philtrum_press_text);
        nal = view.findViewById(R.id.nal);
        nalText = view.findViewById(R.id.nal_text);
        putnam = view.findViewById(R.id.putnam);
        putnamText = view.findViewById(R.id.putnam_text);
        dutton = view.findViewById(R.id.dutton);
        duttonText = view.findViewById(R.id.dutton_text);
        scribner = view.findViewById(R.id.scribner);
        scribnerText = view.findViewById(R.id.scribner_text);
        randomHouse = view.findViewById(R.id.random_house);
        randomHouseText = view.findViewById(R.id.random_house_text);
        hardCaseCrime = view.findViewById(R.id.hard_case_crime);
        hardCaseCrimeText = view.findViewById(R.id.hard_case_crime_text);
        cemetaryDancePublications = view.findViewById(R.id.cemetary_dance_publications);
        cemetaryDanceText = view.findViewById(R.id.cemetary_dance_publications_text);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        recyclerView = view.findViewById(R.id.rv_books);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        setCardViewClickListener(doubleday, "Doubleday", doubleDayText);
        setCardViewClickListener(signetBooks, "Signet Books", signetBooksText);
        setCardViewClickListener(vikingPress, "Viking Press", vikingPressText);
        setCardViewClickListener(grant, "Grant", grantText);
        setCardViewClickListener(viking, "Viking", vikingText);
        setCardViewClickListener(landOfEnchantment, "Land of Enchantment", landOfEnchantmentText);
        setCardViewClickListener(philtrumPress, "Philtrum Press (1984)Viking (1987)", philtrumPressText);
        setCardViewClickListener(nal, "NAL", nalText);
        setCardViewClickListener(putnam, "Putnam", putnamText);
        setCardViewClickListener(dutton, "Dutton", duttonText);
        setCardViewClickListener(scribner, "Scribner", scribnerText);
        setCardViewClickListener(randomHouse, "Random House", randomHouseText);
        setCardViewClickListener(hardCaseCrime, "Hard Case Crime", hardCaseCrimeText);
        setCardViewClickListener(cemetaryDancePublications, "Cemetery Dance Publications", cemetaryDanceText);

        loadAllBooks();

        return view;
    }

    private void setCardViewClickListener(CardView cardView, final String publisher, final TextView textView) {
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (publisher.equals(currentPublisher)) {
                    resetSelectedCardView();
                    currentPublisher = null;
                    bookAdapter.updateBooks(allBooks);
                } else {
                    resetSelectedCardView();
                    currentPublisher = publisher;
                    filterBooksByPublisher(publisher);
                    setSelectedCardView(cardView, textView);
                }
            }
        });
    }

    private void setSelectedCardView(CardView cardView, TextView textView) {
        selectedCardView = cardView;
        cardView.setCardBackgroundColor(getResources().getColor(R.color.bright_orange));
        textView.setTextColor(getResources().getColor(R.color.white));
    }

    private void resetSelectedCardView() {
        if (selectedCardView != null) {
            selectedCardView.setCardBackgroundColor(getResources().getColor(R.color.white));
            TextView textView = null;

            if (selectedCardView == doubleday) {
                textView = doubleDayText;
            } else if (selectedCardView == signetBooks) {
                textView = signetBooksText;
            } else if (selectedCardView == vikingPress) {
                textView = vikingPressText;
            } else if (selectedCardView == grant) {
                textView = grantText;
            } else if (selectedCardView == viking) {
                textView = vikingText;
            } else if (selectedCardView == landOfEnchantment) {
                textView = landOfEnchantmentText;
            } else if (selectedCardView == philtrumPress) {
                textView = philtrumPressText;
            } else if (selectedCardView == nal) {
                textView = nalText;
            } else if (selectedCardView == putnam) {
                textView = putnamText;
            } else if (selectedCardView == dutton) {
                textView = duttonText;
            } else if (selectedCardView == scribner) {
                textView = scribnerText;
            } else if (selectedCardView == randomHouse) {
                textView = randomHouseText;
            } else if (selectedCardView == hardCaseCrime) {
                textView = hardCaseCrimeText;
            } else if (selectedCardView == cemetaryDancePublications) {
                textView = cemetaryDanceText;
            }

            if (textView != null) {
                textView.setTextColor(getResources().getColor(R.color.bright_orange));
            }
        }
    }

    private void loadAllBooks() {
        loadHome.setVisibility(View.VISIBLE);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Call<BookResponse> call = apiService.getBooks();
                    Response<BookResponse> response = call.execute(); // Synchronous call

                    if (response.isSuccessful() && response.body() != null) {
                        allBooks = response.body().getData();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            bookAdapter = new bookAdapter(allBooks);
                            recyclerView.setAdapter(bookAdapter);
                            loadHome.setVisibility(View.GONE);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            loadHome.setVisibility(View.GONE);
                            // Optionally, show an error message to the user
                        }
                    });
                }
            }
        });
    }

    private void filterBooksByPublisher(String publisher) {
        loadHome.setVisibility(View.VISIBLE);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Book> filteredBooks = new ArrayList<>();
                    for (Book book : allBooks) {
                        if (book.getPublisher() != null && book.getPublisher().equals(publisher)) {
                            filteredBooks.add(book);
                        }
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            bookAdapter.updateBooks(filteredBooks);
                            loadHome.setVisibility(View.GONE);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            loadHome.setVisibility(View.GONE);
                            // Optionally, show an error message to the user
                        }
                    });
                }
            }
        });
    }
}
