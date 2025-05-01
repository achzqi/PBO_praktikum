import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static ArrayList<Laporan> laporanList = new ArrayList<>();
    private static ArrayList<Pelapor> pelaporList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int laporanId = 1, pelaporId = 1;

    // Static method untuk validasi input angka
    public static int getValidIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Input harus antara " + min + " dan " + max + ". Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Sistem Pelaporan Kriminal =====");
        System.out.println("Versi: " + getVersion()); // Memanggil static method

        while (true) {
            try {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Laporan");
                System.out.println("2. Lihat Semua Laporan");
                System.out.println("3. Edit Laporan");
                System.out.println("4. Hapus Laporan");
                System.out.println("5. Keluar");

                int choice = getValidIntInput("Pilih menu: ", 1, 5);

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
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                scanner.nextLine(); // clear buffer
            }
        }
    }

    // Static method untuk mendapatkan versi aplikasi
    public static String getVersion() {
        return "1.0.0";
    }

    private static void addLaporan() {
        try {
            System.out.print("Masukkan deskripsi kejahatan: ");
            String deskripsi = scanner.nextLine();
            if (deskripsi.trim().isEmpty()) {
                throw new IllegalArgumentException("Deskripsi tidak boleh kosong");
            }

            System.out.print("Masukkan lokasi kejadian: ");
            String lokasi = scanner.nextLine();
            if (lokasi.trim().isEmpty()) {
                throw new IllegalArgumentException("Lokasi tidak boleh kosong");
            }

            Pelapor pelapor = createPelapor();
            Laporan laporanBaru = new Laporan(laporanId++, deskripsi, lokasi, pelapor);
            laporanList.add(laporanBaru);
            System.out.println("✅ Laporan berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("❌ Gagal menambahkan laporan: " + e.getMessage());
        }
    }

    private static Pelapor createPelapor() {
        try {
            System.out.println("Jenis Pelapor:");
            System.out.println("1. Pelapor Umum");
            System.out.println("2. Petugas Keamanan");
            int jenis = getValidIntInput("Pilih jenis pelapor: ", 1, 2);

            System.out.print("Nama Pelapor: ");
            String nama = scanner.nextLine();
            if (nama.trim().isEmpty()) {
                throw new IllegalArgumentException("Nama tidak boleh kosong");
            }

            String alamat = "";
            System.out.println("Pilih metode input alamat:");
            System.out.println("1. Langsung (contoh: Jl. Melati No. 5)");
            System.out.println("2. Terpisah (jalan dan RT/RW)");
            int pilihAlamat = getValidIntInput("Pilihan: ", 1, 2);

            if (pilihAlamat == 1) {
                System.out.print("Alamat lengkap: ");
                alamat = scanner.nextLine();
                if (alamat.trim().isEmpty()) {
                    throw new IllegalArgumentException("Alamat tidak boleh kosong");
                }
            } else {
                System.out.print("Jalan: ");
                String jalan = scanner.nextLine();
                System.out.print("RT/RW: ");
                String rtRw = scanner.nextLine();
                if (jalan.trim().isEmpty() || rtRw.trim().isEmpty()) {
                    throw new IllegalArgumentException("Jalan dan RT/RW tidak boleh kosong");
                }
                alamat = jalan + " (" + rtRw + ")";
            }

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
        } catch (Exception e) {
            System.out.println("❌ Gagal membuat pelapor: " + e.getMessage());
            throw e; // Re-throw exception untuk ditangani di method pemanggil
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
        try {
            if (laporanList.isEmpty()) {
                System.out.println("⚠ Tidak ada laporan untuk diedit.");
                return;
            }

            int id = getValidIntInput("Masukkan ID laporan yang ingin diedit: ", 1, Integer.MAX_VALUE);

            for (Laporan laporan : laporanList) {
                if (laporan.getId() == id) {
                    System.out.print("Masukkan deskripsi baru: ");
                    String deskripsi = scanner.nextLine();
                    if (deskripsi.trim().isEmpty()) {
                        throw new IllegalArgumentException("Deskripsi tidak boleh kosong");
                    }
                    laporan.setDeskripsi(deskripsi);

                    System.out.print("Masukkan lokasi baru: ");
                    String lokasi = scanner.nextLine();
                    if (lokasi.trim().isEmpty()) {
                        throw new IllegalArgumentException("Lokasi tidak boleh kosong");
                    }
                    laporan.setLokasi(lokasi);

                    System.out.println("✅ Laporan berhasil diperbarui!");
                    return;
                }
            }
            System.out.println("❌ Laporan tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("❌ Gagal mengedit laporan: " + e.getMessage());
        }
    }

    private static void deleteLaporan() {
        try {
            if (laporanList.isEmpty()) {
                System.out.println("⚠ Tidak ada laporan untuk dihapus.");
                return;
            }

            int id = getValidIntInput("Masukkan ID laporan yang ingin dihapus: ", 1, Integer.MAX_VALUE);

            for (int i = 0; i < laporanList.size(); i++) {
                if (laporanList.get(i).getId() == id) {
                    laporanList.remove(i);
                    System.out.println("✅ Laporan berhasil dihapus!");
                    return;
                }
            }
            System.out.println("❌ Laporan tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("❌ Gagal menghapus laporan: " + e.getMessage());
        }
    }
}