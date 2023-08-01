package com.callor.bus.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.bus.api.LoadAPIData;
import com.callor.bus.dao.TerDao;
import com.callor.bus.dao.TerDriveDao;
import com.callor.bus.dao.TerLinkDao;
import com.callor.bus.dao.TerScheduleDao;
import com.callor.bus.dto.TerDriveDto;
import com.callor.bus.dto.TerDto;
import com.callor.bus.dto.TerLinkDto;
import com.callor.bus.dto.TerScheduleDto;
import com.callor.bus.utils.Utils;

@Service
public class SaveDB {

	private final LoadAPIData apiData;
	private final TerDao terDao;
	private final TerLinkDao terLinkDao;
	private final TerDriveDao terDriveDao;
	private final TerScheduleDao terScheduleDao;

	@Autowired
	public SaveDB(LoadAPIData apiData, TerDao terDao, TerLinkDao terLinkDao, TerDriveDao terDriveDao,
			TerScheduleDao terScheduleDao) {
		this.apiData = apiData;
		this.terDao = terDao;
		this.terLinkDao = terLinkDao;
		this.terDriveDao = terDriveDao;
		this.terScheduleDao = terScheduleDao;
	}

	public void saveTerDB() throws JSONException {
		terDao.deleteAll();

		List<TerDto> terList = new ArrayList<>();
		String data = null;
		try {
			data = apiData.connectionTerAPI();
		} catch (IOException e) {
			System.out.println("API 로딩실패");
		}
		JSONObject jsonObject = new JSONObject(data);
		JSONArray resultArray = jsonObject.getJSONArray("result");

		for (int i = 0; i < resultArray.length(); i++) {
			JSONObject resultObject = resultArray.getJSONObject(i);
			TerDto depTerDto = new TerDto();

			// id
			String depTerId = resultObject.getLong("stationID") + "";
			depTerDto.setTerId(depTerId);
			// name
			String depTerName_Region = resultObject.getString("stationName");

			String depTerName = "";
			String depTerRegion = "";

			if (depTerName_Region.contains("/")) {
				String[] dep_parts = depTerName_Region.split("/");
				depTerRegion = dep_parts[0];
				depTerName = dep_parts[1];
			} else {
				depTerRegion = "광주";
				depTerName = depTerName_Region;
			}
			// name
			depTerDto.setTerName(depTerName);
			// region
			depTerDto.setTerRegion(depTerRegion);

			// x
			double depTerX = resultObject.getDouble("x");
			depTerDto.setTerCoorX(depTerX);
			// y
			double depTerY = resultObject.getDouble("y");
			depTerDto.setTerCoorY(depTerY);

			terList.add(depTerDto);

			boolean haveDestinationTer = resultObject.getBoolean("haveDestinationTerminals");

			if (haveDestinationTer) {
				JSONArray arrTers = resultObject.getJSONArray("destinationTerminals");
				for (int j = 0; j < arrTers.length(); j++) {

					JSONObject arrTer = arrTers.getJSONObject(j);

					TerDto arrTerDto = new TerDto();

					// id
					String arrTerId = arrTer.getLong("stationID") + "";
					arrTerDto.setTerId(arrTerId);
					// name
					String arrTerName_Region = arrTer.getString("stationName");

					String[] arr_parts = arrTerName_Region.split("/");

					String arrTerRegion = arr_parts[0];
					String arrTerName = arr_parts[1];
					// name
					arrTerDto.setTerName(arrTerName);
					// region
					arrTerDto.setTerRegion(arrTerRegion);

					// x
					double arrTerX = arrTer.getDouble("x");
					arrTerDto.setTerCoorX(arrTerX);
					// y
					double arrTerY = arrTer.getDouble("y");
					arrTerDto.setTerCoorY(arrTerY);

					terList.add(arrTerDto);
				} // for end
			}
		}
		List<TerDto> dedupTerList = Utils.removeDuplicates(terList);

		for (TerDto dto : dedupTerList) {
			terDao.insert(dto);
		}
	}

	public void saveTerLinkDB() throws JSONException {
		terLinkDao.deleteAll();

		List<TerLinkDto> terLinkList = new ArrayList<>();
		String data = null;
		try {
			data = apiData.connectionTerAPI();
		} catch (IOException e) {
			System.out.println("API 로딩실패");
		}
		JSONObject jsonObject = new JSONObject(data);
		JSONArray resultArray = jsonObject.getJSONArray("result");

		for (int i = 0; i < resultArray.length(); i++) {
			JSONObject resultObject = resultArray.getJSONObject(i);

			boolean haveDestinationTer = resultObject.getBoolean("haveDestinationTerminals");

			if (haveDestinationTer) {
				String depTerId = resultObject.getLong("stationID") + "";

				JSONArray arrTers = resultObject.getJSONArray("destinationTerminals");

				for (int j = 0; j < arrTers.length(); j++) {
					JSONObject arrTer = arrTers.getJSONObject(j);

					TerLinkDto terLinkDto = new TerLinkDto();

					String arrTerId = arrTer.getLong("stationID") + "";

					terLinkDto.setTl_DepTerId(depTerId);
					terLinkDto.setTl_ArrTerId(arrTerId);
					terLinkDto.setTl_Id(depTerId + arrTerId);
					terLinkList.add(terLinkDto);
				}
			}

		}
		for (TerLinkDto dto : terLinkList) {
			terLinkDao.insert(dto);
		}
	}

