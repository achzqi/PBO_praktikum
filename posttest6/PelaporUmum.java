public class PelaporUmum extends Pelapor {
    private String pekerjaan;

    public PelaporUmum(final int id, String nama, String alamat, String pekerjaan) {
        super(id, nama, alamat);
        this.pekerjaan = pekerjaan;
    }

    public String getPekerjaan() { return pekerjaan; }

    @Override
    public void display() {
        super.display();
        System.out.println("Pekerjaan: " + getPekerjaan());
        System.out.println("----------------------");
    }
}

