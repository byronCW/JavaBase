package com.cbm.base.designpattern.observer.manual.impl;

import java.util.ArrayList;

import com.cbm.base.designpattern.observer.manual.Observer;
import com.cbm.base.designpattern.observer.manual.Subject;

/**
 * 天气布告板的信息来源，即被观察者，需实现Subject接口
 * 
 * @author byron
 *
 */
public class WeatherData implements Subject {

	private ArrayList<Observer> observers;

	private float temperature;

	private float humidity;

	private float pressure;

	public WeatherData() {
		observers = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int index = observers.indexOf(o);
		if (index >= 0) {
			observers.remove(o);
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer o : observers) {
			o.update(temperature, humidity, pressure);
		}
	}

	public void measurementsChanged() {
		notifyObserver();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
}
