package com.candyspace.androidtest.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;

public class RetrofitMostPopularApi implements MostPopularApi {

	private final MostPopularService service;

	public RetrofitMostPopularApi() {

		Gson gson = new GsonBuilder()
			.registerTypeAdapter(Article.class, new ArticleDeserializer())
			.create();

		RestAdapter adapter = new RestAdapter.Builder()
			.setEndpoint("http://api.nytimes.com")
			.setConverter(new GsonConverter(gson))
			.build();

		service = adapter.create(MostPopularService.class);

	}

	@Override
	public void fetchArticles(final Callback callback) {
		service.mostPopular(new retrofit.Callback<Response>() {

			@Override
			public void success(Response response, retrofit.client.Response response2) {
				if(response == null || response.getResults() == null) {
					callback.onFailure("No response returned");
					return;
				}
				List<Article> articles = new ArrayList<>();
				for(Article article : response.getResults()) {
					if(article != null && article.getMediaList() != null) {
						articles.add(article);
					}
				}
				callback.onSuccess(articles);
			}

			@Override
			public void failure(RetrofitError error) {
				callback.onFailure(error.getMessage());
			}

		});
	}
}
