package no.java.portal.page;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import no.java.portal.domain.*;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:trygvis@java.no">Trygve Laugst&oslash;l</a>
 * @version $Id$
 */
@Component
public class FrontJspBean implements JspBean {

    private static final List<Category> PARTNER_CATEGORIES = Arrays.asList(Category.nyheter_partnere, Category.partnerinfo,
            Category.stillingsannonser);
    private final Articles articles;
    private final ArticleMetadatas articleMetadatas;
    private final Users users;
    private final MemberPeople memberPeople;

    @Autowired
    public FrontJspBean(Articles articles, ArticleMetadatas articleMetadatas, Users users, MemberPeople memberPeople) {
        this.articles = articles;
        this.articleMetadatas = articleMetadatas;
        this.users = users;
        this.memberPeople = memberPeople;
    }

    public List<MemberPerson> getMemberPeople() {
        return memberPeople.getCurrentMemberPeople();
    }

    public List<NewsItem> getHeadArticles() {
        return articles.getActiveArticleByCategory(Category.nyheter, 0, 2);
    }

    public List<NewsItem> getArticles() {
        return articles.getActiveArticleByCategory(Category.nyheter, 2, 7);
    }

    public List<NewsItem> getFooterArticles() {
        return articles.getActiveArticleByCategory(Category.nyheter, 0, 5);
    }

    public List<NewsItem> getHeadPartnerArticles() {
        return articles.getActiveArticleByCategory(PARTNER_CATEGORIES, 0, 3);
    }

    public List<NewsItem> getPartnerArticles() {
        return articles.getActiveArticleByCategory(PARTNER_CATEGORIES, 3, 25);
    }

    public List<DateTime> getYears() {
        List<DateTime> list = articleMetadatas.getYears();
        Collections.reverse(list);
        return list;
    }

    public Map<Integer, String> getMonths() {
        Map<Integer, String> months = new TreeMap<Integer, String>();
        months.put(1, "jan");
        months.put(2, "feb");
        months.put(3, "mar");
        months.put(4, "apr");
        months.put(5, "mai");
        months.put(6, "jun");
        months.put(7, "jul");
        months.put(8, "aug");
        months.put(9, "sep");
        months.put(10, "okt");
        months.put(11, "nov");
        months.put(12, "des");
        return months;
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            return users.getUser(auth.getName());
        } catch (UserNotFoundException e) {
            throw new RuntimeException("Error getting user", e);
        }
    }

}