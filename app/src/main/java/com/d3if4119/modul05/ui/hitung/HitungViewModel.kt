package com.d3if4119.modul05.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.d3if4119.modul05.data.HasilBmi
import com.d3if4119.modul05.data.HitungBmi
import com.d3if4119.modul05.data.KategoriBmi
import com.d3if4119.modul05.db.BmiDao
import com.d3if4119.modul05.db.BmiEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel(private val db: BmiDao) : ViewModel() {
    // Hasil BMI bisa null jika pengguna belum menghitung BMI
    private val hasilBmi = MutableLiveData<HasilBmi?>()
    private val navigasi = MutableLiveData<KategoriBmi?>()

    fun hitungBmi(berat: String, tinggi: String, isMale: Boolean) {
        val dataBmi = BmiEntity(
            berat = berat.toFloat(),
            tinggi = tinggi.toFloat(),
            isMale = isMale
        )
        hasilBmi.value = HitungBmi.hitung(dataBmi)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataBmi)
            }
        }
    }

    fun mulaiNavigasi() {
        navigasi.value = hasilBmi.value?.kategori
    }
    fun selesaiNavigasi() {
        navigasi.value = null
    }


    fun getHasilBmi() : LiveData<HasilBmi?> = hasilBmi

    fun getNavigasi() : LiveData<KategoriBmi?> = navigasi
}