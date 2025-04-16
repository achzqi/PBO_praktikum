package posttest3;

public class Pelapor {
    protected int id;
    protected String nama;
    protected String alamat;

    public Pelapor(int id, String nama, String alamat) {
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

    public void display() {
        System.out.println("ID Pelapor: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Alamat: " + alamat);
    }
}
