package model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Nota implements Parcelable {
    Integer id;
    String titulo;
    String txt;

    public Nota() {

    }


    public Nota(String titulo, String txt) {
        this.titulo = titulo;
        this.txt = txt;
    }

    public Nota(Integer id, String titulo, String txt) {
        this.id = id;
        this.titulo = titulo;
        this.txt = txt;
    }

    protected Nota(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        titulo = in.readString();
        txt = in.readString();
    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel in) {
            return new Nota(in);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(id);
        }
        parcel.writeString(titulo);
        parcel.writeString(txt);
    }
}
