/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas.PWS.PWS;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MSI 65 SERIES
 */
@Controller
public class Inputdata {
    @RequestMapping("/prosesinput")
    public String inputanuser(HttpServletRequest data, Model barang){
        String namabarang = data.getParameter("var_namabarang");
        String hargabarang = data.getParameter("var_hargabarang");
        Integer chbarang = Integer.valueOf(hargabarang);
        String jumlahbarang = data.getParameter("var_jumlahbarang");
        Double cjbarang = Double.valueOf(jumlahbarang);
        Double jumlahbayar = chbarang * cjbarang;
        Double total = null;
        Integer diskon = 0;
        Double hargadiskon = 0.0;
        
        if(jumlahbayar < 10000){
            total = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
            
        }else if(jumlahbayar <=50000){
            diskon = 5;
            total = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
          
            
        }else if(jumlahbayar <=100000){
            diskon = 10;
            total = jumlahbayar - (jumlahbayar*diskon/100);
            hargadiskon = jumlahbayar*diskon/100;
        }
        barang.addAttribute("name", namabarang);
        barang.addAttribute("price", chbarang);
        barang.addAttribute("jml", cjbarang);
        barang.addAttribute("total", total);
        barang.addAttribute("discountrp", hargadiskon);
        barang.addAttribute("disc", diskon);
        barang.addAttribute("tbayar", jumlahbayar);
        return "nota";
    }
    
}
