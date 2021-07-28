package pnj.uas.ti.zulfahfauziah.vaksinyuk;

public class PesertaVaksinasi {
    private String key;
    private String nik;
    private String nama;

    private String alamat;
    private String nohp;

    public PesertaVaksinasi(String nama, String nik, String alamat, String nohp) {
        this.nik = nik;
        this.nama = nama;
        this.alamat = alamat;
        this.nohp = nohp;
    }

    public PesertaVaksinasi() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}
