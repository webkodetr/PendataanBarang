package Barang;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BarangControl {

    String[] header = {"ID BARANG", "NAMA BARANG", "QTY", "HARGA"};

    private ArrayList<Barang> list = new ArrayList();

//  untuk menampilkan data pada tabel
    public void read(JTable tb) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);

        for (int i = 0; i < list.size(); i++) {
            Object[] oj = new Object[4];
            oj[0] = list.get(i).getID_BARANG();
            oj[1] = list.get(i).getNAMA_BARANG();
            oj[2] = list.get(i).getQTY();
            oj[3] = list.get(i).getHARGA();
            dtm.addRow(oj);
        }

        tb.setModel(dtm);
    }

//  untuk menambahkan data
    public void create(Barang br) {
        list.add(br);
        JOptionPane.showMessageDialog(null, "Berhasil Disimpan!");
    }

//  untuk ubah data
    public void update(Barang br) {
        for (int i = 0; i < list.size(); i++) {
            if (br.getID_BARANG() == list.get(i).getID_BARANG()) {
                list.set(i, br);
            }
        }

        JOptionPane.showMessageDialog(null, "Berhasil Diubah!");
    }

    //  untuk ubah data
    public void delete(int ID_BARANG) {
        for (int i = 0; i < list.size(); i++) {
            if (ID_BARANG == list.get(i).getID_BARANG()) {
                list.remove(i);
            }
        }

        JOptionPane.showMessageDialog(null, "Berhasil Dihapus!");
    }

//    untuk melakukan pencarian berdasarkan ID BARANG
    public void search(JTable tb, int ID_BARANG) {
        DefaultTableModel dtm = new DefaultTableModel(null, header);

        for (int i = 0; i < list.size(); i++) {
            if (ID_BARANG == list.get(i).getID_BARANG()) {
                Object[] oj = new Object[4];
                oj[0] = list.get(i).getID_BARANG();
                oj[1] = list.get(i).getNAMA_BARANG();
                oj[2] = list.get(i).getQTY();
                oj[3] = list.get(i).getHARGA();
                dtm.addRow(oj);
            }
        }

        tb.setModel(dtm);
    }
}
