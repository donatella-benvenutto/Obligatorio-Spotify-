package uy.edu.um;

import java.io.IOException;
import java.util.Scanner;

public class SpotifyMenu {
    private static SpotifyDataManager dataManager = new SpotifyDataManager();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Reading CSV from CSV folder: ... ");
                    String fileName = "CSV/universal_top_spotify_songs.csv";
                    dataManager.loadDataFromCSV(fileName);
                    break;
                case 2:
                    System.out.println("Ingrese el país:");
                    String country = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    String date = scanner.nextLine();
                    dataManager.reportTop10SongsByCountryAndDate(country, date);
                    break;
                case 3:
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    date = scanner.nextLine();
                    dataManager.reportTop5SongsInMostCountries(date);
                    break;
                case 4:
                    System.out.println("Ingrese la fecha inicial (YYYY-MM-DD):");
                    String startDate = scanner.nextLine();
                    System.out.println("Ingrese la fecha final (YYYY-MM-DD):");
                    String endDate = scanner.nextLine();
                    dataManager.reportTop7ArtistsByDateRange(startDate, endDate);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del artista:");
                    String artist = scanner.nextLine();
                    System.out.println("Ingrese la fecha (YYYY-MM-DD):");
                    date = scanner.nextLine();
                    dataManager.reportArtistAppearancesInTop50(artist, date);
                    break;
                case 6:
                    System.out.println("Ingrese el tempo inicial:");
                    double tempoStart = scanner.nextDouble();
                    System.out.println("Ingrese el tempo final:");
                    double tempoEnd = scanner.nextDouble();
                    scanner.nextLine(); // consume newline
                    System.out.println("Ingrese la fecha inicial (YYYY-MM-DD):");
                    startDate = scanner.nextLine();
                    System.out.println("Ingrese la fecha final (YYYY-MM-DD):");
                    endDate = scanner.nextLine();
                    dataManager.reportSongsByTempoRangeAndDateRange(tempoStart, tempoEnd, startDate, endDate);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nMenú de Opciones:");
        System.out.println("[1]. Cargar datos desde un archivo CSV");
        System.out.println("[2]. Reporte: Top 10 canciones en un país en un día dado");
        System.out.println("[3]. Reporte: Top 5 canciones que aparecen en más top 50 en un día dado");
        System.out.println("[4]. Reporte: Top 7 artistas que más aparecen en los top 50 para un rango de fechas dado");
        System.out.println("[5]. Reporte: Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
        System.out.println("[6]. Reporte: Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas");
        System.out.println("[0]. Salir");
        System.out.print("Seleccione una opción: ");
    }
}

