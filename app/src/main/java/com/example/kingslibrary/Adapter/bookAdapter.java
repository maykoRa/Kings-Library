package com.example.kingslibrary.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kingslibrary.Activity.BookDetailsActivity;
import com.example.kingslibrary.DatabaseHelper;
import com.example.kingslibrary.Model.Book;
import com.example.kingslibrary.R;
import com.squareup.picasso.Picasso;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class bookAdapter extends RecyclerView.Adapter<bookAdapter.UserViewHolder>{
    public List<Book> bookList;

    public bookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void updateBooks(List<Book> bookList) {
        this.bookList = bookList;
        notifyDataSetChanged();
    }

    public bookAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_book, parent, false);
        return new UserViewHolder(view);
    }

    public void onBindViewHolder(@NonNull bookAdapter.UserViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.titleBook.setText(book.getTitle());
        holder.publisherBook.setText(book.getPublisher());
        setBookCoverImage(book, holder.imageBook);

        holder.imageBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), BookDetailsActivity.class);
                intent.putExtra("title", book.getTitle());
                intent.putExtra("publisher", book.getPublisher());
                intent.putExtra("id", book.getId());
                intent.putExtra("year", book.getYear());
                intent.putExtra("isbn", book.getISBN());
                intent.putExtra("pages", book.getPages());
                holder.itemView.getContext().startActivity(intent);
            }
        });

        holder.bookmark.setOnClickListener(v -> {
            DatabaseHelper dbHelper = new DatabaseHelper(v.getContext());
            if (dbHelper.isBookBookmarked(book.getId())) {
                dbHelper.removeBookmark(book);
                Toast.makeText(v.getContext(), "Book Removed!" , Toast.LENGTH_SHORT).show();
            } else {
                dbHelper.insertBookmark(book);
                Toast.makeText(v.getContext(), "Book Successfully Added!" , Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int getItemCount() {
        return bookList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageBook;
        private ImageView bookmark;
        private TextView titleBook;
        private TextView publisherBook;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            imageBook = itemView.findViewById(R.id.bookImage);
            titleBook = itemView.findViewById(R.id.bookTitle);
            publisherBook = itemView.findViewById(R.id.bookPublisher);
            bookmark = itemView.findViewById(R.id.bookmark_togel);
        }
    }

    private void setBookCoverImage(Book book, ImageView imageView) {
        if (book.getId() == 1) {
            Picasso.get().load(R.drawable.carrie).resize(200, 300).into(imageView);
        } else if (book.getId() == 2) {
            Picasso.get().load(R.drawable.salems_lot).resize(200, 300).into(imageView);
        } else if (book.getId() == 3) {
            Picasso.get().load(R.drawable.the_shining).resize(200, 300).into(imageView);
        } else if (book.getId() == 4) {
            Picasso.get().load(R.drawable.rage).resize(200, 300).into(imageView);
        } else if (book.getId() == 5) {
            Picasso.get().load(R.drawable.the_stand).resize(200, 300).into(imageView);
        } else if (book.getId() == 6) {
            Picasso.get().load(R.drawable.the_long_walk).resize(200, 300).into(imageView);
        } else if (book.getId() == 7) {
            Picasso.get().load(R.drawable.the_dead_zone).resize(200, 300).into(imageView);
        } else if (book.getId() == 8) {
            Picasso.get().load(R.drawable.firestarter).resize(200, 300).into(imageView);
        } else if (book.getId() == 9) {
            Picasso.get().load(R.drawable.roadwork).resize(200, 300).into(imageView);
        } else if (book.getId() == 10) {
            Picasso.get().load(R.drawable.cujo).resize(200, 300).into(imageView);
        } else if (book.getId() == 11) {
            Picasso.get().load(R.drawable.the_running_man).resize(200, 300).into(imageView);
        } else if (book.getId() == 12) {
            Picasso.get().load(R.drawable.the_dark_tower_1).resize(200, 300).into(imageView);
        } else if (book.getId() == 13) {
            Picasso.get().load(R.drawable.christine).resize(200, 300).into(imageView);
        } else if (book.getId() == 14) {
            Picasso.get().load(R.drawable.pet_semetary).resize(200, 300).into(imageView);
        } else if (book.getId() == 15) {
            Picasso.get().load(R.drawable.cycle_of_the_werewolf).resize(200, 300).into(imageView);
        } else if (book.getId() == 16) {
            Picasso.get().load(R.drawable.the_talisman).resize(200, 300).into(imageView);
        } else if (book.getId() == 17) {
            Picasso.get().load(R.drawable.the_eyes_of_the_dragon).resize(200, 300).into(imageView);
        } else if (book.getId() == 18) {
            Picasso.get().load(R.drawable.thinner).resize(200, 300).into(imageView);
        } else if (book.getId() == 19) {
            Picasso.get().load(R.drawable.it).resize(200, 300).into(imageView);
        } else if (book.getId() == 20) {
            Picasso.get().load(R.drawable.the_dark_tower_2).resize(200, 300).into(imageView);
        } else if (book.getId() == 21) {
            Picasso.get().load(R.drawable.misery).resize(200, 300).into(imageView);
        } else if (book.getId() == 22) {
            Picasso.get().load(R.drawable.the_tommyknockers).resize(200, 300).into(imageView);
        } else if (book.getId() == 23) {
            Picasso.get().load(R.drawable.the_dark_half).resize(200, 300).into(imageView);
        } else if (book.getId() == 24) {
            Picasso.get().load(R.drawable.the_stand_uncut).resize(200, 300).into(imageView);
        } else if (book.getId() == 25) {
            Picasso.get().load(R.drawable.the_dark_tower_3).resize(200, 300).into(imageView);
        } else if (book.getId() == 26) {
            Picasso.get().load(R.drawable.needful_things).resize(200, 300).into(imageView);
        } else if (book.getId() == 27) {
            Picasso.get().load(R.drawable.geralds_game).resize(200, 300).into(imageView);
        } else if (book.getId() == 28) {
            Picasso.get().load(R.drawable.dolores_claiborne).resize(200, 300).into(imageView);
        } else if (book.getId() == 29) {
            Picasso.get().load(R.drawable.insomnia).resize(200, 300).into(imageView);
        } else if (book.getId() == 30) {
            Picasso.get().load(R.drawable.rose_madder).resize(200, 300).into(imageView);
        } else if (book.getId() == 31) {
            Picasso.get().load(R.drawable.the_green_mile).resize(200, 300).into(imageView);
        } else if (book.getId() == 32) {
            Picasso.get().load(R.drawable.desperation).resize(200, 300).into(imageView);
        } else if (book.getId() == 33) {
            Picasso.get().load(R.drawable.the_regulators).resize(200, 300).into(imageView);
        } else if (book.getId() == 34) {
            Picasso.get().load(R.drawable.the_dark_tower_4).resize(200, 300).into(imageView);
        } else if (book.getId() == 35) {
            Picasso.get().load(R.drawable.bag_of_bones).resize(200, 300).into(imageView);
        } else if (book.getId() == 36) {
            Picasso.get().load(R.drawable.the_girl_who_loved_tom_gorgon).resize(200, 300).into(imageView);
        } else if (book.getId() == 37) {
            Picasso.get().load(R.drawable.dreamcatcher).resize(200, 300).into(imageView);
        } else if (book.getId() == 38) {
            Picasso.get().load(R.drawable.black_house).resize(200, 300).into(imageView);
        } else if (book.getId() == 39) {
            Picasso.get().load(R.drawable.from_a_buick_8).resize(200, 300).into(imageView);
        } else if (book.getId() == 40) {
            Picasso.get().load(R.drawable.the_dark_tower_5).resize(200, 300).into(imageView);
        } else if (book.getId() == 41) {
            Picasso.get().load(R.drawable.the_dark_tower_6).resize(200, 300).into(imageView);
        } else if (book.getId() == 42) {
            Picasso.get().load(R.drawable.the_dark_tower_7).resize(200, 300).into(imageView);
        } else if (book.getId() == 43) {
            Picasso.get().load(R.drawable.the_colorado_kid).resize(200, 300).into(imageView);
        } else if (book.getId() == 44) {
            Picasso.get().load(R.drawable.cell).resize(200, 300).into(imageView);
        } else if (book.getId() == 45) {
            Picasso.get().load(R.drawable.liseys_story).resize(200, 300).into(imageView);
        } else if (book.getId() == 46) {
            Picasso.get().load(R.drawable.blaze).resize(200, 300).into(imageView);
        } else if (book.getId() == 47) {
            Picasso.get().load(R.drawable.duma_key).resize(200, 300).into(imageView);
        } else if (book.getId() == 48) {
            Picasso.get().load(R.drawable.under_the_dome).resize(200, 300).into(imageView);
        } else if (book.getId() == 49) {
            Picasso.get().load(R.drawable.one_two_six).resize(200, 300).into(imageView);
        } else if (book.getId() == 50) {
            Picasso.get().load(R.drawable.the_dark_tower_8).resize(200, 300).into(imageView);
        } else if (book.getId() == 51) {
            Picasso.get().load(R.drawable.joyland).resize(200, 300).into(imageView);
        } else if (book.getId() == 52) {
            Picasso.get().load(R.drawable.doctor_sleep).resize(200, 300).into(imageView);
        } else if (book.getId() == 53) {
            Picasso.get().load(R.drawable.mr_mercedes).resize(200, 300).into(imageView);
        } else if (book.getId() == 54) {
            Picasso.get().load(R.drawable.revival).resize(200, 300).into(imageView);
        } else if (book.getId() == 55) {
            Picasso.get().load(R.drawable.finders_keepers).resize(200, 300).into(imageView);
        } else if (book.getId() == 56) {
            Picasso.get().load(R.drawable.end_of_watch).resize(200, 300).into(imageView);
        } else if (book.getId() == 57) {
            Picasso.get().load(R.drawable.gwendys_button_box).resize(200, 300).into(imageView);
        } else if (book.getId() == 58) {
            Picasso.get().load(R.drawable.sleeping_beauties).resize(200, 300).into(imageView);
        } else if (book.getId() == 59) {
            Picasso.get().load(R.drawable.the_outsider).resize(200, 300).into(imageView);
        } else if (book.getId() == 60) {
            Picasso.get().load(R.drawable.elevation).resize(200, 300).into(imageView);
        } else if (book.getId() == 61) {
            Picasso.get().load(R.drawable.the_institute).resize(200, 300).into(imageView);
        } else if (book.getId() == 62) {
            Picasso.get().load(R.drawable.later).resize(200, 300).into(imageView);
        } else if (book.getId() == 63) {
            Picasso.get().load(R.drawable.billy_summers).resize(200, 300).into(imageView);
        }
    }
}
