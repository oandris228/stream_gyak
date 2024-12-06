import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Fuvar> lista = new ArrayList<Fuvar>();
        try {
            File myObj = new File("fuvar.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lista.add(new Fuvar(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (Fuvar e : lista) {
            System.out.print(e + "\n");
        }

        //1. feladat
        System.out.println("1." +lista.stream().count() + "\n");

        //2. feladat
        System.out.println(lista.stream().filter(w -> w.getTaxi_id().equals("6185")).mapToDouble(w -> w.getViteldij()+w.getBorravalo()).sum() + "\n");

        //3. feladat
        System.out.println(lista.stream().mapToDouble(w -> w.getTavolsag()).sum() + "\n");

        //4. feladat
        System.out.println(lista.stream().max(Comparator.comparing(Fuvar::getTavolsag)).get() + "\n");

        //5. feladat
        System.out.println(lista.stream().max(Comparator.comparing(Fuvar::getDiff)).get() + "\n");

        //6. feladat
        System.out.println(lista.stream().filter(w -> w.getTaxi_id().equals("4261")).mapToDouble(w -> w.getKm()).sum() + "\n");

        //7. feladat
        List<Fuvar> filtered = lista.stream().filter(w -> w.getIdotartam() > 0 && w.getViteldij() > 0 && w.getTavolsag() == 0).toList();
        System.out.println("Száma: " + filtered.stream().count() + " Össz idő " + filtered.stream().mapToInt(Fuvar::getIdotartam).sum() + " Össz bevétel: " + filtered.stream().mapToDouble(w -> w.getViteldij()+w.getBorravalo()).sum() + "\n");

        //8. feladat
        System.out.println(lista.stream().anyMatch(w -> w.getTaxi_id().equals("1452")));

        //9. feladat
        System.out.println(lista.stream().filter(w -> w.getIdotartam() != 0).min(Comparator.comparing(Fuvar::getIdotartam)));

        //10. feladat
        //11. feladat

    }
}