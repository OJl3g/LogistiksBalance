package entity;

public class FreightForwarder {
    private String name;
    private String surname;
    private String modelAuto;
    private boolean refrigerator;
    private boolean medicalBook;
    private boolean sanitationOfTheBody;

    public FreightForwarder(String name, String surname, String model, boolean refrigerator, boolean medicalBook, boolean sanitationOfTheBody) {
        this.name = name;
        this.surname = surname;
        this.modelAuto = model;
        this.refrigerator = refrigerator;
        this.medicalBook = medicalBook;
        this.sanitationOfTheBody = sanitationOfTheBody;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getModelAuto() {
        return modelAuto;
    }

    public boolean isRefrigerator() {
        return refrigerator;
    }

    public boolean isMedicalBook() {
        return medicalBook;
    }

    public boolean isSanitationOfTheBody() {
        return sanitationOfTheBody;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setModelAuto(String modelAuto) {
        this.modelAuto = modelAuto;
    }

    public void setRefrigerator(boolean refrigerator) {
        this.refrigerator = refrigerator;
    }

    public void setMedicalBook(boolean medicalBook) {
        this.medicalBook = medicalBook;
    }

    public void setSanitationOfTheBody(boolean sanitationOfTheBody) {
        this.sanitationOfTheBody = sanitationOfTheBody;
    }
}
