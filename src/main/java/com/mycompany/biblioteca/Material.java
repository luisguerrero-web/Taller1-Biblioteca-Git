
package com.mycompany.biblioteca;

public class Material {
    private String Code;
    private String Tittle;
    private String yearPublic;

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String Tittle) {
        this.Tittle = Tittle;
    }

    public String getYearPublic() {
        return yearPublic;
    }

    public void setYearPublic(String yearPublic) {
        this.yearPublic = yearPublic;
    }

    public Material() {
    }

    public Material(String Code, String Tittle, String yearPublic) {
        this.Code = Code;
        this.Tittle = Tittle;
        this.yearPublic = yearPublic;
    }
    
    
}
