package com.example.kingslibrary.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

import java.util.ArrayList;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder> {
    public ArrayList<Book> bookmarkList;
    public Context context;

    public BookmarkAdapter(ArrayList<Book> bookmarkList, Context context) {
        this.bookmarkList = bookmarkList;
        this.context = context;
    }

    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_book, parent, false);
        return new BookmarkViewHolder(view);
    }


    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        Book bookmark = bookmarkList.get(position);
        holder.titleBookmark.setText(bookmark.getTitle());
        holder.publisherBookmark.setText(bookmark.getPublisher());

        DatabaseHelper dbHelper = new DatabaseHelper(context);
        int book_id = dbHelper.getBookIdFromBookmarkToUseItOnBookmarkAdapterWhichShowedOnBookmarkFragment(bookmark.getId());

        setBookCoverImage(book_id, holder.imageBookmark);

        holder.bookmarkBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.removeBookmarkByBookmark(book_id);
                bookmarkList.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
                Toast.makeText(v.getContext(), "Bookmark Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        holder.imageBookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), BookDetailsActivity.class);
                intent.putExtra("title", bookmark.getTitle());
                intent.putExtra("publisher", bookmark.getPublisher());
                intent.putExtra("id", book_id);
                intent.putExtra("year", bookmark.getYear());
                intent.putExtra("isbn", bookmark.getISBN());
                intent.putExtra("pages", bookmark.getPages());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    public int getItemCount() {
        return bookmarkList.size();
    }

    public static class BookmarkViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageBookmark;
        private ImageView bookmarkBookmark;
        private TextView titleBookmark;
        private TextView publisherBookmark;
        public BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBookmark = itemView.findViewById(R.id.bookImage);
            titleBookmark = itemView.findViewById(R.id.bookTitle);
            publisherBookmark = itemView.findViewById(R.id.bookPublisher);
            bookmarkBookmark = itemView.findViewById(R.id.bookmark_togel);

        }
    }

    private void setBookCoverImage(int book_id, ImageView imageView) {
        if (book_id == 1) {
            Picasso.get().load(R.drawable.carrie).resize(200, 300).into(imageView);
        } else if (book_id == 2) {
            Picasso.get().load(R.drawable.salems_lot).resize(200, 300).into(imageView);
        } else if (book_id == 3) {
            Picasso.get().load(R.drawable.the_shining).resize(200, 300).into(imageView);
        } else if (book_id == 4) {
            Picasso.get().load(R.drawable.rage).resize(200, 300).into(imageView);
        } else if (book_id == 5) {
            Picasso.get().load(R.drawable.the_stand).resize(200, 300).into(imageView);
        } else if (book_id == 6) {
            Picasso.get().load(R.drawable.the_long_walk).resize(200, 300).into(imageView);
        } else if (book_id == 7) {
            Picasso.get().load(R.drawable.the_dead_zone).resize(200, 300).into(imageView);
        } else if (book_id == 8) {
            Picasso.get().load(R.drawable.firestarter).resize(200, 300).into(imageView);
        } else if (book_id == 9) {
            Picasso.get().load(R.drawable.roadwork).resize(200, 300).into(imageView);
        } else if (book_id == 10) {
            Picasso.get().load(R.drawable.cujo).resize(200, 300).into(imageView);
        } else if (book_id == 11) {
            Picasso.get().load(R.drawable.the_running_man).resize(200, 300).into(imageView);
        } else if (book_id == 12) {
            Picasso.get().load(R.drawable.the_dark_tower_1).resize(200, 300).into(imageView);
        } else if (book_id == 13) {
            Picasso.get().load(R.drawable.christine).resize(200, 300).into(imageView);
        } else if (book_id == 14) {
            Picasso.get().load(R.drawable.pet_semetary).resize(200, 300).into(imageView);
        } else if (book_id == 15) {
            Picasso.get().load(R.drawable.cycle_of_the_werewolf).resize(200, 300).into(imageView);
        } else if (book_id == 16) {
            Picasso.get().load(R.drawable.the_talisman).resize(200, 300).into(imageView);
        } else if (book_id == 17) {
            Picasso.get().load(R.drawable.the_eyes_of_the_dragon).resize(200, 300).into(imageView);
        } else if (book_id == 18) {
            Picasso.get().load(R.drawable.thinner).resize(200, 300).into(imageView);
        } else if (book_id == 19) {
            Picasso.get().load(R.drawable.it).resize(200, 300).into(imageView);
        } else if (book_id == 20) {
            Picasso.get().load(R.drawable.the_dark_tower_2).resize(200, 300).into(imageView);
        } else if (book_id == 21) {
            Picasso.get().load(R.drawable.misery).resize(200, 300).into(imageView);
        } else if (book_id == 22) {
            Picasso.get().load(R.drawable.the_tommyknockers).resize(200, 300).into(imageView);
        } else if (book_id == 23) {
            Picasso.get().load(R.drawable.the_dark_half).resize(200, 300).into(imageView);
        } else if (book_id == 24) {
            Picasso.get().load(R.drawable.the_stand_uncut).resize(200, 300).into(imageView);
        } else if (book_id == 25) {
            Picasso.get().load(R.drawable.the_dark_tower_3).resize(200, 300).into(imageView);
        } else if (book_id == 26) {
            Picasso.get().load(R.drawable.needful_things).resize(200, 300).into(imageView);
        } else if (book_id == 27) {
            Picasso.get().load(R.drawable.geralds_game).resize(200, 300).into(imageView);
        } else if (book_id == 28) {
            Picasso.get().load(R.drawable.dolores_claiborne).resize(200, 300).into(imageView);
        } else if (book_id == 29) {
            Picasso.get().load(R.drawable.insomnia).resize(200, 300).into(imageView);
        } else if (book_id == 30) {
            Picasso.get().load(R.drawable.rose_madder).resize(200, 300).into(imageView);
        } else if (book_id == 31) {
            Picasso.get().load(R.drawable.the_green_mile).resize(200, 300).into(imageView);
        } else if (book_id == 32) {
            Picasso.get().load(R.drawable.desperation).resize(200, 300).into(imageView);
        } else if (book_id == 33) {
            Picasso.get().load(R.drawable.the_regulators).resize(200, 300).into(imageView);
        } else if (book_id == 34) {
            Picasso.get().load(R.drawable.the_dark_tower_4).resize(200, 300).into(imageView);
        } else if (book_id == 35) {
            Picasso.get().load(R.drawable.bag_of_bones).resize(200, 300).into(imageView);
        } else if (book_id == 36) {
            Picasso.get().load(R.drawable.the_girl_who_loved_tom_gorgon).resize(200, 300).into(imageView);
        } else if (book_id == 37) {
            Picasso.get().load(R.drawable.dreamcatcher).resize(200, 300).into(imageView);
        } else if (book_id == 38) {
            Picasso.get().load(R.drawable.black_house).resize(200, 300).into(imageView);
        } else if (book_id == 39) {
            Picasso.get().load(R.drawable.from_a_buick_8).resize(200, 300).into(imageView);
        } else if (book_id == 40) {
            Picasso.get().load(R.drawable.the_dark_tower_5).resize(200, 300).into(imageView);
        } else if (book_id == 41) {
            Picasso.get().load(R.drawable.the_dark_tower_6).resize(200, 300).into(imageView);
        } else if (book_id == 42) {
            Picasso.get().load(R.drawable.the_dark_tower_7).resize(200, 300).into(imageView);
        } else if (book_id == 43) {
            Picasso.get().load(R.drawable.the_colorado_kid).resize(200, 300).into(imageView);
        } else if (book_id == 44) {
            Picasso.get().load(R.drawable.cell).resize(200, 300).into(imageView);
        } else if (book_id == 45) {
            Picasso.get().load(R.drawable.liseys_story).resize(200, 300).into(imageView);
        } else if (book_id == 46) {
            Picasso.get().load(R.drawable.blaze).resize(200, 300).into(imageView);
        } else if (book_id == 47) {
            Picasso.get().load(R.drawable.duma_key).resize(200, 300).into(imageView);
        } else if (book_id == 48) {
            Picasso.get().load(R.drawable.under_the_dome).resize(200, 300).into(imageView);
        } else if (book_id == 49) {
            Picasso.get().load(R.drawable.one_two_six).resize(200, 300).into(imageView);
        } else if (book_id == 50) {
            Picasso.get().load(R.drawable.the_dark_tower_8).resize(200, 300).into(imageView);
        } else if (book_id == 51) {
            Picasso.get().load(R.drawable.joyland).resize(200, 300).into(imageView);
        } else if (book_id == 52) {
            Picasso.get().load(R.drawable.doctor_sleep).resize(200, 300).into(imageView);
        } else if (book_id == 53) {
            Picasso.get().load(R.drawable.mr_mercedes).resize(200, 300).into(imageView);
        } else if (book_id == 54) {
            Picasso.get().load(R.drawable.revival).resize(200, 300).into(imageView);
        } else if (book_id == 55) {
            Picasso.get().load(R.drawable.finders_keepers).resize(200, 300).into(imageView);
        } else if (book_id == 56) {
            Picasso.get().load(R.drawable.end_of_watch).resize(200, 300).into(imageView);
        } else if (book_id == 57) {
            Picasso.get().load(R.drawable.gwendys_button_box).resize(200, 300).into(imageView);
        } else if (book_id == 58) {
            Picasso.get().load(R.drawable.sleeping_beauties).resize(200, 300).into(imageView);
        } else if (book_id == 59) {
            Picasso.get().load(R.drawable.the_outsider).resize(200, 300).into(imageView);
        } else if (book_id == 60) {
            Picasso.get().load(R.drawable.elevation).resize(200, 300).into(imageView);
        } else if (book_id == 61) {
            Picasso.get().load(R.drawable.the_institute).resize(200, 300).into(imageView);
        } else if (book_id == 62) {
            Picasso.get().load(R.drawable.later).resize(200, 300).into(imageView);
        } else if (book_id == 63) {
            Picasso.get().load(R.drawable.billy_summers).resize(200, 300).into(imageView);
        }
    }
}
