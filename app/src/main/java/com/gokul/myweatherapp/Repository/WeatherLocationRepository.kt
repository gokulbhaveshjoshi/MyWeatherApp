package com.gokul.myweatherapp.Repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gokul.myweatherapp.model.WeatherLocation
import com.gokul.myweatherapp.network.MetaWeather
import com.gokul.myweatherapp.network.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherLocationRepository : ViewModel() {

    private val weatherLocation: MutableLiveData<List<WeatherLocation>?> = MutableLiveData()

    fun observeWeatherLocation(): MutableLiveData<List<WeatherLocation>?> {
        return weatherLocation
    }

    fun requestWeatherLocation(text: String): MutableLiveData<List<WeatherLocation>?> {

        val weatherLocationCall: Call<List<WeatherLocation>> = myInterface.getLocation(text)
        weatherLocationCall.enqueue(object : Callback<List<WeatherLocation>?> {
            override fun onResponse(call: Call<List<WeatherLocation>?>, response: Response<List<WeatherLocation>?>) {
                weatherLocation.setValue(response.body())
            }

            override fun onFailure(call: Call<List<WeatherLocation>?>, t: Throwable) {
                weatherLocation.postValue(null)
            }
        })

        return weatherLocation
    }

    companion object {
        private lateinit var myInterface: MetaWeather
        private var weatherLocationRepository: WeatherLocationRepository? = null
        val instance: WeatherLocationRepository?
            get() {
                if (weatherLocationRepository == null) {
                    weatherLocationRepository = WeatherLocationRepository()
                }
                return weatherLocationRepository
            }
    }

    init {
        myInterface = ServiceBuilder.buildService(MetaWeather::class.java)
    }
}


