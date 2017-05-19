package com.cbm.base.designpattern.observer.manual.impl;

import com.cbm.base.designpattern.observer.manual.DisplayElement;
import com.cbm.base.designpattern.observer.manual.Observer;

/**
 * 天气预报信息布告板
 * 
 * @author byron
 *
 */
public class ForecastDisplay implements Observer, DisplayElement {

	private float temperature;

	private float humidity;

	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.setWeatherData(weatherData);
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		StringBuilder info = new StringBuilder("Current conditions: ").append(temperature).append("F degrees and ")
				.append(humidity).append("% humidity");
		System.out.println(info.toString());
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

	public WeatherData getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(WeatherData weatherData) {
		this.weatherData = weatherData;
	}

}
