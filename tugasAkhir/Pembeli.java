package tugasAkhir;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner;

public class Pembeli {
    private String nama;
    private ArrayList<stuff> cart = new ArrayList<>();

    public Pembeli(String nama) {
        this.nama = nama;
    }

    public void addCart(stuff stuff,int jumlah){
        if (stuff.getJumlah() >= jumlah) {
            stuff.reducedJumlah(jumlah);
            stuff merch = new stuff(stuff.getNama(),stuff.getHarga(),jumlah,stuff.getKode());

            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).compare(merch)){
                    cart.get(i).addJumlah(jumlah);
                    return;
                }
            }
            cart.add(merch);
        }
    }

    public double getTotal(){
        double total = 0;
        for (stuff stuff : cart) total += stuff.getHarga()*stuff.getJumlah();
        return  total;
    }

    public void beli(){
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan kode barang yang ingin Anda beli(Ketik 'list' untuk melihat daftar barang) : ");
        String nm = in.nextLine();
        if (nm.equalsIgnoreCase("list")) {
            list.list();
            beli();
            return;
        }
        stuff stuff = list.searchStuff(nm);
        if (stuff == null){
            System.out.println("Barang tidak tersedia");
            beli();
        }else {
            System.out.println("Masukkan jumlah barang yang Anda inginkan : ");
            int jumlah = in.nextInt();
            in.nextLine();
            if (jumlah == 0){
                System.out.println("Mohon maaf, anda tidak bisa membeli 0 barang");
            }else if (stuff.getJumlah() < jumlah){
                System.out.println("Mohon maaf, stok barang tidak mencukupi");
            }else {
                addCart(stuff,jumlah);
                System.out.println("Barang berhasil di masukkan ke keranjang");
            }
            System.out.println("\nApakah Anda ingin melakukan pembelian lagi ? (Y/T)");
            String c = in.nextLine();
            System.out.println();
            if (c.equalsIgnoreCase("Y"))beli();

        }

    }

    public void bayar(){
        if (cart.size() == 0){
            System.out.println(nama+", Terimakasih telah berkujung ke BT21 Stuff");
            return;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Berikut daftar belanja Anda");
        for (stuff stuff : cart){
            list.listStuff(stuff);
            System.out.println();
        }
        System.out.println("\nTotal Harga Belanja: "+formatUang(getTotal())+"\n");
        System.out.println("Terimakasih telah berbelanja di BT21 Stuff");
    }


    static String formatUang(double angka) {
        DecimalFormat kursIndonesia = (DecimalFormat)DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp ");
        formatRp.setMonetaryDecimalSeparator(' ');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        return kursIndonesia.format(angka).replace(',','.').replace(' ',',');
    }
}
