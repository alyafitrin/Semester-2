package tugasAkhir;


import java.util.ArrayList;

public class list {
    static ArrayList<stuff> list = new ArrayList<>();
    static ArrayList<stuff> list2 = new ArrayList<>();

    public static void list(){
            System.out.printf("\n%75s","----------------List stuff BT21----------------");
            System.out.printf("\n%25s","<ALBUM>");
            System.out.printf("%55s","<MERCH>");
            System.out.println();
            System.out.printf("%-8s","Kode");
            System.out.printf("%-30s","Nama");
            System.out.printf("%-15s","Harga");
            System.out.printf("%-9s","Kode");
            System.out.printf("%-30s","Nama");
            System.out.print("Harga\n");

            for (int i = 0;i<list.size();i++){
                listStuff(list.get(i));
                if (i < list2.size()) {
                    listStuff(list2.get(i));
                }
                System.out.println();

            }

    }

    public static <T extends stuff> void listStuff(T stuff){
        System.out.printf("%-8s",stuff.getKode());
        System.out.printf("%-30s",stuff.getNama());
        System.out.printf("%-16s",stuff.getHarga());
    }

    public static void addAlbum(stuff stuff){
        for (int i = 0; i<list.size();i++){
            if (list.get(i).compare(stuff)){
                list.get(i).addJumlah(stuff.getJumlah());
                return;
            }
        }
        list.add(stuff);
    }

    public static void addMerch(stuff stuff){
        for (int i = 0; i<list2.size();i++){
            if (list2.get(i).compare(stuff)){
                list2.get(i).addJumlah(stuff.getJumlah());
                return;
            }
        }
        list2.add(stuff);

    }

    public static <E extends stuff> void listBuku(E buku){
        System.out.printf("%-8s",buku.getKode());
        System.out.printf("%-29s",buku.getNama());
        System.out.printf("%-13s",buku.getJumAwal());
        System.out.printf("%-15s",buku.getJumlah());
    }



    public static stuff searchStuff(String kode){
        for (stuff stuff : list){
            if (stuff.getKode().equalsIgnoreCase(kode)) {
                return stuff;
            }
        }
        for (stuff stuff : list2) {
            if (stuff.getKode().equalsIgnoreCase(kode)) {
                return stuff;
            }
        }
return null;
    }

    public static void pembukuan (){
        System.out.println("======================================================================");
        System.out.printf("%40s","BT21 Stuff");
        System.out.printf("\n%43s","Laporan Stok Barang");
        System.out.println("\n======================================================================");
        //System.out.println();
        System.out.printf("%-8s","Kode");
        System.out.printf("%-28s","Nama");
        System.out.printf("%-8s","Stok");
        System.out.print("Stok Update\n");
        //System.out.print("Keterangan\n");
        System.out.println("-----------------------------------------------------------------------");

        for (int i = 0;i<list.size();i++){
            listBuku(list.get(i));
            System.out.println();
        }
        for (int i = 0;i<list2.size();i++){
            listBuku(list2.get(i));
            System.out.println();
        }

    }

}
