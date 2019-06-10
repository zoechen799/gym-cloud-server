package com.jonnyblog.wechat.model.entity.message.outbound;

import java.util.List;

/**
 * 多图文消息
 * 
 */
public class NewsMessage extends BaseOutBoundMessage{
    private int ArticleCount;

    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        this.ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        this.Articles = articles;
    }
}
