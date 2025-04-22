public final class Laporan {
    private final int id;
    private String deskripsi;
    private String lokasi;
    private Pelapor pelapor;

    public Laporan(final int id, String deskripsi, String lokasi, Pelapor pelapor2) {
        this.id = id;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.pelapor = pelapor2;
    }

    public int getId() { return id; }
    public String getDeskripsi() { return deskripsi; }
    public String getLokasi() { return lokasi; }
    public Pelapor getPelapor() { return pelapor; }

    public void setDeskripsi(String deskripsi) { this.deskripsi = deskripsi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public void display() {
        System.out.println("\n===== Laporan ID: " + id + " =====");
        System.out.println("Deskripsi: " + deskripsi);
        System.out.println("Lokasi: " + lokasi);
        System.out.println("Pelapor: " + pelapor.getNama() + " (Alamat: " + pelapor.getAlamat() + ")");
        System.out.println("----------------------");
    }
}

