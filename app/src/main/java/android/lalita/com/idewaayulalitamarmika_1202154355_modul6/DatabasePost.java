package android.lalita.com.idewaayulalitamarmika_1202154355_modul6;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by lalita on 3/31/2018.
 */

@IgnoreExtraProperties
public class DatabasePost {
    String gmbr, judul, deskripsi, usr, key;

    //method kosong yang diperlukan untuk melakukan pengecekan
    public DatabasePost(){

    }

    //konstruktor
    public DatabasePost(String gmbr, String judul, String deskripsi,String usr){
        this.gmbr=gmbr;
        this.judul=judul;
        this.deskripsi=deskripsi;
        this.usr=usr;
    }

    //method getter
    public String getKey(){
        return key;
    }

    public void setKey(String key){
        key = key;
    }

    public String getGmbr() {
        return gmbr;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getUsr() {
        return usr;
    }
}
