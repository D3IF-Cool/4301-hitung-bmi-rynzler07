package com.d3if4119.modul05.ui.histori

import androidx.lifecycle.ViewModel
import com.d3if4119.modul05.db.BmiDao

class HistoriViewModel(db: BmiDao) : ViewModel() {
    val data = db.getLastBmi()
}