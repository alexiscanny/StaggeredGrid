package com.candyspace.androidtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.candyspace.androidtest.api.Article;
import com.candyspace.androidtest.model.ArticleWrapper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a sample RecyclerView adapter.
 */
public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleRecyclerViewAdapter.SampleViewHolder> {

	private final List<Article> articles = new ArrayList<>();
	private int previousPosition;

	@Override
	public SampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);
		return new SampleViewHolder(v);
	}

	@Override
	public void onBindViewHolder(SampleViewHolder holder, int position) {
		Article article = articles.get(position);
		if(position > previousPosition){
			new AnimationUtils().animate(holder,true);
		}else{
			new AnimationUtils().animate(holder,false);
		}
		previousPosition= position;
		holder.title.setText(article.getTitle());
		holder.body.setText(article.getBody());

		ArticleWrapper articleWrapper = new ArticleWrapper(article);
		if (articleWrapper.getHeroImageUrl() != null) {
			Picasso.with(holder.itemView.getContext()).load(articleWrapper.getThumbImageUrl()).into(holder.image);
		} else {
			holder.image.setImageResource(R.drawable.no_media);
		}
	}

	@Override
	public int getItemCount() {
		return articles.size();
	}

	public void setArticles(List<Article> articles){
		this.articles.clear();
		if(articles != null) {
			this.articles.addAll(articles);
		}
		notifyDataSetChanged();
	}

	public boolean isHeader(int position) {
		return position %5 == 0;
	}

	static class SampleViewHolder extends RecyclerView.ViewHolder {

		ImageView image;
		TextView title;
		TextView body;

		public SampleViewHolder(View itemView) {
			super(itemView);
			image = (ImageView) itemView.findViewById(R.id.grid_item_image);
			title = (TextView) itemView.findViewById(R.id.grid_item_title);
			body = (TextView) itemView.findViewById(R.id.grid_item_body);
		}

	}

}
