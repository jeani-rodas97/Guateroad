/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

/**
 *
 * @author Jeany
 */
public class Transferencia {
    private int id; 
    private String Fecha; 
    private String DataJson; 
    private int Nonce; 
    private String PreviusHash; 
    private String Hash; 

    public Transferencia(int id, String Fecha, String DataJson, int Nonce, String PreviusHash, String Hash) {
        this.id = id;
        this.Fecha = Fecha;
        this.DataJson = DataJson;
        this.Nonce = Nonce;
        this.PreviusHash = PreviusHash;
        this.Hash = Hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDataJson() {
        return DataJson;
    }

    public void setDataJson(String DataJson) {
        this.DataJson = DataJson;
    }

    public int getNonce() {
        return Nonce;
    }

    public void setNonce(int Nonce) {
        this.Nonce = Nonce;
    }

    public String getPreviusHash() {
        return PreviusHash;
    }

    public void setPreviusHash(String PreviusHash) {
        this.PreviusHash = PreviusHash;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String Hash) {
        this.Hash = Hash;
    }
    
    
}
