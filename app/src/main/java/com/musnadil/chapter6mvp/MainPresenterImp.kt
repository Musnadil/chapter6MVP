package com.musnadil.chapter6mvp

import android.text.TextUtils
import com.musnadil.chapter6mvp.model.Hasil

class MainPresenterImp(private val view:MainView):MainPresenter {
    private val HASIL = mutableListOf<Hasil>()
    override fun addJumlah(angka1: String, angka2:String) {
        if(TextUtils.isEmpty(angka1)||TextUtils.isEmpty(angka2)){
            view.showMessage("Field tidak boleh kosong")
        }else{
            val hasilJumlah = angka1.toInt() + angka2.toInt()
            HASIL.run{
                add(Hasil(hasilJumlah))
            }
            view.showMessage("Hasil perhitungan : $hasilJumlah" )
            view.clearField()
        }
    }

    override fun loadData() {
        if (HASIL.size ==0){
            view.showMessage("Data masih kosong")
        }else{
            var allData =""

            for(i in 0 until HASIL.size){
                allData += "hasil penjumlahan : "+HASIL[i].jumlah +"\n\n"
            }
            allData += "Total : " +HASIL.size
            view.showData(allData)
        }
    }
}