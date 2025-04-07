package posttest3;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Laporan> laporanList = new ArrayList<>();
    private static ArrayList<Pelapor> pelaporList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int laporanId = 1, pelaporId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Sistem Pelaporan Kriminal =====");
            System.out.println("1. Tambah Laporan");
            System.out.println("2. Lihat Semua Laporan");
            System.out.println("3. Edit Laporan");
            System.out.println("4. Hapus Laporan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addLaporan();
                    break;
                case 2:
                    viewLaporan();
                    break;
                case 3:
                    viewLaporan();
                    editLaporan();
                    break;
                case 4:
                    viewLaporan();
                    deleteLaporan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem pelaporan!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    private static void addLaporan() {
        System.out.print("Masukkan deskripsi kejahatan: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Masukkan lokasi kejadian: ");
        String lokasi = scanner.nextLine();

        Pelapor pelapor = createPelapor();
        Laporan laporanBaru = new Laporan(laporanId++, deskripsi, lokasi, pelapor);
        laporanList.add(laporanBaru);
        System.out.println("✅ Laporan berhasil ditambahkan!");
    }

    private static Pelapor createPelapor() {
        System.out.println("Jenis Pelapor:");
        System.out.println("1. Pelapor Umum");
        System.out.println("2. Petugas Keamanan");
        System.out.print("Pilih jenis pelapor: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nama Pelapor: ");
        String nama = scanner.nextLine();
        System.out.print("Alamat Pelapor: ");
        String alamat = scanner.nextLine();

        if (jenis == 1) {
            System.out.print("Pekerjaan: ");
            String pekerjaan = scanner.nextLine();
            PelaporUmum pelapor = new PelaporUmum(pelaporId++, nama, alamat, pekerjaan);
            pelaporList.add(pelapor);
            return pelapor;
        } else {
            System.out.print("Instansi: ");
            String instansi = scanner.nextLine();
            PetugasKeamanan pelapor = new PetugasKeamanan(pelaporId++, nama, alamat, instansi);
            pelaporList.add(pelapor);
            return pelapor;
        }
    }

    private static void viewLaporan() {
        if (laporanList.isEmpty()) {
            System.out.println("⚠ Belum ada laporan.");
            return;
        }
        System.out.println("\n===== Daftar Laporan Kriminal =====");
        for (Laporan laporan : laporanList) {
            laporan.display();
        }
    }

    private static void editLaporan() {
        System.out.print("Masukkan ID laporan yang ingin diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Laporan laporan : laporanList) {
            if (laporan.getId() == id) {
                System.out.print("Masukkan deskripsi baru: ");
                laporan.setDeskripsi(scanner.nextLine());
                System.out.print("Masukkan lokasi baru: ");
                laporan.setLokasi(scanner.nextLine());
                System.out.println("✅ Laporan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("❌ Laporan tidak ditemukan.");
    }

    private static void deleteLaporan() {
        System.out.print("Masukkan ID laporan yang ingin dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < laporanList.size(); i++) {
            if (laporanList.get(i).getId() == id) {
                laporanList.remove(i);
                System.out.println("✅ Laporan berhasil dihapus!");
                return;
            }
        }
        System.out.println("❌ Laporan tidak ditemukan.");
    }
}
