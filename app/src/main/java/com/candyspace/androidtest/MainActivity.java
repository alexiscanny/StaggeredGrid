package com.candyspace.androidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.candyspace.androidtest.api.Article;
import com.candyspace.androidtest.api.MostPopularApi;
import com.candyspace.androidtest.api.RetrofitMostPopularApi;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	public static final String TAG = MainActivity.class.getSimpleName();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SampleRecyclerViewAdapter adapter = new SampleRecyclerViewAdapter();

		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		recyclerView.setHasFixedSize(true);



		final GridLayoutManager manager = new GridLayoutManager(this, 2);

		manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
			@Override
			public int getSpanSize(int position) {
				return adapter.isHeader(position) ? manager.getSpanCount() : 1;

//				return (3 - position % 3);
//				return (position%3==0?2:1);
			}
		});

		recyclerView.setItemAnimator(new DefaultItemAnimator());
		recyclerView.setLayoutManager(manager);

		recyclerView.setAdapter(adapter);


		MostPopularApi api = new RetrofitMostPopularApi();
		api.fetchArticles(new MostPopularApi.Callback() {

			@Override
			public void onSuccess(List<Article> articles) {
				Log.d(TAG, "Got articles");
				adapter.setArticles(articles);
			}

			@Override
			public void onFailure(String error) {
				Log.d(TAG, "Failed to get articles");
			}

		});
	}

}
