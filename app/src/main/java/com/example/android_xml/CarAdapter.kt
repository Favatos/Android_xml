package com.example.android_xml

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_xml.databinding.ItemCarBinding

class CarAdapter(
    private var carList: List<Car>
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    inner class CarViewHolder(
        private val binding: ItemCarBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(car: Car) {
            binding.brandModelText.text = "${car.brand} ${car.model}"
            binding.yearText.text = "Год: ${car.year}"
            binding.priceText.text = "Цена: ${car.cost} ₽"
            binding.descriptionText.text = "Описание: ${car.description}"
            binding.carImage.setImageResource(car.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int = carList.size

    fun updateList(newList: List<Car>) {
        carList = newList
        notifyDataSetChanged()
    }
}