package nl.hu.bep3.jobboard.keywords.core.application.query;

public class ListMatchesForKeyword {
    private final String keyword;

    public ListMatchesForKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }
}
