package com.gokul.myweatherapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.gokul.myweatherapp.Repository.WeatherDataRepository
import com.gokul.myweatherapp.Repository.WeatherLocationRepository
import com.gokul.myweatherapp.model.WeatherLocation
import com.gokul.myweatherapp.model.WeatherModel

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherDataRepository: WeatherDataRepository = WeatherDataRepository.instance!!
    private val weatherLocationRepository: WeatherLocationRepository = WeatherLocationRepository.instance!!

    /**
     * Requesting Methods
     */

    fun requestWeatherData(woeid: Int) {
        weatherDataRepository.requestWeatherData(woeid)
    }

    fun requestWeatherLocation(text: String) {
        weatherLocationRepository.requestWeatherLocation(text)
    }

    /**
     * Get Observer
     */

    fun observeWeatherData(): MutableLiveData<WeatherModel?> {
        return weatherDataRepository.observeWeatherData()
    }

    fun observeWeatherLocation(): MutableLiveData<List<WeatherLocation>?> {
        return weatherLocationRepository.observeWeatherLocation()
    }

}
