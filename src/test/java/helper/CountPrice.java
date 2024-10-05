package helper;

public class CountPrice {
    public static double jumlahkan(double ... angka){
        double total = 0;
        for (double nilai : angka) {
            total += nilai;
        }
        return total;
    }
//    public static void main(String[] args) {
//        double hasil1 = jumlahkan(2.4,1.1,1.5);
//        System.out.println("penjumlahan 1= "+hasil1);
//    }
}
