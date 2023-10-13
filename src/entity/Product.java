package entity;

public class Product {
    private String nameFood;
    private  int expirationDate;
    private int dateOfManufacture;


    public Product(String nameFood, int expirationDate, int dateOfManufacture) {
        this.nameFood = nameFood;
        this.expirationDate = expirationDate;
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getNameFood() {
        return nameFood;
    }

    public int getExpirationDate() {
        return expirationDate;
    }

    public int getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public void setExpirationDate(int expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setDateOfManufacture(int dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}
