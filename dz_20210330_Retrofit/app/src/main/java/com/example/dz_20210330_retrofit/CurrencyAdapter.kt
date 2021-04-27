package com.example.dz_20210330_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(val currencies: ArrayList<Currency>) :
    RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    class CurrencyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val ccy : TextView = view.findViewById(R.id.textccy)
        val baseccy : TextView = view.findViewById(R.id.textbaseccy)
        val buy : TextView = view.findViewById(R.id.textbuy)
        val sale : TextView = view.findViewById(R.id.textsale)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.currency_item, parent, false)
        return CurrencyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.ccy.text = currencies[position].ccy
        holder.baseccy.text = currencies[position].base_ccy
        holder.buy.text = currencies[position].buy
        holder.sale.text = currencies[position].sale
    }
}