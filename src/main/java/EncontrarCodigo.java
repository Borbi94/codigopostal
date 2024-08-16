import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EncontrarCodigo {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, ingrese uno o más códigos postales como argumentos.");
            return;
        }


        Map<String, String> codigosPostales = new HashMap<>();
        String archivoCSV = "codigos_postales.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String codigoPostal = datos[0].trim();
                String asentamiento = datos[1].trim();
                codigosPostales.put(codigoPostal, asentamiento);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        for (String codigo : args) {
            if (codigosPostales.containsKey(codigo)) {
                System.out.println("Código Postal: " + codigo + " -> Asentamiento: " + codigosPostales.get(codigo));
            } else {
                System.out.println("Código Postal: " + codigo + " no encontrado.");
            }
        }
    }
}
