package tugasAkhir;

public class stuff {
    private String nama;
    private double harga;
    private int jumlah;
    private String kode;
    private int jumAwal;

    public stuff(String nama, double harga, int jumlah, String kode) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.kode = kode;
        this.jumAwal = jumlah;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void addJumlah(int jumlah){
        this.jumlah += jumlah;
    }

    public void reducedJumlah(int jumlah){
        this.jumlah -= jumlah;
    }

    public String getKode() {
        return kode;
    }

    public boolean compare(stuff stuff){
        if (this.getKode().equalsIgnoreCase(stuff.getKode()) && this.getHarga() == stuff.getHarga()) return true;
        else return false;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public int getJumAwal() {
        return jumAwal;
    }

    public void setJumAwal(int jumAwal) {
        this.jumAwal = jumAwal;
    }
}
