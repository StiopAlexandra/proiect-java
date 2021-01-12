package org.proiect;

public class Book {
    private String title;
    private String author;
    private String pages;
    private BookCategory category;

    public Book(String title, String author, String pages, BookCategory category) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.category = category;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages='" + pages + '\'' +
                ", category=" + category +
                '}';
    }
}
