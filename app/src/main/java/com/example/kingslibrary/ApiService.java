package com.example.kingslibrary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/books")
    Call<BookResponse> getBooks();

    @GET("api/books")
    Call<BookResponse> getBooksByPublisher(@Query("Publisher") String publisher);

}
