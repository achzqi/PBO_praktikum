package posttest3;
public class PetugasKeamanan extends Pelapor {
    private String instansi;

    public PetugasKeamanan(int id, String nama, String alamat, String instansi) {
        super(id, nama, alamat);
        this.instansi = instansi;
    }

    public String getInstansi() { return instansi; }

    @Override
    public void display() {
        super.display();
        System.out.println("Instansi: " + instansi);
        System.out.println("----------------------");
    }
}

