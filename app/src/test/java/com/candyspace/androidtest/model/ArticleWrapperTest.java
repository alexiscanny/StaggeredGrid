package com.candyspace.androidtest.model;

import com.candyspace.androidtest.api.Article;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleWrapperTest {

	public static final String THUMB_URL="http://a/thumb/url";
	public static final String HERO_URL="http://a/hero/url";

	@Mock Article article;

	ArticleWrapper articleWrapper;

	@Before
	public void setUp() throws Exception {
		articleWrapper = new ArticleWrapper(article);
	}

	@Test
	public void testGetThumbImageUrl() throws Exception {
		assertEquals(THUMB_URL, articleWrapper.getThumbImageUrl());
	}

	@Test
	public void testGetHeroImageUrl() throws Exception {
		assertEquals(HERO_URL, articleWrapper.getHeroImageUrl());
	}
}