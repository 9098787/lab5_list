package com.example.lab5_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Используем ConstraintLayout с RecyclerView

        // 1. Инициализация RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // 2. Подготовка данных
        List<String> imageTitles = new ArrayList<>();
        imageTitles.add("Кот номер 1");
        imageTitles.add("Кот номер 2");
        imageTitles.add("Кот номер 3");
        imageTitles.add("Кот номер 4");

        // 3. Установка адаптера
        recyclerView.setAdapter(new ImageAdapter(imageTitles));
    }

    // Адаптер для RecyclerView
    private static class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
        private final List<String> titles;

        public ImageAdapter(List<String> titles) {
            this.titles = titles;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            String title = titles.get(position);
            holder.textView.setText(title);

            // Switch-case для картинок
            switch (title) {
                case "Кот номер 1":
                    holder.imageView.setImageResource(R.drawable.img1);
                    break;
                case "Кот номер 2":
                    holder.imageView.setImageResource(R.drawable.img2);
                    break;
                case "Кот номер 3":
                    holder.imageView.setImageResource(R.drawable.img3);
                    break;
                case "Кот номер 4":
                    holder.imageView.setImageResource(R.drawable.img4);
                    break;
            }
        }

        @Override
        public int getItemCount() {
            return titles.size();
        }

        // ViewHolder
        static class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView imageView;
            final TextView textView;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
    }
}
