package com.alphabraille.services


import com.alphabraille.entities.Device
import com.alphabraille.repositories.DeviceRepository
import org.springframework.stereotype.Service

@Service
class DeviceService(private val deviceRepository: DeviceRepository) {
    fun findAll(): List<Device> = deviceRepository.findAll()
    fun save(device: Device): Device = deviceRepository.save(device)
}
