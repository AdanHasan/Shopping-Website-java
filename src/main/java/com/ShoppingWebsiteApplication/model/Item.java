package  com.ShoppingWebsiteApplication.model;

public class Item {

    private Long id;
    private String title;

    private Double price;
    private Long inStock;
    private Long quantity;
    private String pictureUrl;
    private Boolean liked ;

    private Boolean cart ;

    public Item(Long id , String title ,Double price , Long inStock, Long quantity,String pictureUrl , Boolean liked , Boolean cart) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.inStock=inStock;
        this.quantity = quantity;
        this.pictureUrl = pictureUrl;
        this.liked=liked;
        this.cart=cart;

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Long getInStock() {
        return inStock;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }


    public Boolean getLiked() {
        return liked;
    }

    public Boolean getCart() {
        return cart;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setInStock(Long inStock) {
        this.inStock = inStock;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }

    public void setCart(Boolean cart) {
        this.cart = cart;
    }
}
