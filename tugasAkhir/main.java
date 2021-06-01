package tugasAkhir;

import java.util.Scanner;

public class main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        list.addAlbum(new album("2 COOL 4 SKOOL",180000,5,"A1"));
        list.addAlbum(new album("O!RUL8,2?",200000,5,"A2"));
        list.addAlbum(new album("SKOOL LUV AFFAIR",200000,5,"A3"));
        list.addAlbum(new album("DARK & WILD",215000,5,"A4"));
        list.addAlbum(new album("THE 3RD MINI ALBUM",190000,5,"A5"));
        list.addAlbum(new album("THR 4TH MINI ALBUM",190000,5,"A6"));
        list.addAlbum(new album("YOUNG FOREVER",290000,5,"A7"));
        list.addAlbum(new album("WINGS",210000,10,"A8"));
        list.addAlbum(new album("YOU NEVER WALK ALONE",250000,10,"A9"));
        list.addAlbum(new album("LOVE YOURSELF 'HER'",210000,10,"A10"));
        list.addAlbum(new album("LOVE YOURSELF 'TEAR'",225000,10,"A11"));
        list.addAlbum(new album("LOVE YOURSELF 'ANSWER'",250000,10,"A12"));
        list.addAlbum(new album("MAP OF THE SOUL PERSONA",210000,15,"A13"));
        list.addAlbum(new album("MAP OF THE SOUL 7",275000,15,"A14"));
        list.addAlbum(new album("BE (Deluxe Edition)",545000,20,"A15"));
        list.addMerch(new merch("Light Stick Keyring Ver.3",220000,20,"M1"));
        list.addMerch(new merch("Light stick MAP OF THE SOUL",320000,20,"M2"));
        list.addMerch(new merch("Fabric Poster",280000,20,"M3"));
        list.addMerch(new merch("Official Slogan",246000,20,"M4"));
        list.addMerch(new merch("Poster Set",278000,30,"M5"));
        list.addMerch(new merch("beWater with BTS",325000,30,"M6"));

        System.out.println("\n=====================================Selamat datang di BT21 Stuff=====================================");
        menu();


    }

    public static void menu(){
        System.out.println("\nSiapakah Anda ?");
        System.out.println("1. Pembeli");
        System.out.println("2. Admin");
        System.out.println("3. Keluar");

        String M = in.nextLine();
        System.out.println();

        switch (M) {
            case "1":
                System.out.println("Silahkan masukkan nama anda: ");
                String nm = in.nextLine();
                System.out.println();
                Pembeli pembeli = new Pembeli(nm);
                pembeli.beli();
                pembeli.bayar();
                break;
            case "2":
                System.out.println("Username : ");
                String uss = in.nextLine();
                System.out.println("Password : ");
                String pass = in.nextLine();
                if (!(uss.equalsIgnoreCase("BTs4ff") && pass.equalsIgnoreCase("1234"))) {
                    System.out.println("username dan password salah");
                } else {
                    System.out.println("\nHalo admin, pilih menu yang diinginkan");
                    System.out.println("1. Pemasok barang");
                    System.out.println("2. Pembukuan stok barang");
                    String c = in.nextLine();
                    switch (c){
                        case "1" :
                            System.out.println("Masukkan Kode barang : ");
                            String kode = in.nextLine();
                            stuff stuff = list.searchStuff(kode);
                            System.out.println("Masukkan Jumlah Stok : ");
                            int jumlah = in.nextInt();
                            in.nextLine();
                            stuff.addJumlah(jumlah);
                            System.out.println("Stok berhail ditambahkan");

                            break;
                        case "2" :
                            list.pembukuan();
                            break;
                    }
                    menu();
                }
            case "3":
                System.out.println("Terimakasih telah menggunakan aplikasi BT21 Stuff");
                System.exit(0);
        }
            menu();
    }
}