package com.callor.car.persistance;

import java.util.List;

import com.callor.car.model.CarDto;

public interface CarDao {
	public int insert(CarDto carDto);
	
	public CarDto findTachoByCarNum(String carnum);

	public List<CarDto> selectAll();
	
	public void create_car_table(String dumy);
}
