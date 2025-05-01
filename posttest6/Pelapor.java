public abstract class Pelapor implements Displayable {
    protected final int id;
    protected String nama;
    protected String alamat;

    public Pelapor(final int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setAlamat(String jalan, String rtRw) {
        this.alamat = jalan + " (" + rtRw + ")";
    }

    @Override
    public void display() {
        System.out.println("ID Pelapor: " + getId());
        System.out.println("Nama: " + getNama());
        System.out.println("Alamat: " + getAlamat());
    }

    @Override
    public String getSummary() {
        return "Pelapor: " + nama + " (ID: " + id + ")";
    }
}