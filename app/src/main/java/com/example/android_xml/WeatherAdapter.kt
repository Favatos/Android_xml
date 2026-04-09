package com.example.android_xml

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android_xml.databinding.ItemWeatherBinding

class WeatherAdapter(
    private var weatherList: List<DataSeries>
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(
        private val binding: ItemWeatherBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(weather: DataSeries) {
            binding.textDate.text = "Дата: ${formatDate(weather.date)}"
            binding.textWeather.text = "Погода: ${weather.weather}"
            binding.textTemp.text =
                "Температура: ${weather.temp2m.min}° / ${weather.temp2m.max}°"
            binding.textWind.text =
                "Ветер: ${weather.wind10m_max ?: 0}"

            val temp = weather.temp2m.max

            // 🌡️ Цвет по температуре
            val color = when {
                temp <= 0 -> R.color.weather_cold
                temp <= 15 -> R.color.weather_normal
                else -> R.color.weather_hot
            }

            binding.rootLayout.setBackgroundResource(color)

            // 🌧️ Картинка по погоде
            val image = when (weather.weather) {
                "clearday" -> R.drawable.ic_sun
                "cloudy" -> R.drawable.ic_cloud
                "lightrain", "rain" -> R.drawable.ic_rain
                "lightsnow", "snow" -> R.drawable.ic_snow
                else -> R.drawable.ic_sun
            }

            binding.imageWeather.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int = weatherList.size

    fun updateList(newList: List<DataSeries>) {
        weatherList = newList
        notifyDataSetChanged()
    }
}

private fun formatDate(date: String): String {
    val year = date.substring(0, 4)
    val month = date.substring(4, 6)
    val day = date.substring(6, 8)

    return "$day.$month.$year"
}