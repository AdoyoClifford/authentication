package com.example.emergencysystem.data

import com.example.emergencysystem.domain.model.Doctors

fun DoctorsEntity.toDoctors(): Doctors {
    return Doctors(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun Doctors.toDoctorsEntity(): DoctorsEntity {
    return DoctorsEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}