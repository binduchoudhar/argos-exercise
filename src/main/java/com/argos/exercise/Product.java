package com.argos.exercise;

import java.math.BigDecimal;

public class Product {
	private String name;
	private String imageUrl;
	private BigDecimal price;
	private BigDecimal argosPrice = new BigDecimal(500);
	private BigDecimal temperature;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getArgosPrice() {
		return argosPrice;
	}

	public void setArgosPrice(BigDecimal argosPrice) {
		this.argosPrice = argosPrice;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nname: ").append(name);
		sb.append("\nimageUrl: ").append(imageUrl);
		sb.append("\nprice: ").append(price);
		sb.append("\nargosPrice: ").append(argosPrice);
		sb.append("\ntemperature: ").append(temperature);
		return sb.toString();

	}
}
