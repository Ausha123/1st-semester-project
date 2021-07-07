package pos.dto;

public class BookDTO {
    private String id;
    private String name;
    private String author;
    private String pubDate;
    private int units;
    private String isbn;
    private String category;
    private Double price;

    public BookDTO() {
    }

    public BookDTO(String id, String name, String author, String pubDate, int units, String isbn, String category, Double price) {
        this.setId(id);
        this.setName(name);
        this.setAuthor(author);
        this.setPubDate(pubDate);
        this.setUnits(units);
        this.setIsbn(isbn);
        this.setCategory(category);
        this.setPrice(price);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