	public void saveTerDriveDB() throws JSONException {
		terDriveDao.deleteAll();

		List<TerLinkDto> test_linkTerList = terLinkDao.selectAll();

		String data = null;
		List<TerDriveDto> terDriveDtoList = new ArrayList<>();
		for (TerLinkDto dto : test_linkTerList) {
			String depTerId = dto.getTl_DepTerId();
			String arrTerId = dto.getTl_ArrTerId();
			try {
				data = apiData.connectionBusAPI(depTerId, arrTerId);
			} catch (IOException e) {
				System.out.println("BUS API 호출 오류");
				throw new RuntimeException(e);
			}
			JSONObject jsonObject = new JSONObject(data);
			JSONObject resultObject = jsonObject.getJSONObject("result");
			JSONArray stations = resultObject.getJSONArray("station");
			for (int i = 0; i < stations.length(); i++) {
				JSONObject station = stations.getJSONObject(i);
				TerDriveDto terDriveDto = new TerDriveDto();
				terDriveDto.setTd_TlID(dto.getTl_Id());
				terDriveDto.setTd_ID(dto.getTl_Id() + "_0" + i);
				// waste time
				String wasteTime = station.getString("wasteTime");
				terDriveDto.setTd_WasteTime(wasteTime);
				// interval
				String intervals = station.getString("interval");
				String[] lines = intervals.split("/");
				String interval = lines[0];
				terDriveDto.setTd_Interval(interval);
				// normal fare

				int nightFare = station.getInt("nightFare");

				if (nightFare == 0) {
					int normalFare = station.getInt("normalFare");
					terDriveDto.setTd_Fare(normalFare);
					// 주간 스케쥴
				} else {
					// 야간 스케쥴
					terDriveDto.setTd_Fare(nightFare);
				}
				terDriveDtoList.add(terDriveDto);
			}
		}
		for (TerDriveDto dto : terDriveDtoList) {
			terDriveDao.insert(dto);
		}
	}

	public void saveTerScheduleDB() throws JSONException {
		terScheduleDao.deleteAll();

		List<TerLinkDto> test_linkTerList = terLinkDao.selectAll();

		String data = null;
		List<TerScheduleDto> terScheduleDtoList = new ArrayList<>();

		for (TerLinkDto dto : test_linkTerList) {
			String depTerId = dto.getTl_DepTerId();
			String arrTerId = dto.getTl_ArrTerId();
			try {
				data = apiData.connectionBusAPI(depTerId, arrTerId);
			} catch (IOException e) {
				System.out.println("BUS API 호출 오류");
				throw new RuntimeException(e);
			}
			JSONObject jsonObject = new JSONObject(data);
			JSONObject resultObject = jsonObject.getJSONObject("result");
			JSONArray stations = resultObject.getJSONArray("station");
			for (int i = 0; i < stations.length(); i++) {
				JSONObject station = stations.getJSONObject(i);

				int normalFare = station.getInt("normalFare");
				int nightFare = station.getInt("nightFare");

				if (nightFare == 0) {
					// 주간 스케쥴
					String schedules = station.getString("schedule");
					String[] lines = schedules.split("\n");

					for (String line : lines) {
						String[] times = line.split("/");
						for (String time : times) {
							TerScheduleDto terScheduleDto = new TerScheduleDto();
							terScheduleDto.setTes_TdId(dto.getTl_Id() + "_0" + i);
							terScheduleDto.setTes_Schedule(time);
							terScheduleDtoList.add(terScheduleDto);
						}
					}
				} else if (normalFare == 0) {
					// 야간 스케쥴
					String schedules = station.getString("nightSchedule");
					String[] lines = schedules.split("\n");

					for (String line : lines) {
						String[] times = line.split("/");
						for (String time : times) {
							TerScheduleDto terScheduleDto = new TerScheduleDto();
							terScheduleDto.setTes_TdId(dto.getTl_Id() + "_0" + i);
							terScheduleDto.setTes_Schedule(time);
							terScheduleDtoList.add(terScheduleDto);
						}
					}
				} else {
					// 주간,야간 스케쥴
					String schedules = station.getString("schedule");
					String[] lines = schedules.split("\n");

					for (String line : lines) {
						String[] times = line.split("/");
						for (String time : times) {
							TerScheduleDto terScheduleDto = new TerScheduleDto();
							terScheduleDto.setTes_TdId(dto.getTl_Id() + "_0" + i);
							terScheduleDto.setTes_Schedule(time);
							terScheduleDtoList.add(terScheduleDto);
						}
					}

					schedules = station.getString("nightSchedule");
					lines = schedules.split("\n");

					for (String line : lines) {
						String[] times = line.split("/");
						for (String time : times) {
							TerScheduleDto terScheduleDto = new TerScheduleDto();
							terScheduleDto.setTes_TdId(dto.getTl_Id() + "_0" + i);
							terScheduleDto.setTes_Schedule(time);
							terScheduleDtoList.add(terScheduleDto);
						}
					}
				}
			}
		}
		for (TerScheduleDto dto : terScheduleDtoList) {
			terScheduleDao.insert(dto);
		}
	}

}
