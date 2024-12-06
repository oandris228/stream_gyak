import java.io.File;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Fuvar {
    private String taxi_id;
    private String indulas;
    private int idotartam;
    private float tavolsag;
    private float viteldij;
    private float borravalo;
    private String fizetes_modja;

    public Fuvar(String data) {
        try {
                String[] split = data.split(";");
                taxi_id = split[0];
                indulas = split[1];
                idotartam = Integer.parseInt(split[2]);
                tavolsag = Float.parseFloat(split[3].replace(',', '.'));
                viteldij = Float.parseFloat(split[4].replace(',', '.'));
                borravalo = Float.parseFloat(split[5].replace(',', '.'));
                fizetes_modja = split[6];
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return taxi_id + " " + indulas + " " + idotartam + " " + tavolsag + " " + viteldij + " " + borravalo + " " + fizetes_modja;
    }

    public String getTaxi_id() {
        return taxi_id;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public float getTavolsag() {
        return tavolsag;
    }

    public float getViteldij() {
        return viteldij;
    }

    public float getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public float getDiff() {
        return borravalo-viteldij;
    }

    public double getKm() {
        return tavolsag*1.6;
    }
}
