package com.example.taxiservicespring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.taxiservicespring.api.TripApi;
import com.example.taxiservicespring.controller.dto.CarDto;
import com.example.taxiservicespring.controller.dto.TripConfirmDto;
import com.example.taxiservicespring.controller.dto.TripCreateDto;
import com.example.taxiservicespring.controller.dto.TripDto;
import com.example.taxiservicespring.service.TripService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TripController implements TripApi{
    private final TripService tripService;

    public TripDto getById(long id) {
        log.info("request trip with id {}", id);
        return tripService.find(id);
    }

    public List<CarDto> getCarsByTripId(long tripId) {
        log.info("request cars by trip id {}", tripId);
        return tripService.findCarsByTripId(tripId);
    }

    public List<TripDto> getAll(int page, int count, String sorting) {
        log.info("request list of all trips");
        return tripService.getAll(page, count, sorting);
    }

    public long getCount() {
        log.info("request count of all trips");
        return tripService.getCount();
    }

    public List<TripDto> getAllByPersonId(int page, int count, String sorting, int personId) {
        log.info("request list of trips filtered by person id {}", personId);
        return tripService.getAllByPersonId(personId, page, count, sorting);
    }

    public long getCountByPesonId(long personId) {
        log.info("request count of trips filtered by person id {}", personId);
        return tripService.getCountByPersonId(personId);
    }

    public List<TripDto> getAllByDate(int page, int count, String sorting, String dateRange) {
        log.info("request list of trips filtered by date {}", dateRange);
        return tripService.getAllByDate(dateRange, page, count, sorting);
    }

    public long getCountByDate(String dateRange) {
        log.info("request count of trips filtered by date {}", dateRange);
        return tripService.getCountByDate(dateRange);
    }

    public List<TripDto> getAllByPersonIdAndDate(int page, int count, String sorting, int personId, String dateRange) {
        log.info("request list of trips filtered by person id {} and date {}", personId, dateRange);
        return tripService.getAllByPersonIdAndDate(personId, dateRange, page, count, sorting);
    }

    public long getCountByPersonIdAndDate(long personId, String dateRange) {
        log.info("request count of trips filtered by person id {} and date {}", personId, dateRange);
        return tripService.getCountByPersonIdAndDate(personId, dateRange);
    }

    public TripConfirmDto create(TripCreateDto tripCreateDto) {
        log.info("request create new trip");
        return tripService.create(tripCreateDto);
    }

    public TripDto confirm(TripConfirmDto tripConfirmDto) {
        log.info("request confirm new trip");
        return tripService.confirm(tripConfirmDto);
    }

    public TripDto updateStatus(long tripId, String status) {
        log.info("request update trip status");
        return tripService.updateStatus(tripId, status);
    }
}
