/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotheek;

/**
 *
 * @author frederic
 */
public class Boek {
    private String isbn;
    private String titel;
    private String auteur;
    
    public Boek(String isbn, String titel, String auteur)
    {
        this.isbn = isbn;
        this.titel = titel;
        this.auteur = auteur;
    }
    
    @Override
    public String toString()
    {
        return this.titel + " - " + this.auteur + " [" + this.isbn + "]";
    }
}
