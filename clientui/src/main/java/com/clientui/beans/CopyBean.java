package com.clientui.beans;



public class CopyBean {
    private Long id;
    private String serialNumber;
    private BookBean book;

    public CopyBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "CopyBean{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
