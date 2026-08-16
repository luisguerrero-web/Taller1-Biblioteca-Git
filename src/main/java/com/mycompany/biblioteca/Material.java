
package com.mycompany.biblioteca;

public class Material {
    private String code;
    private String tittle;
    private String yearPublic;

    public String getCode() {
        return code;
    }

    public void setCode(String Code) {
        this.code = Code;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String Tittle) {
        this.tittle = Tittle;
    }

    public String getYearPublic() {
        return yearPublic;
    }

    public void setYearPublic(String yearPublic) {
        this.yearPublic = yearPublic;
    }

    public Material() {
    }

    public Material(String code, String tittle, String yearPublic) {
        this.code = code;
        this.tittle = tittle;
        this.yearPublic = yearPublic;
    }

    
    
}
