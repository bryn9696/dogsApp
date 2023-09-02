package com.example.powerbreathe;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.powerbreathe.DogModels.DogModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DogAdapter adapter;
    private List<DogModel> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();
        adapter = new DogAdapter(dataList);
        recyclerView.setAdapter(adapter);

        FetchDataAsyncTask fetchDataAsyncTask = new FetchDataAsyncTask();
        fetchDataAsyncTask.execute();
    }

    private class FetchDataAsyncTask extends AsyncTask<Void, Void, List<DogModel>> {

        @Override
        protected List<DogModel> doInBackground(Void... voids) {
            String apiURL = "https://api.thedogapi.com/v1/breeds?limit=20";
            List<DogModel> data = new ArrayList<>();

            try {
                URL url = new URL(apiURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                InputStream inputStream = conn.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    response.append(line);
                }

                Gson gson = new Gson();
                DogModel[] dogModels = gson.fromJson(response.toString(), DogModel[].class);
                for (DogModel dog : dogModels) {
                    data.add(new DogModel(dog.getName(), dog.getWeight(), dog.getHeight(), dog.getId(), dog.getReferenceImageId()));
                    System.out.println(dog.getReferenceImageId());
                }

                bufferedReader.close();
                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return data;
        }

        @Override
        protected void onPostExecute(List<DogModel> data) {
            dataList.addAll(data);
            adapter.notifyDataSetChanged();
        }
    }
}